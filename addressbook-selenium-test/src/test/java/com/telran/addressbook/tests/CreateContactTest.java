package com.telran.addressbook.tests;

import com.telran.addressbook.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class CreateContactTest extends TestBase {
    @DataProvider
    public Iterator<Object[]> validContacts() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.csv")));
        String line = reader.readLine();
        while (line != null) {
            String[] split = line.split(";");
            list.add(new Object[]{new ContactData()
                    .withName(split[0])
                    .withLastname(split[1])
                    .withEmail(split[2])
                    .withPhone(split[3])
                    .withGroup(split[4])});
            line = reader.readLine();
        }
        return list.iterator();
    }


    @Test(dataProvider = "validContacts")
    public void testCreateContact(ContactData contacts) throws Exception {
        int before = app.getContactHelper().getContactCount();
        app.getContactHelper().initContactCreation();
        app.getContactHelper().fillContactForm(new ContactData()
                .withName(contacts.getName())
                .withLastname(contacts.getLastname())
                .withEmail(contacts.getEmail())
                .withPhone(contacts.getPhone())
                .withGroup(contacts.getGroup()));
        app.getContactHelper().submitContactCreation(By.xpath("(//input[@name='submit'])[2]"));
        int after = app.getContactHelper().getContactCount();
        Assert.assertEquals(after, before + 1);
    }

//    @Test
//    public void testCreateBlankContact() throws Exception {
//        int before = app.getContactHelper().getContactCount();
//        app.getContactHelper().initContactCreation();
//        app.getContactHelper().fillContactForm(new ContactData("", "", "", ""));
//        app.getContactHelper().submitContactCreation(By.xpath("(//input[@name='submit'])[2]"));
//        int after = app.getContactHelper().getContactCount();
//        Assert.assertEquals(after, before + 1);
//    }

}