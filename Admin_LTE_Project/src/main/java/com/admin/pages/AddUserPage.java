package com.admin.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.admin.base.TestBase;

public class AddUserPage extends TestBase{
	
	@FindBy(id="username")
	WebElement username;
	
	@FindBy(id="mobile")
	WebElement mobile;
	
	@FindBy(id="email")
	WebElement email;
	
	@FindBy(xpath="//select[@class='form-control']")
	WebElement select_state;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(xpath="//button[contains(text(),'Submit')]")
	WebElement submit;
	
	@FindBy(xpath="//input[@placeholder='Username']")
	WebElement userPlaceholder;
	
	@FindBy(xpath="//input[@placeholder='Mobile']")
	WebElement mobilePlaceholder;
	
	@FindBy(xpath="//input[@placeholder='Email']")
	WebElement emailPlaceholder;
	
	/*@FindBy(xpath="//select[@class='form-control']")
	WebElement selectStatePlaceholder;
*/	
	@FindBy(xpath="//input[@placeholder='Password']")
	WebElement passwordPlaceholder;
	
	@FindBy(xpath="html/body/div[1]/div[1]/section[2]/div/div/div/form/div[1]/div[4]/div/input[1]")
	WebElement genderMale;
	
	@FindBy(xpath="html/body/div[1]/div[1]/section[2]/div/div/div/form/div[1]/div[4]/div/input[2]")
	WebElement genderFemale;
	
	public AddUserPage() {
		PageFactory.initElements(driver, this);
    }
	
	public List<String> userPlaceholderData() {
		List<String> list1= new ArrayList<String>();
		list1.add(userPlaceholder.getAttribute("placeholder"));
		list1.add(mobilePlaceholder.getAttribute("placeholder"));
		list1.add(emailPlaceholder.getAttribute("placeholder"));
		//list1.add(selectStatePlaceholder.getText());
		list1.add(passwordPlaceholder.getAttribute("placeholder"));
		return list1;
	}
	
	public String getAllUserInfo(String Username, String Mobile, String Email, String Gender, String State, String Password) {
		username.sendKeys(Username);
		mobile.sendKeys(Mobile);
		email.sendKeys(Email);
		
		if (Gender.equalsIgnoreCase("Male"))
		{
			genderMale.click();
			
		}
		else if (Gender.equalsIgnoreCase("Female")) 
		{
			genderFemale.click();
		}
	
		Select s= new Select(select_state);
		s.deselectByVisibleText(State);;
		
		password.sendKeys(Password);	
	    submit.click();
	    
	   // driver.switchTo().alert().accept();
		
		return driver.switchTo().alert().getText();
	}
	}
