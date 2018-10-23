package com.admin.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.admin.base.TestBase;

public class HomePage extends TestBase{
	
	@FindBy(xpath="html/body/div[1]/header/a/span[2]")
	WebElement homePageTitle;
	
	@FindBy(xpath=".//a[@href=\"dashboard.html\"]//span[text()=\"Dashboard\"]")
	WebElement dashboardlink;
	
	@FindBy(xpath=".//*[contains(text(),'Users')]")
	WebElement userlink;
	
	@FindBy(xpath=".//*[contains(text(),'Operators')]")
	WebElement operatorlink;
	
	@FindBy(xpath=".//*[contains(text(),'Operators')]")
	WebElement logoutlink;
	
    public HomePage() {
		PageFactory.initElements(driver, this);
	}
	public String validateHomePageTitle() {
		return driver.getTitle();
	}
	
	public boolean verifyPageDashboard() {
		System.out.println("CHecking dashboard");
		return dashboardlink.isDisplayed();
	}
	
	public boolean verifyUserlink() {
		return userlink.isDisplayed();
		
	}
	public UserPage clickUserLink() {
		userlink.click();
		return new UserPage();
	}
	public boolean verifyOperatorLink() {
		return operatorlink.isDisplayed();
			}
	
	public boolean verifyLogoutLink() {
		return logoutlink.isDisplayed();
			}
	
}
