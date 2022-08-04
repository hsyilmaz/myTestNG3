package Gun03;

import Utils.GenelWebDriver;
import Utils.Tools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
    /*
       Senaryo;
       1- Siteyi açınız.
       2- Adress Ekleyiniz.
       3- En son eklenen adresi edit yaparak ad ve soyadı değiştirip kaydediniz.
       4- En son eklenen adresi siliniz.
 */

public class _02_AddressFunctionality extends GenelWebDriver {
    @Test
    void Adresekle()
    {
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

        WebElement Country = driver.findElement(By.name("country_id"));
        Select countMenu=new Select(Country);
        countMenu.selectByValue("215");

        WebElement Region = driver.findElement(By.name("zone_id"));
        Select regionMenu=new Select(Region);
        regionMenu.selectByValue("3341");

        WebElement DefAddress= driver.findElement(By.cssSelector("[name='default'][value='1']"));
        DefAddress.click();

        WebElement Continue = driver.findElement(By.cssSelector("[value='Continue']"));
        Continue.click();

        Tools.successMessageValidation();

        Tools.Bekle(5);
    }


    @Test
    void Adresedit(){

        WebElement addressBook = driver.findElement(By.linkText("Address Book"));
        addressBook.click();

        WebElement Editadres = driver.findElement(By.xpath("(//a[text()='Edit'])[3]"));
        Editadres.click();

        WebElement name = driver.findElement(By.id("input-firstname"));
        name.clear();
        name.sendKeys("Nazann");

        WebElement Lname = driver.findElement(By.name("lastname"));
        Lname.clear();
        Lname.sendKeys("Nazancan");

        WebElement DefAddress= driver.findElement(By.cssSelector("[name='default'][value='0']"));
        DefAddress.click();

        WebElement Continue = driver.findElement(By.cssSelector("[value='Continue']"));
        Continue.click();

        Tools.successMessageValidation();

        WebElement Deleteadres = driver.findElement(By.xpath("(//a[text()='Delete'])[3/**/]"));
        Deleteadres.click();

        Tools.successMessageValidation();

        Tools.Bekle(5);

    }



    }


