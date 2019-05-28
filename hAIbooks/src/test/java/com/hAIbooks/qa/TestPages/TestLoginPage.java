package com.hAIbooks.qa.TestPages;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.hAIbooks.qa.Base.TestBase;
import com.hAIbooks.qa.ExcelReader.ExcelReader;
import com.hAIbooks.qa.Pages.LoginPage;
import com.hAIbooks.qa.Times.TestUtils;

public class TestLoginPage extends TestBase
{

	
	public TestLoginPage() throws IOException 
	{
		super();
		
	}
	
	LoginPage loginpage;
	ExcelReader excel;
	String ExcelPath=System.getProperty("user.dir")+"/TestData/BusinessAdvisiory.xlsx";
	
	
	@BeforeClass
	public void Setup() throws IOException
	{
		Intilization();
		loginpage=new LoginPage();
		excel= new ExcelReader(ExcelPath);
	}
	
	@Test(priority=1)
	public void canClickLogin() throws InterruptedException
	{
		loginpage.clickLogin();
		Thread.sleep(TestUtils.PAGE_LOAD_TIMEOUT);
		
	}
	
	@Test(priority=2)
	public void contentLoginPage()
	{
		String actualOutput=loginpage.contentLoginPage();
		String expectedOutput="Simplify your business with hAIbooks";
		Assert.assertEquals(actualOutput, expectedOutput, "Actual and Expected outputs did not matched");
	}
	
	@Test(priority=3)
	public void contentOfSignUp()
	{
		String actualOutput=loginpage.getStartedContent();
		String expectedOutput="Get Started";
		Assert.assertEquals(actualOutput, expectedOutput, "Actual and Expected outputs did not matched");
	}
	
	@Test(priority=4)
	public void signupContent()
	{
		String actualOutput=loginpage.signUpSidebar();
		String expectedOutput="And get sorted. Simple yet powerful accounting software that does the hard work for you.";
		Assert.assertEquals(actualOutput, expectedOutput, "Actual and Expected outputs did not matched");
		
	}
	
	@Test(priority=5)
	public void canVerifyValidationMessageLoginpannel()
	{
		String actualOutput=loginpage.verifyValidationMessage();
		String expectedOutput="Please enter the correct email address and password. If you haven't yet registered for hAIbooks, please click Sign up now.";
		Assert.assertEquals(actualOutput, expectedOutput, "Actual and Expected outputs did not matched");
	}
	
	@Test(priority=6)
	public void googleLogoIsDisplayed()
	{
		boolean flag=loginpage.googleLogo();
		Assert.assertEquals(flag, true, "Google logo is not displayed");
	}
	
	@Test(priority=7)
	public void facebookLogoIsDisplayed()
	{
		boolean flag=loginpage.facebookLogo();
		Assert.assertEquals(flag, true, "Facebook logo is not displayed");
	}
	
	
	@DataProvider(name="testdata")
	 public Object[][] passData() 
	 {
	   excel=new ExcelReader(ExcelPath);
	   int rowsCount=excel.getRowCount(1);
	   Object[][] credentials= new Object[rowsCount][2];
			  
	   for(int i=1;i<rowsCount;i++)
	   {
			credentials[i][0]=excel.getCellData(1, i, "Username");
			credentials[i][1]=excel.getCellData(1, i, "Password");
				  
		}
		return credentials;
	  
	 }
	
	@Test(priority=8,dataProvider="testdata")
	public void haIbooksLoginTest(String UserName,String PassWord) 
	{
		loginpage.loginhAIbooks(UserName, PassWord);	
		
	}
	
	@Test(priority=9)
	public void canVerifyuserLogin() throws InterruptedException
	{
		Thread.sleep(TestUtils.Thread_sleep);
		String actualOutput =loginpage.VerifyUserLogin();
		String expectedOutput="Hello, Alex";
		Assert.assertEquals(actualOutput, expectedOutput, "Actual and Expected outputs did not matched");
		Thread.sleep(TestUtils.PAGE_LOAD_TIMEOUT);
	}
	
	
	@AfterClass
	public void closeBrowser() throws InterruptedException
	{
		loginpage.clickLogout();
		Thread.sleep(TestUtils.Thread_sleep);
		driver.quit();
	}
	
	
	
	
		 
}
