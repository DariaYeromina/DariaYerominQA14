package com.telran.addressbook.appManager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager  {

    private ContactHelper contactHelper;
    private GroupHelper groupHelper;
    private NavigationHelper navigationHelper;
    private HelperBase helperBase;
    private WebDriver driver;


    public void start() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        groupHelper = new GroupHelper(driver);
        navigationHelper = new NavigationHelper(driver);
        helperBase = new HelperBase(driver);
        contactHelper=new ContactHelper(driver);
        openAddressbook("http://localhost/addressbook/");
        login("admin", "secret");
    }

    public void login(String user, String pwd) {
        driver.findElement(By.name("user")).clear();
        driver.findElement(By.name("user")).sendKeys(user);
        driver.findElement(By.name("pass")).click();
        driver.findElement(By.name("pass")).clear();
        driver.findElement(By.name("pass")).sendKeys(pwd);
        driver.findElement(By.xpath("//input[@value='Login']")).click();
    }

    public void openAddressbook(String url) {
        driver.get(url);
    }

    public void acceptAlert() {
        driver.switchTo().alert().accept();
    }

    public void stop() {
        driver.quit();
    }

    public ContactHelper getContactHelper() {
        return contactHelper;
    }

    public GroupHelper getGroupHelper() {
        return groupHelper;
    }

    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }
}
