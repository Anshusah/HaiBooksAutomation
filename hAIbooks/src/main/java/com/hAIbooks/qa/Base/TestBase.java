package com.hAIbooks.qa.Base;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.io.File;
import java.lang.reflect.Method;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.hAIbooks.qa.Times.TestUtils;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TestBase 
{
	public static WebDriver driver;
	public Properties OR;
	public File f1;
	public FileInputStream file;
	
	
	
	public static ExtentReports extent;
	public static ExtentTest test;
	
	
	static 
	{
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		extent = new ExtentReports(System.getProperty("user.dir") + "/ExtentReport/test" + formater.format(calendar.getTime()) + ".html", false);
	}
	
	
	/***************************Base Class********************************************/
	public TestBase() throws IOException
	{

		OR=new Properties();
		f1=new File(System.getProperty("user.dir")+"/src/helper/java/com/hAIbooks/qa/Config/Config.Properties");
		file=new FileInputStream(f1);
		OR.load(file);
				
		f1=new File(System.getProperty("user.dir")+"/src/helper/java/com/hAIbooks/qa/Config/Or.Properties");
		file=new FileInputStream(f1);
		OR.load(file);
		
	}
	
	public void Intilization()
	{
		String Browser=OR.getProperty("browser");
		
		if(Browser.equalsIgnoreCase("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/Drivers/chromedriver.exe");
			driver= new ChromeDriver();
		}
		
		else if(Browser.equalsIgnoreCase("firefox"))
		{
			System.out.println(System.getProperty("user.dir"));
			System.setProperty("webdriver.firefox.marionette", System.getProperty("user.dir")+"/Drivers/geckodriver.exe");
			driver= new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(TestUtils.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtils.IMPLICT_WAIT, TimeUnit.SECONDS);
		driver.get(OR.getProperty("QaUrl"));			
	}
	
	/*********************************Extent Report***********************************/
	
	
	public String getScreenshot(String imageName) throws IOException
	{
		if(imageName.equals(""))
		{
			imageName = "blank";
		}

		
		File image=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String imageLocaion=System.getProperty("user.dir")+"/ScreenShots/";
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		String actualImageName = imageLocaion+imageName+"_"+formater.format(calendar.getTime())+".png";
		File destFile = new File(actualImageName);
		FileUtils.copyFile(image, destFile);
		return actualImageName;

		
	}
	
	
	
	
	public void getresult(ITestResult result) throws IOException 
	{
		if (result.getStatus() == ITestResult.SUCCESS) {

			test.log(LogStatus.PASS, result.getName() + " test is pass");
		} else if (result.getStatus() == ITestResult.SKIP) {
			test.log(LogStatus.SKIP, result.getName() + " test is skipped and skip reason is:-" + result.getThrowable());
		} else if (result.getStatus() == ITestResult.FAILURE) {
			test.log(LogStatus.FAIL, result.getName() + " test is failed" + result.getThrowable());
			String screen = getScreenshot("");
			test.log(LogStatus.FAIL, test.addScreenCapture(screen));
		} else if (result.getStatus() == ITestResult.STARTED) {
			test.log(LogStatus.INFO, result.getName() + " test is started");
		}
	}
	
	
	@AfterMethod()
	public void afterMethod(ITestResult result) throws IOException {
		getresult(result);
	}

	@BeforeMethod()
	public void beforeMethod(Method result) {
		test = extent.startTest(result.getName());
		test.log(LogStatus.INFO, result.getName() + " test Started");
	}
	
	@AfterClass(alwaysRun = true)
	public void endTest() {
		//driver.quit();
		extent.endTest(test);
		extent.flush();
	}

	
	
	

}
