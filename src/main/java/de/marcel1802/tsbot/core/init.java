package de.marcel1802.tsbot.core;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.github.theholywaffle.teamspeak3.TS3Api;
import com.github.theholywaffle.teamspeak3.TS3Config;
import com.github.theholywaffle.teamspeak3.TS3Query;
import com.github.theholywaffle.teamspeak3.api.event.ClientJoinEvent;
import com.github.theholywaffle.teamspeak3.api.event.ClientLeaveEvent;
import com.github.theholywaffle.teamspeak3.api.event.ClientMovedEvent;
import com.github.theholywaffle.teamspeak3.api.event.TS3EventAdapter;
import com.github.theholywaffle.teamspeak3.api.event.TS3EventType;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

public class init {

    static Logger logger = Logger.getLogger("MyLog");
    static FileHandler fh;

    public static void main(String[] args) {

        fh = Logging.init(logger);

        if (fh == null) return;
        if (!checkConfigExist()) return;

        settingsAsClass settingsObj = loadSettings();

        if (settingsObj == null) {
            logger.warning("Config error. The format does not fit.");
        }
        else {
            startTeamspeakBot(settingsObj);
        }

    }

    public static boolean checkConfigExist() {
        Path p = Path.of("settings.yaml");
        Path defaultSettingsPath = Path.of("src/main/java/de/marcel1802/tsbot/resources/example-settings.yaml");

        if (Files.exists(p)) {
            return true;
        }
        else {
            try {
                Files.createFile(p);
            }
            catch (Exception ex) {
                logger.warning("Config file cannot be created.");
                return false;
            }

            try (BufferedReader br = new BufferedReader(Files.newBufferedReader(defaultSettingsPath));
                 BufferedWriter bw = new BufferedWriter(Files.newBufferedWriter(p))) {

                logger.warning("The config file does not exist. Config created. Please adjust the settings and restart the bot.");

                String line;

                while ((line = br.readLine()) != null) {
                    bw.write(line+"\n");
                }

                return false;
            }
            catch (Exception ex) {
                logger.warning("Config file created. Cannot copy default settings.");
                return false;
            }
        }
    }

    public static settingsAsClass loadSettings() {
        try {
            File file = new File("settings.yaml");
            ObjectMapper om = new ObjectMapper(new YAMLFactory());
            return om.readValue(file, settingsAsClass.class);
        }
        catch(Exception ex) {
            return null;
        }
    }

