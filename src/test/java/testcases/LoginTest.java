package testcases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.BaseClass;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtils;

public class LoginTest extends BaseClass {

    LoginPage loginPage;

    @DataProvider(name = "loginData")
    public Object[][] getLoginData() {
        logger.info("Fetching data from Excel for Login...");
        return ExcelUtils.getExcelData("Login");
    }

    @Test(dataProvider = "loginData")
    public void loginTest(String email, String password, String scenario, String expectedMessage) throws InterruptedException {
        logger.info("=== Running Login Test for Scenario: " + scenario + " ===");
        logger.info("Email: " + email + ", Password: " + password);

        loginPage = new LoginPage(driver);

        logger.info("Clicking on Login link...");
        loginPage.clickLoginLink();

        logger.info("Entering email and password...");
        loginPage.enterEmail(email);
        loginPage.enterPassword(password);

        logger.info("Clicking Login button...");
        loginPage.clickLoginButton();

        SoftAssert softAssert = new SoftAssert();
        String actualMessage = "";

        if (scenario.equalsIgnoreCase("Registered User")) {
            logger.info("Checking if login is successful...");
            boolean isSuccess = loginPage.isLoginSuccessful();
            softAssert.assertTrue(isSuccess, "Home Page not loaded / Login Failed");

            if (isSuccess) {
                logger.info("✅ Login successful. Logging out...");
                HomePage home = new HomePage(driver);
                home.clickLogoutLink();
            }

        } else if (scenario.equalsIgnoreCase("UnRegistered User")
                || scenario.equalsIgnoreCase("Blank username")
                || scenario.equalsIgnoreCase("blankPassword")) {

            logger.info("Fetching error message...");
            actualMessage = loginPage.getErrorMessage();
            logger.info("Actual error message: " + actualMessage);
            softAssert.assertTrue(actualMessage.toLowerCase().contains(expectedMessage.toLowerCase()),
                    "Expected: " + expectedMessage + ", Actual: " + actualMessage);

        } else if (scenario.equalsIgnoreCase("Invalid email format")) {
            logger.info("Fetching invalid email format error...");
            actualMessage = loginPage.getInvalidEmailErrorMessage();
            logger.info("Actual format error: " + actualMessage);
            softAssert.assertTrue(actualMessage.toLowerCase().contains(expectedMessage.toLowerCase()),
                    "Expected: " + expectedMessage + ", Actual: " + actualMessage);
        }

        logger.info("Assertion completed for scenario: " + scenario);
        softAssert.assertAll();
    }
}
