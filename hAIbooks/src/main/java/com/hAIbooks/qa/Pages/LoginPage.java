package com.hAIbooks.qa.Pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hAIbooks.qa.Base.TestBase;
import com.hAIbooks.qa.Times.TestUtils;

public class LoginPage extends TestBase
{

	public LoginPage() throws IOException 
	{
		PageFactory.initElements(driver, this);
	
	}
	
	
	@FindBy(xpath="//a[contains(text(),'Login')]")
	WebElement loginTab;
	
	@FindBy(xpath="//div[@class='accountcontrol__content']//h1")
	WebElement contenSimplify;
	
	@FindBy(xpath="//h3[contains(text(),'Get Started')]")
	WebElement getStartedContent;
	
	@FindBy(xpath="//p[@class='text-bright line-height-normal']")
	WebElement contentSignup;
	
	@FindBy(xpath="//a[@id='signUpAnim']")
	WebElement signUp;
	
	@FindBy(xpath="//div[@class='social-block']//ul/li[1]/a")
	WebElement googleLogo;
	
	@FindBy(xpath="//div[@class='social-block']//ul/li[2]/a")
	WebElement facebookLogo;
	
	@FindBy(xpath="//input[@id='email-address']")
	WebElement usrename;
	
	@FindBy(xpath="//input[@id='cpassword']")
	WebElement password;
	
	@FindBy(xpath="//input[@id='btnLogin']")
	WebElement loginButton;
	
	@FindBy(xpath="//div[@id='validationSummaryLogin']//ul/li")
	WebElement validationMsg;
	
	@FindBy(xpath="//a[@class='user dropdown-toggle']")
	WebElement verifiedUser;
	
	@FindBy(xpath="//a[@class='user dropdown-toggle']")
	WebElement ProfileClk;
	
	@FindBy(xpath="//span[contains(text(),'Log Out')]")
	WebElement Logoutbtn;
	
	public void clickLogin()
	{
		loginTab.click();
		
	}
	
	public String  contentLoginPage()
	{
		return contenSimplify.getText();
	}
	
	public String getStartedContent()
	{
		return getStartedContent.getText();	
	}
	
	public String signUpSidebar()
	{
		return contentSignup.getText();
	}
	
	public String verifyValidationMessage()
	{
		loginButton.click();
		return validationMsg.getText();
	}
	
	public boolean googleLogo()
	{
		return googleLogo.isDisplayed();
	}
	
	public boolean facebookLogo()
	{
		return facebookLogo.isDisplayed();
	}
	
	
	public void loginhAIbooks(String userName, String passWord)
	{
		usrename.clear();
		usrename.sendKeys(userName);
		password.clear();
		password.sendKeys(passWord);
		loginButton.click();	
		
	}
	
	public String VerifyUserLogin()
	{
		return verifiedUser.getText();
	}
	
	public void clickUserLogout()
	{
		verifiedUser.click();
	}
	
	public void clickLogout() throws InterruptedException
	{
		ProfileClk.click();
		Thread.sleep(TestUtils.Thread_sleep);
		Logoutbtn.click();
	}
	
	
	
	
	
	
	

	
	
	
	
	
	
	

}
