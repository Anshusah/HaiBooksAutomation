package com.hAIbooks.qa.Screenshots;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


import com.hAIbooks.qa.Base.TestBase;

public class ScreenShot extends TestBase
{
	
	public ScreenShot() throws IOException 
	{
		super();
	}

	//public static WebDriver driver;
	public String getScreenshot(String ImageName) throws IOException
	{
		if(ImageName.equals(""))
			ImageName="blank";
		
		
		File image=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String ImageLocation=(System.getProperty("user.dir")+"/Screenshots/");
		Calendar calendar= Calendar.getInstance();
		SimpleDateFormat formater=new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		String actualImageName=ImageLocation+ImageName+"_"+formater.format(calendar.getTime())+".png";
		
		File destFile=new File(actualImageName);
		
		FileUtils.copyFile(image, destFile);		
		
		return actualImageName;
	}

}
