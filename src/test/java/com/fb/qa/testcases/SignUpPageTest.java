package com.fb.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fb.qa.Pages.ContinuePage;
import com.fb.qa.Pages.SignUpPage;
import com.fb.qa.base.TestBase;

public class SignUpPageTest extends TestBase {
	SignUpPage signUpPage;
	ContinuePage continuePage;
	public SignUpPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		signUpPage = new SignUpPage();
		
	}
	
	@Test(priority=1) 
	public void SignUpPageTitle() {
		String title = signUpPage.createNewAccount().validateSignUpPageTitle();
		Assert.assertEquals(title,"Facebook - log in or sign up");
	}
	
	@Test(priority=2)
	public void createnewAccountTest() {
		continuePage = signUpPage.createNewAccount().signup(prop.getProperty("firstName"), 
				prop.getProperty("lastName"), prop.getProperty("emailAddress"),
				prop.getProperty("remailAddress"), prop.getProperty("newPassword"), 
				prop.getProperty("day"), prop.getProperty("month"), prop.getProperty("year"));
	}
	
//	@AfterMethod
//	public void tearDown() {
//		driver.quit();
//	}

}
