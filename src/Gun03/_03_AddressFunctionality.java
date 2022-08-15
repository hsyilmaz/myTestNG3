package Gun03;

import Utils.GenelWebDriver;
import Utils.Tools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
    /*
       Senaryo;
       1- Siteyi açınız.
       2- Adress Ekleyiniz.
       3- En son eklenen adresi edit yaparak ad ve soyadı değiştirip kaydediniz.
       4- En son eklenen adresi siliniz.
 */

public class _03_AddressFunctionality extends GenelWebDriver {
    @Test
    void Adresekle() {
        WebElement addressBook = driver.findElement(By.linkText("Address Book"));
        addressBook.click();

        WebElement newaddress = driver.findElement(By.linkText("New Address"));
        newaddress.click();

        WebElement name = driver.findElement(By.id("input-firstname"));
        name.sendKeys("Muhsin");

        WebElement Lname = driver.findElement(By.name("lastname"));
        Lname.sendKeys("YILMAZ");

        WebElement company = driver.findElement(By.name("company"));
        company.sendKeys("ABC");

        WebElement Address1 = driver.findElement(By.name("address_1"));
        Address1.sendKeys("first street");

        WebElement Address2 = driver.findElement(By.name("address_2"));
        Address2.sendKeys("second street");

        WebElement City = driver.findElement(By.name("city"));
        City.sendKeys("Bahcelievler");

        WebElement PostCode = driver.findElement(By.name("postcode"));
        PostCode.sendKeys("81630");


        WebElement country=driver.findElement(By.id("input-country"));
        Select countryS=new Select(country);
        countryS.selectByIndex(10);

        WebElement State=driver.findElement(By.id("input-zone"));
        //WebElement State_options= driver.findElement(By.cssSelector("[id='input-zone']>option)"));
        Select state=new Select(State);
        System.out.println("state.getOptions().size() 1 = " + state.getOptions().size());

                    wait.until(ExpectedConditions.numberOfElementsToBeLessThan
                            (By.cssSelector("[id='input-zone']>option)"), state.getOptions().size()));
    // option ların sayısı ilk halinden küçük olana kadar bekle : yeni durum gelene kadar bekle

        System.out.println("state.getOptions().size() 2 = " + state.getOptions().size());
        //for(WebElement e: state.getOptions())
            //System.out.println(e.getText());

        state.selectByIndex(3);


        WebElement DefAddress = driver.findElement(By.cssSelector("[name='default'][value='0']"));
        DefAddress.click();

        WebElement Continue = driver.findElement(By.cssSelector("[value='Continue']"));
        Continue.click();

        Tools.successMessageValidation();

        Tools.Bekle(5);


}



}



