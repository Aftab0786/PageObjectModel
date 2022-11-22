package com.fb.qa.testcases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fb.qa.Pages.HomePage;
import com.fb.qa.Pages.LoginPage;
import com.fb.qa.Pages.ProfilePage;
import com.fb.qa.base.TestBase;

public class ProfilePageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	ProfilePage profilePage;
	Logger log = Logger.getLogger(ProfilePageTest.class);
	public ProfilePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		log.info("* Starting test cases execution for profile page  **");
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		profilePage = new ProfilePage();
	}
	
	@Test(priority=1)
	public void verifyHomePageTitleTest() {
		String homePageTitle = homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "Facebook");
	}
	@Test(priority=2)
	public void verifyProfilePageTest() {
		profilePage = homePage.clickOnprofilePage();
	}
	
//	@AfterMethod
//	public void tearDown() {
//		driver.quit();
//	}

}
