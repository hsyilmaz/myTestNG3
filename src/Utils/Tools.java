package Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import javax.xml.soap.Text;
import java.util.List;

public class Tools {

    public static void compareToList(List<String>menuExpList, List<WebElement>menuActList){

        for(int i=0; i<menuExpList.size(); i++)
            Assert.assertEquals(menuExpList.get(i), menuActList.get(i).getText(),"Karsilastirma sonucu");

    }

    public static void successMessageValidation(){
        WebElement confirmationText = GenelWebDriver.driver.findElement
         (By.xpath("//div[contains(text(),' successfully updated.')]"));
        Assert.assertTrue(confirmationText.getText().contains("successfully"));

    }


}
