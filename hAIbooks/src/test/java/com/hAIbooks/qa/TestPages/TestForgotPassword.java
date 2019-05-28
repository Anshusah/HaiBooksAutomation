package com.hAIbooks.qa.TestPages;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.hAIbooks.qa.Base.TestBase;
import com.hAIbooks.qa.ExcelReader.ExcelReader;
import com.hAIbooks.qa.NewTab.CreatingNewTab;
import com.hAIbooks.qa.Pages.ForgotPassword;
import com.hAIbooks.qa.Pages.LoginPage;
import com.hAIbooks.qa.Screenshots.ScreenShot;
import com.hAIbooks.qa.Sikuli.Sikuli;
import com.hAIbooks.qa.SwitchingTab.SwitchTab;
import com.hAIbooks.qa.Times.TestUtils;

public class TestForgotPassword extends TestBase
{

	public TestForgotPassword() throws IOException 
	{
		super();
	}
	
	ScreenShot screenshot;
	LoginPage loginpage;
	ForgotPassword forgot;
	CreatingNewTab newtab;
	SwitchTab tab;
	Sikuli sikuli;
	ExcelReader excel;
	String ExcelPath=System.getProperty("user.dir")+"/TestData/UsernameList.xlsx";
	
	@BeforeClass
	public void setUp() throws IOException
	{
		Intilization();
		loginpage= new LoginPage();
		forgot= new ForgotPassword();
		excel= new ExcelReader(ExcelPath);
		newtab= new CreatingNewTab();
		sikuli= new Sikuli();
		tab= new SwitchTab();
		screenshot=new ScreenShot();
		
	}
	
	@Test(priority=1)
	public void canClickLogin()
	{
		loginpage.clickLogin();
	}
	
	@Test(priority=2)
	public void clickForgotPassword() throws InterruptedException
	{
		forgot.clickForgotPassword();
		
	}
	
	@Test(priority=3)
	public void validationForgotPassword()
	{
		String actualOutput=forgot.validationForgotPassword();
		String expectedOutput="Please enter Email";
		Assert.assertEquals(actualOutput, expectedOutput, "Actual and Expected outputs did not matched");
	}
	
	@Test(priority=4)
	public void inputUserId() throws IOException
	{
		String UserName=excel.getCellData(0, 1, "Username");
		System.out.println(UserName);
		forgot.inputUserId(UserName);
		screenshot.getScreenshot("checkInbox");
		
		
	}
	
	@Test(priority=5)
	public void emailVerification() throws Exception
	{
		String UserName=excel.getCellData(0, 1, "Username");
		newtab.OpenNewTab();
		newtab.switchToNewTab(UserName);
		Thread.sleep(TestUtils.Thread_sleep);
		sikuli.ResetPassword();		
	}
	
	@Test(priority=6)
	public void creatingPassword()
	{
		String newPassword=excel.getCellData(1, 1, "NewPasswod");
		String conPassword=excel.getCellData(1, 1, "ConfirmNewPassword");
		tab.switchtab(2);
	    forgot.createNewPassword(newPassword, conPassword);
	    
	}
	
	
	@Test(priority=7)
	public void reLoginWithNewPassword() throws InterruptedException
	{
		String Username=excel.getCellData(0, 1, "Username");
		String conPassword=excel.getCellData(1, 1, "NewPasswod");
		loginpage.loginhAIbooks(Username, conPassword);
		Thread.sleep(TestUtils.PAGE_LOAD_TIMEOUT);
		
	}
	
	@Test(priority=8)
	public void reVerfyingUser()
	{
		String actualOutput=forgot.verfyingUser();
		String expectedOutput="Hello, Alex";
		Assert.assertEquals(actualOutput, expectedOutput, "Actual and Expected outputs did not matched");
	}
	
	@Test(priority=9)
	public void userLogout() throws InterruptedException
	{
		loginpage.clickLogout();
	}
	
	@AfterClass
	public void TearDown()
	{
		driver.quit();
	}

}
