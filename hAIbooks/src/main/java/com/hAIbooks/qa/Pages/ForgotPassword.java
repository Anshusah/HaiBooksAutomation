package com.hAIbooks.qa.Pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hAIbooks.qa.Base.TestBase;
import com.hAIbooks.qa.Times.TestUtils;

public class ForgotPassword extends TestBase
{

	public ForgotPassword() throws IOException 
	{
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//a[@class='forgot-pass']")
	WebElement fogotPassword;
	
	@FindBy(xpath="//input[@id='txtForgotPasswordEmail']")
	WebElement emailInput;
	
	@FindBy(xpath="//input[@id='btnSubmit']")
	WebElement sendButton;
	
	@FindBy(xpath="//span[@id='txtForgotPasswordEmail-error']")
	WebElement validationMessage;
	
	@FindBy(xpath="//input[@id='newpass']")
	WebElement newPassword;
	
	@FindBy(xpath="//input[@id='confirm']")
	WebElement confirmPassword;
	
	@FindBy(xpath="//input[@class='btn btn_primary']")
	WebElement saveButton;
	
	@FindBy(xpath="//a[@class='user dropdown-toggle']")
	WebElement verifyingUser;
	
	
	
	public void clickForgotPassword() throws InterruptedException
	{
		fogotPassword.click();
		Thread.sleep(TestUtils.Thread_sleep);
		sendButton.click();
	}
	
	public String validationForgotPassword()
	{
		return validationMessage.getText();
	}
		
	public void inputUserId(String username)
	{
		emailInput.sendKeys(username);
		sendButton.click();
	}
	
	public void createNewPassword(String NewPwd, String ConPwd)
	{
		newPassword.sendKeys(NewPwd);
		confirmPassword.sendKeys(ConPwd);
		saveButton.click();
		
	}
	
	public String verfyingUser()
	{
		return verifyingUser.getText();
		
	}
	
	


}
