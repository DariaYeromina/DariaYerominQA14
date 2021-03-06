package com.telran.addressbook.appManager;

import com.telran.addressbook.model.ContactData;
import com.telran.addressbook.tests.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class ContactHelper extends HelperBase {


    public ContactHelper(WebDriver driver) {
        super(driver);
    }

    public void initContactCreation() {
        click(By.linkText("add new"));
    }

    public void fillContactForm(ContactData contactData) {
        if(contactData.getGroup() != null){
        if (isElementPresent(By.name("new_group"))&&
                isElementPresent(By.xpath("//select[@name='new_group']/option[text()='"+contactData.getGroup()+"']"))) {
            new Select(driver.findElement(By.name("new_group")))
                    .selectByVisibleText(contactData.getGroup());
        } else if (isElementPresent(By.name("new_group"))){
            TestBase.app.getGroupHelper().createGroupWithThisName(contactData.getGroup());
            TestBase.app.getNavigationHelper().goToHomePage();
            initContactCreation();
            new Select(driver.findElement(By.name("new_group")))
                    .selectByVisibleText(contactData.getGroup());
        }}
        type(By.name("firstname"), contactData.getName());
        type(By.name("lastname"), contactData.getLastname());
        type(By.name("mobile"), contactData.getPhone());
        type(By.name("email"), contactData.getEmail());
        attach(By.name("photo"), contactData.getPhoto());

        if (isElementPresent(By.xpath("//*[@name='new_group']"))) {
            new Select(driver.findElement(By.xpath("//*[@name='new_group']"))).selectByVisibleText(contactData.getGroup());

        }
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

    public void selectAllContacts() {
        click(By.id("MassCB"));
    }
}

