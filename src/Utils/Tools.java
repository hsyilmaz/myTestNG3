package Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import java.util.List;

public class Tools {

    public static void compareToList(List<String>menuExpList, List<WebElement>menuActList)
    {
        for(int i=0; i<menuExpList.size(); i++)
            Assert.assertEquals(menuExpList.get(i), menuActList.get(i).getText(),"Karsilastirma sonucu");
    }

    public static void successMessageValidation()
    {
      WebElement confirmingMssg =
      GenelWebDriver.driver.findElement(By.cssSelector("div[class='alert alert-success alert-dismissible']"));

      Assert.assertTrue(confirmingMssg.getText().contains(" successfully "));

    }
    public static void Bekle(int saniye)
    {
        try {Thread.sleep(saniye*1000);}

        catch (InterruptedException e)
        { throw new RuntimeException(e); }

    }
    public static double WebElementToDouble(WebElement e) {
        String result=e.getText();
        result=result.replaceAll("[\\D]","");
        return Double.parseDouble(result);

//        return Double.parseDouble(e.getText().replaceAll("[\\D]",""));
//        return Double.parseDouble(e.getText().replace("$",""));
    }
    public static int RandomGenerator (int max)
    {
        return (int)(Math.random()*max);
    }



}
