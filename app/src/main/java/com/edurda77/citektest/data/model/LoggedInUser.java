package com.edurda77.citektest.data.model;

public class LoggedInUser {

    private String userName;
    private String userPassword;

    public LoggedInUser(String userName, String displayName) {
        this.userName = userName;
        this.userPassword = displayName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserPassword() {
        return userPassword;
    }
}