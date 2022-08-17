package com.fb.qa.testcases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fb.qa.Pages.HomePage;
import com.fb.qa.Pages.LoginPage;
import com.fb.qa.base.TestBase;


public class LoginPageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	Logger log = Logger.getLogger(LoginPageTest.class);
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		log.info("* Starting test cases execution  **");
		initialization();
		loginPage = new LoginPage();
		
		
		
	}
	
	@Test(priority=1) 
	public void LoginPageTitle() {
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title,"Facebook - log in or sign up");
	}
	@Test(priority=2) 
	public void fbLogoImageTest() {
		boolean flag = loginPage.validateFBImage();
		Assert.assertTrue(flag);
	}
	@Test(priority=3)
	public void loginTest() {
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
//	@AfterMethod
//	public void tearDown() {
//		driver.quit();
//	}

}
