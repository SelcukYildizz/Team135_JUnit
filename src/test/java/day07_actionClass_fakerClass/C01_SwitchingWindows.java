package day07_actionClass_fakerClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase_BeforeAfter;

import java.util.List;
import java.util.Set;

public class C01_SwitchingWindows extends TestBase_BeforeAfter {


    @Test

    public void test01(){

        //● https://testotomasyonu.com/addremove/ adresine gidin.
        driver.get("https://testotomasyonu.com/addremove/");


        //● Sayfadaki textin “Add/Remove Elements” olduğunu doğrulayın.
        WebElement addRemoveText = driver.findElement(By.xpath("//h2"));

        String expectedText = "Add/Remove Elements";
        String actualText = addRemoveText.getText();

        Assert.assertEquals(expectedText,actualText);


        //● Sayfa başlığının(title) “Test Otomasyonu” olduğunu doğrulayın.
        String actualTitle = driver.getTitle();

        String expectedTitle = "Test Otomasyonu";


        Assert.assertEquals(actualTitle,expectedTitle);


        //● ’Please click for Electronics Products’ linkine tiklayin.

        // Linke tikladigimizda,
        // kontrolumuz disinda yeni bir tab acildigi icin,
        // o tabe gecis yapabilmek icin WHD bulmamız gerekiyor.

        // 1. adim : click yapmadan önnce bulundugumuz sayfanın WHD kaydedelim

        String ilkWindowWHD = driver.getWindowHandle();

        // 2. adim: click edelim

        driver.findElement(By.linkText("Electronic Products"))
                .click();

        //3. adim : click edildikten sonra 2. window olacagi icin,
        //         bir Set olusturup, yeni WHD yi de kaydedelim,

        Set<String> tumWHDSeti = driver.getWindowHandles();

        //4.adim :  each loop Set deki WHD lerden, ilk WHD ye ait olmayani,
        //          2. WHD olarak kaydedelim

        String ikinciWHD = "";

        for ( String eachWHD
                 :tumWHDSeti      )   {

            if ( ! eachWHD.equals(ilkWindowWHD)){
                ikinciWHD = eachWHD;
            }


        }

        // 5. adim : buldugumuz 2. window HAndle ile 2. windowa gecelim

        driver.switchTo().window(ikinciWHD);




        //● Electronics sayfasinin acildigini test edin

        String expectedTitleİcerik = "Electronics";
        String actualTitleİcerik = driver.getTitle();

        Assert.assertTrue(actualTitleİcerik.contains(expectedTitleİcerik));


        //● Bulunan urun sayisinin 16 olduğunu test edin

        List<WebElement> bulunanElementlerListesi = driver.findElements(By.xpath("//*[@*='product-box mb-2 pb-1']"));

        int expectedUrunSayisi = 16;
        int actualUrunSayisi = bulunanElementlerListesi.size();

        Assert.assertEquals(expectedUrunSayisi,actualUrunSayisi);

        //● Ilk actiginiz addremove sayfasina donun

        driver.switchTo().window(ilkWindowWHD);


        //● Url’in addremove icerdigini test edin

        String expectedUrlIcerik = "addremove";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(expectedUrlIcerik));




    }





}
