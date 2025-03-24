package com.jioCinema.utiliti;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class BaseTest {
	public RemoteWebDriver driver;
	ExtentTest test;
	
	public void launchApplication() {
		switch (Web_Constants.PROJECT.toLowerCase()) {
		case "web": {

			switch (Web_Constants.OS.toLowerCase()) {
			case "windows": {
				switch (Web_Constants.browser.toLowerCase()) {
				case "chrome": {
					ChromeOptions options = new ChromeOptions();
					options.addArguments("--disable-notifications");
					options.addArguments("disable-infobars");
					driver = new ChromeDriver(options);
					break;
				}
				case "firefox": {
					FirefoxOptions options = new FirefoxOptions();
					options.addArguments("-private");
					driver = new FirefoxDriver(options);
				}
				}
			}
			}
		}
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
		driver.get(Web_Constants.URL);

	}

	public void logStatus(String status, String Message) {
		switch (status.toLowerCase()) {
		case "info":
			System.out.println("[" + status.toUpperCase() + "]" + " : " + Message);
			test.info(MarkupHelper.createLabel(Message, ExtentColor.WHITE));

			break;
		case "warning":
			System.err.println("[" + status.toUpperCase() + "]" + " : " + Message);
			test.warning(MarkupHelper.createLabel(Message, ExtentColor.RED));
			break;
		case "error":
			System.err.println("[" + status.toUpperCase() + "]" + " : " + Message);
			test.warning(MarkupHelper.createLabel(Message, ExtentColor.RED));
			break;
		case "pass":
			System.out.println("[" + status.toUpperCase() + "]" + " : " + Message);
			test.pass(MarkupHelper.createLabel(Message, ExtentColor.GREEN));
			break;
		case "fail":
			System.err.println("[" + status.toUpperCase() + "]" + " : " + Message);
			test.fail(MarkupHelper.createLabel(Message, ExtentColor.RED));
			break;
		case "skip":
			System.out.println("[" + status.toUpperCase() + "]" + " : " + Message);
			test.skip(MarkupHelper.createLabel(Message, ExtentColor.PINK));
			break;
		default:
			test.warning(Message);
			break;
		}
	}
	
	public static void takeSnapShot(WebDriver driver,String fileWithPath) throws Exception{
		TakesScreenshot scrShot =((TakesScreenshot)driver);
		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
		File DestFile=new File(fileWithPath);
		FileUtils.copyFile(SrcFile, DestFile);
		}
	
	
		public void createFolder(String foldPath) {
			File f = new File(foldPath);
			if (!f.exists()) {
				f.mkdirs();
			}
		}
		
		public String getTimeStampWithsec() {

			String timeStamp = "";
			Date d = new Date();
			Calendar c = Calendar.getInstance();
			c.setTime(d);
			timeStamp = timeStamp + (c.get(Calendar.MONTH) + 1) + c.get(Calendar.DAY_OF_MONTH) + c.get(Calendar.HOUR)
			+ c.get(Calendar.MINUTE) + c.get(Calendar.SECOND) + c.get(Calendar.MILLISECOND);

			return timeStamp;
		}
}
