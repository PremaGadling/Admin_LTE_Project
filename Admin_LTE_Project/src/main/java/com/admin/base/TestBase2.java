package com.admin.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.admin.util.TestUtils;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;


public class TestBase2 {
	
	public static WebDriver driver;
	public static Properties prop;
	
	public static ExtentReports extent;
	public static ExtentTest test;
	
	public TestBase2() {
		try {
			prop= new Properties();
			FileInputStream ip= new FileInputStream("D:\\Project\\Admin_LTE_Project\\src\\main\\java\\com\\admin\\config\\config.properties");
			prop.load(ip);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void initialization() {
		String browserName= prop.getProperty("browser");
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "G:\\Selenium Software\\chromedriver_win32\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			} else if(browserName.equals("firefox")) {
			System.setProperty("webdriver.firefox.marionette", "G:\\Selenium Software\\Mozila_Firefox_Driver\\geckodriver-v0.21.0-win6\\geckodriver.exe");
			driver= new FirefoxDriver();
			
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(TestUtils.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(TestUtils.IMPLICIT_WAIT, TimeUnit.SECONDS);
			
			driver.get(prop.getProperty("url"));
			
			
			
		}
	}

	}
