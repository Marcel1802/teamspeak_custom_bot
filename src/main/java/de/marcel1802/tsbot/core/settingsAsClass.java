package de.marcel1802.tsbot.core;


import java.util.Set;

public class settingsAsClass {


    private String  general_ip;
    private int     general_virtualServerID;
    private String  general_loginname;
    private String  general_loginpassword;
    private String  general_displayname;
    private int     general_joinChannel;

    private boolean     moveDefault_enabled;
    private int         moveDefault_defaultChannelID;
    private int         moveDefault_AFKChannelID;
    private int         moveDefault_moveTime;
    private BotAction   moveDefault_mode;
    private String      moveDefault_message;
    private boolean     moveDefault_logging;

    private boolean     notifyComplaints_enabled;
    private int         notifyComplaints_adminGroup;
    private BotAction   notifyComplaints_mode;
    private String      notifyComplaints_message;
    private boolean     notifyComplaints_logging;

    private boolean     defaultNicknameCheck_enabled;
    private BotAction   defaultNicknameCheck_mode;
    private String      defaultNicknameCheck_message;
    private boolean     defaultNicknameCheck_logging;


    private boolean     versionWarner_enabled;
    private Set<String> versionWarner_warningVersions;
    private String      versionWarner_warnMessage;
    private boolean     versionWarner_logging;

    private boolean     countryList_enabled;
    private int         countryList_mode;
    private Set<String> countryList_whitelist;
    private String      countryList_whitelistKickMessage;
    private Set<String> countryList_blacklist;
    private String      countryList_blacklistKickMessage;
    private boolean     countryList_logging;

    public boolean isMoveDefault_logging() {
        return moveDefault_logging;
    }

    public void setMoveDefault_logging(boolean moveDefault_logging) {
        this.moveDefault_logging = moveDefault_logging;
    }

    public boolean isNotifyComplaints_logging() {
        return notifyComplaints_logging;
    }

    public void setNotifyComplaints_logging(boolean notifyComplaints_logging) {
        this.notifyComplaints_logging = notifyComplaints_logging;
    }

    public boolean isDefaultNicknameCheck_logging() {
        return defaultNicknameCheck_logging;
    }

    public void setDefaultNicknameCheck_logging(boolean defaultNicknameCheck_logging) {
        this.defaultNicknameCheck_logging = defaultNicknameCheck_logging;
    }

    public boolean isVersionWarner_logging() {
        return versionWarner_logging;
    }

    public void setVersionWarner_logging(boolean versionWarner_logging) {
        this.versionWarner_logging = versionWarner_logging;
    }

    public boolean isCountryList_logging() {
        return countryList_logging;
    }

    public void setCountryList_logging(boolean countryList_logging) {
        this.countryList_logging = countryList_logging;
    }

    public boolean isCountryList_enabled() {
        return countryList_enabled;
    }

    public void setCountryList_enabled(boolean countryList_enabled) {
        this.countryList_enabled = countryList_enabled;
    }

    public int getCountryList_mode() {
        return countryList_mode;
    }

    public void setCountryList_mode(int countryList_mode) {
        this.countryList_mode = countryList_mode;
    }

    public Set<String> getCountryList_whitelist() {
        return countryList_whitelist;
    }

    public void setCountryList_whitelist(Set<String> countryList_whitelist) {
        this.countryList_whitelist = countryList_whitelist;
    }

    public String getCountryList_whitelistKickMessage() {
        return countryList_whitelistKickMessage;
    }

    public void setCountryList_whitelistKickMessage(String countryList_whitelistKickMessage) {
        this.countryList_whitelistKickMessage = countryList_whitelistKickMessage;
    }

    public Set<String> getCountryList_blacklist() {
        return countryList_blacklist;
    }

    public void setCountryList_blacklist(Set<String> countryList_blacklist) {
        this.countryList_blacklist = countryList_blacklist;
    }

    public String getCountryList_blacklistKickMessage() {
        return countryList_blacklistKickMessage;
    }

    public void setCountryList_blacklistKickMessage(String countryList_blacklistKickMessage) {
        this.countryList_blacklistKickMessage = countryList_blacklistKickMessage;
    }

