package com.telran.addressbook.appManager;

import com.telran.addressbook.model.ContactData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactHelper extends HelperBase {


    public ContactHelper(WebDriver driver) {
        super(driver);
    }

    public void initContactCreation() {
        click(By.linkText("add new"));
    }

    public void fillContactForm(ContactData contactData) {
        type(By.name("firstname"), contactData.getName());
        type(By.name("lastname"), contactData.getLastname());
        type(By.name("mobile"), contactData.getPhone());
        type(By.name("email"), contactData.getEmail());

    }

    public void submitContactCreation(By locator){
        click(locator);
    }

    public int getContactCount() {
        return driver.findElements(By.name("selected[]")).size();
    }

    public void createContact() {
        initContactCreation();
        type(By.name("firstname"), "name");
        type(By.name("lastname"), "lastname");
        type(By.name("mobile"), "9999999999");
        type(By.name("email"), "email@gmail.com");
        submitContactCreation(By.name("submit"));
    }

    public boolean isThereAContact() {
        return isElementPresent(By.name("selected[]"));
    }

    public void selectContact() {
        click(By.name("selected[]"));
    }

    public void initContactDeletion() {
        click(By.xpath("//html//div[2]/input[1]"));
    }

    public void initModifyContact() {
        click(By.xpath("//img[@alt='Edit']"));
}

    public void submitContactModification() {
        click(By.name("update"));
    }
}

