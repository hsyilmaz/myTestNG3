package Gun09FPrj;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class senario3POM extends driver {
    @Test
    void ordercheck() {

        senarioelements snr = new senarioelements(driver);
        snr.email.sendKeys("grup21@gmail.com");
        snr.password.sendKeys("grup21");
        snr.login.click();
        snr.Adding.get(0).click();
        snr.recp_name.sendKeys("grup21");
        snr.recp_email.sendKeys("grup21@gmail.com");
        snr.addtocart.click();
        snr.shopingcart.click();
        snr.termservice.click();
        snr.checkoutbtn.click();
        Select newadres = new Select(snr.newaddress);
        newadres.selectByVisibleText("New Address");

        wait.until(ExpectedConditions.elementToBeClickable(snr.country));
        Select ulke = new Select(snr.country);
        ulke.selectByIndex(1);

        wait.until(ExpectedConditions.elementToBeClickable(snr.state));
        Select eyalet = new Select(snr.state);
        eyalet.selectByIndex(37);

        snr.city.sendKeys("Flagtown");
        snr.address.sendKeys("Main Street");
        snr.postalcode.sendKeys("23423");
        snr.number.sendKeys("+15677890");
        snr.continue1.click();
        wait.until(ExpectedConditions.elementToBeClickable(snr.continue2)).click();
        wait.until(ExpectedConditions.elementToBeClickable(snr.continue3)).click();
        wait.until(ExpectedConditions.elementToBeClickable(snr.confrim)).click();
        wait.until(ExpectedConditions.urlContains("completed"));
        Assert.assertEquals(snr.txtvalidate.getText(), "Your order has been successfully processed!");


    }
}
