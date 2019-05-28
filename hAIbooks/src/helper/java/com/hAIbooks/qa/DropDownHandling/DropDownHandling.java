 package com.hAIbooks.qa.DropDownHandling;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.hAIbooks.qa.Base.TestBase;
import com.hAIbooks.qa.Times.TestUtils;

public class DropDownHandling extends TestBase
{
	public DropDownHandling() throws IOException 
	{
		super();
	}
	public void HandlingDropDown(String xpath2, String Data) throws InterruptedException
	{
		
		System.out.println("Driver="+driver);
		//driver.findElement(By.xpath(xpath1)).click();
		List<WebElement> dd_menu=driver.findElements(By.xpath(xpath2));
		

		for(WebElement ele:dd_menu)
		{
			String innerHTML=ele.getAttribute("innerHTML");
			
			if(innerHTML.contentEquals(Data))
			{
				ele.click();
				Thread.sleep(TestUtils.Thread_sleep);	
				break;
			}	
					
		}
		
	}

}
