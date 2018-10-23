package com.admin.ExtendReport;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class GetScreenShot {
	
	public static String capture(WebDriver driver, String screenshotName) 
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String dest_path =System.getProperty("D:\\Project\\Admin_LTE_Project")+"\\ErrorScreenshot\\"+screenshotName+".png";
		try
		{
			File  dest = new File(dest_path);
			FileUtils.copyFile(src, dest);
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
			
		return dest_path;
	}
}