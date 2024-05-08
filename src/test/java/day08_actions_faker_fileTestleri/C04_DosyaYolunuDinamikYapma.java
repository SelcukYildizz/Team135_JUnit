package day08_actions_faker_fileTestleri;

import org.junit.Assert;
import org.junit.Test;
import utilities.TestBase_BeforeAfterClass;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C04_DosyaYolunuDinamikYapma {


    @Test
    public void test01(){

        // Masaustunde logo.png dosyasinin oldugunu test edin


        String dosyaYolu = "C:/Users/selcu/Downloads/logo.png";

        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));

        // dosya yolu yukaridaki gibi yazilirsa
        // sadece o bilgisayarda calisir
        // testin tum bilgisayarlarda calisabilmesi icin
        // dosya yolunu dinamik yapmamiz gerekir


        System.out.println(System.getProperty("user.home"));

        // C:\Users\selcu
        //bu kod bize bilgisayarimizdaki kullanicinin ana dosya yolunu verir

        System.out.println(System.getProperty("user.dir"));
        // C:\Users\selcu\OneDrive\Masaüstü\Team135_JUnit
        // icinde calistigimiz projenin dosya yolunu verir

        /*
            Masaustundeki dosyanin dosya yolu :

            /Users/ahmetbulutluoz             /Desktop/logo.png

              bana ozel kisim                  herkeste ayni
           System.getProperty("user.home")
         */

        String dinamikDosyaYolu = System.getProperty("user.home") + "/Downloads/logo.png";
        Assert.assertTrue(Files.exists(Paths.get(dinamikDosyaYolu)));

        dosyaYolu = "src/test/java/day08_actions_faker_fileTestleri/Deneme.txt";

        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
















    }

















}
