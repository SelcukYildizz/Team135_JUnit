package day07_actionClass_fakerClass;

import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase_BeforeAfterClass;

public class C07_KlavyeEylemleri extends TestBase_BeforeAfterClass {


    @Test
    public void test01(){

        driver.get("htttps://www.testotomasyonu.com");

        Actions actions = new Actions(driver);

        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.bekle(2);



        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.bekle(2);

        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.bekle(2);

        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.bekle(2);

        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.bekle(2);



    }



}
