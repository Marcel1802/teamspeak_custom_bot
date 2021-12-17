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

## Modules

moveDefault: Moves a client after a specific time if the user is idling in the default channel

notifyComplaints: Notifies admins after joining if there are entries on the complaints list

defaultNicknameCheck: Notifies a user if the name is equals "TeamSpeakUser"

## Some setting explainations

> general_joinChannel: Channel the bot goes into after joining

> moveDefault_mode: Possible modes: 0 = no notification, 1 = message, 2 = poke

> moveDefault_moveTime: Time after the client gets moved from the default channel into the AFK channel (in seconds)

> notifyComplaints_mode: Possible modes: 1 = message, 2 = poke

> defaultNicknameCheck_mode: Possible modes: 1 = message, 2 = poke, 3 = kick
