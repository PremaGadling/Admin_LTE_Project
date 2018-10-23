package com.admin.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.admin.base.TestBase;

public class LoginPage extends TestBase {
	
	@FindBy(xpath="//a[@href='index2.html']")
	WebElement pagetitle;
	
	@FindBy(id="email")
	WebElement emailId;
	
	@FindBy(id="password")
	WebElement pwd;
	
	@FindBy(xpath=".//*[contains(text(),'Sign In')]")
	WebElement signIn;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String ValidateLoginPageTitle() {
		return driver.getTitle();
	}
	public HomePage login(String un, String passd) {
		emailId.sendKeys(un);
		pwd.sendKeys(passd);
		signIn.click();
		return new HomePage();
		
	}
}
