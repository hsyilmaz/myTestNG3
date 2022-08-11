package Gun07;

import Utils.GenelWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _04_PlaceOrderPOM extends GenelWebDriver {

    @Test
    void ProceedToCheckout()
    {
        _03_PlaceOrderElements elements = new _03_PlaceOrderElements(driver);

        elements.searchInput.sendKeys("ipod");

        elements.searchbutton.click();

        elements.iPod.click();

        elements.addtoCart.click();

        elements.Checkout.click();

        wait.until(ExpectedConditions.elementToBeClickable(elements.contin)).click();


        wait.until(ExpectedConditions.elementToBeClickable(elements.contin2)).click();

        wait.until(ExpectedConditions.elementToBeClickable(elements.contin3)).click();

        wait.until(ExpectedConditions.elementToBeClickable(elements.agree)).click();

        elements.contin4.click();

        wait.until(ExpectedConditions.elementToBeClickable(elements.confirmOrder)).click();

        wait.until(ExpectedConditions.urlContains("success"));

        Assert.assertEquals(elements.h1.getText(),"Your order has been placed!","Comparison result");
    }

}


