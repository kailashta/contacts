package com.company;

import java.util.ArrayList;

public class ContactPojo {
    private String name;
    private String title;
    private String company;
    private static ArrayList<Long> phoneNumbers = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public  ArrayList<Long> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(ArrayList<Long> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public ContactPojo(String name, String title, String company , ArrayList<Long> phoneNumbers) {
        this.name = name;
        this.title = title;
        this.company = company;
        this.phoneNumbers = phoneNumbers;
    }
    public ContactPojo(){

    }
}
