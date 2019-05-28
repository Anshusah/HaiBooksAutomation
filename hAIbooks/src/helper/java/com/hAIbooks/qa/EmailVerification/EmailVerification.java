package com.hAIbooks.qa.EmailVerification;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hAIbooks.qa.Base.TestBase;

public class EmailVerification extends TestBase
{

	public EmailVerification() throws IOException 
	{
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//span[@id='txtRegistrationEmail-error']")
	WebElement alredayEmailContent;
	
	@FindBy(xpath="//input[@id='btnRegistrationNext']")
	WebElement NextButton;
	
	@FindBy(xpath="//input[@id='txtRegistrationEmail']")
	WebElement EmailInput;
	
	@FindBy(xpath="//input[@id='btnRegister']")
	WebElement GetStarted;
	
	
	
	public void ClickNextButton()
	{
		NextButton.click();
		
	}
	
	public void EmailTextBox(String EmailID)
	{
		EmailInput.sendKeys(EmailID);
		
	}
	
	public void ClickGetStarted()
	{
		GetStarted.click();
	}
	
	public boolean ContentOfEmailAlreadyExist()
	{
		return alredayEmailContent.isEnabled();
	}
	


}
