package day04_JunitFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_Before_After_Notasyonlari {

    /*
    Eger her test methodundan önce mutlaka calısmasını istedigimiz
    bir method varsa @Before notasyonu ile isaretlenir.
    Ayni sekilde method sonrasi calismasini istediginiz methodlara da
    @After notasyonu yazilir.
     */



    WebDriver driver;

    @Before
    public void setUp (){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        System.out.println("Setup methodu calisti");

    }

    @After
    public void teardown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
        System.out.println("Teardown methodu calisti");


    }


    @Test


    public void youtubeTesti() throws InterruptedException {


        driver.get("https://www.youtube.com");

        String expectedUrlIcerik = "youtube";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrlIcerik)){
            System.out.println("Youtube testi PASSED");
        } else {
            System.out.println("Youtube testi FAILED");
        }



    }
    @Test

    public void testOtomasyonuTesti () throws InterruptedException {



        driver.get("https://www.testotomasyonu.com");

        String expectedUrlIcerik = "testotomasyonu";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrlIcerik)){
            System.out.println("Testotomasyonu testi PASSED");
        } else {
            System.out.println("Testotomasyonu testi FAILED");
        }

    }

    @Test

    public void wiseQuarterTesti () throws InterruptedException {

        driver.get("https://www.wisequarter.com");

        String expectedUrlIcerik = "wisequarter";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrlIcerik)){
            System.out.println("Wisequarter testi PASSED");
        } else {
            System.out.println("Wisequarter testi FAILED");
        }

    }
}