    public int getVersionWarner_warnMethod() {
        return versionWarner_warnMethod;
    }

    public void setVersionWarner_warnMethod(int versionWarner_warnMethod) {
        this.versionWarner_warnMethod = versionWarner_warnMethod;
    }

    private int         versionWarner_warnMethod;
    private Set<String> versionWarner_kickVersions;
    private String      versionWarner_kickMessage;

    public boolean isVersionWarner_enabled() {
        return versionWarner_enabled;
    }

    public void setVersionWarner_enabled(boolean versionWarner_enabled) {
        this.versionWarner_enabled = versionWarner_enabled;
    }

    public Set<String> getVersionWarner_warningVersions() {
        return versionWarner_warningVersions;
    }

    public void setVersionWarner_warningVersions(Set<String> versionWarner_warningVersions) {
        this.versionWarner_warningVersions = versionWarner_warningVersions;
    }

    public String getVersionWarner_warnMessage() {
        return versionWarner_warnMessage;
    }

    public void setVersionWarner_warnMessage(String versionWarner_warnMessage) {
        this.versionWarner_warnMessage = versionWarner_warnMessage;
    }

    public Set<String> getVersionWarner_kickVersions() {
        return versionWarner_kickVersions;
    }

    public void setVersionWarner_kickVersions(Set<String> versionWarner_kickVersions) {
        this.versionWarner_kickVersions = versionWarner_kickVersions;
    }

    public String getVersionWarner_kickMessage() {
        return versionWarner_kickMessage;
    }

    public void setVersionWarner_kickMessage(String versionWarner_kickMessage) {
        this.versionWarner_kickMessage = versionWarner_kickMessage;
    }

    public settingsAsClass() {}

    @Override
    public String toString() {
        return "settingsAsClass{" +
                "general_ip='" + general_ip + '\'' +
                ", general_virtualServerID=" + general_virtualServerID +
                ", general_loginname='" + general_loginname + '\'' +
                ", general_loginpassword='" + general_loginpassword + '\'' +
                ", general_displayname='" + general_displayname + '\'' +
                ", general_joinChannel=" + general_joinChannel +
                ", moveDefault_enabled=" + moveDefault_enabled +
                ", moveDefault_defaultChannelID=" + moveDefault_defaultChannelID +
                ", moveDefault_AFKChannelID=" + moveDefault_AFKChannelID +
                ", moveDefault_moveTime=" + moveDefault_moveTime +
                ", moveDefault_mode=" + moveDefault_mode +
                ", moveDefault_message='" + moveDefault_message + '\'' +
                ", moveDefault_logging=" + moveDefault_logging +
                ", notifyComplaints_enabled=" + notifyComplaints_enabled +
                ", notifyComplaints_adminGroup=" + notifyComplaints_adminGroup +
                ", notifyComplaints_mode=" + notifyComplaints_mode +
                ", notifyComplaints_message='" + notifyComplaints_message + '\'' +
                ", notifyComplaints_logging=" + notifyComplaints_logging +
                ", defaultNicknameCheck_enabled=" + defaultNicknameCheck_enabled +
                ", defaultNicknameCheck_mode=" + defaultNicknameCheck_mode +
                ", defaultNicknameCheck_message='" + defaultNicknameCheck_message + '\'' +
                ", defaultNicknameCheck_logging=" + defaultNicknameCheck_logging +
                ", versionWarner_enabled=" + versionWarner_enabled +
                ", versionWarner_warningVersions=" + versionWarner_warningVersions +
                ", versionWarner_warnMessage='" + versionWarner_warnMessage + '\'' +
                ", versionWarner_logging=" + versionWarner_logging +
                ", countryList_enabled=" + countryList_enabled +
                ", countryList_mode=" + countryList_mode +
                ", countryList_whitelist=" + countryList_whitelist +
                ", countryList_whitelistKickMessage='" + countryList_whitelistKickMessage + '\'' +
                ", countryList_blacklist=" + countryList_blacklist +
                ", countryList_blacklistKickMessage='" + countryList_blacklistKickMessage + '\'' +
                ", countryList_logging=" + countryList_logging +
                ", versionWarner_warnMethod=" + versionWarner_warnMethod +
                ", versionWarner_kickVersions=" + versionWarner_kickVersions +
                ", versionWarner_kickMessage='" + versionWarner_kickMessage + '\'' +
                '}';
    }

