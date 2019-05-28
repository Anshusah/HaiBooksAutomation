package com.hAIbooks.qa.Sikuli;

import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import com.hAIbooks.qa.Times.TestUtils;

public class Sikuli 
{
	public void Activation() throws Exception
	{
		Screen screen = new Screen();
		Pattern imag1 = new Pattern(System.getProperty("user.dir")+"/SikuliImages/Acc.PNG");
		Pattern imag2 = new Pattern(System.getProperty("user.dir")+"/SikuliImages/Acc1.PNG");
		Thread.sleep(TestUtils.Thread_sleep);
		screen.click(imag1);
		Thread.sleep(TestUtils.Thread_sleep);
		screen.click(imag2);
		Thread.sleep(TestUtils.Thread_sleep);
		
	}
	
	
	public void YopmailActivation() throws Exception
	{
		Screen screen = new Screen();
		Pattern imag2 = new Pattern(System.getProperty("user.dir")+"/SikuliImages/GetStarted.PNG");
		Thread.sleep(TestUtils.Thread_sleep);
		screen.click(imag2);
		Thread.sleep(TestUtils.Thread_sleep);
		
	}
	
	public void ResetPassword() throws Exception
	{
		Screen screen = new Screen();
		Pattern imag1 = new Pattern(System.getProperty("user.dir")+"/SikuliImages/ResetPasswordOne.PNG");
		Pattern imag2 = new Pattern(System.getProperty("user.dir")+"/SikuliImages/ResetPasswordTwo.PNG");
		Thread.sleep(TestUtils.Thread_sleep);
		screen.click(imag1);
		Thread.sleep(TestUtils.Thread_sleep);
		screen.click(imag2);
		Thread.sleep(TestUtils.Thread_sleep);
		
	}

}
