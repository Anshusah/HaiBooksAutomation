package com.hAIbooks.qa.Pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hAIbooks.qa.Base.TestBase;

public class BusinessOwner extends TestBase
{

	public BusinessOwner() throws IOException 
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@id='btnRegister']")
	WebElement GetStarted;
	
	
	/*********
	 * Web Element of Sign Up
	 */
	@FindBy(xpath="//a[@id='signupTop1']")
	WebElement signUp;
	
	@FindBy(xpath="//input[@id='btnRegistrationNext']")
	WebElement nextBtn;
	
	@FindBy(xpath="//span[@id='spanRoleRequired']")
	WebElement conTent;
	
	@FindBy(xpath="//div[@id='divBusinessOwner']")
	WebElement businessOwner;
	
	/**
	 * Web Element of Phone Number
	 */
	@FindBy(xpath="//input[@id='txtRegistrationPhone']")
	WebElement phoneNum;
	
	/**
	 * Web Element of Password
	 */
	@FindBy(xpath="//input[@id='txtRegistrationPassword']")
	WebElement passWord;
	
	@FindBy(xpath="//span[@id='txtRegistrationPassword-error']")
	WebElement validationTextPwd;
	
	@FindBy(xpath="//input[@id='txtRegistrationFirstName']")
	WebElement fristName;
	
	@FindBy(xpath="//input[@id='txtRegistrationLastName']")
	WebElement lastName;
	
	/***
	 * Web Element of Error Message
	 */
	@FindBy(xpath="//span[@id='txtRegistrationFirstName-error']")
	WebElement errorFirstName;
	
	@FindBy(xpath="//span[@id='txtRegistrationLastName-error']")
	WebElement errorLastName;
	
	@FindBy(xpath="//span[@id='txtRegistrationEmail-error']")
	WebElement errorEmailId;
	
	@FindBy(xpath="//span[@id='txtRegistrationPhone-error']")
	WebElement errorPhoneNum;
	
	@FindBy(xpath="//span[@id='txtRegistrationPassword-error']")
	WebElement errorCreatePwd;
	
	@FindBy(xpath="//span[@id='txtRegistrationConfirmPwd-error']")
	WebElement errorConfirmPwd;
	
	public void ClcikSignUp()
	{
		signUp.click();
	}
	public String ColorNextButton()
	{
		return nextBtn.getCssValue("background").toString();
	}

	
	public void ClickNextButton() throws Exception
	{
		nextBtn.click();
	}
	
	public String ToverifyContent()
	{
		return conTent.getText();
	}
	
	public boolean ToverifyTextIsPresent()
	{
		return conTent.isDisplayed();
	}
	
	public void ClickBusinessOwner()
	{
		businessOwner.click();
	}
	
	public String ToVerifyColorOfNextButton()
	{
		return nextBtn.getCssValue("background").toString();
	}
		
	public boolean ToReVerifyTextIsPresent()
	{
		return conTent.isDisplayed();
	}
	
	public void ReClickNextButton()
	{
		nextBtn.click();
	}
	
	public int PhoneNumberValidation()
	{
		phoneNum.sendKeys("859674859641253699455");
		String typedValue=phoneNum.getAttribute("value");
		int size=typedValue.length();
		return size;
		
	}
	
	public String MinimumCharacterValidationPasswors()
	{
		passWord.clear();
		passWord.sendKeys("sun");
		GetStarted.click();
		return validationTextPwd.getText();
				
	}
	
	public int  MaximumCharacterValidationPaasword()
	{
		passWord.clear();
		passWord.sendKeys("WordCountershowyouthetopkeywordsandkeyworddensityofthearticlewordsforanarticleessayreportstorybookpaper");
		String typedValue=passWord.getAttribute("value");
		int size=typedValue.length();
		return size;
			
	}
	
	public int CharacterLimitationFirstName()
	{
		fristName.clear();
		fristName.sendKeys("fthearticlewordsforanarticleessayreportstorybookpaper");
		String typedValue=fristName.getAttribute("value");
		
		int size=typedValue.length();
		
		return size;	
	}
	
	public int CharacterLimitationLastName()
	{
		lastName.sendKeys("fthearticlewordsforanarticleessayreportstorybookpaper");
		String typedValue=lastName.getAttribute("value");
		int size=typedValue.length();
		return size;
		
	}
	
	public void ClearSignUpPage()
	{
		fristName.clear();
		lastName.clear();
		phoneNum.clear();
		passWord.clear();
		
	}
	
	public void ClickGetStarted()
	{
		GetStarted.click();
	}
	
	public String ErrorMessageFirstName()
	{
		return errorFirstName.getText();
	}
	
	public String ErrorMessageLastName()
	{
		return errorLastName.getText();
	}
	
	public String ErrorMessageEmailID()
	{
		return errorEmailId.getText();
	}
	
	public String ErrorMessagePhoneNum()
	{
		return errorPhoneNum.getText();
	}
	
	public String ErrorCreatePassword()
	{
		return errorCreatePwd.getText();		
	}
	
	public String ErrorConfirmPassword()
	{
		return errorConfirmPwd.getText();
	}

}
