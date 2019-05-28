package com.hAIbooks.qa.SwitchingTab;

import java.io.IOException;
import java.util.ArrayList;

import com.hAIbooks.qa.Base.TestBase;

public class SwitchTab extends TestBase
{
	public SwitchTab() throws IOException 
	{
		super();
		
	}

	public void switchtab(int tabNo)
	{
		ArrayList tabs = new ArrayList (driver.getWindowHandles());
	    System.out.println(tabs.size());
	    driver.switchTo().window((String) tabs.get(tabNo)); 
	}
	

}
