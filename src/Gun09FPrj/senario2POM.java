package Gun09FPrj;

import org.testng.Assert;
import org.testng.annotations.Test;

public class senario2POM extends driver{

    @Test
    void logintest(){

        senarioelements snr=new senarioelements(driver);

        snr.email.sendKeys("grup22@hotmail.com");

        snr.password.sendKeys("dsdsd");

        snr.login.click();

        Assert.assertTrue(snr.hatamsg.getText().contains("Login was unsuccessful"));
        Assert.assertTrue(snr.hatamsg.isDisplayed());

    }
}
