package com.hAIbooks.qa.TestPages;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.hAIbooks.qa.Base.TestBase;
import com.hAIbooks.qa.CheckBox.SelectCheckBox;
import com.hAIbooks.qa.EmailVerification.EmailVerification;
import com.hAIbooks.qa.ExcelReader.ExcelReader;
import com.hAIbooks.qa.NewTab.CreatingNewTab;
import com.hAIbooks.qa.Pages.LoginPage;
import com.hAIbooks.qa.Pages.RegBusinessOwner;
import com.hAIbooks.qa.Screenshots.ScreenShot;
import com.hAIbooks.qa.Sikuli.Sikuli;
import com.hAIbooks.qa.Times.TestUtils;

public class TestRegBusinessOwner extends TestBase
{

	LoginPage loginpage;
	ScreenShot screenshot;
	RegBusinessOwner owner;
	EmailVerification emailVerification;
	SelectCheckBox check;
	CreatingNewTab newTab;
	Sikuli sikuli;
	ExcelReader excel;
	String ExcelPath=System.getProperty("user.dir")+"/TestData/BusinessOwner.xlsx";
	public TestRegBusinessOwner() throws IOException 
	{
		super();
		
	}
	
	@BeforeClass
	public void SetUp() throws IOException, InterruptedException
	{
		Intilization();
		owner= new RegBusinessOwner();
		excel=new ExcelReader(ExcelPath);
		check=new SelectCheckBox();
		newTab=new CreatingNewTab();
		sikuli=new Sikuli();
		emailVerification=new EmailVerification();	
		screenshot=new ScreenShot();
		loginpage=new LoginPage();
		
		
		Thread.sleep(TestUtils.PAGE_LOAD_TIMEOUT);
	}
	
	@Test(priority=1)
	public void canClickTryFree()
	{
		owner.clickTryFree();
		
	}
	
	@Test(priority=2)
	public void canClickBusinessAdvisiorIcon()
	{
		owner.clickAdvisior();
		
	}
	
	@Test(priority=3)
	public void canClickNestButton() 
	{
		owner.clickNextButton();
	}
	
	@Test(priority=4)
	public void canGetFristNameAndLastName() 
	{
		String firstName=excel.getCellData(0, 1, "FirstName");
		String lasttName=excel.getCellData(0, 1, "LastName");
		owner.getName(firstName, lasttName);
		
	}
	
	@Test(priority=5)
	public void canGetEmailAndPhone()
	{
		String emailId=excel.getCellData(0, 1, "EmailAddress");
		String phoneNumber=excel.getCellData(0, 1, "PhoneNumber");
		owner.getEmailPhone(emailId, phoneNumber);				
	}
	
	@Test(priority=6)
	public void canSetPassword()
	{
		String passWord=excel.getCellData(0, 1, "Password");
		String confirmPassword=excel.getCellData(0, 1, "ConfirmPassword");
		owner.getPassword(passWord, confirmPassword);		
	}
	
	@Test(priority=7)
	public void tickCheckbox() throws IOException
	{
		check.ClcikCheckBox();
	}
	
	@Test(priority=8)
	public void canSubmitForm() throws InterruptedException
	{
		owner.clickGetStarted();
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
		
		
		String emailAdd=excel.getCellData(0, 1, "EmailAddress");
		newTab.OpenNewTab();
		newTab.switchToNewTab(emailAdd);
		Thread.sleep(TestUtils.PAGE_LOAD_TIMEOUT);
		sikuli.Activation();
		newTab.InsertTabNumToSwith(2);	
	}
	
	
	
	
	
	
	
	/*@Test(priority=11)
	public void loginhAIbooks() throws InterruptedException
	{
		String UN=excel.getCellData(0, 1, "EmailAddress");
		String pwd=excel.getCellData(0, 1, "Password");
				
		owner.loginhAIbooks(UN, pwd);
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
	}*/
	
	
	
	
	
	
	
	
	
	

}
