package com.nopcommerce.testCases;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.nopcommerce.pageObjects.AddCustomerPage;
import com.nopcommerce.pageObjects.LoginPage;

public class AddCustomer_TestCase2 extends BaseClass{

	@Test
	public void addNewCustomer() throws Exception {
		
		logger.info("Opening the URL");
		driver.get(baseURL);
		
		LoginPage lp = new LoginPage(driver);
		
		logger.info("Entered Username");
		lp.setUsername(username);
		logger.info("Entered Password");
		lp.setPassword(password);
		logger.info("Clicking Login");
		lp.clickLogin();
		
		logger.info("Adding New Customer");
		AddCustomerPage ac = new AddCustomerPage(driver);
		
		ac.clickCustomer1();
		logger.info("Clicked On Customer Menu");
		
		ac.clickCustomer2();
		logger.info("Clicked on the Sub Option Customer");
		
		ac.clickAddCustomer();
		logger.info("Clicked on AddCustomer Button");
		
		String email = randomstring()+"@gmail.com";
		ac.setEmail(email);
		logger.info("Email Added");
		
		ac.setPassword("User123");
		logger.info("Password Added");
		
		Thread.sleep(2000);
		ac.setFname("Rishi");
		logger.info("First Name Added");
		
		ac.setLname("Bhaskar PM");
		logger.info("Last Name Added");
		
		ac.setGender("Male");
		logger.info("Gender Added");
		
		ac.setDOB("3/20/1999");
		logger.info("Date of Birth Added");
		
		ac.setComapanyName("Apple");
		logger.info("Company Name Added");
		
		ac.setNewsletter("StoreName");
		logger.info("News Letter Added");
		
		ac.setCustomerRoles("Guests");
		logger.info("Customer Role Added");
		
		ac.setVendor("Vendor 2");
		logger.info("Vendor Category Selected");
		
		ac.setAdminComment("Customer is Verified to be Added");
		logger.info("Admin Comment Added");
		
		Thread.sleep(2000);
		ac.clickSave();
		logger.info("Clicked On Save Button");
		
		
		String msg = driver.findElement(By.xpath("/html/body/div[3]/div[3]/div[1]")).getText();
		//String msg = driver.findElement(By.tagName("body")).getText();
		
		if(msg.contains("The new customer has been added successfully.")) {
			Assert.assertTrue(true);
			logger.info("Test Case Passed");
		}
		else {
			captureScreen(driver,"AddCustomer");
			Assert.assertTrue(false);
			logger.info("Test Case Passed");
		}
		
		logger.info("Test Case Done");
	}
	
}
