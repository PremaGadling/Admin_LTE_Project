package com.admin.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.admin.base.TestBase;

public class UserPage extends TestBase{
	
	
	@FindBy(xpath="html/body/div[1]/div[1]/section[1]/h1")
	WebElement userLabel;
	
	@FindBy(xpath="//button[contains(text(),'Add User')]")
	WebElement click_add_users;
		
	public UserPage(){
		PageFactory.initElements(driver, this);
	}
	public String verifyUserTitle() {
		return driver.getTitle();
		}
	public AddUserPage verifyAddUser() {
		click_add_users.click();
		return new AddUserPage();
	}
	public String verifyUserLabel() 
	{
		return userLabel.getText();	
	}

	public String verifyCurrentUrl() 
	{
		return driver.getCurrentUrl();
		
	}
}
