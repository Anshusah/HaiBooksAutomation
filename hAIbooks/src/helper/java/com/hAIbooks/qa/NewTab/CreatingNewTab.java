package com.hAIbooks.qa.NewTab;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hAIbooks.qa.Base.TestBase;
import com.hAIbooks.qa.Times.TestUtils;

public class CreatingNewTab extends TestBase
{

	public CreatingNewTab() throws IOException 
	{
		PageFactory.initElements(driver, this);	
	}
	
	@FindBy(xpath="//input[@id='inbox_field']")
	WebElement emailInput;
	
	@FindBy(xpath="//button[contains(text(),'Go!')]")
	WebElement clickGo;
	
	
	
	public void OpenNewTab() throws InterruptedException
	{
		((JavascriptExecutor) driver).executeScript("window.open('about:blank','_blank');");	 		 
	}
	
	public void switchToNewTab(String EmailAddress) throws Exception 
	{
		
		String subWindowHandler = null;

		  Set<String> handles = driver.getWindowHandles();
		  Iterator<String> iterator = handles.iterator();
		  while (iterator.hasNext()) 
		  {
		   subWindowHandler = iterator.next();
		  }
		  driver.switchTo().window(subWindowHandler);
		  driver.get(OR.getProperty("mailinator"));
		  Thread.sleep(TestUtils.PAGE_LOAD_TIMEOUT);
		  emailInput.sendKeys(EmailAddress);
		  //emailInput.sendKeys(Keys.ENTER);
		  //Thread.sleep(TestUtils.Thread_sleep);
		  clickGo.click();	  
	}
	
	
	
	public void InsertTabNumToSwith(int tabNo)
	{
		ArrayList tabs = new ArrayList (driver.getWindowHandles());
	    System.out.println(tabs.size());
	    driver.switchTo().window((String) tabs.get(tabNo)); 
	}

}
