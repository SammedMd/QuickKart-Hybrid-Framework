package testcases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.BaseClass;
import pages.HomePage;
import pages.RegisterPage;
import utilities.ExcelUtils;

import org.testng.Assert;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class RegisterTest extends BaseClass {

    Logger logger = LogManager.getLogger(RegisterTest.class);  // FIXED: Logger declaration

    @DataProvider(name = "registerData")
    public Object[][] getRegisterData() {
        return ExcelUtils.getExcelData("Register");
    }

    @Test(priority = 1, dataProvider = "registerData", groups = "register")
    public void registerNewUserTest(String firstName, String lastName, String dummyEmail, String password, String confirmPassword) {
        logger.info("===Starting Register Test Case ===");

        try {
            HomePage homePage = new HomePage(getDriver());
            RegisterPage register = new RegisterPage(getDriver());
            SoftAssert softAssert = new SoftAssert();

            String generatedEmail = "user" + System.currentTimeMillis() + "@mail.com";

            logger.info("SCENARIO: Register New User");
            logger.info("First Name: " + firstName + " | Last Name: " + lastName);
            logger.info("Generated Email: " + generatedEmail);

            homePage.clickRegisterLink();
            register.selectGender();
            register.enterFirstName(firstName);
            register.enterLastName(lastName);
            register.enterEmail(generatedEmail);
            register.enterPassword(password);
            register.enterConfirmPassword(confirmPassword);
            register.clickRegisterButton();            String successMessage = register.getSucessMessaage();
            logger.info("Success Message: " + successMessage);

            Assert.assertEquals(successMessage, "Your registration completed", "Registration failed!");
            logger.info("Registration successful!\n==========================================");

            softAssert.assertAll();

        } catch (Exception e) {
            logger.error("Exception in Register Test: " + e.getMessage());
            e.printStackTrace();
            Assert.fail("Test crashed!");
        }
    }
}
