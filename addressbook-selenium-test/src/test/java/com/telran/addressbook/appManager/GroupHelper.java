package com.telran.addressbook.appManager;

import com.telran.addressbook.model.GroupData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GroupHelper extends HelperBase {

    public GroupHelper(WebDriver driver) {
        super(driver);
    }

    public void returnToGroupsPage() {

        click(By.linkText("group page"));
    }

    public void submitGroupCreation(By locator) {

        click(locator);
    }

    public void fillGroupForm(GroupData groupData) {
        type(By.name("group_name"), groupData.getName());
        type(By.name("group_header"), groupData.getHeader());
        type(By.name("group_footer"), groupData.getFooter());

    }

    public void initGroupCreation() {
        click(By.name("new"));
    }

    public void deleteGroup() {
        click(By.name("delete"));

    }

    public void selectGroup() {
        click(By.name("selected[]"));
    }

    public int getGroupCount() {
        return driver.findElements(By.name("selected[]")).size();
    }

    public void initModifyGroup() {
        click(By.xpath("//*[@value='Edit group']"));
    }

    public void submitGroupModification() {
        click(By.cssSelector("[name=update]"));
    }

    public boolean isThereAGroup() {
        return isElementPresent(By.name("selected[]"));
    }

    public void createGroup() {
        initGroupCreation();
        fillGroupForm(new GroupData()
                .withName("name1")
                .withHeader("header1")
                .withFooter("footer1"));
        submitGroupCreation(By.name("submit"));
        returnToGroupsPage();
    }
}
