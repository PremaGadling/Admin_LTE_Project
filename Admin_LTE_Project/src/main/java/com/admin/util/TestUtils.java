package com.admin.util;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.ITestResult;
import com.admin.ExtendReport.GetScreenShot;
import com.admin.base.TestBase;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TestUtils extends TestBase{

	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 10;

	public static String TESTDATA_SHEET_PATH = "D:\\Project\\Admin_LTE_Project\\src\\main\\java\\com\\admin\\testdata\\Admin_LTE.xlsx";


	static Workbook book;
	static Sheet sheet;
	XSSFWorkbook wb;
	public static ExtentTest test;
	
	public static void init()
	{
		extent= new ExtentReports(System.getProperty("user.dir")+"/test-output/ExtentReportScreenshot.html",true);		
	}
	
	public static void captureScreenshot()
	{
		test = extent.startTest("captureScreenshot");
		test.log(LogStatus.PASS, "Test passed.");
	}
	
	public static void getResult(String testName, ITestResult result)
	{
		test = extent.startTest(testName);
		if (result.getStatus()==ITestResult.SUCCESS)
		{
			test.log(LogStatus.PASS, "Test Passed.");
			
		}
		else if (result.getStatus()==ITestResult.FAILURE) 
		{
			String screenshotPath = GetScreenShot.capture(driver, "screenshotForExtentReport");	
			test.log(LogStatus.FAIL, result.getThrowable());
			test.log(LogStatus.FAIL, "Snapshot Below: "+test.addScreenCapture(screenshotPath));
		}
		extent.endTest(test);
	}
	
	public static void endReport() 
	{
		extent.flush();
		extent.close();
	} 	
}