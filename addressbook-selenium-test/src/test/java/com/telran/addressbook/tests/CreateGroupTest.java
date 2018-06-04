package com.telran.addressbook.tests;

import com.telran.addressbook.model.GroupData;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class CreateGroupTest extends TestBase {
    @DataProvider
    public Iterator<Object[]> validGroups() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/groups.csv")));
        String line = reader.readLine();
        while (line!=null){
            String[]split = line.split(";");
            list.add(new Object[]{ new GroupData()
                    .withName(split[0])
                    .withHeader(split[1])
                    .withFooter(split[2])});
            line = reader.readLine();
        }
        return list.iterator();
    }

    @Test(dataProvider = "validGroups")
    public void testCreateGroupLongName(GroupData group){
        app.getNavigationHelper().goToGroupsPage();
        int before = app.getGroupHelper().getGroupCount();
        app.getGroupHelper().initGroupCreation();
        app.getGroupHelper().fillGroupForm(new GroupData()
                .withName(group.getName())
                .withHeader(group.getHeader())
                .withFooter(group.getFooter()));
        app.getGroupHelper().submitGroupCreation(By.name("submit"));
        app.getGroupHelper().returnToGroupsPage();
        int after = app.getGroupHelper().getGroupCount();
        Assert.assertEquals(after,before+1);

    }

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
