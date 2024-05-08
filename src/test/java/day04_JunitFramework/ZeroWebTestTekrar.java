package day04_JunitFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ZeroWebTestTekrar {
    public static void main(String[] args) throws InterruptedException {


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //1. http://zero.webappsecurity.com/ Adresine gidin

        driver.get("http://zero.webappsecurity.com/");

        // 2. Sign in butonuna basin

        driver.findElement(By.id("signin_button")).click();

        Thread.sleep(3000);

        // 3. Login kutusuna “username” yazin

        WebElement loginKutusu = driver.findElement(By.id("user_login"));

        loginKutusu.sendKeys("username");



        // 4. Password kutusuna “password” yazin

        WebElement passwordKutusu = driver.findElement(By.id("user_password"));

        passwordKutusu.sendKeys("password");


        Thread.sleep(3000);

        // 5. Sign in tusuna basin, back tusuna basarak sayfaya donun

        driver.findElement(By.xpath("//input[@name='submit']")).click();

        driver.navigate().back();
        Thread.sleep(3000);


        //6. Online banking menusunden Pay Bills sayfasina gidin

        driver.findElement(By.xpath("//strong[text()='Online Banking'"))
                .click();

        driver.findElement(By.id("pay_bills_link"))
                .click();
        Thread.sleep(3000);



        //7. “Purchase Foreign Currency” tusuna basin
        //8. “Currency” drop down menusunden Eurozone’u secin
        //9. “amount” kutusuna bir sayi girin
        //10. “US Dollars” in secilmedigini test edin
        //11. “Selected currency” butonunu secin
        //12. “Calculate Costs” butonuna basin sonra “purchase” butonuna basin
        //13. “Foreign currency cash was successfully purchased.” yazisinin ciktigini kontrol edin.


    }





}
