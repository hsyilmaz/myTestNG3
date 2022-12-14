package Gun06;

import Utils.ParametreliWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

/*
 * fakrlı tarayıcılar ile search
 * sonrasında paralel çalıştır.
 */

public class _05_Task_2 extends ParametreliWebDriver {

    @Test(dataProvider = "getData")
    void  SearchFunction(String txtSearch)
    {
        WebElement searchInput = driver.findElement(By.name("search"));
        searchInput.clear();
        searchInput.sendKeys(txtSearch);

        WebElement searchButton = driver.findElement(By.cssSelector("#search  button"));
        searchButton.click();

        //h4>a
        List<WebElement> captions = driver.findElements(By.cssSelector("[class='caption'] a"));

        for (WebElement e : captions) {
            Assert.assertTrue(e.getText().toLowerCase().contains(txtSearch));
        }
    }

    @DataProvider
    public Object[] getData()
    {
        Object[] data = {"mac","ipod","samsung"};
        return data;
    }

}
