import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Test {
    private WebDriver driver;

   public void someMethod(){
       type(By.name("firstname"), "name");
       type(By.name("firstname3"), "name3");
   }

    public void type(By locator, String text) {
        driver.findElement(locator).click();
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
    }
}
