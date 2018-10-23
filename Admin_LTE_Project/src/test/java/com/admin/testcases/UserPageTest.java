package com.admin.testcases;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.admin.base.TestBase;
import com.admin.pages.HomePage;
import com.admin.pages.LoginPage;
import com.admin.pages.UserPage;

public class UserPageTest extends TestBase{
	HomePage homePage;
	LoginPage loginPage;
	UserPage userPage;
	
	
	public UserPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		homePage= new HomePage();
		loginPage= new LoginPage();
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		userPage=homePage.clickUserLink();	
	}
	
	@Test(priority=1)
	public void userTitleTest() {
		String actualUserTitle = userPage.verifyUserTitle();
		assertEquals(actualUserTitle, "AdminLTE 2 | User");
	}
	
	@Test(priority=2)
	public void userLabelTest() {
		String actualUserLabel = userPage.verifyUserLabel();
		assertEquals(actualUserLabel, "Users");
	}
	@Test(priority=3)
	public void clickOnAddUserTest() {
		userPage.verifyAddUser();

	}
	@Test(priority=4)
	public void CurrentUrlTest() 
	{
		String actualUrl = userPage.verifyCurrentUrl();
		assertEquals(actualUrl, "file:///G:/Selenium%20Software/Offline%20Website/pages/examples/users.html");
}
}
