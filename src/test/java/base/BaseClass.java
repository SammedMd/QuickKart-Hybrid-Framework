package base;

import java.time.Duration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseClass {

    public WebDriver driver;
    public Logger logger;

    @BeforeClass
    @Parameters({"os", "browser"})
    public void setup(@Optional("windows") String os, @Optional("chrome") String browser) {
        logger = LogManager.getLogger(this.getClass());

        logger.info("Running on OS: " + os + ", Browser: " + browser);
        logger.info("Thread ID: " + Thread.currentThread());

        try {
            switch (browser.toLowerCase()) {
                case "chrome":
                    driver = new ChromeDriver();
                    logger.info("Chrome Launched");
                    break;
                case "firefox":
                    driver = new FirefoxDriver();
                    logger.info("Firefox Launched");
                    break;
                case "edge":
                    EdgeOptions edgeOptions = new EdgeOptions();
                    edgeOptions.addArguments("--inprivate"); // OR use a temp profile
                    driver = new EdgeDriver(edgeOptions);
                    logger.info("Edge Launched");
                    break;
                default:
                    logger.error("Invalid browser name: " + browser);
                    throw new IllegalArgumentException("Unsupported browser: " + browser);
            }

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.manage().window().maximize();

            String appUrl = "https://demowebshop.tricentis.com";
            driver.get(appUrl);
            logger.info("Navigated to: " + appUrl);

        } catch (Exception e) { 
            logger.error("Exception during browser setup: ", e);
        }
    }

   @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            logger.info("Browser closed");
        }
    }
}
