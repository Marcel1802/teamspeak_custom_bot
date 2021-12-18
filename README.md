### Creating a 'settings.yaml' in the same directory as the jar files is necessary


    general_ip: 127.0.0.1
    general_virtualServerID: 1
    general_loginname: queryLoginName
    general_loginpassword: queryPassword
    general_displayname: displayName
    general_joinChannel: 1

    moveDefault_enabled: true
    moveDefault_defaultChannelID: 1
    moveDefault_AFKChannelID: 2
    moveDefault_moveTime: 30
    moveDefault_mode: 1
    moveDefault_message:  You got moved due to inactivity.

    notifyComplaints_enabled: true
    notifyComplaints_adminGroup: 6
    notifyComplaints_mode: 1
    notifyComplaints_message: There are entries on the complaints list!

    defaultNicknameCheck_enabled: true
    defaultNicknameCheck_mode: 1
    defaultNicknameCheck_message: Please don't use the default name, choose another one.

    versionWarner_enabled: true
    versionWarner_warningVersions:
        - "3.5.3 [Build: 1588756070]"
        - "3.5.2 [Build: 1585812952]"
        - "3.5.0 [Build: 1605605389]"
    versionWarner_warnMethod: 1
    versionWarner_warnMessage: You are using an outdated version of the TeamSpeak client. Please update your client.
    versionWarner_kickVersions:
        - "3.3.2 [Build: 1566767614]"
    versionWarner_kickMessage: Your TeamSpeak client is VERY outdated. Please update your client immediately.

## Modules

moveDefault: Moves a client after a specific time if the user is idling in the default channel

notifyComplaints: Notifies admins after joining if there are entries on the complaints list

defaultNicknameCheck: Notifies a user if the name is equals "TeamSpeakUser"

versionWarner: Warns / kicks clients if their TeamSpeak client version is listed (used for outdated client versions)

## Some setting explainations

> general_joinChannel: Channel the bot goes into after joining

> moveDefault_mode: Possible modes: 0 = no notification, 1 = message, 2 = poke

> moveDefault_moveTime: Time after the client gets moved from the default channel into the AFK channel (in seconds)

> notifyComplaints_mode: Possible modes: 1 = message, 2 = poke

> defaultNicknameCheck_mode: Possible modes: 1 = message, 2 = poke, 3 = kick
