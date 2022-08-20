package Gun07;

import Utils.GenelWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _04_PlaceOrderPOM extends GenelWebDriver {

    @Test
    void ProceedToCheckout()
    {
       _03_PlaceOrderElements elts = new _03_PlaceOrderElements(driver);

        elts.searchInput.sendKeys("ipod");

        elts.searchbutton.click();

        elts.iPod.click();

        elts.addtoCart.click();

        elts.Checkout.click();

        wait.until(ExpectedConditions.elementToBeClickable(elts.contin)).click();

        wait.until(ExpectedConditions.elementToBeClickable(elts.contin2)).click();

        wait.until(ExpectedConditions.elementToBeClickable(elts.contin3)).click();

        wait.until(ExpectedConditions.elementToBeClickable(elts.agree)).click();

        elts.contin4.click();

        wait.until(ExpectedConditions.elementToBeClickable(elts.confirmOrder)).click();

        wait.until(ExpectedConditions.urlContains("success"));

        Assert.assertEquals(elts.h1.getText(),"Your order has been placed!","Comparison result");
    }

}