    public settingsAsClass(String general_ip, int general_virtualServerID, String general_loginname, String general_loginpassword, String general_displayname, int general_joinChannel, boolean moveDefault_enabled, int moveDefault_defaultChannelID, int moveDefault_AFKChannelID, int moveDefault_moveTime, BotAction moveDefault_mode, String moveDefault_message, boolean moveDefault_logging, boolean notifyComplaints_enabled, int notifyComplaints_adminGroup, BotAction notifyComplaints_mode, String notifyComplaints_message, boolean notifyComplaints_logging, boolean defaultNicknameCheck_enabled, BotAction defaultNicknameCheck_mode, String defaultNicknameCheck_message, boolean defaultNicknameCheck_logging, boolean versionWarner_enabled, Set<String> versionWarner_warningVersions, String versionWarner_warnMessage, boolean versionWarner_logging, boolean countryList_enabled, int countryList_mode, Set<String> countryList_whitelist, String countryList_whitelistKickMessage, Set<String> countryList_blacklist, String countryList_blacklistKickMessage, boolean countryList_logging, int versionWarner_warnMethod, Set<String> versionWarner_kickVersions, String versionWarner_kickMessage) {
        this.general_ip = general_ip;
        this.general_virtualServerID = general_virtualServerID;
        this.general_loginname = general_loginname;
        this.general_loginpassword = general_loginpassword;
        this.general_displayname = general_displayname;
        this.general_joinChannel = general_joinChannel;
        this.moveDefault_enabled = moveDefault_enabled;
        this.moveDefault_defaultChannelID = moveDefault_defaultChannelID;
        this.moveDefault_AFKChannelID = moveDefault_AFKChannelID;
        this.moveDefault_moveTime = moveDefault_moveTime;
        this.moveDefault_mode = moveDefault_mode;
        this.moveDefault_message = moveDefault_message;
        this.moveDefault_logging = moveDefault_logging;
        this.notifyComplaints_enabled = notifyComplaints_enabled;
        this.notifyComplaints_adminGroup = notifyComplaints_adminGroup;
        this.notifyComplaints_mode = notifyComplaints_mode;
        this.notifyComplaints_message = notifyComplaints_message;
        this.notifyComplaints_logging = notifyComplaints_logging;
        this.defaultNicknameCheck_enabled = defaultNicknameCheck_enabled;
        this.defaultNicknameCheck_mode = defaultNicknameCheck_mode;
        this.defaultNicknameCheck_message = defaultNicknameCheck_message;
        this.defaultNicknameCheck_logging = defaultNicknameCheck_logging;
        this.versionWarner_enabled = versionWarner_enabled;
        this.versionWarner_warningVersions = versionWarner_warningVersions;
        this.versionWarner_warnMessage = versionWarner_warnMessage;
        this.versionWarner_logging = versionWarner_logging;
        this.countryList_enabled = countryList_enabled;
        this.countryList_mode = countryList_mode;
        this.countryList_whitelist = countryList_whitelist;
        this.countryList_whitelistKickMessage = countryList_whitelistKickMessage;
        this.countryList_blacklist = countryList_blacklist;
        this.countryList_blacklistKickMessage = countryList_blacklistKickMessage;
        this.countryList_logging = countryList_logging;
        this.versionWarner_warnMethod = versionWarner_warnMethod;
        this.versionWarner_kickVersions = versionWarner_kickVersions;
        this.versionWarner_kickMessage = versionWarner_kickMessage;
    }

    public int getGeneral_joinChannel() {
        return general_joinChannel;
    }

    public void setGeneral_joinChannel(int general_joinChannel) {
        this.general_joinChannel = general_joinChannel;
    }

    public String getGeneral_ip() {
        return general_ip;
    }

    public void setGeneral_ip(String general_ip) {
        this.general_ip = general_ip;
    }

