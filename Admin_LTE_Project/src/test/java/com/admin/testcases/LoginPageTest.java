package com.admin.testcases;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.admin.base.TestBase;
import com.admin.pages.LoginPage;

public class LoginPageTest extends TestBase {
	
	LoginPage loginPage;

	LoginPageTest(){
		super();
	}
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage= new LoginPage();
	}
	@Test
	public void LoginPageTitleTest() {
		String title=loginPage.ValidateLoginPageTitle();
		assertEquals(title, "AdminLTE 2 | Log in");
	}
	@Test
	public void LoginTest() {
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	@Test
	public void tearDown() {
		driver.quit();
	}
	
}
