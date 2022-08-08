package Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Parametreli_GWD {

    public static WebDriver driver;
    public static WebDriverWait wait;

    @Parameters("browser")
    @BeforeClass
    public void BaslangicIslemleri(String browser)
    {
        System.out.println("Driver start ....");
        Logger logger = Logger.getLogger("");
        logger.setLevel(Level.SEVERE);

        if (browser.equalsIgnoreCase("chrome")){

        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        }
        else if (browser.equalsIgnoreCase("firefox")){

                System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
                System.setProperty("webdriver.gecko.driver", "drivers/geckodriver");
                driver = new FirefoxDriver();
            }

        driver = new ChromeDriver();
        driver.manage().window().maximize(); // max
        driver.manage().deleteAllCookies();  //

        wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30)); // sadece ana sayfa yüklenirken en başta
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // bütün webElement için geçerli

        driver.get("http://opencart.abstracta.us/index.php?route=account/login");

//        System.out.println(driver.getTitle());  calisiyor.
//        System.out.println(driver.findElement(By.tagName("title")).getText()); calismiyor!!!

        loginTest();
    }

        void loginTest()
        {
            WebElement inputEmail= driver.findElement(By.id("input-email"));
            inputEmail.sendKeys("hsy@gmail.com");

            WebElement password= driver.findElement(By.id("input-password"));
            password.sendKeys("Hy338");

            WebElement loginBtn= driver.findElement(By.cssSelector("input[value='Login']"));
            loginBtn.click();

        }

    @AfterClass
    public void BitisIslemleri()
    {
        System.out.println("Driver stop ....");

        try {Thread.sleep(3000);}

        catch (InterruptedException e)
        {throw new RuntimeException(e);}

        driver.quit();
    }

}
