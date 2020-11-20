package com.nopcommerce.testCases;

import java.io.IOException;

import org.junit.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.nopcommerce.pageObjects.LoginPage;
import com.nopcommerce.utilities.XLUtils;

public class LoginPageDDT_TestCase1 extends BaseClass{

	@Test(dataProvider="LoginData")
	public void loginTest(String uname, String pwd) throws InterruptedException, IOException {
		
		logger.info("Opening the URL");
		driver.get(baseURL);
		
		LoginPage lp = new LoginPage(driver);
		
		lp.setUsername(uname);
		logger.info("Entered Username");
		
		lp.setPassword(pwd);
		logger.info("Entered Password");
		
		lp.clickLogin();
		logger.info("Clicked the Login Button");
		
		if(driver.getTitle().equals("Dashboard / nopCommerce administration")) {
			Thread.sleep(2000);
			
			lp.clickLogout();
			logger.info("Logging out of the page");
			
			Assert.assertTrue(true);
			logger.info("Login Test Case Passed");
		}
		else {
			//captureScreen(driver,"LoginTest");
			Assert.assertTrue(false);
			logger.info("Login Test Case Failed");
		}
	}
	
	@DataProvider(name="LoginData")
	public String[][] getData() throws Exception{
		
		String path = System.getProperty("user.dir")+"/src/test/java/com/nopcommerce/testData/LoginData.xlsx";
		int rownum = XLUtils.getRowCount(path, "Sheet1");
		int colnum = XLUtils.getColumnCount(path, "Sheet1", rownum);
		
		String logindata[][] = new String[rownum][colnum];
		
		for(int i=1;i<=rownum;i++) {
			for(int j=0;j<colnum;j++) {
				
				logindata[i-1][j] = XLUtils.getColumnData(path, "Sheet1", i, j);
			}
		}
		return logindata;
	}
}
