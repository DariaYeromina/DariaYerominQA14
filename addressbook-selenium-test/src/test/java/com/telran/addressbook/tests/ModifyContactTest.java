package com.telran.addressbook.tests;

import com.telran.addressbook.model.ContactData;
import com.telran.addressbook.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ModifyContactTest extends TestBase {

    @Test
    public void contactModificationTests() {
        app.getNavigationHelper().goToHomePage();
        if (!app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact();
        }
        int before = app.getContactHelper().getContactCount();
        app.getContactHelper().initModifyContact();
        app.getContactHelper().fillContactForm(new ContactData()
                .withName("")
                .withLastname("")
                .withEmail("")
                .withPhone(""));
        app.getContactHelper().submitContactModification();
        int after = app.getContactHelper().getContactCount();
        Assert.assertEquals(after, before);

    }
}
