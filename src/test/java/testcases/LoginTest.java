package testcases;

import org.testng.Assert;
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
        logger.info("📊 Fetching data from Excel for Login...");
        return ExcelUtils.getExcelData("Login");
    }

    @Test(dataProvider = "loginData")
    public void loginTest(String email, String password, String scenario, String expectedMessage) {
        logger.info("=== 🧪 Running Login Test for Scenario: " + scenario + " ===");
        logger.info("Email: " + email + ", 🔒 Password: " + password);

        HomePage homePage = new HomePage(getDriver());
        LoginPage loginPage = new LoginPage(getDriver());

        // Click login link
        logger.info("Clicking on Login link...");
        homePage.clickLoginLink();

        // Fill form
        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
        loginPage.clickLoginButton();


        SoftAssert softAssert = new SoftAssert();
        String actualMessage = "";

        if (scenario.equalsIgnoreCase("Registered User")) {
            logger.info("Checking if login is successful...");
            boolean isSuccess = loginPage.isLoginSuccessful();
            softAssert.assertTrue(isSuccess, "Home Page not loaded / Login Failed");

            if (!isSuccess) {
                throw new RuntimeException("CAPTURE_SCREENSHOT: Login failed for registered user");
            }

            logger.info("Login successful. Logging out...");
            HomePage home = new HomePage(getDriver());
            home.clickLogoutLink();

        } else if (scenario.equalsIgnoreCase("UnRegistered User")
                || scenario.equalsIgnoreCase("Blank username")
                || scenario.equalsIgnoreCase("blankPassword")) {

            logger.info("❗ Fetching error message...");
            actualMessage = loginPage.getErrorMessage();
            logger.info("Actual: " + actualMessage);

            if (!actualMessage.toLowerCase().contains(expectedMessage.toLowerCase())) {
                throw new RuntimeException("CAPTURE_SCREENSHOT: Unexpected error message: " + actualMessage);
            }

        } else if (scenario.equalsIgnoreCase("Invalid email format")) {
            logger.info("❗ Fetching invalid email format error...");
            actualMessage = loginPage.getInvalidEmailErrorMessage();
            logger.info("Actual format error: " + actualMessage);


            if (!actualMessage.toLowerCase().contains(expectedMessage.toLowerCase())) {
                throw new RuntimeException("CAPTURE_SCREENSHOT: Invalid email format message mismatch");
            }
        }

        logger.info("All validations done for: " + scenario);
        softAssert.assertAll();
    }
}
