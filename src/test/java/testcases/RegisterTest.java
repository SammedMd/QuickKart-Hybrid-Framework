package testcases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.Assert;

import base.BaseClass;
import pages.RegisterPage;
import utilities.ExcelUtils;

public class RegisterTest extends BaseClass {

    @DataProvider(name = "registerData")
    public Object[][] getRegisterData() {
        return ExcelUtils.getExcelData("Register");
    }

    @Test(priority = 1, dataProvider = "registerData", groups = "register")
    public void registerNewUserTest(String firstName, String lastName, 
    		        String email, String password, String confirmPassword) {
       
    	RegisterPage register = new RegisterPage(driver);
        SoftAssert softAssert = new SoftAssert();

        register.clickRegisterLink();
        register.selectGender();
       
        register.enterFirstName(firstName);
        softAssert.assertTrue(register.isFirstNameValid(), "First Name invalid: " + firstName);
       
        register.enterLastName(lastName);
     //   softAssert.assertTrue(register.isLastNameValid(), "Last Name invalid: " + lastName);

        String uniqueEmail = "sammed" + System.currentTimeMillis() + "@mail.com";
        register.enterEmail(uniqueEmail);

      //  register.enterEmail(email);
    //    softAssert.assertTrue(register.isEmailValid(), "Email invalid: " + email);

        register.enterPassword(password);
     //   softAssert.assertTrue(register.isPasswordValid(), "Password invalid");

        register.enterConfirmPassword(confirmPassword);
     //   softAssert.assertTrue(register.isConfirmPasswordValid(), "Confirm Password invalid");

        register.clickRegisterButton();

        // Check overall success message (hard assert)
        String successMessage = register.getSucessMessaage();
        Assert.assertEquals(successMessage, "Your registration completed", "Registration failed for email: " + uniqueEmail);


        // Collect all soft assert failures
        softAssert.assertAll();
    }
}
