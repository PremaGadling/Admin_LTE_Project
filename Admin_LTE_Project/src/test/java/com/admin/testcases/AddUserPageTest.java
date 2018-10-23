package com.admin.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.admin.base.TestBase;
import com.admin.pages.AddUserPage;
import com.admin.pages.HomePage;
import com.admin.pages.LoginPage;
import com.admin.pages.UserPage;


public class AddUserPageTest extends TestBase {
	
	HomePage homePage;
	LoginPage loginPage;
	UserPage userPage;
	AddUserPage add_user_page;
	
	 public AddUserPageTest() {
		super();
	}
	@BeforeMethod
	public void setUp() {
		initialization();
		homePage= new HomePage();
		loginPage= new LoginPage();
		
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		userPage=homePage.clickUserLink();
		add_user_page=userPage.verifyAddUser();
		
	}
	
	/*@DataProvider
	public Object[][] getAdminLTEData ()  {
		add_user_page=userPage.verifyAddUser();
		Object data[][]=TestUtils.getUserTestData(sheetName);
		return data;
		
	}
	*/
	@Test(priority=1,dataProvider="getAdminLTEData")
	public void getAllUserInfoTest(String Username, String Mobile, String Email, String Gender, String State, String Password) {
		/*String actual=add_user_page.getAllUserInfo("prema", "8149093621", "p@gmail.com", "mail","Maharastra","12345");
		Assert.assertEquals(actual, "User Added Successfully. You can not see added user.","USER NOT ADDED SUCCESSFULLY");
		userPage=homePage.clickUserLink();	
		add_user_page=userPage.verifyAddUser();*/
		
	    add_user_page.getAllUserInfo(Username, Mobile, Email, Gender, State, Password);
		
	}
	
	
/*	@Test(priority=0)
	public void userPlaceholderDataTest() {
		List<String> actual=add_user_page.userPlaceholderData();
		
		List<String> exp= new ArrayList<String>();
		
		exp.add("Username");
		exp.add("Mobile");
		exp.add("Email");
		//exp.add("Select State");
		exp.add("Password");
		
		Assert.assertEquals(actual, exp);
	}
	
*/		@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}

