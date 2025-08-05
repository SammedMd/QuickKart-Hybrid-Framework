package base;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.ITestResult;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.ScreenShotUtilities;

public class BaseClass {

    private static ThreadLocal<WebDriver> threadDriver = new ThreadLocal<>();
    public Logger logger;

    // Get the current thread's driver
    public static WebDriver getDriver() {
        return threadDriver.get();
    }

    @BeforeClass
    @Parameters({"os", "browser"})
    public void setup(@Optional("windows") String os, @Optional("chrome") String browser) {
        logger = LogManager.getLogger(this.getClass());

        logger.info("Running on OS: " + os + ", Browser: " + browser);
        logger.info("Thread ID: " + Thread.currentThread());

        try {
            WebDriver localDriver = null;

            switch (browser.toLowerCase()) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    localDriver = new ChromeDriver();
                    logger.info("Chrome Launched");
                    break;

                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    localDriver = new FirefoxDriver();
                    logger.info("Firefox Launched");
                    break;

//                case "edge":
//                    WebDriverManager.edgedriver().setup();
//                    EdgeOptions edgeOptions = new EdgeOptions();
//                    edgeOptions.addArguments("--inprivate");
//                    localDriver = new EdgeDriver(edgeOptions);
//                    logger.info("Edge Launched");
//                    break;

                default:
                    logger.error("Invalid browser name: " + browser);
                    throw new IllegalArgumentException("Unsupported browser: " + browser);
            }

            threadDriver.set(localDriver); // Store driver per thread

            getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            getDriver().manage().window().maximize();

            String appUrl = "https://demowebshop.tricentis.com";
            getDriver().get(appUrl);
            logger.info("Navigated to: " + appUrl);

        } catch (Exception e) {
            logger.error("Exception during browser setup: ", e);
        }
    }

    @AfterMethod
    public void captureScreenshotOnFailure(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            Throwable exception = result.getThrowable();
            String failureReason = exception != null ? exception.getMessage() : "";

            if (failureReason != null && failureReason.contains("CAPTURE_SCREENSHOT")) {
                String testName = result.getName();
                ScreenShotUtilities.captureScreenshot(getDriver(), testName);
                logger.info("Screenshot captured for failed test: " + testName);
            } else {
                logger.warn("Test failed but no screenshot taken (not marked with CAPTURE_SCREENSHOT): " + result.getName());
            }
        }
    }

    @AfterClass
    public void tearDown() {
        if (getDriver() != null) {
            getDriver().quit();
            threadDriver.remove(); // Clean up thread
            logger.info("Browser closed");
        }
    }
}
