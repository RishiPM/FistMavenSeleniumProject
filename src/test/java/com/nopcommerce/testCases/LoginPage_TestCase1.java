package com.nopcommerce.testCases;

import java.io.IOException;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.nopcommerce.pageObjects.LoginPage;

public class LoginPage_TestCase1 extends BaseClass{

	@Test
	public void LoginTest() throws InterruptedException, IOException {
		
		logger.info("Opening the URL");
		driver.get(baseURL);
		
		LoginPage lp = new LoginPage(driver);
		
		lp.setUsername(username);
		logger.info("Entered Username");
		
		lp.setPassword(password);
		logger.info("Entered Password");
		
		lp.clickLogin();
		logger.info("Clicked the Login Button");
		
		if(driver.getTitle().equals("Dashboard / nopCommerce administration")) {
			Thread.sleep(3000);
			
			lp.clickLogout();
			logger.info("Logging out of the page");
			
			Assert.assertTrue(true);
			logger.info("Login Test Case Passed");
		}
		else {
			captureScreen(driver,"LoginTest");
			Assert.assertTrue(false);
			logger.info("Login Test Case Failed");
		}
	}
}
