package com.nopcommerce.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddCustomerPage {

	public WebDriver ldriver;
	
	public AddCustomerPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath="/html/body/div[3]/div[2]/div/ul/li[4]/a")
	@CacheLookup
	WebElement lnkCustomer1;
	
	@FindBy(xpath="/html/body/div[3]/div[2]/div/ul/li[4]/ul/li[1]/a")
	@CacheLookup
	WebElement lnkCustomer2;
	
	@FindBy(xpath="/html/body/div[3]/div[3]/div/form[1]/div[1]/div/a")
	@CacheLookup
	WebElement btnAddcustomer;

	@FindBy(xpath="//*[@id=\"Email\"]")
	@CacheLookup
	WebElement txtEmail;

	@FindBy(xpath="//*[@id=\"Password\"]")
	@CacheLookup
	WebElement txtPassword;

	@FindBy(xpath="//*[@id=\"FirstName\"]")
	@CacheLookup
	WebElement txtFirstname;

	@FindBy(xpath="//*[@id=\"LastName\"]")
	@CacheLookup
	WebElement txtLastname;

	@FindBy(xpath="//*[@id=\"Gender_Male\"]")
	@CacheLookup
	WebElement rdMaleGender;

	@FindBy(xpath="//*[@id=\"Gender_Female\"]")
	@CacheLookup
	WebElement rdFemaleGender;
	
	@FindBy(xpath="//*[@id=\"DateOfBirth\"]")
	@CacheLookup
	WebElement txtDateofbirth;
	
	@FindBy(xpath="//*[@id=\"Company\"]")
	@CacheLookup
	WebElement txtCompanyName;
	
	By txtNewsLetter = By.xpath("//*[@id=\"customer-info\"]/div[2]/div[1]/div[9]/div[2]/div/div[1]/div");
	By listitemStorename = By.xpath("//*[@id=\"SelectedNewsletterSubscriptionStoreIds_listbox\"]/li[1]");
	By listitemTestStore = By.xpath("//*[@id=\"SelectedNewsletterSubscriptionStoreIds_listbox\"]/li[2]");
	
	
	@FindBy(xpath="//*[@id=\"customer-info\"]/div[2]/div[1]/div[10]/div[2]/div/div[1]/div")
	@CacheLookup
	WebElement txtCustomerroles;
	
	By txtcustomerRoles=By.xpath("//div[@class='k-multiselect-wrap k-floatwrap']");
	By lstitemAdministrators=By.xpath("//li[contains(text(),'Administrators')]");
	By lstitemRegistered=By.xpath("//li[contains(text(),'Registered')]");
	By lstitemGuests=By.xpath("//li[contains(text(),'Guests')]");
	By lstitemVendors=By.xpath("//li[contains(text(),'Vendors')]");
	
	By drpmgrOfVendor=By.xpath("//*[@id='VendorId']");
	
	@FindBy(xpath="//*[@id=\"AdminComment\"]")
	@CacheLookup
	WebElement txtAdminCommand;

	@FindBy(xpath="/html/body/div[3]/div[3]/div/form/div[1]/div/button[1]")
	@CacheLookup
	WebElement btnSave;
	
	public void clickCustomer1() {
		lnkCustomer1.click();
	}
	
	public void clickCustomer2() {
		lnkCustomer2.click();
	}
	
	public void clickAddCustomer() {
		btnAddcustomer.click();
	}
	
	public void setEmail(String email) {
		txtEmail.sendKeys(email);
	}
	
    public void setPassword(String pwd) {
		txtPassword.sendKeys(pwd);
	}

    public void setFname(String fname) {
    	txtFirstname.sendKeys(fname);
	}

    public void setLname(String lname) {
		txtLastname.sendKeys(lname);
	}

    public void setGender(String gender) {
		 if(gender.equals("Male")) {
			 rdMaleGender.click();
		 } 
		 else if(gender.equals("Female")) {
			 rdFemaleGender.click();
		 }
		 else {
			 rdMaleGender.click();
		 }
	}

    public void setDOB(String dob) {
    	txtDateofbirth.sendKeys(dob);
	}

    public void setComapanyName(String cname) {
    	txtCompanyName.sendKeys(cname);
	}

    public void setNewsletter(String nl) {
    	ldriver.findElement(txtNewsLetter).click();
    	WebElement listitem;
    	switch(nl){
    	case "StoreName":
    		listitem = ldriver.findElement(listitemStorename); break;
    	case "TestStore":
    		listitem = ldriver.findElement(listitemTestStore); break;
    	default:
    		listitem = ldriver.findElement(listitemStorename);
    	}
    	
    	JavascriptExecutor js = (JavascriptExecutor)ldriver;
		js.executeScript("arguments[0].click();", listitem);
	}
    
    public void setCustomerRoles(String role) 
	{
		ldriver.findElement(By.xpath("//*[@id=\"SelectedCustomerRoleIds_taglist\"]/li/span[2]")).click();
	
		ldriver.findElement(txtcustomerRoles).click();
					
		WebElement listitem;
		
		switch(role)
		{
		case "Administrators":
				listitem=ldriver.findElement(lstitemAdministrators); break;
		case "Guests":
				listitem=ldriver.findElement(lstitemGuests); break;
		case "Registered":
			listitem=ldriver.findElement(lstitemRegistered); break;
		case "Vendors":
			listitem=ldriver.findElement(lstitemVendors); break;
		default:
			listitem=ldriver.findElement(lstitemGuests);
		}
					
		JavascriptExecutor js = (JavascriptExecutor)ldriver;
		js.executeScript("arguments[0].click();", listitem);	
		}
    
  
    public void setVendor(String value)
	{
		Select drp=new Select(ldriver.findElement(drpmgrOfVendor));
		drp.selectByVisibleText(value);
	}

    public void setAdminComment(String acomment) {
    	txtAdminCommand.sendKeys(acomment);
	}
    
    public void clickSave() {
    	btnSave.click();
    }
}
