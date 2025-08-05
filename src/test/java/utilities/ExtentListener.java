package utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import base.BaseClass;
import org.openqa.selenium.WebDriver;

public class ExtentListener implements ITestListener {

    private static ExtentReports extent;
    private static ExtentTest test;
    private static String browserName;

    @Override
    public void onStart(ITestContext context) {
        // 🔽 Get browser parameter from testng.xml
        browserName = context.getCurrentXmlTest().getParameter("browser");

        if (browserName == null || browserName.isEmpty()) {
            browserName = "unknownBrowser";
        }

        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String reportPath = System.getProperty("user.dir") + "/extent-reports/Report_" + browserName + "_" + timestamp + ".html";

        ExtentSparkReporter spark = new ExtentSparkReporter(new File(reportPath));
        spark.config().setDocumentTitle("Automation Report");
        spark.config().setReportName("Demo Web Shop Test Report - " + browserName.toUpperCase());

        extent = new ExtentReports();
        extent.attachReporter(spark);
        extent.setSystemInfo("Tester", "Sammed Mudeppagol");
        extent.setSystemInfo("Browser", browserName);
        extent.setSystemInfo("Environment", "QA");
    }

    @Override
    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.pass("✅ " + result.getMethod().getMethodName() + " PASSED");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test.fail("❌ " + result.getMethod().getMethodName() + " FAILED");
        test.fail(result.getThrowable());

        WebDriver driver = BaseClass.getDriver();
        String screenshotPath = ScreenShotUtilities.captureScreenshot(driver, result.getName());
        try {
            test.addScreenCaptureFromPath(screenshotPath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test.skip("⚠️ " + result.getMethod().getMethodName() + " SKIPPED");
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }
}
