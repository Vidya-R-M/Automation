package com.jioCinema.utiliti;

import java.io.IOException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import java.security.GeneralSecurityException;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.TestNGCucumberRunner;
/**
 * 
 * @author Automation team
 *
 */

public class ReportConfigurations extends AbstractTestNGCucumberTests {

	public ReportUtils reportUtils;

	public InetAddress systemAddress;

	//	@Parameters({ "OS", "Browser", "Project" })
	@BeforeSuite(alwaysRun = true)
	public void beforeSuite(@Optional ITestContext ctx, @Optional String OS, @Optional String Browser,
			@Optional String Project ,@Optional String platformName ,@Optional String browser_Stack ,@Optional String KLOV_FLAG) {

		reportUtils = new ReportUtils();

		Web_Constants constants = new Web_Constants();

		Project = System.getProperty("Project");
		if (Project == null) {
			System.out.println("Jenkins Project Value:-" + Project);
			Project = Web_Constants.PROJECT;
		}

		OS = System.getProperty("OS");
		if (OS == null) {
			System.out.println("Jenkins OS Value:-" + OS);
			OS = Web_Constants.OS;
		}

		String environment = System.getProperty("Environment");
		if (environment == null) {
			System.out.println("Jenkins Environment Value:-" + environment);
			environment = Web_Constants.ENV;
		}

		Browser = System.getProperty("Browser");
		if (Browser == null) {
			System.out.println("Jenkins Browser Value:-" + Browser);
			Browser = Web_Constants.browser;
		}

		platformName = System.getProperty("platformName");
		if (platformName == null) {
			System.out.println("Jenkins platformName Value:-" + platformName);
			platformName = Web_Constants.PLATFORM_NAME;
		}


		String J_REPORT_EMAIL = System.getProperty("REPORT_EMAIL");
		if (J_REPORT_EMAIL == null) {
		}

		constants.Web_ConstantsConfiguration(OS, Browser, Project, environment, platformName,browser_Stack,KLOV_FLAG);

		String suiteName = null;
		switch (Web_Constants.PROJECT) {
		case "WEB":
			suiteName = ctx.getCurrentXmlTest().getSuite().getName() + "#" + platform() + "#"
					+ Web_Constants.ENV + "#" + Web_Constants.browser+"#";
			break;
		case "MobileRW":
			suiteName = ctx.getCurrentXmlTest().getSuite().getName() + "#" + platform() + "#"
					+ Web_Constants.ENV + "#" + Web_Constants.browser+"#";
			break;
		

		default:
			break;
		}
		if (suiteName.toLowerCase().contains("default")) {
			suiteName = this.getClass().getSimpleName();
		}

		reportUtils.initializeReport(suiteName);

		try {
			systemAddress = Inet4Address.getLocalHost();
			System.out.println("SystemAddress:-" + systemAddress);
		} catch (UnknownHostException e) {

		}

		String IP_adress = systemAddress.getHostAddress().replace(".", "_");
		System.out.println("AP_Adress:-" + IP_adress);
		if (Web_Constants.OS.equalsIgnoreCase("Windows")) {
			reportUtils.createFolder(Web_Constants.SCREENSHOT_PATH);
			reportUtils.screenShotFolderPath = Web_Constants.SCREENSHOT_PATH;
			reportUtils.screenShotFilePath = Web_Constants.SCREENSHOT_PATH + IP_adress + "\\" + getDateStamp() + "\\";
			System.out.println("ReportScreenshot");
			System.out.println("ReportFilePath");
			System.out.println("AP_Adress:-" + IP_adress);
		}
	}

	@AfterSuite(alwaysRun = true)
	public void afterSetUp() {
		ReportUtils.report.flush();
	}

	public String platform() {

		String platform="";

		switch (Web_Constants.PROJECT) {
		case "WEB": {
			platform ="RW";
			break;
		}
		case "MobileRW": {
			platform ="MRW";
			break;
		}
		}
		return platform;

	}

	public String getDateStamp() {
		DateFormat dfor = new SimpleDateFormat("ddMMyyyy");
		Date obj = new Date();
		String date = dfor.format(obj);
		return date;
	}

	public String hourStamp() {
		Date d = new Date();
		String hour = String.valueOf(d.getHours());
		return hour;
	}

	// To get current time
	public static String getTimeStamp() {
		Date d = new Date();
		return d.toString().replace(":", "_").replace(" ", "_");
	}

}
