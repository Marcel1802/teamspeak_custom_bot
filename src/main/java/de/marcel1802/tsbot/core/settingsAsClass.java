package de.marcel1802.tsbot.core;


public class settingsAsClass {


    private String  general_ip;
    private String  general_loginname;
    private String  general_loginpassword;
    private String  general_displayname;
    private int     general_joinChannel;

    private boolean moveDefault_enabled;
    private int     moveDefault_defaultChannelID;
    private int     moveDefault_AFKChannelID;
    private int     moveDefault_moveTime;
    private int     moveDefault_mode;
    private String  moveDefault_message;

    private boolean notifyComplaints_enabled;
    private int     notifyComplaints_adminGroup;
    private int     notifyComplaints_mode;
    private String  notifyComplaints_message;

    private boolean defaultNicknameCheck_enabled;
    private String  defaultNicknameCheck_message;

    public settingsAsClass() {}

    public settingsAsClass(String general_ip, String general_loginname, String general_loginpassword, String general_displayname, int general_joinChannel, boolean moveDefault_enabled, int moveDefault_defaultChannelID, int moveDefault_AFKChannelID, int moveDefault_moveTime, int moveDefault_mode, String moveDefault_message, boolean notifyComplaints_enabled, int notifyComplaints_adminGroup, int notifyComplaints_mode, String notifyComplaints_message, boolean defaultNicknameCheck_enabled, String defaultNicknameCheck_message) {
        this.general_ip = general_ip;
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
        this.notifyComplaints_enabled = notifyComplaints_enabled;
        this.notifyComplaints_adminGroup = notifyComplaints_adminGroup;
        this.notifyComplaints_mode = notifyComplaints_mode;
        this.notifyComplaints_message = notifyComplaints_message;
        this.defaultNicknameCheck_enabled = defaultNicknameCheck_enabled;
        this.defaultNicknameCheck_message = defaultNicknameCheck_message;
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

    public int getMoveDefault_mode() {
        return moveDefault_mode;
    }

    public void setMoveDefault_mode(int moveDefault_mode) {
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

    public int getNotifyComplaints_mode() {
        return notifyComplaints_mode;
    }

    public void setNotifyComplaints_mode(int notifyComplaints_mode) {
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

    @Override
    public String toString() {
        return "settingsAsClass{" +
                "general_ip='" + general_ip + '\'' +
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
                ", notifyComplaints_enabled=" + notifyComplaints_enabled +
                ", notifyComplaints_adminGroup=" + notifyComplaints_adminGroup +
                ", notifyComplaints_mode=" + notifyComplaints_mode +
                ", notifyComplaints_message='" + notifyComplaints_message + '\'' +
                ", defaultNicknameCheck_enabled=" + defaultNicknameCheck_enabled +
                ", defaultNicknameCheck_message='" + defaultNicknameCheck_message + '\'' +
                '}';
    }
}
