package com.admin.testcases;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.admin.base.TestBase;
import com.admin.pages.HomePage;
import com.admin.pages.LoginPage;
import com.admin.util.TestUtils;


public class HomePageTest extends TestBase {
	TestUtils testUtils;
	HomePage homePage;
	LoginPage loginPage;
	
	public HomePageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		testUtils= new TestUtils();
		homePage= new HomePage();
		loginPage= new LoginPage();
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	@BeforeTest
	public void extentInit()
	{
		TestUtils.init();		
	}
	
	
	@Test(priority=0)
	public void homePageTitleTest() {
		String title=homePage.validateHomePageTitle();
		assertEquals(title, "AdminLTE 2 | Dashboard");
	
	}
	 @Test(priority=1)
	public void verifyDashboard() {
		 System.out.println("Dashboard test case");
		boolean actual=homePage.verifyPageDashboard();
		System.out.println("Dash board pass fail : "+actual);
		
		Assert.assertTrue(actual);
	}
	
	@Test(priority=2)
	public void clickOnUserLink() {
		boolean actual=homePage.verifyUserlink();
		Assert.assertTrue(actual);
	}
	
	@Test(priority=3)
	public void clickOnOperatorLink() {
		boolean actual=homePage.verifyOperatorLink();
		Assert.assertTrue(actual);
	}
	
	@Test(priority=4)
	public void clickOnLogoutLink() {
		boolean actual=homePage.verifyLogoutLink();
		Assert.assertTrue(actual);
	}
	
	
	@AfterMethod
	public void tearDown(ITestResult result)
	{
		TestUtils.getResult("HomePageTest",result);
		driver.quit();		
	}
	
	@AfterTest
	public void extentEnd()
	{
		TestUtils.endReport();		
	}

	/*@AfterMethod
	public void tearDown() {
		driver.quit();
	}
*/
}
