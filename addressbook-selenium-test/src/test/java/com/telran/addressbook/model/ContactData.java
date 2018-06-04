package com.telran.addressbook.model;

import java.io.File;

public class ContactData {
    private String name;
    private String lastname;
    private String group;
    private File photo;
    private String phone;
    private String email;

    public ContactData withName(String name) {
        this.name = name;
        return this;
    }
    public ContactData withLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }
    public ContactData withPhone(String phone) {
        this.phone = phone;
        return this;
    }
    public ContactData withEmail(String email) {
        this.email = email;
        return this;
    }
    public ContactData withGroup(String group) {
        this.group = group;
        return this;
    }
    public ContactData withPhoto(File photo) {
        this.photo = photo;
        return this;
    }

    public String getName() {
        return name;
    }
    public String getLastname() {
        return lastname;
    }
    public String getPhone() {
        return phone;
    }
    public String getEmail() {
        return email;
    }
    public File getPhoto() {
        return photo;
    }
    public String getGroup() { return group;
    }


    @Override
    public String toString() {
        return "ContactData{" +
                "name='" + name + '\'' +
                '}';
    }
}