package com.facebook.loginPages;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.ID, using = "email")
	WebElement userNameId;

	public WebElement userNameMethod(String enterYourUserName) {
		/// driver.findElement(By.id("email"));
		userNameId.sendKeys(enterYourUserName);
		return userNameId;
	}

	@FindBy(how = How.NAME, using = "pass")
	public WebElement passwordLocator;

	public WebElement passWordMethod(String enterYourPassword) {
		passwordLocator.sendKeys(enterYourPassword);
		return passwordLocator;
	}

	@FindBy(how = How.XPATH, using = "//button[starts-with(@id,'u_0_5_')]")
	private WebElement loginButtonLocator;

	public void logingButton() {
		loginButtonLocator.click();
	}
	
public void screenShot(String screenShotName) {
		
		//Convert web driver object to TakeScreenshot
		TakesScreenshot scrShot =((TakesScreenshot)driver);
		//Call getScreenshotAs method to create image file
		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
		//Move image file to new destination
		//long time=System.currentTimeMillis();
		String detFilePath=System.getProperty("user.dir")+"\\ScreenShots\\"+"test"+".png";
		//String fileWithPath="screenShot/"+time+screenShotName+".png";	
		File DestFile=new File(detFilePath);
		//Copy file at destination
		try {
			FileUtils.copyFile(SrcFile, DestFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		}

}