    public String getGeneral_loginname() {
        return general_loginname;
    }

    public void setGeneral_loginname(String general_loginname) {
        this.general_loginname = general_loginname;
    }

    public String getGeneral_loginpassword() {
        return general_loginpassword;
    }

    public void setGeneral_loginpassword(String general_loginpassword) {
        this.general_loginpassword = general_loginpassword;
    }

    public String getGeneral_displayname() {
        return general_displayname;
    }

    public void setGeneral_displayname(String general_displayname) {
        this.general_displayname = general_displayname;
    }

    public boolean isMoveDefault_enabled() {
        return moveDefault_enabled;
    }

    public void setMoveDefault_enabled(boolean moveDefault_enabled) {
        this.moveDefault_enabled = moveDefault_enabled;
    }

    public int getMoveDefault_defaultChannelID() {
        return moveDefault_defaultChannelID;
    }

    public void setMoveDefault_defaultChannelID(int moveDefault_defaultChannelID) {
        this.moveDefault_defaultChannelID = moveDefault_defaultChannelID;
    }

    public int getMoveDefault_AFKChannelID() {
        return moveDefault_AFKChannelID;
    }

    public void setMoveDefault_AFKChannelID(int moveDefault_AFKChannelID) {
        this.moveDefault_AFKChannelID = moveDefault_AFKChannelID;
    }

    public int getMoveDefault_moveTime() {
        return moveDefault_moveTime;
    }

    public void setMoveDefault_moveTime(int moveDefault_moveTime) {
        this.moveDefault_moveTime = moveDefault_moveTime;
    }

    public BotAction getMoveDefault_mode() {
        return moveDefault_mode;
    }

    public void setMoveDefault_mode(BotAction moveDefault_mode) {
        this.moveDefault_mode = moveDefault_mode;
    }

    public String getMoveDefault_message() {
        return moveDefault_message;
    }

    public void setMoveDefault_message(String moveDefault_message) {
        this.moveDefault_message = moveDefault_message;
    }

    public boolean isNotifyComplaints_enabled() {
        return notifyComplaints_enabled;
    }

    public void setNotifyComplaints_enabled(boolean notifyComplaints_enabled) {
        this.notifyComplaints_enabled = notifyComplaints_enabled;
    }

    public int getNotifyComplaints_adminGroup() {
        return notifyComplaints_adminGroup;
    }

    public void setNotifyComplaints_adminGroup(int notifyComplaints_adminGroup) {
        this.notifyComplaints_adminGroup = notifyComplaints_adminGroup;
    }

    public BotAction getNotifyComplaints_mode() {
        return notifyComplaints_mode;
    }

    public void setNotifyComplaints_mode(BotAction notifyComplaints_mode) {
        this.notifyComplaints_mode = notifyComplaints_mode;
    }

    public String getNotifyComplaints_message() {
        return notifyComplaints_message;
    }

    public void setNotifyComplaints_message(String notifyComplaints_message) {
        this.notifyComplaints_message = notifyComplaints_message;
    }


    public boolean isDefaultNicknameCheck_enabled() {
        return defaultNicknameCheck_enabled;
    }

    public void setDefaultNicknameCheck_enabled(boolean defaultNicknameCheck_enabled) {
        this.defaultNicknameCheck_enabled = defaultNicknameCheck_enabled;
    }

    public String getDefaultNicknameCheck_message() {
        return defaultNicknameCheck_message;
    }

    public void setDefaultNicknameCheck_message(String defaultNicknameCheck_message) {
        this.defaultNicknameCheck_message = defaultNicknameCheck_message;
    }

    public BotAction getDefaultNicknameCheck_mode() {
        return defaultNicknameCheck_mode;
    }

    public void setDefaultNicknameCheck_mode(BotAction defaultNicknameCheck_mode) {
        this.defaultNicknameCheck_mode = defaultNicknameCheck_mode;
    }

    public int getGeneral_virtualServerID() {
        return general_virtualServerID;
    }

    public void setGeneral_virtualServerID(int general_virtualServerID) {
        this.general_virtualServerID = general_virtualServerID;
    }

}
