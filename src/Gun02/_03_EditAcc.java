package Gun02;

import Utils.GenelWebDriver;
import Utils.Tools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
/*
      1- Siteyi açınız.
      2- Edit Account a tıklatınız.
      3- Yeni isim ve soyisim göndererek Continue yapınız.
      4- İşlem sonucunu kontrol ediniz.
      5- Bu işlemi 2. kez çalıştırarak eski haline getiriniz.
*/

public class _03_EditAcc extends GenelWebDriver {

    @Test (priority=1)
    void EditAccount() {

        WebElement edit = driver.findElement(By.linkText("Edit Account"));
        edit.click();

        WebElement Fname = driver.findElement(By.id("input-firstname"));
        Fname.clear();
        Fname.sendKeys("Nazmi");

        WebElement Lname = driver.findElement(By.id("input-lastname"));
        Lname.clear();
        Lname.sendKeys("Naz");

        WebElement cntn = driver.findElement(By.cssSelector("input[type='submit']"));
        cntn.click();

        Tools.successMessageValidation();
    }

    @Test (priority=2)
    void EditAccount2(){
        WebElement edit = driver.findElement(By.linkText("Edit Account"));
        edit.click();

        WebElement Fname = driver.findElement(By.id("input-firstname"));
        Fname.clear();
        Fname.sendKeys("First");

        WebElement Lname = driver.findElement(By.id("input-lastname"));
        Lname.clear();
        Lname.sendKeys("Surname");

        WebElement cntn = driver.findElement(By.cssSelector("input[type='submit']"));
        cntn.click();

        Tools.successMessageValidation();

        }



    }

