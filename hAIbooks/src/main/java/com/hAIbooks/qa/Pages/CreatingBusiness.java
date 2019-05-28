package com.hAIbooks.qa.Pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.hAIbooks.qa.Base.TestBase;
import com.hAIbooks.qa.Times.TestUtils;

public class CreatingBusiness extends TestBase
{

	public CreatingBusiness() throws IOException 
	{
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//a[contains(text(),'Login')]")
	WebElement loginTab;
	
	@FindBy(xpath="//input[@id='email-address']")
	WebElement userName;
	
	@FindBy(xpath="//input[@id='cpassword']")
	WebElement passWord;
	
	@FindBy(xpath="//input[@id='btnLogin']")
	WebElement LoginButton;
	
	/**************************Content*****************************************/
	@FindBy(xpath="//h1[contains(text(),'Let’s start!')]")
	WebElement Text1;
	
	@FindBy(xpath="//h2[contains(text(),'Add a business')]")
	WebElement Text2;
	
	@FindBy(xpath="//h3[contains(text(),'Please tell us about your business')]")
	WebElement Text3;
	
	
	@FindBy(xpath="//span[contains(text(),'Select Business Type')]")
	WebElement selectBusinessType ;
	
	@FindBy(xpath="//input[@id='btnCreateBusiness']")
	 WebElement getStarted;
	
	@FindBy(xpath="//span[@id='cname-error']")
	WebElement errorBusinessName ;
	
	@FindBy(xpath="//span[@id='company-start-date-error']")
	WebElement errorCompanyStartDate;
	
	@FindBy(xpath="//span[@id='FirstFinancialYearEnd-error']")
	WebElement errorFinanCialYearEnd;
	
	
	@FindBy(xpath="//input[@id='cname']")
	WebElement businessName;
	
	@FindBy(xpath="//li[@class='form-row form-show'][2]/div/button")
	 WebElement accountFormCalender;

	 @FindBy(xpath="//li[@class='form-row form-show'][3]/div/button")
	 WebElement nextAccountCalender;
	 

	 @FindBy(xpath="//input[@id='Building']")
	 WebElement buildingNumber;
	 
	 @FindBy(xpath="//input[@id='Street']")
	 WebElement street;
	 
	 @FindBy(xpath="//input[@id='City']")
	 WebElement city;
	 
	 @FindBy(xpath="//input[@id='Region']")
	 WebElement region;
	 
	 @FindBy(xpath="//input[@id='PostCode']")
	 WebElement postCode;
	 
	 @FindBy(xpath="//input[@id='Country']")
	 WebElement country;
	 
	 @FindBy(xpath="//div[@class='select-holder']/div/button/span[1]")
	 WebElement industry;
	 
	 @FindBys(@FindBy(xpath="//div[@class='dropdown-menu open']//li/a/span"))
	 private List<WebElement> industryList;
	 
	 @FindBy(xpath="//input[@id='IsVatRegistered']")
	 WebElement checkBox1;
	 
	 @FindBy(xpath="//input[@name='VATRegistrationNumber']")
	 WebElement vatRegisteredNo;
	 
	 @FindBy(xpath="//div[@class='company-block dropdown-block dropdown']")
		WebElement ProfileIcon;
	 @FindBy(xpath="//span[contains(text(),'My Businesses')]")
		WebElement MyBusiness;
	 @FindBy(xpath="//a[contains(text(),'Add Business')]")
		WebElement AddBusiness;
	 @FindBy(xpath="//a[@class='user dropdown-toggle']")
		WebElement ProfileClk;
		
		@FindBy(xpath="//span[contains(text(),'Log Out')]")
		WebElement Logoutbtn;
	 public void userLoginPannel(String Username, String Password) throws InterruptedException
	 {
		 loginTab.click();
		 Thread.sleep(TestUtils.PAGE_LOAD_TIMEOUT);
		 userName.sendKeys(Username);
		 passWord.sendKeys(Password);
		 LoginButton.click();
		 Thread.sleep(TestUtils.PAGE_LOAD_TIMEOUT);
	 }
	 public void ProfileIconClick()
	 {
		 ProfileIcon.click();
		 
	 }
	 public void MyBusinessClick()
	 {
		 MyBusiness.click();
		 
	 }
	 public void AddBusinessClick()
	 {
		 AddBusiness.click();
		 
	 }
	 
	 public String canVerifyContentOne()
	 {
		 return Text1.getText();
		 
	 }
	 
	 public String canVerifyContentTwo()
	 {
		 return Text2.getText();
		 
	 }
	 
	 public String canVerifyContentThree()
	 {
		 return Text3.getText();
		 
	 }
	 
	 public void selectBusinessType()
	 {
		 selectBusinessType.click();
		 
	 }
	 
	 public void clickGetStarted()
	 {
		 getStarted.click();
	 }
	 
	 public String validationMessageBusinessName()
	 {
		 return errorBusinessName.getText();
	 }
	 
	 public String validationBusinessStartDate()
	 {
		 return errorCompanyStartDate.getText();
	 }
	 
	 public String validationFinancialYearEnd()
	 {
		 return errorFinanCialYearEnd.getText();
	 }
	 
	 public void createBusinessName(String BusinessName)
	 {
		 businessName.sendKeys(BusinessName);
	 }
	 
	 public void clickaccountFormCalendarIcon()
	 {
		 accountFormCalender.click();
		 
		 
	 }
	 
	 public void clickAccountMadeCalendarIcon()
	 {
		 nextAccountCalender.click();
	 }
	 
	 public void BuildingNumStreet(String buildingNo, String Street)
	 {
		 buildingNumber.sendKeys(buildingNo);
		 street.sendKeys(Street);
	 }
	 
	 public void GetCityRegion(String City, String Region)
	 {
		 city.sendKeys(City);
		 region.sendKeys(Region);
	 }
	 
	 public void getPostCodeCountry(String postcode, String Country)
	 {
		 postCode.sendKeys(postcode);
		 country.sendKeys(Country);
	 }
	 
	 public void clickIndustry()
	 {
		 industry.click();
		 
	 }
	 
	 public void submitButton(String regno)
	 {
		 checkBox1.click();
		 System.out.println(regno);
		 vatRegisteredNo.sendKeys(regno);
	 }
	 public void clickLogout() throws InterruptedException
		{
			ProfileClk.click();
			Thread.sleep(TestUtils.Thread_sleep);
			Logoutbtn.click();
		}
	 
	
}
	
	
	
	