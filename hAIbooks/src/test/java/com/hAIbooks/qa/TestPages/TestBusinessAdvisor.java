package com.hAIbooks.qa.TestPages;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.hAIbooks.qa.Base.TestBase;
import com.hAIbooks.qa.Pages.BusinessAdvisor;
import com.hAIbooks.qa.Times.TestUtils;

public class TestBusinessAdvisor extends TestBase
{

	BusinessAdvisor advisior;
	public TestBusinessAdvisor() throws IOException 
	{
		super();
		
	}
	
	@BeforeClass
	public void SetUp() throws Exception
	{
		Intilization();
		advisior=new BusinessAdvisor();
	
	}
	
	@Test(priority=1)
	public void CanGtoSignup() throws InterruptedException
	{
		advisior.ClcikSignUp();
		Thread.sleep(TestUtils.PAGE_LOAD_TIMEOUT);
	}
	
	@Test(priority=2)
	public void VerifyColorNextButton() throws InterruptedException
	{	
		Thread.sleep(TestUtils.Thread_sleep);
		String color=advisior.ColorNextButton();
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
	public void CanGoToNextButton() throws Exception
	{
		advisior.ClickNextButton();
		Thread.sleep(TestUtils.Thread_sleep);
	}
	
	@Test(priority=4)
	public void VerifyContent() throws InterruptedException
	{
		String Text=advisior.ToverifyContent();
		Assert.assertEquals(Text, "Please select System Role");		
		Thread.sleep(TestUtils.Thread_sleep);
	}
	
	@Test(priority=5)
	public void VerifyTextIsPresent()
	{
		boolean flag=advisior.ToverifyTextIsPresent();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=6)
	public void CanGoToBusinessOwner()
	{
		advisior.ClickBusinessOwner();
	}
	
	@Test(priority=7)
	public void ReVerifyColorOfNextButton()
	{
		String color=advisior.ToVerifyColorOfNextButton();
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
	public void ReVerifyTextIsPresent() throws InterruptedException
	{
		boolean flag=advisior.ToReVerifyTextIsPresent();
		Assert.assertFalse(flag);
		Thread.sleep(TestUtils.Thread_sleep);
	}
	
	@Test(priority=9)
	public void ReClickNextButtonTest()
	{
		advisior.ReClickNextButton();
	}
	
	@Test(priority=10)
	public void PhoneNumberValidationTest()
	{
		int size=advisior.PhoneNumberValidation();
		
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
		String Text=advisior.MinimumCharacterValidationPasswors();
		
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
		int size=advisior.MaximumCharacterValidationPaasword();
		

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
		int size=advisior.CharacterLimitationFirstName();
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
		int size=advisior.CharacterLimitationLastName();
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
		advisior.ClearSignUpPage();	
		Thread.sleep(TestUtils.Thread_sleep);
	}
	
	@Test(priority=16)
	public void ClickGetStartedTest()
	{
		advisior.ClickGetStarted();
	}
	
	@Test(priority=17)
	public void ErrorMessageFirstNameTest()
	{
		String Text=advisior.ErrorMessageFirstName();		
		Assert.assertEquals(Text, "Please enter First Name");	
		
	}
	
	@Test(priority=18)
	public void ErrorMessageLastNameTest()
	{
		String Text=advisior.ErrorMessageLastName();
		Assert.assertEquals(Text, "Please enter Last Name");	
	}
	
	@Test(priority=19)
	public void ErrorMessageEmailIDTest()
	{
		String Text=advisior.ErrorMessageEmailID();
		Assert.assertEquals(Text, "Please enter Email");
	}
	
	@Test(priority=20)
	public void ErrorMessagePhoneNumTest()
	{
		String Text=advisior.ErrorMessagePhoneNum();
		Assert.assertEquals(Text, "Please enter Phone Number");
	}
	
	@Test(priority=21)
	public void ErrorCreatePasswordTest()
	{
		String Text=advisior.ErrorCreatePassword();
		Assert.assertEquals(Text, "Please create Password");
		
	}
	
	@Test(priority=22)
	public void ErrorConfirmPasswordTest()
	{
		String Text=advisior.ErrorConfirmPassword();
		Assert.assertEquals(Text, "Please confirm password");
	}
	
	@AfterClass
	public void TearDown()
	{
		driver.quit();
	}

}
