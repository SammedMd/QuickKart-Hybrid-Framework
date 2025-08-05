package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShotUtilities {

    static Logger logger = LogManager.getLogger(ScreenShotUtilities.class);

    public static String captureScreenshot(WebDriver driver, String fileName) {
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String destPath = System.getProperty("user.dir") + "/screenshots/" + fileName + "_" + timestamp + ".png";

        try {
            FileUtils.copyFile(src, new File(destPath));
            logger.info("Screenshot saved: " + destPath);
        } catch (IOException e) {
            logger.error("Screenshot saving failed: " + e.getMessage());
        }

        return destPath; // ✅ Now this works fine
    }
}
