package Gun09FPrj;

import org.testng.Assert;
import org.testng.annotations.Test;

public class senario1POM extends driver{

    @Test
    void login() {

        senarioelements snr = new senarioelements(driver);

        snr.email.sendKeys("grup21@gmail.com");

        snr.password.sendKeys("grup21");

        snr.login.click();

        Assert.assertEquals(snr.loginvalidate.getText(),"Log out");

    }
}
