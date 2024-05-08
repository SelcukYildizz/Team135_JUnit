package day06_jsAlerts_iFrame;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase_BeforeAfter;

import java.util.List;

public class C04_IFrame extends TestBase_BeforeAfter {


    @Test

    public void iFrameTesti(){
        //1- https://testotomasyonu.com/discount adresine gidin
        driver.get("https://testotomasyonu.com/discount");

        //2- Elektronics Products yazisinin gorunur olduğunu test edin

        // önce elektronic products ın oldugu Iframe geçis yapmalıyız

        WebElement iFrameElectronics = driver.findElement(By.xpath("(//iframe)[1]"));
        driver.switchTo().frame(iFrameElectronics);



        //WebElement elekronicProductYazi = driver.findElement(By.tagName("h2"));
        WebElement elekronicProductYazi = driver.findElement(By.xpath("//*[text()='Electronics Products']"));

        Assert.assertTrue(elekronicProductYazi.isDisplayed());


        //3- Dell bilgisayar urun isminin ‘DELL Core I3 11th Gen’ olduğunu test edin
        WebElement dellBilgisayarElementi = driver.findElement(By.xpath("(//*[@id='pictext1'])[1]"));

       String expectedYazi = "DELL Core I3 11th Gen";
       String actualYazi = dellBilgisayarElementi.getText();

       Assert.assertEquals(actualYazi,expectedYazi);


        //4- Sagdaki bolumde gorunen urunler arasinda ‘Men Slim Fit’ içeren
        // en az 1 urun olduğunu test edin

        // önce anasayfaya donup, sonra sağdaki iframe e gecelim

        driver.switchTo().parentFrame();

        // sonra sagdaki iFrame gecis yapalim
        WebElement iFrameFashion = driver.findElement(By.xpath("(//iframe)[2]"));
        driver.switchTo().frame(iFrameFashion);


        // tum urunleri liste kaydedelim
        List<WebElement> tumUrunElementleriList = driver.findElements(By.xpath("//a[@class='overlay']"));

        List<String> urunIsimleriList = ReusableMethods.stringListeDonustur(tumUrunElementleriList);

        // Bir flag olusturalim, listedeki tum urun isimlerinin gozden gecirip
        // istenen icerige sahip bir urun varsa flagı degiselim

        boolean arananUrunVarMi = false;

        for ( String each   :urunIsimleriList      )   {

            if (each.contains("Men Slim Fit")){
                arananUrunVarMi = true;
            }

        }

        Assert.assertTrue(arananUrunVarMi);




        //5- ‘Fashion’ yazisinin gorunur olduğunu test edin

        WebElement fashionElementi = driver.findElement(By.xpath("//*[text()='Fashion']"));

        Assert.assertTrue(fashionElementi.isDisplayed());



        //6- ‘Here are some products’ yazisinin gorunur olduğunu test edin

        driver.switchTo().parentFrame();

        WebElement hereElementi = driver.findElement(By.xpath("//*[text()='Here are some products.']"));

        Assert.assertTrue(hereElementi.isDisplayed());


        //7- Sayfayi kapatin


    }
}
