package com.facebook.registrationTests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.facebook.base.BaseTest;
import com.facebook.registrationPages.RegistrationPage;
import com.facebook.utilities.ExcelReader;

public class RegistrationTest extends BaseTest {
	RegistrationPage regPage;
	ExcelReader exReader;
	String file = "src/test/resources/registration.xlsx";
	String sheetName = "Sheet1";

	@BeforeMethod
	public void openFacebook() {
		openApp();
	}

	@Test
	public void createRegistrationTest() {
		regPage = new RegistrationPage(driver);
		regPage.createNewAccountButton();
		exReader = new ExcelReader(file, sheetName);
		String fName = exReader.getStringCellValue(1, 0);
		regPage.firstNameField(fName);
	}

	@AfterMethod
	public void closeFacebook() {
	 closeApp();
	}
}
