package com.facebook.utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.facebook.base.BaseTest;

public class ScreenShot{
	
	public void webElementScreenShot(WebElement user, String screenShotName) {
		File SrcFile=user.getScreenshotAs(OutputType.FILE);
		long time=System.currentTimeMillis();
		String fileWithPath="screenShot/"+time+screenShotName+".png";
		File DestFile=new File(fileWithPath);
		try {
			FileUtils.copyFile(SrcFile, DestFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		}
	
	
	public void screenShot(String screenShotName) {
		BaseTest b = new BaseTest();
		WebDriver driver=b.openApp();
		//Convert web driver object to TakeScreenshot
		TakesScreenshot scrShot =((TakesScreenshot)driver);
		//Call getScreenshotAs method to create image file
		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
		//Move image file to new destination
		     //roll up
		long time=System.currentTimeMillis();
		String fileWithPath="screenShot/"+time+screenShotName+".png";
		File DestFile=new File(fileWithPath);
		   //roll over
		//String detFilePath=System.getProperty("user.dir")+"\\ScreenShots\\"+"test"+".png";
		//File DestFile=new File(detFilePath);
		
		//Copy file at destination
		try {
			FileUtils.copyFile(SrcFile, DestFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		}

}
