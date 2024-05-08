package day05_assertions_dropdownMenu;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.TestBase_BeforeAfterClass;

import java.time.Duration;

public class C04_RadioButtons extends TestBase_BeforeAfterClass {

    //Gerekli yapiyi olusturun ve aşağıdaki görevi tamamlayın.
    // a. Verilen web sayfasına gidin.
    //      https://testotomasyonu.com/form

    // b. Cinsiyet Radio button elementlerini locate edin
    // c. Iki farkli test method’u oluşturup yazidan veya direk buton’dan size uygun olani secin
    // d. Sectiginiz radio button’un seçili, ötekilerin seçili olmadigini test edin




    @Test
    public void yazidanSecimTesti (){

        driver.get("https://testotomasyonu.com/form");



        WebElement kadinYaziElementi = driver.findElement(By.xpath("//*[@for ='inlineRadio1']"));
        WebElement erkekYaziElementi = driver.findElement(By.xpath("//*[@for ='inlineRadio2']"));
        WebElement digerYaziElementi = driver.findElement(By.xpath("//*[@for ='inlineRadio3']"));

        erkekYaziElementi.click();

        WebElement kadinCheckBox = driver.findElement(By.xpath("//*[@id ='inlineRadio1']"));
        WebElement erkekCheckBox = driver.findElement(By.xpath("//*[@id ='inlineRadio2']"));
        WebElement digerCheckBox = driver.findElement(By.xpath("//*[@id ='inlineRadio3']"));

        // erkegin secili oldugunu test edelim

        Assert.assertTrue(erkekCheckBox.isSelected());

        // kadin ve diger in secili olmadigini test edin

        Assert.assertFalse(kadinCheckBox.isSelected());
        Assert.assertFalse(digerCheckBox.isSelected());






    }







}
