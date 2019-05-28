package com.hAIbooks.qa.TestPages;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.hAIbooks.qa.Base.TestBase;
import com.hAIbooks.qa.Pages.BusinessOwner;
import com.hAIbooks.qa.Times.TestUtils;

public class TestBusinessOwner extends TestBase
{

	public TestBusinessOwner() throws IOException 
	{
		super();
	}
	BusinessOwner businessowner;
	
	@BeforeClass
	public void SetUp() throws Exception
	{
		Intilization();
		businessowner=new BusinessOwner();
	
	}
	
	@Test(priority=1)
	public void ClcikSignUp() throws InterruptedException
	{
		businessowner.ClcikSignUp();
		Thread.sleep(TestUtils.PAGE_LOAD_TIMEOUT);
	}
	
	@Test(priority=2)
	public void ColorNextButtonTest() throws InterruptedException
	{	
		Thread.sleep(TestUtils.Thread_sleep);
		String color=businessowner.ColorNextButton();
		System.out.println("RGBColor="+color);
		if(color.contains("rgb(39, 168, 228)"))
		{
			System.out.println("Color matched");
		}
		else
		{
			System.out.println("Not Matched");
		}
		
		Thread.sleep(TestUtils.Thread_sleep);
	}

			
	@Test(priority=3)
	public void ClcikNextButtonTest() throws Exception
	{
		businessowner.ClickNextButton();
		Thread.sleep(TestUtils.Thread_sleep);
	}
	
	@Test(priority=4)
	public void ToverifyContentTest() throws InterruptedException
	{
		String Text=businessowner.ToverifyContent();
		Assert.assertEquals(Text, "Please select System Role");		
		Thread.sleep(TestUtils.Thread_sleep);
	}
	
	@Test(priority=5)
	public void ToverifyTextIsPresentTest()
	{
		boolean flag=businessowner.ToverifyTextIsPresent();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=6)
	public void ClickBusinessOwnerTest()
	{
		businessowner.ClickBusinessOwner();
	}
	
	@Test(priority=7)
	public void ToVerifyColorOfNextButtonTest()
	{
		String color=businessowner.ToVerifyColorOfNextButton();
		System.out.println("Green Color="+color);
		
		if(color.contains("rgb(41, 173, 210)"))
		{
			System.out.println("Color matched");
		}
		else
		{
			System.out.println("Not Matched");
		}
	}
	
	@Test(priority=8)
	public void ToReVerifyTextIsPresent() throws InterruptedException
	{
		boolean flag=businessowner.ToReVerifyTextIsPresent();
		Assert.assertFalse(flag);
		Thread.sleep(TestUtils.Thread_sleep);
	}
	
	@Test(priority=9)
	public void ReClickNextButtonTest()
	{
		businessowner.ReClickNextButton();
	}
	
	@Test(priority=10)
	public void PhoneNumberValidationTest()
	{
		int size=businessowner.PhoneNumberValidation();
		
		if (size == 15) {
			System.out.println("Max character functionality is working fine.");
		}
 
		else {
			System.out.println("No limit is set.");
		}
	}
	
	
	@Test(priority=11)
	public void MinimumCharacterValidationPassworsTest()
	{
		String Text=businessowner.MinimumCharacterValidationPasswors();
		
		if(Text.contentEquals("Must be at least 6 characters long, and contain at least one uppercase letter, "
				+ "one lowercase letter and one number"))
		{
			System.out.println("Validation Text is Displayed");
		}
		else
		{
			System.out.println("Validation Text is not displayed");
		}
	}
	
	
	@Test(priority=12)
	public void MaximumCharacterValidationPaaswordTest()
	{
		int size=businessowner.MaximumCharacterValidationPaasword();
		

		if (size == 100) {
			System.out.println("Maximum limitation of Character in Password Text box is set ");
		}
 
		else {
			System.out.println("Maximum limitation of Character in Password Text box is not set");
		}
		
		
	}
	
	
	@Test(priority=13)
	public void CharacterLimitationFirstNameTest()
	{
		int size=businessowner.CharacterLimitationFirstName();
		if(size==50)
		{
			System.out.println("Maximum limitation of Character in First Name Text box is set ");
		}
		else 
		{
			System.out.println("Maximum limitation of Character in First Name Text box is  not set ");
		}
	}
	
	
	@Test(priority=14)
	public void CharacterLimitationLastNameTest()
	{
		int size=businessowner.CharacterLimitationLastName();
		if(size==50)
		{
			System.out.println("Maximum limitation of Character in Last Name Text box is set ");
		}
		else 
		{
			System.out.println("Maximum limitation of Character in Last Name Text box is  not set ");
		}
	}
	
	@Test(priority=15)
	public void ClearSignUpPageTest() throws InterruptedException
	{
		businessowner.ClearSignUpPage();	
		Thread.sleep(TestUtils.Thread_sleep);
	}
	
	@Test(priority=16)
	public void ClickGetStartedTest()
	{
		businessowner.ClickGetStarted();
	}
	
	@Test(priority=17)
	public void ErrorMessageFirstNameTest()
	{
		String Text=businessowner.ErrorMessageFirstName();		
		Assert.assertEquals(Text, "Please enter First Name");	
		
	}
	
	@Test(priority=18)
	public void ErrorMessageLastNameTest()
	{
		String Text=businessowner.ErrorMessageLastName();
		Assert.assertEquals(Text, "Please enter Last Name");	
	}
	
	@Test(priority=19)
	public void ErrorMessageEmailIDTest()
	{
		String Text=businessowner.ErrorMessageEmailID();
		Assert.assertEquals(Text, "Please enter Email");
	}
	
	@Test(priority=20)
	public void ErrorMessagePhoneNumTest()
	{
		String Text=businessowner.ErrorMessagePhoneNum();
		Assert.assertEquals(Text, "Please enter Phone Number");
	}
	
	@Test(priority=21)
	public void ErrorCreatePasswordTest()
	{
		String Text=businessowner.ErrorCreatePassword();
		Assert.assertEquals(Text, "Please create Password");
		
	}
	
	@Test(priority=22)
	public void ErrorConfirmPasswordTest()
	{
		String Text=businessowner.ErrorConfirmPassword();
		Assert.assertEquals(Text, "Please confirm password");
	}
	
	@AfterClass
	public void TearDown()
	{
		driver.quit();
	}

}
