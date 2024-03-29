package com.hAIbooks.qa.TestPages;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.hAIbooks.qa.Base.TestBase;
import com.hAIbooks.qa.Calendar.CalendarHandling;
import com.hAIbooks.qa.CheckBox.SelectCheckBox;
import com.hAIbooks.qa.DropDownHandling.DropDownHandling;
import com.hAIbooks.qa.ExcelReader.ExcelReader;
import com.hAIbooks.qa.Pages.CreatingBusiness;
import com.hAIbooks.qa.Times.TestUtils;

public class TestCreatingBusiness extends TestBase
{
	static String xpath1 ="//div[@class='dropdown-menu open']//li/a/span";
	static String xpath2 ="//span[@class='jcf-list-content']//li/span";
	

	static String xpath_monthSelection="//span[@class='jcf-select jcf-unselectable jcf-select-ui-datepicker-month']";
	 static String xpath_monthList="//span[@class='jcf-list-content']//li/span";
	 static String XpathYearSelection="//span[@class='jcf-select jcf-unselectable jcf-select-ui-datepicker-year']";
	 static String XpathYearList="//span[@class='jcf-list-content']//li/span";
	 static String xpathDate="//div[@id='ui-datepicker-div']//tbody/tr/td";
	public TestCreatingBusiness() throws IOException 
	{
		super();
		
	}
	
	SelectCheckBox checkbox;

	CalendarHandling calendar;
	DropDownHandling dd;
	CreatingBusiness business;
	ExcelReader excel;
	String ExcelPath=System.getProperty("user.dir")+"/TestData/BusinessOwner.xlsx";
	
	@BeforeClass
	public void setUp() throws Exception
	{
		Intilization();
		business=new CreatingBusiness();
		excel=new ExcelReader(ExcelPath);
		dd=new DropDownHandling();
		calendar= new CalendarHandling();
		checkbox= new SelectCheckBox();
		
		
	}
	
	@Test(priority=1)
	public void getLogin() throws InterruptedException
	{
		String Username=excel.getCellData(0, 1, "EmailAddress");
		String Password=excel.getCellData(0, 1, "Password");
		business.userLoginPannel(Username, Password);
	}
	@Test(priority=5)
	public void canVerifyContentOne()
	{
		String actualOutput=business.canVerifyContentOne();
		String expectedOutput="Let’s start!";
		Assert.assertEquals(actualOutput, expectedOutput, "Actual and Expected outputs did not matched");
	}
	
	@Test(priority=6)
	public void canVerifyContentTwo()
	{
		String actualOutput=business.canVerifyContentTwo();
		String expectedOutput="Add a business";
		Assert.assertEquals(actualOutput, expectedOutput, "Actual and Expected outputs did not matched");
	}
	
	
	
	@Test(priority=7)
	public void clickSelectBusinesDropDown() throws InterruptedException
	{
		business.selectBusinessType();
		
		String dropDownValue=excel.getCellData(1, 1, "ROle");
		dd.HandlingDropDown(xpath2, dropDownValue);
	}
	@Test(priority=8)
	public void clickGetStarted1()
	{
		business.clickGetStarted();
	}
	
	
	@Test(priority=9)
	public void validationMessageBusinessName()
	{
		String actualOutput=business.validationMessageBusinessName();
		String expectedOutput="Please enter Business Name";
		Assert.assertEquals(actualOutput, expectedOutput, "Actual and Expected outputs did not matched");
	}
	
	@Test(priority=10)
	public void validationBusinessStartDate()
	{
		String actualOutput=business.validationBusinessStartDate();
		String expectedOutput="Please enter Business Start Date";
		Assert.assertEquals(actualOutput, expectedOutput, "Actual and Expected outputs did not matched");
	}
	
	@Test(priority=11)
	public void validationFinancialYearEnd()
	{
		String actualOutput=business.validationFinancialYearEnd();
		String expectedOutput="Please enter Financial Year End";
		Assert.assertEquals(actualOutput, expectedOutput, "Actual and Expected outputs did not matched");
	}
	
	@Test(priority=12)
	public void addBusinessName()
	{
		String businessName=excel.getCellData(1, 1, "BusinessName");
		business.createBusinessName(businessName);
	}
	
	@Test(priority=13)
	public void addAccountDate() throws InterruptedException
	{
		business.clickaccountFormCalendarIcon();
		
		String excelMonth=excel.getCellData(1, 1, "BusinessMonth");
		String excelDate=excel.getCellData(1, 1, "BusinessDate");
		String excelYear=excel.getCellData(1, 1, "BusinessYear");
		
		calendar.ClcikMonth(xpath_monthSelection, xpath_monthList, excelMonth);
		calendar.ClcikYear(XpathYearSelection, XpathYearList, excelYear);
		calendar.ClickDate(xpathDate, excelDate);
	}
	
	@Test(priority=14)
	public void addAccountMadeUpDate() throws InterruptedException
	{
		business.clickAccountMadeCalendarIcon();
		
		String excelDate=excel.getCellData(1, 1, "FinancialDate");
		String excelMonth=excel.getCellData(1, 1, "FinancialMonth");
		String excelYear=excel.getCellData(1, 1, "FinancialYear");
		
		calendar.ClcikMonth(xpath_monthSelection, xpath_monthList, excelMonth);
		calendar.ClcikYear(XpathYearSelection, XpathYearList, excelYear);
		calendar.ClickDate(xpathDate, excelDate);
		Thread.sleep(TestUtils.Thread_sleep);
	}
	
	@Test(priority=15)
	public void BuildingNumStreet() throws InterruptedException
	{
		String buildingNum=excel.getCellData(1, 1, "BuildingNumber");
		String street=excel.getCellData(1, 1, "Street");
		business.BuildingNumStreet(buildingNum, street);
		Thread.sleep(TestUtils.Thread_sleep);
	}
	
	@Test(priority=16)
	public void GetCityRegion() throws InterruptedException
	{
		String city=excel.getCellData(1, 1, "City");
		String region=excel.getCellData(1, 1, "Region");
		business.GetCityRegion(city, region);
		Thread.sleep(TestUtils.Thread_sleep);
		
	}
	
	@Test(priority=17)
	public void getPostCodeCountry() throws InterruptedException
	{
		String postcode=excel.getCellData(1, 1, "PostCode");
		String country=excel.getCellData(1, 1, "Country");
		business.getPostCodeCountry(postcode, country);
		Thread.sleep(TestUtils.Thread_sleep);
	}
	
	@Test(priority=18)
	public void clickIndustry() throws InterruptedException
	{
		business.clickIndustry();
		String industry=excel.getCellData(1, 1, "Industry");
		dd.HandlingDropDown(xpath1, industry);
		Thread.sleep(TestUtils.Thread_sleep);
	}
	
	
	@Test(priority=20)
	public void clickGetStartedTest() throws InterruptedException
	{
		business.clickGetStarted();
		Thread.sleep(TestUtils.Thread_sleep);
	}
	
	@AfterClass
	public void closeBrowser() throws InterruptedException
	{
		business.clickLogout();
		Thread.sleep(TestUtils.Thread_sleep);
		driver.quit();
	}
}
