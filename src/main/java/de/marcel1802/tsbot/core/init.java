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

import java.io.File;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class init {

    public static void main(String[] args) {

        settingsAsClass settingsObj = loadSettings();

        if (settingsObj == null) {
            System.out.println("Config error");
        }
        else {
            startTeamspeakBot(settingsObj);
        }

    }

    public static settingsAsClass loadSettings() {
        try {
            File file = new File("settings.yaml");
            ObjectMapper om = new ObjectMapper(new YAMLFactory());
            return om.readValue(file, settingsAsClass.class);
        }
        catch(Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public static void startTeamspeakBot(settingsAsClass loadedSettings) {

        final TS3Config config = new TS3Config();
        config.setHost(loadedSettings.getGeneral_ip());
        config.setEnableCommunicationsLogging(true);

        final TS3Query query = new TS3Query(config);
        query.connect();

        final TS3Api api = query.getApi();
        api.login(loadedSettings.getGeneral_loginname(), loadedSettings.getGeneral_loginpassword());
        api.selectVirtualServerById(loadedSettings.getGeneral_virtualServerID());

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
                                if (loadedSettings.getMoveDefault_mode() == 1) {
                                    api.sendPrivateMessage(e.getClientId(), loadedSettings.getMoveDefault_message());
                                } else if (loadedSettings.getMoveDefault_mode() == 2) {
                                    api.pokeClient(e.getClientId(), loadedSettings.getMoveDefault_message());
                                }
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
                            if (loadedSettings.getNotifyComplaints_mode() == 1) {
                                api.sendPrivateMessage(e.getClientId(), loadedSettings.getNotifyComplaints_message());
                            } else if (loadedSettings.getNotifyComplaints_mode() == 2) {
                                api.pokeClient(e.getClientId(), loadedSettings.getNotifyComplaints_message());
                            }
                        }
                    }
                }

                if (loadedSettings.isDefaultNicknameCheck_enabled()) {
                    if (e.getClientNickname().equalsIgnoreCase("teamspeakuser")) {
                        if (loadedSettings.getDefaultNicknameCheck_mode() == 1) {
                            api.sendPrivateMessage(e.getClientId(), loadedSettings.getDefaultNicknameCheck_message());
                        }
                        else if (loadedSettings.getDefaultNicknameCheck_mode() == 2) {
                            api.pokeClient(e.getClientId(), loadedSettings.getDefaultNicknameCheck_message());
                        }
                        else {
                            api.kickClientFromServer(loadedSettings.getDefaultNicknameCheck_message(), e.getClientId());
                        }
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
}
