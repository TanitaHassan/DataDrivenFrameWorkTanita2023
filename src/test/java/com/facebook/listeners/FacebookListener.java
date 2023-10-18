package com.facebook.listeners;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.facebook.base.BaseTest;
import com.facebook.loginPages.LoginPage;
import com.facebook.utilities.ScreenShot;

public class FacebookListener implements ITestListener{

	@Override
	public void onTestStart(ITestResult result) {
		String methodName=result.getName();
		System.out.println(methodName+" >>>>>>method started");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String methodName=result.getName();
		System.out.println(methodName+" >>>>>method passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		String methodName=result.getName();
		System.out.println(methodName+" >>>>>>method Failed");
		screenShot(methodName);				
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String methodName=result.getName();
		System.out.println(methodName+" >>>>>>>method Skipped");
		screenShot(methodName);	
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		String methodName=result.getName();
		System.out.println(methodName+" >>>>>>>method Fail With success");
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		String methodName=result.getName();
		System.out.println(methodName+" >>>>>>>method Fail With Time");
	}

	@Override
	public void onStart(ITestContext context) {
		String suitName=context.getName();
		System.out.println(suitName+" >>>>>>>Tests started");
	}

	@Override
	public void onFinish(ITestContext context) {
		String testName=context.getName();
		System.out.println(testName+" >>>>>>>Tests Finished");
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
