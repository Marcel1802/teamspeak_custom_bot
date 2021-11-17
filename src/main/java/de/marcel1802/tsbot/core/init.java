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
            // todo
            System.out.println("Config error");
        }
        else {

            final TS3Config config = new TS3Config();
            config.setHost(settingsObj.getGeneral_ip());
            config.setEnableCommunicationsLogging(true);

            final TS3Query query = new TS3Query(config);
            query.connect();

            final TS3Api api = query.getApi();
            api.login(settingsObj.getGeneral_loginname(), settingsObj.getGeneral_loginpassword());
            api.selectVirtualServerById(1);

            try {
                api.setNickname(settingsObj.getGeneral_displayname());
            } catch (Exception ex) {
                //
            }

            final int clientId = api.whoAmI().getId();

            Set<Integer> moveDefault_list = new HashSet<Integer>();

            api.registerEvent(TS3EventType.SERVER);
            api.addTS3Listeners(new TS3EventAdapter() {

                @Override
                public void onClientJoin(ClientJoinEvent e) {
                    if (settingsObj.isMoveDefault_enabled()) {
                        moveDefault_list.add(e.getClientId());
                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                long sleepTime = 1000 * settingsObj.getMoveDefault_moveTime();
                                try {
                                    Thread.sleep(sleepTime);
                                    if (moveDefault_list.contains(e.getClientId()) && api.getClientInfo(e.getClientId()).getChannelId() == settingsObj.getMoveDefault_defaultChannelID()) {
                                        api.moveClient(e.getClientId(), settingsObj.getMoveDefault_AFKChannelID());
                                        if (settingsObj.getMoveDefault_mode() == 1) {
                                            api.sendPrivateMessage(e.getClientId(), settingsObj.getMoveDefault_message());
                                        } else if (settingsObj.getMoveDefault_mode() == 2) {
                                            api.pokeClient(e.getClientId(), settingsObj.getMoveDefault_message());
                                        }
                                    }
                                } catch (Exception ex) {
                                }
                            }
                        }).start();
                    }

                    if (settingsObj.isNotifyComplaints_enabled()) {
                        if (!api.getComplaints().isEmpty()) {
                            List<String> servergroups = Arrays.asList(e.getClientServerGroups().split("\\s*,\\s*"));
                            if (servergroups.contains(Integer.toString(settingsObj.getNotifyComplaints_adminGroup()))) {
                                if (settingsObj.getNotifyComplaints_mode() == 1) {
                                    api.sendPrivateMessage(e.getClientId(), settingsObj.getNotifyComplaints_message());
                                } else if (settingsObj.getNotifyComplaints_mode() == 2) {
                                    api.pokeClient(e.getClientId(), settingsObj.getNotifyComplaints_message());
                                }
                            }
                        }
                    }
                }

                @Override
                public void onClientLeave(ClientLeaveEvent e) {
                    if (settingsObj.isMoveDefault_enabled()) {
                        if (moveDefault_list.contains(e.getClientId())) {
                            moveDefault_list.remove(e.getClientId());
                        }
                    }
                }

                @Override
                public void onClientMoved(ClientMovedEvent e) {
                    if (settingsObj.isMoveDefault_enabled()) {
                        if (moveDefault_list.contains(e.getClientId())) {
                            moveDefault_list.remove(e.getClientId());
                        }
                    }
                }

            });
        }

    }

    public static settingsAsClass loadSettings() {
        try {
            File file = new File("settings.yaml");
            ObjectMapper om = new ObjectMapper(new YAMLFactory());
            settingsAsClass settings = om.readValue(file, settingsAsClass.class);
            return settings;
        }
        catch(Exception ex) {
            return null;
        }
    }


}
