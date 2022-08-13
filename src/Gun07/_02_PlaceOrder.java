package Gun07;
import Utils.GenelWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _02_PlaceOrder extends GenelWebDriver {

/*    Senaryo :
   1- Siteyi açınız.
   2- Sitede "ipod" kelimesini aratınız
   3- Çıkan sonuçlardan ilkini sepete atınız.
   4- Shopping Chart a tıklatınız.
   5- Checkout yapınız.
   6- Continue butonalarına tıklatıp bilgileri giriniz.
   7- En confirm ile siparişi verdiğinizi doğrulayınız.
      doğrulamayı çıkan sayfadaki "Your order has been placed" yazısı ile yapınız.
*/

    @Test
    void ProceedToCheckout(){
        WebElement searchInput = driver.findElement(By.name("search"));
        searchInput.sendKeys("ipod");

        WebElement searchButton = driver.findElement(By.cssSelector("#search  button"));
        searchButton.click();

        WebElement ipod = driver.findElement(By.linkText("iPod Classic"));
        ipod.click();

        WebElement addtoCart= driver.findElement(By.cssSelector("button#button-cart"));
        addtoCart.click();

//        WebElement teyit = driver.findElement(By.linkText("shopping cart"));
//        Assert.assertTrue(teyit.isDisplayed());

        WebElement Checkout = driver.findElement(By.linkText("Checkout"));
        Checkout.click();

        WebElement contin = wait.until(ExpectedConditions.elementToBeClickable(By.id("button-payment-address")));
        contin.click();

        WebElement contin2 = wait.until(ExpectedConditions.elementToBeClickable(By.id("button-shipping-address")));
        contin2.click();

        WebElement contin3 = wait.until(ExpectedConditions.elementToBeClickable(By.id("button-shipping-method")));
        contin3.click();

        WebElement agree = wait.until(ExpectedConditions.elementToBeClickable(By.name("agree")));
        agree.click();

        WebElement contin4 = driver.findElement(By.id("button-payment-method"));
        contin4.click();

        WebElement confirmOrder = wait.until(ExpectedConditions.elementToBeClickable(By.id("button-confirm")));
        confirmOrder.click();

        wait.until(ExpectedConditions.urlContains("success"));
//        Assert.assertTrue(driver.getCurrentUrl().contains("success"));

        //WebElement h1 = driver.findElement(By.xpath("//h1[contains(text(),'placed!')]"));
        WebElement h1 = driver.findElement(By.cssSelector("#content>h1"));

        Assert.assertEquals(h1.getText(),"Your order has been placed!","Comparison result");
    }

}
