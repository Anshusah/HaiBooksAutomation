package com.hAIbooks.qa.CheckBox;

import java.io.IOException;

import org.openqa.selenium.By;

import com.hAIbooks.qa.Base.TestBase;
import com.hAIbooks.qa.Times.TestUtils;

public class SelectCheckBox extends TestBase
{

	public SelectCheckBox() throws IOException 
	{
		super();
	}
	
	public void ClcikCheckBox()
	{
		
		try
		{
			Thread.sleep(TestUtils.Thread_sleep);
			driver.findElement(By.xpath("//label[@class='agree-label']")).click();
		}
		catch(Exception e)
		{
			System.out.println(e);
	
		}
	}

}
