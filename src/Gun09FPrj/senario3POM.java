package Gun09FPrj;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class senario3POM extends driver {


    @Test
    void loginfailure(){

        senarioelements snr=new senarioelements(driver);

        snr.email.sendKeys("grup22@hotmail.com");

        snr.password.sendKeys("dsdsd");

        snr.login.click();

        Assert.assertTrue(snr.hatamsg.getText().contains("Login was unsuccessful"));
        Assert.assertTrue(snr.hatamsg.isDisplayed());
    }

    @Test (dependsOnMethods = {"loginfailure"})
    void login() {

        senarioelements snr = new senarioelements(driver);

        snr.email.clear();
        snr.email.sendKeys("grup21@gmail.com");
        snr.password.clear();
        snr.password.sendKeys("grup21");

        snr.login.click();

        Assert.assertEquals(snr.loginvalidate.getText(),"Log out");
    }

    @Test (dependsOnMethods = {"login"})
    void ordercheck() {

        senarioelements snr = new senarioelements(driver);
//        snr.email.sendKeys("grup21@gmail.com");
//        snr.password.sendKeys("grup21");
//        snr.login.click();
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
           System.out.println("eyalet.getOptions().size() = " + eyalet.getOptions().size());
        wait.until(ExpectedConditions.numberOfElementsToBeLessThan(By.id("BillingNewAddress_StateProvinceId"),eyalet.getOptions().size()));
        eyalet.selectByValue("38");

//       System.out.println(snr.stateoption.size());  //62
//        System.out.println(snr.state.getSize());
//        System.out.println(eyalet.getOptions().size());  //62

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
