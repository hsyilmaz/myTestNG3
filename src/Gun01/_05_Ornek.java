package Gun01;

/*
   Senaryo ;
     1- http://opencart.abstracta.us/index.php?route=account/login  sitesini açınız.
     2- asd@gmail.com  ve 123qweasd   bilgileri ile login olan test metodunu yazınız.
     3- Login olup olmadığınızı assert ile kontrol ediniz.*/

import Utils.GenelWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _05_Ornek extends GenelWebDriver {

    @Test
    void LoginTest()
    {
        WebElement inputEmail= driver.findElement(By.id("input-email"));
        inputEmail.sendKeys("hsy@gmail.com");

        WebElement password= driver.findElement(By.id("input-password"));
        password.sendKeys("Hy338");

        WebElement loginBtn= driver.findElement(By.cssSelector("input[value='Login']"));
        loginBtn.click();

//        WebElement teyid=driver.findElement(By.xpath("//*[text()='Your Store']"));

//        Assert.assertEquals("https://opencart.abstracta.us/index.php?route=account/account", driver.getWindowHandle());


    }

}
