package Alp.Test;

import Alp.Utils.GeneralWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



public class _04_Proje extends GeneralWebDriver {

    String email = "alperes@gmail.com";
    String password = "123456qwerasd";

    By loginButtonMainPage = By.linkText("Log in");
    By emailInputLocator = By.id("Email");
    By passwordInputLocator = By.id("Password");

    @BeforeClass(dependsOnMethods = "baslangicIslemler")
    void driverConfiguration(){
        System.out.println("2. before class");
        driver.get("https://demowebshop.tricentis.com/");
    }

    @Test
    void seneryo1(){

        WebElement logIn = driver.findElement(loginButtonMainPage);
        logIn.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(emailInputLocator));

        WebElement emailInput = driver.findElement(emailInputLocator);
        emailInput.sendKeys(email);

        WebElement passwordInput = driver.findElement(passwordInputLocator);
        passwordInput.sendKeys(password);

        passwordInput.submit();

        WebElement accountEmail = driver.findElement(By.cssSelector("[class='account']"));

        Assert.assertEquals(email, accountEmail.getText());

    }

    @Test(dependsOnMethods = "seneryo1")
    void seneryo2(){
        WebElement logOut = driver.findElement(By.linkText("Log out"));
        logOut.click();

        WebElement logIn = driver.findElement(By.linkText("Log in"));
        logIn.click();

        WebElement emailInput = driver.findElement(emailInputLocator);
        emailInput.sendKeys(email.replace("a","e"));

        WebElement passwordInput = driver.findElement(passwordInputLocator);
        passwordInput.sendKeys(password + "1");
        passwordInput.submit();

        WebElement warningLabel1 = driver.findElement(By.cssSelector("[class='validation-summary-errors']"));
        WebElement warningLabel2 = driver.findElement(By.cssSelector("[class='validation-summary-errors']>ul>li"));

        Assert.assertTrue(warningLabel1.getText().contains("unsuccessful"));
        Assert.assertTrue(warningLabel2.getText().contains("No customer account found"));
    }


    @Test(dependsOnMethods = "seneryo2")
    void seneryo3(){
        WebElement emailInput = driver.findElement(emailInputLocator);
        emailInput.clear();
        emailInput.sendKeys(email);

        WebElement passwordInput = driver.findElement(passwordInputLocator);
        passwordInput.sendKeys(password);
        passwordInput.submit();

        WebElement giftCard = driver.findElement(By.cssSelector("[onclick=\"AjaxCart.addproducttocart_catalog('/addproducttocart/catalog/2/1/1    ');return false;\"]"));
        giftCard.click();

        WebElement reName = driver.findElement(By.id("giftcard_2_RecipientName"));
        reName.sendKeys("İsmet Ozan Eş");

        WebElement reEmail = driver.findElement(By.id("giftcard_2_RecipientEmail"));
        reEmail.sendKeys("elifes@gmail.com");

        WebElement addToCartButton = driver.findElement(By.id("add-to-cart-button-2"));
        addToCartButton.click();

        WebElement sepet = driver.findElement(By.cssSelector("[class='cart-label']"));
        sepet.click();

        WebElement terms = driver.findElement(By.id("termsofservice"));
        terms.click();

        WebElement checkOut = driver.findElement(By.id("checkout"));
        checkOut.click();

        WebElement adressContainer = driver.findElement(By.id("billing-new-address-form"));

        if (!adressContainer.getAttribute("style").contains("display: none;")){

            WebElement countries = driver.findElement(By.id("BillingNewAddress_CountryId"));

            Select dropDownMenu = new Select(countries);
            dropDownMenu.selectByVisibleText("Turkey");

            WebElement city = driver.findElement(By.id("BillingNewAddress_City"));
            city.sendKeys("İzmir");

            WebElement address1 = driver.findElement(By.id("BillingNewAddress_Address1"));
            address1.sendKeys("Urla");

            WebElement zipCode = driver.findElement(By.id("BillingNewAddress_ZipPostalCode"));
            zipCode.sendKeys("35000");

            WebElement phoneNum = driver.findElement(By.id("BillingNewAddress_PhoneNumber"));
            phoneNum.sendKeys("12345678900");

        }



        WebElement ctnBtn = driver.findElement(By.cssSelector("[class='button-1 new-address-next-step-button']"));
        ctnBtn.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[for='paymentmethod_0']")));

        ctnBtn = driver.findElement(By.cssSelector("[class='button-1 payment-method-next-step-button']"));
        ctnBtn.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[id='checkout-payment-info-load'] p")));

        ctnBtn = driver.findElement(By.cssSelector("[class='button-1 payment-info-next-step-button']"));
        ctnBtn.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li[class='title'] strong")));

        WebElement confrimBtn = driver.findElement(By.cssSelector("[class='button-1 confirm-order-next-step-button']"));
        confrimBtn.click();

        WebElement title = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//strong[text()='Your order has been successfully processed!']")));


        Assert.assertTrue(title.getText().contains("successfully"));
    }
}
