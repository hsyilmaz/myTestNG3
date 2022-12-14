package Gun06;

import Utils.GenelWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.List;

/*
 * mac,ipod ve samsung için Dataprovider ile search:
 */
public class _04_Task extends GenelWebDriver {


    @Test(dataProvider = "getData")
        void search (String txtSearch)
    {
        WebElement searchInput = driver.findElement(By.name("search"));
        searchInput.clear();
        searchInput.sendKeys(txtSearch);

        WebElement searchButton = driver.findElement(By.cssSelector("#search  button"));
        searchButton.click();

        //h4>a
        List <WebElement> captions =
                driver.findElements(By.cssSelector(".caption a"));

        for (WebElement e : captions) {
            Assert.assertTrue(e.getText().toLowerCase().contains(txtSearch));
        }
    }
    @DataProvider
    public Object [] getData()
    {
        Object [] data={"mac","iPod","samsung"};
        return data;
    }



    }



