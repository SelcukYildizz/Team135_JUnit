package day06_jsAlerts_iFrame;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase_BeforeAfter;

public class C02_BasicAuthentication extends TestBase_BeforeAfter {

    @Test
    public void basicAuthenticationTesti(){
        //1- Bir class olusturun : BasicAuthentication

        //2- https://testotomasyonu.com/basicauth sayfasina gidin
        driver.get("https://testotomasyonu.com/basicauth");

        //3- asagidaki yontem ve test datalarini kullanarak authentication’i yapin

        //Html komutu : https://username:password@URL
        // Username    : membername
        //  password     : sunflower

        driver.get("membername:sunflower@https://testotomasyonu.com/basicauth");

        //4- Basarili sekilde sayfaya girildigini dogrulayin

        String expectedGirisYazi = "Congratulations! You are logged in as: membername";
        String actualGirisYazi = driver.findElement(By.tagName("i"))
                .getText();

        Assert.assertEquals(actualGirisYazi,expectedGirisYazi);

    }

}
