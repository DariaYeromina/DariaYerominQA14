package com.telran.addressbook.tests;

import com.telran.addressbook.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ModifyContact extends TestBase {

    @Test
    public void contactModificationTests() {
        int before = app.getContactCount();
        app.initModifyContact();
        app.submitContactModification();
        int after = app.getContactCount();
        Assert.assertEquals(after, before);

    }
}
