package com.telran.addressbook.tests;

import com.telran.addressbook.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ModifyGroupTest extends TestBase {
    @Test
    public void groupModificationTests(){
        app.getNavigationHelper().goToGroupsPage();
       if( ! app.getGroupHelper().isThereAGroup()){
           app.getGroupHelper().createGroup();
       }
       int before = app.getGroupHelper().getGroupCount();
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().initModifyGroup();
        app.getGroupHelper().fillGroupForm(new GroupData()
                .withFooter("footer")
                .withName("name")
                .withHeader("1headre"));
        app.getGroupHelper().submitGroupModification();
        app.getGroupHelper().returnToGroupsPage();
        int after = app.getGroupHelper().getGroupCount();
        Assert.assertEquals(after, before);
    }
}
