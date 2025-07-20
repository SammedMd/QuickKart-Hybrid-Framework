package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {
   WebDriver driver;
   
   public RegisterPage(WebDriver driver) {
	   this.driver = driver;
   } 
   //Locators
   By registerLink = By.className("ico-register");
   By gender = By.id("gender-male");
   By firstName = By.id("FirstName");
   By lastName = By.id("LastName");
   By emailInput = By.xpath("//*[@id=\"Email\"]");
   By passwordInput = By.id("Password");
   By confirmPasswordInput = By.name("ConfirmPassword");
   By registerButton = By.xpath("//input[@id='register-button']");
   By sucessMessage = By.xpath("//div[@class='result']");
   
   //Actions
   public void clickRegisterLink() {
	   driver.findElement(registerLink).click();
   } 
   
   public void selectGender() {
	   driver.findElement(gender).click();
   }
   
   public void enterFirstName(String fName) {
	   driver.findElement(firstName).sendKeys(fName);
   }
   
     public void enterLastName(String lName) {
    	 driver.findElement(lastName).sendKeys(lName);
     }
     
     public void enterEmail(String mail) {
    	 driver.findElement(emailInput).sendKeys(mail);
     }
     
     public void enterPassword(String pass) {
    	 driver.findElement(passwordInput).sendKeys(pass);
     }
     
     public void enterConfirmPassword(String Cpass) {
    	 driver.findElement(confirmPasswordInput).sendKeys(Cpass);
     }
     
     public void clickRegisterButton() {
    	 driver.findElement(registerButton).click();
     }
     
   public String getSucessMessaage() {
	   return driver.findElement(sucessMessage).getText();
   }

   public boolean isFirstNameValid() {
	    // Check if the error message element is present and visible
	    try {
	        By firstNameError = By.id("FirstName-error");
	        return !driver.findElement(firstNameError).isDisplayed();
	    } catch (Exception e) {
	        // If element not found, then assume it's valid
	        return true;
	    }
	}
}
//public boolean isEmailValid() {
//	// TODO Auto-generated method stub
//	return false;
//}
//
//public boolean isPasswordValid() {
//	// TODO Auto-generated method stub
//	return false;
//}
//
//public boolean isConfirmPasswordValid() {
//	// TODO Auto-generated method stub
//	return false;
//}
//
//public boolean isLastNameValid() {
//	// TODO Auto-generated method stub
//	return false;
//}
//  
//}
