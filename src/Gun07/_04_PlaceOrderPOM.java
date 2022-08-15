package Gun07;

import Utils.GenelWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _04_PlaceOrderPOM extends GenelWebDriver {

    @Test
    void ProceedToCheckout()
    {
       _03_PlaceOrderElements elmnts = new _03_PlaceOrderElements(driver);

        elmnts.searchInput.sendKeys("ipod");

        elmnts.searchbutton.click();

        elmnts.iPod.click();

        elmnts.addtoCart.click();

        elmnts.Checkout.click();

        wait.until(ExpectedConditions.elementToBeClickable(elmnts.contin)).click();

        wait.until(ExpectedConditions.elementToBeClickable(elmnts.contin2)).click();

        wait.until(ExpectedConditions.elementToBeClickable(elmnts.contin3)).click();

        wait.until(ExpectedConditions.elementToBeClickable(elmnts.agree)).click();

        elmnts.contin4.click();

        wait.until(ExpectedConditions.elementToBeClickable(elmnts.confirmOrder)).click();

        wait.until(ExpectedConditions.urlContains("success"));

        Assert.assertEquals(elmnts.h1.getText(),"Your order has been placed!","Comparison result");
    }

}


