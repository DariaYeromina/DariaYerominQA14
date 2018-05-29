package com.telran.addressbook.tests;

import com.telran.addressbook.model.GroupData;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;

public class CreatGroupTest extends TestBase {

    @Test
    public void testCreatGroupLongName() throws Exception {
        //OpenAddressbook
        int before = app.getGroupHelper().getGroupCount();
        app.getGroupHelper().initGroupCreation();
        app.getGroupHelper().fillGroupForm(new GroupData()
                .withName("")
                .withHeader("header1")
                .withFooter("footer1"));
        app.getGroupHelper().submitGroupCreation(By.name("submit"));
        app.getGroupHelper().returnToGroupsPage();
        int after = app.getGroupHelper().getGroupCount();
        //System.out.println("testCreateGroupLongName() passed");
        Assert.assertEquals(after, before + 1);

    }

    @Test
    public void testCreatGroupShortName() throws Exception {
        //OpenAddressbook
        app.getNavigationHelper().goToGroupsPage();
        int before = app.getGroupHelper().getGroupCount();
        app.getGroupHelper().initGroupCreation();
        app.getGroupHelper().fillGroupForm(new GroupData()
                .withName("n")
                .withHeader("h")
                .withFooter("f"));
        app.getGroupHelper().submitGroupCreation(By.name("submit"));
        app.getGroupHelper().returnToGroupsPage();
        int after = app.getGroupHelper().getGroupCount();
        //System.out.println("testCreateGroupShortName() passed");
        Assert.assertEquals(after, before + 1);
    }

    @Test
    public void testCreatGroupEmpty() throws Exception {
        //OpenAddressbook
        app.getNavigationHelper().goToGroupsPage();
        int before = app.getGroupHelper().getGroupCount();
        app.getGroupHelper().initGroupCreation();
        app.getGroupHelper().fillGroupForm(new GroupData()
                .withName("")
                .withHeader("")
                .withFooter(""));
        app.getGroupHelper().submitGroupCreation(By.name("submit"));
        app.getGroupHelper().returnToGroupsPage();
        int after = app.getGroupHelper().getGroupCount();
        //System.out.println("testCreateGroupEmptyName() passed");
        Assert.assertEquals(after, before + 1);
    }


}
