package com.nopcommerce.testCases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.nopcommerce.utilities.ReadConfig;

public class BaseClass {

	ReadConfig rc = new ReadConfig();
	
	public String baseURL = rc.getBaseURL();
	public String username = rc.getUsername();
	public String password = rc.getPassword();
	public static WebDriver driver;
	
	public static Logger logger;
	
	@BeforeClass
	@Parameters("browser")
	public void setup(String br) {
		
		logger = Logger.getLogger("ECommerce");
		PropertyConfigurator.configure("Log4j.properties");
		
		if(br.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", rc.getChromeDriver());
			driver = new ChromeDriver();
			logger.info("Opening In Chrome Browser");
			driver.manage().window().maximize();
		}
		else if(br.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", rc.getFirefoxDriver());
			driver = new FirefoxDriver();
			logger.info("Opening In FireFox Browser");
			driver.manage().window().maximize();
		}
		else if(br.equals("edge")) {
			System.setProperty("webdriver.edge.driver", rc.getEdgeDriver());
			driver = new EdgeDriver();
			logger.info("Opening In Edge Browser");
			driver.manage().window().maximize();
		}
	}
	
	@AfterClass
	public void closeBrowser() {
		logger.info("Closing the Browser");
		driver.quit();
	}
	
	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}
	
	public static String randomstring() {
		String gs = RandomStringUtils.randomAlphabetic(6);
		return (gs);
	}
	
}
