package tests.day1;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AmazonPage;
import utilities.Driver;
import utilities.ReusableMethods;


public class C1softAssert {

    // amazon anasayfaya gidin
    @Test
    public void test01(){
        Driver.getDriver().get("https://www.amazon.com");

        // amazon anasayfaya gittiginizi dogrulayin
        SoftAssert softAssert= new SoftAssert();
        String expectedUrlKelime="amazon";
        String actualUrl= Driver.getDriver().getCurrentUrl();
        softAssert.assertTrue(actualUrl.contains(expectedUrlKelime),"Url amazon icermiyor");

        //Nutella aratın
        AmazonPage amazonPage= new AmazonPage();
        amazonPage.amazonAramaKutusu.sendKeys("Nutella" + Keys.ENTER);
        // arama sonuçlarının nutella içerdiğini doğrulayın
        String aramaSonucYazisi =amazonPage.aramaSonucuElementi.getText();
        softAssert.assertTrue(aramaSonucYazisi.contains("Nutella"));

        // Java aratın
        ReusableMethods.bekle(5);
        amazonPage.amazonAramaKutusu.clear();
        amazonPage.amazonAramaKutusu.sendKeys("Java" + Keys.ENTER);

        // arama sonuclarinin 1000'den fazla oldugunu dogrulayin
        aramaSonucYazisi = amazonPage.aramaSonucuElementi.getText();

        String[] sonucArr = aramaSonucYazisi.split(" ");

        String javaSonucYazisiStr = sonucArr[3];

        javaSonucYazisiStr = javaSonucYazisiStr.replaceAll("\\W", "");

        int sonucSayisiInt = Integer.parseInt(javaSonucYazisiStr);

        softAssert.assertTrue(sonucSayisiInt>1000);








        softAssert.assertAll();
        Driver.closeDriver();
    }
}
