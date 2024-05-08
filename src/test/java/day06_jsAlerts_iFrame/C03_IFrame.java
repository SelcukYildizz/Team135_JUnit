package day06_jsAlerts_iFrame;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase_BeforeAfter;

public class C03_IFrame extends TestBase_BeforeAfter {



    @Test
    public void iframeTest(){

        //1 ) https://the-internet.herokuapp.com/iframe adresine gidin.
        driver.get("https://the-internet.herokuapp.com/iframe");

        // - “An IFrame containing….” textinin erisilebilir oldugunu test edin ve  konsolda yazdirin.
        WebElement anIframeYaziElementi = driver.findElement(By.tagName("h3"));

        Assert.assertTrue(anIframeYaziElementi.isEnabled());

        System.out.println(anIframeYaziElementi.getText());


        // - Text Box’a “Merhaba Dunya!” yazin.
        WebElement iFrameElementi = driver.findElement(By.xpath("//*[@id='mce_0_ifr']"));

        driver.switchTo().frame(iFrameElementi);
        ReusableMethods.bekle(1);





        WebElement textBox = driver.findElement(By.xpath("//*[@id='tinymce']"));
        textBox.clear();
        textBox.sendKeys("Merhaba Dünya!");

        // - TextBox’in altinda bulunan “Elemental Selenium” linkinin gorunur oldugunu dogrulayin

        driver.switchTo().parentFrame();// böylece asıl katmana geri dönüyoruz.

        WebElement elementalSeleniumYazi = driver.findElement(By.linkText("Elemental Selenium"));
        Assert.assertTrue(elementalSeleniumYazi.isDisplayed());
        // ve  yazisini konsolda yazdirin.
        System.out.println(elementalSeleniumYazi.getText());






    }
}
