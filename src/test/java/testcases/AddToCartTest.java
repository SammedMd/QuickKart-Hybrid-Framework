package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.LoginPage;
import pages.ProductPage;
import pages.SearchPage;

public class AddToCartTest extends BaseClass{
   
	@Test(priority = 1)
	public void testAddToCart() throws InterruptedException {
		logger.info("Starting Add to Cart Test");
		LoginPage lp = new LoginPage(driver);
		lp.clickLoginLink();
		lp.enterEmail("registered_user_email.com");
		lp.enterPassword("Password123");
		lp.clickLoginButton();
		logger.info("Logged In sucessFully");
		
		SearchPage sp = new SearchPage(driver);
			sp.enterProductName("Laptop");
			sp.clickSearchButton();
			sp.clickFirstProduct();
			
			ProductPage pp = new ProductPage(driver);
			pp.clickAddToCart();
			Thread.sleep(3000);
			String msg = pp.getCartSuccessMessage();
			logger.info("Sucess Message: " + msg);
			
			Assert.assertTrue(msg.contains("The product has been added to your shopping cart"),
	                  "Product not added to cart");
	  logger.info("Add to cart Test Passed");	
	  
	  
	}
		}
//LoginPage lp = new LoginPage(driver);
//lp.clickLoginLink();
//lp.enterEmail("registered_user_email.com");
//lp.enterPassword("Password123");
//lp.clickLoginButton();
//logger.info("Logged In sucessFully");

