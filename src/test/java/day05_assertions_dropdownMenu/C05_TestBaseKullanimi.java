package day05_assertions_dropdownMenu;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase_BeforeAfter;

import java.util.List;

public class C05_TestBaseKullanimi extends TestBase_BeforeAfter {

    //

   @Test
    public void aramaTesti(){
       // testotomasyonu sitesine gidin

       driver.get("https://www.testotomasyonu.com");

       // phone icin arama yapin

       WebElement aramaKutusu = driver.findElement(By.id("global-search"));
       aramaKutusu.sendKeys("phone" + Keys.ENTER);


       //

       List<WebElement> bulunanElementList =
               driver. findElements(By.xpath("//*[@*='product-box my-2  py-1']"));

       Assert.assertTrue(bulunanElementList.size()>0);
       ReusableMethods.bekle(3);

   }



}
