package com.jioCinema.utiliti;

import org.testng.Assert;

public class Web_Constants {

	public static String URL = "https://www.jiocinema.com/";
	public static String ENV = "Prod";

	/** WEB Configured Browsers and Platforms **/
	public static String PROJECT = "WEB", OS = "Windows", PLATFORM_NAME = "Desktop", browser = "Chrome";

	//Reports path
	public final static String REPORT_PATH = "C:\\jioCinema_Automation-Reports\\";
	public static String ExtentReportPath="";
	public final static String SCREENSHOT_PATH = "C:\\jioCinema_Automation_ScreenShots\\";
	public static final boolean SCREENSHOT_TO_FOLDER = false;

	public void Web_ConstantsConfiguration(String OS,String browser,String project,String Environment , String platformName ,String browser_Stack,String KLOV_FLAG) {
		if (project!=null) {
			this.PROJECT=project;
		}
		if (OS!=null) {
			this.OS=OS;
		}
		if (Environment!=null) {
			this.ENV=Environment;
		}
		if (platformName!=null) {
			this.PLATFORM_NAME=platformName;
		}
		if (OS.equalsIgnoreCase("windows")) {
			if (PROJECT.equalsIgnoreCase("web")||PROJECT.equalsIgnoreCase("mobilerw")) {
				Web_Constants.OS = "Windows";
				switch (browser.toLowerCase()) {
				case "chrome":
					Web_Constants.browser = "Chrome";
					break;
				case "firefox":
					Web_Constants.browser = "Firefox";
					break;
				case "edge":
					Web_Constants.browser = "edge";
					break;
				case "ie":
					Web_Constants.browser = "ie";
					break;
				default:
					Assert.assertTrue(false, "Selected Browser not Applicable:-" + browser);
					break;
				}
			}
		}
		switch (ENV.toLowerCase()) {
		case "prod":{
			URL="https://www.mewatch.sg/";
			break;
		}
		case "preprod":{
			URL="https://annapurna:mcvalley@preprod98.mewatch.sg/";
			break;
		}
		default:
			break;
		}
		System.out.println("[INFO] Project - "+project);
		System.out.println("[INFO] OS - "+OS);
		System.out.println("[INFO] Environment - "+Environment);
		System.out.println("[INFO] Browser - "+browser);
		System.out.println("[INFO] URL - "+URL);
	}
}
