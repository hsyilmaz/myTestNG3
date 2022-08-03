package Gun03;

import Utils.GenelWebDriver;
import Utils.Tools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
    //Siteyi Ac.
    // Adres ekle

public class _02_AddressFunctionality extends GenelWebDriver {
    @Test
    void Adresekle()
    {
        WebElement addressBook = driver.findElement(By.linkText("Address Book"));
        addressBook.click();

        WebElement newaddress = driver.findElement(By.linkText("New Address"));
        newaddress.click();

        WebElement name = driver.findElement(By.id("input-firstname"));
        name.sendKeys("Nuriye");

        WebElement Lname = driver.findElement(By.name("lastname"));
        Lname.sendKeys("Nuriyeli");

        WebElement company = driver.findElement(By.name("company"));
        company.sendKeys("ABC");

        WebElement Address1 = driver.findElement(By.name("address_1"));
        Address1.sendKeys("first street");

        WebElement Address2 = driver.findElement(By.name("address_2"));
        Address2.sendKeys("second street");

        WebElement City = driver.findElement(By.name("city"));
        City.sendKeys("Birmingham");

        WebElement PostCode = driver.findElement(By.name("postcode"));
        PostCode.sendKeys("12345");

        WebElement Country = driver.findElement(By.name("country_id"));
        Select countMenu=new Select(Country);
        countMenu.selectByValue("222");

        WebElement Region = driver.findElement(By.name("zone_id"));
        Select regionMenu=new Select(Region);
        regionMenu.selectByIndex(12);

        WebElement DefAddress= driver.findElement(By.cssSelector("[name='default'][value='0']"));
        DefAddress.click();

        WebElement Continue = driver.findElement(By.cssSelector("[value='Continue']"));
        Continue.click();

        Tools.successMessageValidation();

        Tools.Bekle(5);
    }
    /*
       WebElement country=driver.findElement(By.id("input-country"));
       Select countryS=new Select(country);
       countryS.selectByIndex(10);

       WebElement State=driver.findElement(By.id("input-zone"));
       Select state=new Select(State);
       System.out.println("state.getOptions().size() 1 = " + state.getOptions().size());

       wait.until(ExpectedConditions.numberOfElementsToBeLessThan(By.cssSelector("[id='input-zone']>option"),
                   state.getOptions().size()));
       // option ların sayısı ilk halinden küçük olana kadar bekle : yeni durum gelene kadar bekle

       System.out.println("state.getOptions().size() 2 = " + state.getOptions().size());

       State=driver.findElement(By.id("input-zone"));
       state=new Select(State);

//       System.out.println("state.getOptions().size() = " + state.getOptions().size());
//       for(WebElement e: state.getOptions())
//           System.out.println(e.getText());

       state.selectByIndex(3);
       */

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

        WebElement Deleteadres = driver.findElement(By.xpath("(//a[text()='Delete'])[3]"));
        Deleteadres.click();

        Tools.successMessageValidation();

        Tools.Bekle(5);



    }



    }


