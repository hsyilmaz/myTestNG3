package Gun03;

import Utils.Tools;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class alperPrj {

    public static WebDriverWait wait;
    public static WebDriver driver;

    @BeforeMethod
    void driverGet() {

        System.out.println("Driver Start ......");

        Logger logger = Logger.getLogger("");
        logger.setLevel(Level.SEVERE);

        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");

        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        Duration dr = Duration.ofSeconds(30);

        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        driver.manage().timeouts().pageLoadTimeout(dr);
        driver.manage().timeouts().implicitlyWait(dr);

        driver.get("https://www.wikipedia.org/");


    }

    @AfterMethod
    public void BitirIslemleri() {
        System.out.println("Driver Quit .....");

        try {Thread.sleep(3000);}
        catch (InterruptedException e)
        {throw new RuntimeException(e);}
        driver.quit();
    }


    @Test
    void seneryo1() {
        By other_project = By.cssSelector("[class='other-project-title jsl10n']");

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(other_project));

        List<WebElement> otherProjects = driver.findElements(other_project);

        List<String> projectNames = new ArrayList<>();

        projectNames.add("Commons");
        projectNames.add("Vikigezgin");
        projectNames.add("Vikisözlük");
        projectNames.add("Vikikitap");
        projectNames.add("Vikihaber");
        projectNames.add("Vikiveri");
        projectNames.add("Vikiversite");
        projectNames.add("Vikisöz");
        projectNames.add("MediaWiki");
        projectNames.add("Vikikaynak");
        projectNames.add("Vikitür");
        projectNames.add("Meta Viki");

        for (int i = 0; i < projectNames.size(); i++) {

            Assert.assertEquals(projectNames.get(i), otherProjects.get(i).getText(), "Karşılaştırma Sonucu : ");
        }
    }

    @Test(dependsOnMethods = {"seneryo1"})
    void seneryo2() throws AWTException {

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class='central-textlogo__image sprite svg-Wikipedia_wordmark']")));


        Robot robot = new Robot();

        WebElement searchButton = driver.findElement(By.xpath("//button[@class='pure-button pure-button-primary-progressive']"));
        searchButton.click();

        WebElement spanButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='mw-advancedSearch-expandablePane-button oo-ui-widget oo-ui-widget-enabled oo-ui-buttonElement oo-ui-buttonElement-framed oo-ui-indicatorElement oo-ui-labelElement oo-ui-buttonWidget'][1]")));
        spanButton.click();

        WebElement thisWords = driver.findElement(By.xpath("//*[@id='ooui-33']"));
        thisWords.sendKeys("Test");

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        thisWords.sendKeys("Api");

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        thisWords.sendKeys("Database");

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        WebElement searchInput = driver.findElement(By.xpath("//input[@id='ooui-php-1']"));
        searchInput.sendKeys("Yazılım");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@title='Yazılım mühendisliği']")));
        robot.keyPress(KeyEvent.VK_DOWN);
        robot.keyRelease(KeyEvent.VK_DOWN);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        WebElement conditation = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='mw-search-nonefound']")));

        Assert.assertEquals(conditation.getText(), "Sorguyla eşleşen bir sonuç yok.", "Karşılaştırma sonucu : ");


    }

    @Test
    void seneryo3() throws AWTException {

        Robot rbt = new Robot();

        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement searchButton = driver.findElement(By.cssSelector("button[class='pure-button pure-button-primary-progressive']"));
        searchButton.click();

        WebElement searchInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[id='ooui-php-1']")));
//        searchInput.sendKeys("Yazılım");

        Actions actions=new Actions(driver);
        Action action=actions.moveToElement(searchInput).click().sendKeys("Yazılım").build();
        action.perform();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[title='Yazılım mühendisliği']")));

        action=actions.sendKeys(Keys.DOWN).sendKeys(Keys.ENTER).build();
        action.perform();

//        rbt.keyPress(KeyEvent.VK_META);
//        rbt.keyPress(KeyEvent.VK_TAB);
//        rbt.keyRelease(KeyEvent.VK_TAB);
//        Tools.Bekle(1);
//        rbt.keyRelease(KeyEvent.VK_META);
//
//        rbt.keyPress(KeyEvent.VK_DOWN);
//        rbt.keyRelease(KeyEvent.VK_DOWN);
//        rbt.keyPress(KeyEvent.VK_ENTER);
//        rbt.keyRelease(KeyEvent.VK_ENTER);



        WebElement yazilimBaslik = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[title='Yazılım mühendisliği']")));
        yazilimBaslik.click();

        WebElement firstHeading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[id='firstHeading']")));

        Assert.assertEquals("Yazılım mühendisliği", firstHeading.getText(), "Karşılaştırma Sonucu : ");

        WebElement element = driver.findElement(By.cssSelector("a[href$='Privacy_policy/tr']"));

        js.executeScript("arguments[0].scrollIntoView()", element);

        js.executeScript("arguments[0].click()", element);

        WebElement header = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[id='firstHeading']")));

        Assert.assertEquals(header.getText(),"Gizlilik Politikası", "Karşılaştırma sonucu : ");
    }
}
