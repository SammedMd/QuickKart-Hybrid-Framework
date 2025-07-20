package testcases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtils;

public class LoginTest extends BaseClass {

    @DataProvider(name = "loginData")
    public Object[][] getLoginData() {
        return ExcelUtils.getExcelData("Login");
    }

    @Test(priority = 1, dataProvider = "loginData", groups = "login")
    public void loginTest(String email, String pass, String scenarioType, String expectedResult) {
        LoginPage login = new LoginPage(driver);

        login.clickLoginLink();

        Assert.assertTrue(login.isLoginPageLoaded(), "Login page is not loaded.");

        login.enterEmail(email);
        login.enterPassword(pass);
        login.clickRememberMe();
        login.clickLoginButton();

        if (scenarioType.equalsIgnoreCase("Valid")) {
            Assert.assertTrue(login.isLoginSuccessful(), "Login should be successful.");
            HomePage home = new HomePage(driver);
            home.clickLogout();
        } else {
        	String actualError = login.getErrorMessage().toLowerCase();
        	String expected = expectedResult.toLowerCase();

        	// 🔍 Debug log in console
        	System.out.println("======== SCENARIO: " + scenarioType + " ========");
        	System.out.println("Expected Result: " + expected);
        	System.out.println("Actual Result:   " + actualError);
        	System.out.println("==========================================");

        	// 🧠 Validate it
        	Assert.assertTrue(actualError.contains(expected), "❌ Mismatch: Expected vs Actual error message");


            switch (scenarioType.toLowerCase()) {
                case "invalid credentials":
                case "invalid email format":  // app doesn’t validate format, so both get same message
                    Assert.assertTrue(actualError.contains("login was unsuccessful") || actualError.contains("Please enter a valid email address."),
                            "Expected error for invalid credentials or email format");
                    break;

                case "blank username":
                    Assert.assertTrue(actualError.contains("please enter your email") || actualError.contains("login was unsuccessful"),
                            "Expected error for blank email");
                    break;

                case "blank password":
                    Assert.assertTrue(actualError.contains("please enter your password") || actualError.contains("login was unsuccessful"),
                            "Expected error for blank password");
                    break;

                case "both fields blank":
                    Assert.assertTrue(actualError.contains("login was unsuccessful"),
                            "Expected error for both fields blank");
                    break;

                default:
                    Assert.fail("Unknown scenario type: " + scenarioType);
            }
        }
    }
}
