package Gun03;

import Utils.GenelWebDriver;
import Utils.Tools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;
    /*
       Senaryo;
       1- Siteyi açınız.
       2- Adress Ekleyiniz.
       3- En son eklenen adresi edit yaparak ad ve soyadı değiştirip kaydediniz.
       4- En son eklenen adresi siliniz.
 */

public class _02_AddressFunctionality extends GenelWebDriver {
    @Test
    void Adres_add()
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
       //wait.until(ExpectedConditions.elementToBeClickable(Country));


        WebElement Region_options = driver.findElement(By.cssSelector("[id='input-zone']>option"));
        wait.until(ExpectedConditions.stalenessOf(Region_options));
        //bu elemanın bayatlamış hali gidene kadar bekle

        WebElement Region = driver.findElement(By.id("input-zone"));
        Select regionMenu=new Select(Region);
        regionMenu.selectByIndex(15);

        WebElement DefAddress= driver.findElement(By.cssSelector("[name='default'][value='0']"));
        DefAddress.click();

        WebElement Continue = driver.findElement(By.cssSelector("[value='Continue']"));
        Continue.click();

        Tools.successMessageValidation();

    }

    @Test(dependsOnMethods = {"Adres_add"})
    void Adres_edit() {

        WebElement addressBook = driver.findElement(By.linkText("Address Book"));
        addressBook.click();

        List<WebElement> editall = driver.findElements(By.linkText("Edit"));
        WebElement sonedit = editall.get(editall.size()-1);  // son edit element.
        System.out.println("editall = " + editall.size());
        sonedit.click();


        WebElement name = driver.findElement(By.id("input-firstname"));
        name.clear();
        name.sendKeys("Nazann");

        WebElement Lname = driver.findElement(By.name("lastname"));
        Lname.clear();
        Lname.sendKeys("Nazancan");

        WebElement DefAddress = driver.findElement(By.cssSelector("[name='default'][value='0']"));
        DefAddress.click();

        WebElement Continue = driver.findElement(By.cssSelector("[value='Continue']"));
        Continue.click();

        Tools.successMessageValidation();
    }

    @Test(dependsOnMethods = {"Adres_edit"})
    void Adres_delete(){

        WebElement addressBook = driver.findElement(By.linkText("Address Book"));
        addressBook.click();

        List<WebElement> deleteall = driver.findElements(By.linkText("Delete"));
        WebElement sondelete = deleteall.get(deleteall.size()-1);  // son delete element.
        System.out.println("deleteall = " + deleteall.size());
        sondelete.click();

        Tools.successMessageValidation();

    }



    }


