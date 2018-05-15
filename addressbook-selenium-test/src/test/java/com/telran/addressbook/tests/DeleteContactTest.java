package com.telran.addressbook.tests;

import org.testng.annotations.Test;

public class DeleteContactTest extends TestBase {

    @Test
    public void contactDeletionTest(){
        app.selectContact();
        app.initContactDeletion();
        app.acceptAlert();

    }
}
