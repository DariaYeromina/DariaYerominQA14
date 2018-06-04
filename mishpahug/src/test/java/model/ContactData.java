package model;

import java.io.File;

public class ContactData {
    private String name;
    private String lastname;
    private String phone;
    private String email;
    private String group;
    private File photo;

    public String getGroup() {
        return group;
    }

    public ContactData withGroup(String group) {
        this.group = group;
        return this;
    }

    public File getPhoto(){
        return photo;
    }

    public ContactData withPhoto(File photo){
        this.photo = photo;
        return this;
    }

    public ContactData(String name, String lastname, String phone, String email) {
        this.name = name;
        this.lastname = lastname;
        this.phone = phone;
        this.email = email;
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
}
