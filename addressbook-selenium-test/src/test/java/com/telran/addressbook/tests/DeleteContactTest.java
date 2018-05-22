package com.telran.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DeleteContactTest extends TestBase {

    @Test
    public void contactDeletionTest() {
        app.getNavigationHelper().goToHomePage();

        if (!app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact();
        }
        int before = app.getContactHelper().getContactCount();
        app.getContactHelper().selectContact();
        app.getContactHelper().initContactDeletion();
        app.acceptAlert();
        int after = app.getContactHelper().getContactCount();
        Assert.assertEquals(after, before - 1);

    }
}
