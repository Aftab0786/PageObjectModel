package com.fb.qa.testcases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fb.qa.Pages.FriendsPage;
import com.fb.qa.Pages.HomePage;
import com.fb.qa.Pages.LoginPage;
import com.fb.qa.base.TestBase;

public class HomePageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	FriendsPage friendsPage;
	Logger log = Logger.getLogger(HomePageTest.class);
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		log.info("* Starting test cases execution home page **");
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		friendsPage = new FriendsPage();
	}
	
//	@Test(priority=1)
//	public void verifyHomePageTitleTest() {
//		String homePageTitle = homePage.verifyHomePageTitle();
//		Assert.assertEquals(homePageTitle, "Facebook – log in or sign up");
//	}
	
	@Test(priority=2)
	public void verifyFriendsLinkTest() {
		friendsPage = homePage.clickOnfriendsLink();
	}
	
	
	
//	@AfterMethod
//	public void tearDown() {
//		driver.quit();
//	}

}
