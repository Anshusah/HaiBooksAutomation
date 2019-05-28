package com.hAIbooks.qa.Pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hAIbooks.qa.Base.TestBase;
import com.hAIbooks.qa.Times.TestUtils;

public class RegBusinessOwner extends TestBase
{

	public RegBusinessOwner() throws IOException 
	{
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//a[@id='signupTop1']")
	WebElement tryFree;
	
	@FindBy(xpath="//input[@id='txtRegistrationFirstName']")
	WebElement fristName;
	
	@FindBy(xpath="//input[@id='txtRegistrationLastName']")
	WebElement lastName;
	
	@FindBy(xpath="//input[@id='txtRegistrationEmail']")
	WebElement typeEmail;
	
	@FindBy(xpath="//input[@id='txtRegistrationPhone']")
	WebElement phone;
	
	@FindBy(xpath="//input[@id='txtRegistrationPassword']")
	WebElement password;
	
	@FindBy(xpath="//input[@id='txtRegistrationConfirmPwd']")
	WebElement conPassword;
	
	@FindBy(xpath="//input[@id='btnRegister']")
	WebElement getStarted;
	
	@FindBy(xpath="//span[@id='txtRegistrationEmail-error']")
	WebElement alredayEmailContent;
	
	@FindBy(xpath="//div[@id='divBusinessOwner']")
	WebElement businessOwnerIcon;;
	
	@FindBy(xpath="//input[@id='btnRegistrationNext']")
	WebElement nextBtn;
	
	
	
	

	@FindBy(xpath="//img[@class='logo-color']")
	WebElement logo;
	
	@FindBy(xpath="//a[@class='btn btn_landing btn_primary']")
	WebElement signUp;
	
	
	@FindBy(xpath="//a[@id='leftLogin']")
	WebElement Leftlogin;
	
	@FindBy(xpath="//input[@id='email-address']")
	WebElement loginUsrename;
	
	@FindBy(xpath="//input[@id='cpassword']")
	WebElement loginPassword;
	
	@FindBy(xpath="//input[@id='btnLogin']")
	WebElement loginButton;
	
	
	public void clickTryFree()
	{
		tryFree.click();
	}
	
	public void clickAdvisior()
	{
		businessOwnerIcon.click();
	}
	
	public void clickNextButton()
	{
		nextBtn.click();
		
	}
	
	public void getName(String FirstName, String LastName)
	{
		fristName.sendKeys(FirstName);
		lastName.sendKeys(LastName);	
	}
	
	public void getEmailPhone(String emailId, String PhoneNum)
	{
		typeEmail.sendKeys(emailId);
		phone.sendKeys(PhoneNum);
	}
	
	public void getPassword(String Password, String ConPassword)
	{
		password.sendKeys(Password);
		conPassword.sendKeys(ConPassword);	
	}
	
	public void clickGetStarted()
	{
		getStarted.click();
	}
	
	public void loginhAIbooks(String userName, String passWord) throws InterruptedException
	{
		logo.click();
		Thread.sleep(TestUtils.PAGE_LOAD_TIMEOUT);
		signUp.click();
		Thread.sleep(TestUtils.PAGE_LOAD_TIMEOUT);
		Leftlogin.click();
		Thread.sleep(TestUtils.PAGE_LOAD_TIMEOUT);
		loginUsrename.clear();
		loginUsrename.sendKeys(userName);
		loginPassword.clear();
		loginPassword.sendKeys(passWord);
		loginButton.click();	
		Thread.sleep(TestUtils.PAGE_LOAD_TIMEOUT);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
