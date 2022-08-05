package Gun02;

/*
  Senaryo
  1- Siteyi açınız.
  2- Newsletter  Subscribe ve UnSubscribe işlemlerini ayrı ayı testlerde yapınız.
  3- Newsletter  üyelik statusunu tersine ceviriniz.
 */

import Utils.GenelWebDriver;
import Utils.Tools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class _02_Subscribe extends GenelWebDriver {

    By link=By.linkText("Newsletter");
    By yes=By.cssSelector("input[value='1']");
    By no=By.cssSelector("input[value='0']");
    By cnt =By.cssSelector("input[value='Continue']");

    @Test(priority = 1)
    void Subscribing()
    {
        wait.until(ExpectedConditions.elementToBeClickable(link));

        WebElement newsletterLink = driver.findElement(link);
        newsletterLink.click();

        WebElement accept1= driver.findElement(yes);
        accept1.click();

        WebElement continueButton = driver.findElement(cnt);
        continueButton.click();

        Tools.successMessageValidation();
    }

    @Test(priority = 2)
    void Unsubscribing()
    {
        WebElement newsletterLink = wait.until(ExpectedConditions.elementToBeClickable(link));
        newsletterLink.click();

        WebElement accept2= ((WebElement) no);  // writing code in this way is possible too.
        accept2.click();

        WebElement continueButton = ((WebElement) cnt); //
        continueButton.click();

        Tools.successMessageValidation();
    }

    @Test(priority = 3)
    void SubscriptionStatusChange()
    {
        WebElement newsletterLink = wait.until(ExpectedConditions.elementToBeClickable(link));
        newsletterLink.click();

        WebElement yesRadioButton= driver.findElement(yes);
        WebElement noRadioButton= driver.findElement(no);

        if (yesRadioButton.isSelected())
            noRadioButton.click();
        else
            yesRadioButton.click();

        WebElement continueButton = driver.findElement(cnt);
        continueButton.click();

        Tools.successMessageValidation();
    }



}
