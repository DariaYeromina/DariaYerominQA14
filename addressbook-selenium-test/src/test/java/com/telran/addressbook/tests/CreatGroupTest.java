package com.telran.addressbook.tests;

import com.telran.addressbook.model.GroupData;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;

public class CreatGroupTest extends TestBase {

  @Test(priority = 2)
  public void testCreatGroupLongName() throws Exception {
    //OpenAddressbook
    int before = app.getGroupHelper().getGroupCount();
    app.getGroupHelper().initGroupCreation();
    app.getGroupHelper().fillGroupForm(new GroupData("name1", "header1", "footer1"));
    app.getGroupHelper().submitGroupCreation(By.name("submit"));
    app.getGroupHelper().returnToGroupsPage();
    int after = app.getGroupHelper().getGroupCount();
    //System.out.println("testCreateGroupLongName() passed");
    Assert.assertEquals(after, before+1);

  }

  @Test(priority = 1)
  public void testCreatGroupShortName() throws Exception {
    //OpenAddressbook
    app.getNavigationHelper().goToGroupsPage();
    int before = app.getGroupHelper().getGroupCount();
    app.getGroupHelper().initGroupCreation();
    app.getGroupHelper().fillGroupForm(new GroupData("n", "h", "f"));
    app.getGroupHelper().submitGroupCreation(By.name("submit"));
    app.getGroupHelper().returnToGroupsPage();
    int after = app.getGroupHelper().getGroupCount();
    //System.out.println("testCreateGroupShortName() passed");
    Assert.assertEquals(after,before+1);
  }

  @Test(priority = 3)
  public void testCreatGroupEmpty() throws Exception {
    //OpenAddressbook
    app.getNavigationHelper().goToGroupsPage();
    int before = app.getGroupHelper().getGroupCount();
    app.getGroupHelper().initGroupCreation();
    app.getGroupHelper().fillGroupForm(new GroupData("", "", ""));
    app.getGroupHelper().submitGroupCreation(By.name("submit"));
    app.getGroupHelper().returnToGroupsPage();
    int after = app.getGroupHelper().getGroupCount();
    //System.out.println("testCreateGroupEmptyName() passed");
    Assert.assertEquals(after, before+1);
  }



}
