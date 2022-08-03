package Gun02;

import Utils.GenelWebDriver;
import Utils.Tools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class _03_EditAcc2 extends GenelWebDriver {


    @Test
    void EditAccount()
    {
        editAccount("Nazmi", "Naz");
        //Bekle
        editAccount("First", "Surname");
    }


    void editAccount(String ad, String soyad) {
        WebElement edit = driver.findElement(By.linkText("Edit Account"));
        edit.click();

        WebElement Fname = driver.findElement(By.id("input-firstname"));
        Fname.clear();
        Fname.sendKeys(ad);

        WebElement Lname = driver.findElement(By.id("input-lastname"));
        Lname.clear();
        Lname.sendKeys(soyad);

        WebElement cntn = driver.findElement(By.cssSelector("input[type='submit']"));
        cntn.click();

        Tools.successMessageValidation();
    }
}




