package Alp.Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.time.Duration;

public class GeneralWebDriver {

    public static WebDriver driver;
    public static WebDriverWait wait;

    @Parameters("browser")
    @BeforeClass
    public void baslangicIslemler(String browser) {

        System.out.println("Driver Start ......");

        if (browser.equalsIgnoreCase("chrome")) {
            System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
            System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
            driver = new ChromeDriver();
        }
        if (browser.equalsIgnoreCase("firefox")) {

            System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "true");
            System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");
            driver = new FirefoxDriver();
        }


        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        Duration baseDuration = Duration.ofSeconds(30);
        Duration webDriverDuration = Duration.ofSeconds(10);

        driver.manage().timeouts().pageLoadTimeout(baseDuration);
        driver.manage().timeouts().implicitlyWait(baseDuration);

        wait = new WebDriverWait(driver, webDriverDuration);

    }





    @AfterClass
    void endProcess() {

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();

    }


}
