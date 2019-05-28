package com.hAIbooks.qa.TestPages;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.hAIbooks.qa.Base.TestBase;
import com.hAIbooks.qa.CheckBox.SelectCheckBox;
import com.hAIbooks.qa.EmailVerification.EmailVerification;
import com.hAIbooks.qa.ExcelReader.ExcelReader;
import com.hAIbooks.qa.NewTab.CreatingNewTab;
import com.hAIbooks.qa.Pages.LoginPage;
import com.hAIbooks.qa.Pages.RegBusinessAdvisor;
import com.hAIbooks.qa.Screenshots.ScreenShot;
import com.hAIbooks.qa.Sikuli.Sikuli;
import com.hAIbooks.qa.Times.TestUtils;

public class TestRegBusinessAdvisor extends TestBase
{

	CreatingNewTab newTab;
	ScreenShot screenshot;
	RegBusinessAdvisor advisior;
	EmailVerification emailVerification;
	SelectCheckBox check;
	LoginPage loginpage;
	Sikuli sikuli;
	ExcelReader excel;
	String ExcelPath=System.getProperty("user.dir")+"/TestData/BusinessAdvisiory.xlsx";
	public TestRegBusinessAdvisor() throws IOException 
	{
		super();
		
	}
	
	@BeforeClass
	public void SetUp() throws IOException, InterruptedException
	{
		Intilization();
		advisior= new RegBusinessAdvisor();
		excel=new ExcelReader(ExcelPath);
		check=new SelectCheckBox();
		sikuli=new Sikuli();
		emailVerification=new EmailVerification();	
		screenshot=new ScreenShot();
		loginpage=new LoginPage();
		newTab= new CreatingNewTab();
		
		Thread.sleep(TestUtils.PAGE_LOAD_TIMEOUT);
	}
	
	@Test(priority=1)
	public void canClickTryFree()
	{
		advisior.clickTryFree();
		
	}
	
	@Test(priority=2)
	public void canClickBusinessAdvisiorIcon()
	{
		advisior.clickAdvisior();
		
	}
	
	@Test(priority=3)
	public void canClickNestButton() 
	{
		advisior.clickNextButton();
	}
	
	@Test(priority=4)
	public void canGetFristNameAndLastName() 
	{
		String firstName=excel.getCellData(0, 1, "FirstName");
		String lasttName=excel.getCellData(0, 1, "LastName");
		advisior.getName(firstName, lasttName);
		
	}
	
	@Test(priority=5)
	public void canGetEmailAndPhone()
	{
		String emailId=excel.getCellData(0, 1, "EmailAddress");
		String phoneNumber=excel.getCellData(0, 1, "PhoneNumber");
		advisior.getEmailPhone(emailId, phoneNumber);				
	}
	
	@Test(priority=6)
	public void canSetPassword()
	{
		String passWord=excel.getCellData(0, 1, "Password");
		String confirmPassword=excel.getCellData(0, 1, "ConfirmPassword");
		advisior.getPassword(passWord, confirmPassword);		
	}
	
	@Test(priority=7)
	public void tickCheckbox() throws IOException
	{
		check.ClcikCheckBox();
	}
	
	@Test(priority=8)
	public void canSubmitForm() throws InterruptedException
	{
		advisior.clickGetStarted();
		Thread.sleep(TestUtils.Thread_sleep);
	}
	
	@Test(priority=9)
	public void emailVerificationPage() throws IOException, InterruptedException
	{
		screenshot.getScreenshot("emailVerificationPage");
		Thread.sleep(TestUtils.Thread_sleep);
	}
	
	@Test(priority=10)
	public void openNewTab() throws Exception
	{
		String emailId=excel.getCellData(0, 1, "EmailAddress");
		newTab.OpenNewTab();
		newTab.switchToNewTab(emailId);
		Thread.sleep(TestUtils.PAGE_LOAD_TIMEOUT);
		sikuli.Activation();
		newTab.InsertTabNumToSwith(2);
		
		
	}
	
	@Test(priority=11)
	public void loginhAIbooks() throws InterruptedException
	{
		String UN=excel.getCellData(0, 1, "EmailAddress");
		String pwd=excel.getCellData(0, 1, "Password");
		loginpage.loginhAIbooks(UN, pwd);
		Thread.sleep(TestUtils.PAGE_LOAD_TIMEOUT);
	}
	
	@Test(priority=12)
	public void canVerifyuserLogin() throws InterruptedException
	{
		Thread.sleep(TestUtils.Thread_sleep);
		String actualOutput =loginpage.VerifyUserLogin();
		String expectedOutput="Hello, Alex";
		Assert.assertEquals(actualOutput, expectedOutput, "Actual and Expected outputs did not matched");
		Thread.sleep(TestUtils.PAGE_LOAD_TIMEOUT);
	}
	
	@Test(priority=13)
	public void canuserlogOut() throws InterruptedException
	{
		loginpage.clickUserLogout();
		Thread.sleep(TestUtils.Thread_sleep);
	}
	
	
	
	@AfterClass
	public void CloseBrowser()
	{
		driver.quit();
	}
	
	
	
	
	
	
	
	
	
	

}
