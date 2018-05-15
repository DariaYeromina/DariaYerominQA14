package com.telran.addressbook.tests;

import com.telran.addressbook.appManager.ApplicationManager;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class TestBase {

    public ApplicationManager app = new ApplicationManager();

    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {
        app.start();

    }

    @AfterClass(alwaysRun = true)
    public void tearDown() throws Exception {
        app.stop();

    }

}
