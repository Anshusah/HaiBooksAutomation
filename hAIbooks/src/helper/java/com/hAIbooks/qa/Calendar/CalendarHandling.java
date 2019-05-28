package com.hAIbooks.qa.Calendar;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.hAIbooks.qa.Base.TestBase;
import com.hAIbooks.qa.Times.TestUtils;


public class CalendarHandling extends TestBase
{

	public CalendarHandling() throws Exception 
	{
		super();
		
	}
	public void ClcikYear(String XpathYearSelection, String XpathYearList, String ExcelYear) throws InterruptedException
	{
		driver.findElement(By.xpath(XpathYearSelection)).click();
		Thread.sleep(TestUtils.PAGE_LOAD_TIMEOUT);
		List<WebElement> years=driver.findElements(By.xpath(XpathYearList));
		
		for(WebElement yRs:years)
		{
			String selectedYear=yRs.getAttribute("innerHTML");
				
			if(selectedYear.contentEquals(ExcelYear))
			{
				yRs.click();
				break;
				
			}
		}
		
	}
	
	public void ClcikMonth(String xpath_monthSelection, String xpath_monthList, String businessMonth) throws InterruptedException
	{
		driver.findElement(By.xpath(xpath_monthSelection)).click();
		Thread.sleep(TestUtils.PAGE_LOAD_TIMEOUT);
		List <WebElement> months=driver.findElements(By.xpath(xpath_monthList));
		
		for(WebElement mThs:months)
		{
			String totalMonths=mThs.getAttribute("innerHTML");
			if(totalMonths.contentEquals(businessMonth))
			{
				mThs.click();
				break;
			}
		}
		
				
		Thread.sleep(TestUtils.PAGE_LOAD_TIMEOUT);

	}
	
	
	
	public void ClickDate(String XpathDate, String Exceldate)
	{
		
			 WebElement dateWidget = driver.findElement(By.id("ui-datepicker-div"));
			 
			  //List<WebElement> rows=dateWidget.findElements(By.tagName("tr"));
			 
			  List<WebElement> columns=dateWidget.findElements(By.tagName("td"));
			 
			  for (WebElement cell: columns)
			  {
			 
			   
			   if (cell.getText().equals(Exceldate))
			   {
			 
			   cell.findElement(By.linkText(Exceldate)).click();
			 
			   break;
			   }
			  }
	}
	
	

}
