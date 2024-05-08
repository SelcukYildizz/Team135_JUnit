package day06_jsAlerts_iFrame;

import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase_BeforeAfter;

public class C05_SwitchingWindows extends TestBase_BeforeAfter {

    @Test
    public void window(){

        driver.get("https://www.testotomasyonu.com");

        System.out.println(driver.getWindowHandle());

        // electronics linkine click yapalim

        driver.findElement(By.linkText("Electronics")).click();

        // wisequarter anasayfasina gidelim

        driver.get("https://www.wisequarter.com");

        System.out.println(driver.getWindowHandle());




    }
}
