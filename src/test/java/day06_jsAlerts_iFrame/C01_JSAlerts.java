package day06_jsAlerts_iFrame;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.ReusableMethods;
import utilities.TestBase_BeforeAfterClass;

public class C01_JSAlerts extends TestBase_BeforeAfterClass {

    //3 test method'u olusturup asagidaki gorevi tamamlayin




    @Test
    public void basicAlert(){
        //1. Test

        // - https://testotomasyonu.com/javascriptAlert adresine gidin
        driver.get("https://testotomasyonu.com/javascriptAlert");
        ReusableMethods.bekle(2);

        // - 1.alert'e tiklayin
        driver.findElement(By.xpath("(//button[@class='j-button'])[1]")).click();
        ReusableMethods.bekle(2);

        // - Alert'deki yazinin "I am a JS Alert" oldugunu test edin

        String expectedAlertYazi = "I am a JS Alert";
        String actualAlertYazi = driver.switchTo().alert().getText();
        Assert.assertEquals(actualAlertYazi,expectedAlertYazi);
        ReusableMethods.bekle(2);
        // - OK tusuna basip alert'i kapatin

        driver.switchTo().alert().accept();
        ReusableMethods.bekle(2);


    }


    @Test
    public void confirmAlert(){
        //2.Test


        // - https://testotomasyonu.com/javascriptAlert adresine gidin
        driver.get("https://testotomasyonu.com/javascriptAlert");

        // - 2.alert'e tiklayalim
        driver.findElement(By.xpath("(//button[@class='j-button'])[2]"))
                .click();

        // - Cancel'a basip,
        driver.switchTo().alert().dismiss();

        //cikan sonuc yazisinin "You clicked: Cancel" oldugunu test edin

        String expectedSonucYazisi = "You clicked: Cancel";
        String actualSonucYazisi = driver.findElement(By.xpath("//*[@id='result']"))
                .getText();

        Assert.assertEquals(expectedSonucYazisi,actualSonucYazisi);








    }


    @Test
    public void promtAlert(){

        //3.Test

        // - https://testotomasyonu.com/javascriptAlert adresine gidin
        driver.get("https://testotomasyonu.com/javascriptAlert");

        // - 3.alert'e tiklayalim
        driver.findElement(By.xpath("(//button[@class='j-button'])[3]"))
                .click();

        // - Cikan prompt ekranina "Abdullah" yazdiralim
        driver.switchTo().alert().sendKeys("Selçuk");

        // - OK tusuna basarak alert'i kapatalim
        driver.switchTo().alert().accept();


        // - Cikan sonuc yazisinin Abdullah icerdigini test edelim
        String expectedSonuc = "Selçuk";
        String actualSonuc   = driver.findElement(By.xpath("//*[@id='result']"))
                                     .getText();

        Assert.assertTrue(actualSonuc.contains(expectedSonuc));
        ReusableMethods.bekle(3);



    }
}
