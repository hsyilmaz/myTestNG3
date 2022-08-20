package Alp.Test;

import Alp.Utils.GenerallWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class _03_Proje extends GenerallWebDriver {

    By demoEbookButton = By.cssSelector("[onclick=\"return EJProductClick('1595015')\"]");
    By continueButton = By.cssSelector("[class=\"Continue-Button Close-Cart\"]");
    By allFrames = By.xpath("//iframe");
    By contactImage = By.cssSelector("[class='contact']");
    By containerCloseButton = By.cssSelector("[class='Close Close-Cart Desktop-Only md hydrated']");
    By snackbarSpan = By.cssSelector("[id='SnackBar']>span");
    By debbitCardButton = By.cssSelector("[class='Payment-Button CC']");
    By payButton = By.cssSelector("[class='Pay-Button']");
    By creditCardPlaceholder = By.cssSelector("[placeholder='Kart numarası']");


    int containerFrame = 4;
    int creditCardInputFrame = 2;

    @BeforeClass(dependsOnMethods = "baslangicIslemler")
    void driverConfiguration() {
        driver.get("https://shopdemo.e-junkie.com/");
    }


    @Test
    void seneryo1() {

        WebElement demoEbookButton = driver.findElement(this.demoEbookButton);
        demoEbookButton.click();

        // ------------------------------------

        driver.switchTo().frame(containerFrame);

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(this.allFrames)));

        // ------------------------------------

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class='Product-Quantity-Value readOnly']")));

        WebElement demoQuantity = driver.findElement(By.cssSelector("[class='Product-Quantity-Value readOnly']"));

        Assert.assertEquals(demoQuantity.getAttribute("value"), "1");

        WebElement removeProduct = driver.findElement(By.cssSelector("[class='Product-Remove']"));
        removeProduct.click();

        // ------------------------------------

        wait.until(ExpectedConditions.elementToBeClickable(this.continueButton));

        WebElement continueButton = driver.findElement(this.continueButton);
        continueButton.click();

        // ------------------------------------

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(this.allFrames)));

        driver.switchTo().defaultContent();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cart_item_nos")));

        List<WebElement> basket = driver.findElements(By.id("cart_item_nos"));

        Assert.assertEquals(basket.get(0).getText(), "0");

    }

    @Test(dependsOnMethods = "seneryo1")
    void seneryo2() {

        WebElement demoEbookButton = driver.findElement(this.demoEbookButton);
        demoEbookButton.click();

        driver.switchTo().frame(containerFrame);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class='Apply-Button Show-Promo-Code-Button']")));

        WebElement promoCodeButton = driver.findElement(By.cssSelector("[class='Apply-Button Show-Promo-Code-Button']"));
        promoCodeButton.click();

        String promoCode = "123456789";

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class='Promo-Code-Value']")));

        WebElement promoCodeInput = driver.findElement(By.cssSelector("[class='Promo-Code-Value']"));
        promoCodeInput.sendKeys(promoCode);

        WebElement promoCodeApplyButton = driver.findElement(By.cssSelector("[class='Promo-Apply']"));
        promoCodeApplyButton.click();

        String invaildPromoCode = "Invalid promo code";

        WebElement snackBar = wait.until(ExpectedConditions.visibilityOfElementLocated(this.snackbarSpan));

        Assert.assertEquals(snackBar.getText(), invaildPromoCode);

        WebElement containerCloseIcon = driver.findElement(this.containerCloseButton);

        containerCloseIcon.click();

        driver.switchTo().defaultContent();

        wait.until(ExpectedConditions.visibilityOfElementLocated(this.contactImage));


    }

    @Test(dependsOnMethods = "seneryo2")
    void seneryo3() {

        WebElement demoEbookButton = driver.findElement(this.demoEbookButton);
        demoEbookButton.click();

        driver.switchTo().frame(containerFrame);

        WebElement debbitCardButton = driver.findElement(this.debbitCardButton);
        debbitCardButton.click();

        WebElement payButton = driver.findElement(this.payButton);
        payButton.click();

        String snackBarValidateMessage = "Invalid Email\nInvalid Email\nInvalid Billing Name";

        WebElement snackBar = wait.until(ExpectedConditions.visibilityOfElementLocated(this.snackbarSpan));

        Assert.assertEquals(snackBar.getText(), snackBarValidateMessage);

        WebElement containerCloseIcon = driver.findElement(this.containerCloseButton);

        containerCloseIcon.click();

        driver.switchTo().defaultContent();

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(this.allFrames)));

    }

    @Test(dependsOnMethods = "seneryo3")
    void seneryo4() {

        WebElement demoEbookButton = driver.findElement(this.demoEbookButton);
        demoEbookButton.click();

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(this.allFrames)));

        driver.switchTo().frame(containerFrame);


        wait.until(ExpectedConditions.visibilityOfElementLocated(this.debbitCardButton));

        WebElement debbitCardButton = driver.findElement(this.debbitCardButton);

        debbitCardButton.click();

        driver.findElement(By.cssSelector("[placeholder='Email']")).sendKeys("alperes@hotmail.com");
        driver.findElement(By.cssSelector("[placeholder='Confirm Email']")).sendKeys("alperes@hotmail.com");
        driver.findElement(By.cssSelector("[placeholder='Name On Card']")).sendKeys("Alper");
        driver.findElement(By.cssSelector("[class='Billing-Phone Inline']>input")).sendKeys("123-456-7890");
        driver.findElement(By.cssSelector("[class='Billing-Company']>input")).sendKeys("Techno Study");

        driver.switchTo().frame(creditCardInputFrame);

        wait.until(ExpectedConditions.visibilityOfElementLocated(this.creditCardPlaceholder));

        WebElement creditCardInput = driver.findElement(this.creditCardPlaceholder);
        creditCardInput.sendKeys("1111 1111 1111 1111");


        driver.switchTo().defaultContent();

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(this.allFrames)));

        driver.switchTo().frame(containerFrame);


        WebElement payButton = driver.findElement(this.payButton);
        payButton.click();

        WebElement snackBar = wait.until(ExpectedConditions.visibilityOfElementLocated(this.snackbarSpan));

        Assert.assertEquals(snackBar.getText(), "Kart numaranız geçersiz.");

        WebElement containerCloseIcon = driver.findElement(this.containerCloseButton);

        containerCloseIcon.click();


        driver.switchTo().defaultContent();

        wait.until(ExpectedConditions.visibilityOfElementLocated(contactImage));


    }

    @Test(dependsOnMethods = "seneryo4")
    void seneryo5() {

        WebElement demoEbookButton = driver.findElement(this.demoEbookButton);
        demoEbookButton.click();

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(this.allFrames)));
        driver.switchTo().frame(containerFrame);

        wait.until(ExpectedConditions.visibilityOfElementLocated(this.debbitCardButton));

        WebElement debbitCardButton = driver.findElement(this.debbitCardButton);

        debbitCardButton.click();

        driver.findElement(By.cssSelector("[placeholder='Email']")).sendKeys("alperes13@hotmail.com");
        driver.findElement(By.cssSelector("[placeholder='Confirm Email']")).sendKeys("alperes13@hotmail.com");
        driver.findElement(By.cssSelector("[placeholder='Name On Card']")).sendKeys("Alper");
        driver.findElement(By.cssSelector("[class='Billing-Phone Inline']>input")).sendKeys("123-456-7890");
        driver.findElement(By.cssSelector("[class='Billing-Company']>input")).sendKeys("Techno Study");

        driver.switchTo().frame(creditCardInputFrame);

        wait.until(ExpectedConditions.visibilityOfElementLocated(this.creditCardPlaceholder));

        WebElement creditCardInput = driver.findElement(this.creditCardPlaceholder);
        creditCardInput.sendKeys("4242 4242 4242 4242");


        driver.findElement(By.cssSelector("[placeholder='AA / YY']")).sendKeys("1222");
        driver.findElement(By.cssSelector("[placeholder='CVC']")).sendKeys("000");


        driver.switchTo().defaultContent();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(this.allFrames)));
        driver.switchTo().frame(containerFrame);

        wait.until(ExpectedConditions.visibilityOfElementLocated(this.payButton));

        WebElement payButton = driver.findElement(this.payButton);
        payButton.click();

        driver.switchTo().defaultContent();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class='confirme_text']")));

        WebElement thankYou = driver.findElement(By.cssSelector("[class='confirme_text']>span"));
        Assert.assertEquals(thankYou.getText(), "your order is confirmed. Thank you!");
    }
}
