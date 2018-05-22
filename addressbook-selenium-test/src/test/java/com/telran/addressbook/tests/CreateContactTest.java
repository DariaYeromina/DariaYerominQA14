package com.telran.addressbook.tests;

import com.telran.addressbook.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.*;


public class CreateContactTest extends TestBase {
    private WebDriver driver;


    @Test
    public void testCreateContact() throws Exception {
        int before = app.getContactHelper().getContactCount();
        app.getContactHelper().initContactCreation();
        app.getContactHelper().fillContactForm(new ContactData("Daria", "Yeromin", "0532849684", "daria.sviridenko@gmail.com"));
        app.getContactHelper().submitContactCreation(By.xpath("(//input[@name='submit'])[2]"));
        int after = app.getContactHelper().getContactCount();
        Assert.assertEquals(after, before + 1);
    }
    @Test
    public void testCreateBlankContact() throws Exception {
        int before = app.getContactHelper().getContactCount();
        app.getContactHelper().initContactCreation();
        app.getContactHelper().fillContactForm(new ContactData("", "", "", ""));
        app.getContactHelper().submitContactCreation(By.xpath("(//input[@name='submit'])[2]"));
        int after = app.getContactHelper().getContactCount();
        Assert.assertEquals(after, before + 1);
    }

}