    public static void startTeamspeakBot(settingsAsClass loadedSettings) {

        logger.info("Config found and okay. Starting bot ...");

        final TS3Config config = new TS3Config();
        config.setHost(loadedSettings.getGeneral_ip());
        config.setEnableCommunicationsLogging(true);

        final TS3Query query = new TS3Query(config);

        try {
            query.connect();
        }
        catch (Exception ex) {
            logger.warning("Error: Timeout while trying to connect to the server. Is the IP address correct?");
        }


        final TS3Api api = query.getApi();

        try {
            api.login(loadedSettings.getGeneral_loginname(), loadedSettings.getGeneral_loginpassword());
        }
        catch (Exception ex) {
            logger.warning("Error: Cannot log in. Check your login data.");
            return;
        }

        try {
            api.selectVirtualServerById(loadedSettings.getGeneral_virtualServerID());
        }
        catch (Exception ex) {
            logger.warning("Error: Wrong virtual server ID. Cannot connect. Default ID is 1");
            return;
        }
        final int thisBotID = api.whoAmI().getId();

        if (api.getClientInfo(thisBotID).getChannelId() != loadedSettings.getGeneral_joinChannel()) {
            api.moveQuery(loadedSettings.getGeneral_joinChannel());
        }

        if (!api.getClientInfo(thisBotID).getNickname().equals(loadedSettings.getGeneral_displayname())) {
            api.setNickname(loadedSettings.getGeneral_displayname());
        }


        Set<Integer> moveDefault_list = new HashSet<>();

        api.registerEvent(TS3EventType.SERVER);
        api.addTS3Listeners(new TS3EventAdapter() {

            @Override
            public void onClientJoin(ClientJoinEvent e) {
                if (loadedSettings.isMoveDefault_enabled()) {
                    moveDefault_list.add(e.getClientId());
                    new Thread(() -> {
                        try {
                            Thread.sleep(1000L * loadedSettings.getMoveDefault_moveTime());
                            if (moveDefault_list.contains(e.getClientId()) && api.getClientInfo(e.getClientId()).getChannelId() == loadedSettings.getMoveDefault_defaultChannelID()) {
                                api.moveClient(e.getClientId(), loadedSettings.getMoveDefault_AFKChannelID());
                                executeAction(loadedSettings.getMoveDefault_mode(),loadedSettings.getMoveDefault_message(),e.getClientId(),api);
                                moveDefault_list.remove(e.getClientId());
                            }
                        } catch (Exception ex) {
                            // todo
                        }
                    }).start();
                }

                if (loadedSettings.isNotifyComplaints_enabled()) {
                    if (!api.getComplaints().isEmpty()) {
                        List<String> servergroups = Arrays.asList(e.getClientServerGroups().split("\\s*,\\s*"));
                        if (servergroups.contains(Integer.toString(loadedSettings.getNotifyComplaints_adminGroup()))) {
                            executeAction(loadedSettings.getNotifyComplaints_mode(),loadedSettings.getNotifyComplaints_message(),e.getClientId(), api);
                        }
                    }
                }

                if (loadedSettings.isDefaultNicknameCheck_enabled()) {
                    if (e.getClientNickname().equalsIgnoreCase("teamspeakuser")) {
                        executeAction(loadedSettings.getDefaultNicknameCheck_mode(),loadedSettings.getDefaultNicknameCheck_message(),e.getClientId(),api);
                    }
                }

                if (loadedSettings.isVersionWarner_enabled() && e.getClientType() == 0) {
                    if (loadedSettings.getVersionWarner_kickVersions().contains(api.getClientInfo(e.getClientId()).getVersion())) {
                        api.kickClientFromServer(loadedSettings.getVersionWarner_kickMessage(),e.getClientId());
                    }
                    else if (loadedSettings.getVersionWarner_warningVersions().contains(api.getClientInfo(e.getClientId()).getVersion())) {
                        if (loadedSettings.getVersionWarner_warnMethod() == 1) {
                            api.sendPrivateMessage(e.getClientId(), loadedSettings.getVersionWarner_warnMessage());
                        }
                        else {
                            api.pokeClient(e.getClientId(), loadedSettings.getVersionWarner_warnMessage());
                        }
                    }
                }

                if (loadedSettings.isCountryList_enabled()) {

                    if (loadedSettings.getCountryList_mode() == 0 && !loadedSettings.getCountryList_whitelist().contains(e.getClientCountry())) {
                        api.kickClientFromServer(loadedSettings.getCountryList_whitelistKickMessage(),e.getClientId());
                    }
                    else if (loadedSettings.getCountryList_mode() == 1 && loadedSettings.getCountryList_blacklist().contains(e.getClientCountry())) {
                        api.kickClientFromServer(loadedSettings.getCountryList_blacklistKickMessage(), e.getClientId());
                    }

                }

            }

            @Override
            public void onClientLeave(ClientLeaveEvent e) {
                if (loadedSettings.isMoveDefault_enabled()) {//&& moveDefault_list.contains(e.getClientId())
                    moveDefault_list.remove(e.getClientId());
                }
            }

            @Override
            public void onClientMoved(ClientMovedEvent e) {
                if (loadedSettings.isMoveDefault_enabled()) {//&& moveDefault_list.contains(e.getClientId())
                    moveDefault_list.remove(e.getClientId());
                }
            }
        });

    }

    public static void executeAction(BotAction botAction, String message, int clientID, TS3Api apiObj) {
        switch (botAction) {

            case NONE: {
                break;
            }

            case MESSAGE: {
                apiObj.sendPrivateMessage(clientID,message);
                break;
            }

            case POKE: {
                apiObj.pokeClient(clientID, message);
                break;
            }

            case KICK: {
                apiObj.kickClientFromServer(message, clientID);
                break;
            }

        }
    }
}
