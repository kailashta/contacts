package com.company;

import java.util.ArrayList;

public class User {
    private String userName;
    private String emailId;
    private String password;
    private ArrayList<ContactPojo> contacts = new ArrayList<>();

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<ContactPojo> getContacts() {
        return contacts;
    }

    public void setContacts(ArrayList<ContactPojo> contacts) {
        this.contacts = contacts;
    }

    public User(String userName, String emailId, String password) {
        this.userName = userName;
        this.emailId = emailId;
        this.password = password;
    }
    public User(){

    }
}
