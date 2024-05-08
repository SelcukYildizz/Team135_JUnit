package day04_JunitFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_AyarlariMethodOlarakYapma {

    WebDriver driver;


    public void setUp (){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    public void teardown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();


    }


    @Test


    public void youtubeTesti() throws InterruptedException {
        setUp();

        driver.get("https://www.youtube.com");

        String expectedUrlIcerik = "youtube";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrlIcerik)){
            System.out.println("Youtube testi PASSED");
        } else {
            System.out.println("Youtube testi FAILED");
        }
        teardown();


    }
    @Test

    public void testOtomasyonuTesti () throws InterruptedException {

        setUp();

        driver.get("https://www.testotomasyonu.com");

        String expectedUrlIcerik = "testotomasyonu";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrlIcerik)){
            System.out.println("Testotomasyonu testi PASSED");
        } else {
            System.out.println("Testotomasyonu testi FAILED");
        }
        teardown();
    }

    @Test

    public void wiseQuarterTesti () throws InterruptedException {
        setUp();
        driver.get("https://www.wisequarter.com");

        String expectedUrlIcerik = "wisequarter";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrlIcerik)){
            System.out.println("Wisequarter testi PASSED");
        } else {
            System.out.println("Wisequarter testi FAILED");
        }
        teardown();
    }
}
