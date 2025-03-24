package com.jioCinema.utiliti;

import java.io.File;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.observer.entity.ReportEntity;

import com.aventstack.extentreports.reporter.ExtentKlovReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoClientURI;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;


//import com.aventstack.extentreports.reporter.configuration.ResourceCDN;
import io.cucumber.java.Scenario;
import io.reactivex.rxjava3.core.Observer;
/**
 * 
 * @author Automation team
 *
 */

public class ReportUtils {

	public ExtentSparkReporter reporter;
	public static ExtentReports report;
	protected ExtentTest mainTest;
	public ExtentTest test;
	public InetAddress systemAddress;
	public String suiteName;
	public String testName;
	public String Report_Name;
	private String report_folder;
	public static String className;
	public static String methodName;
	public static String testCaseName;
	public static String hour;
	public Status status;
	public ExtentKlovReporter klovReporter;
	public Observer<ReportEntity> reporterEntity;

	public static String screenShotFolderPath;
	public static String screenShotFilePath;

	public static String scenarioName;

	public void initializeReport(String suiteName) {

		report_folder = Web_Constants.REPORT_PATH + Web_Constants.PROJECT + "_Reports" + "\\";
		createFolder(report_folder);

		suiteName = suiteName.replace(".", "_").replace(":", "_");

		Report_Name = report_folder + suiteName + "#" + getTimeStamp() + ".html";
		reporter = new ExtentSparkReporter(Report_Name);
		reporter.config().setDocumentTitle("meWatchReport");
		reporter.config().setReportName("meWatch_" + Web_Constants.PROJECT + "_" + Web_Constants.browser);
		report = new ExtentReports();
		report.attachReporter(reporter);
		Web_Constants.ExtentReportPath = Report_Name;

		try {
			systemAddress = Inet4Address.getLocalHost();
		} catch (UnknownHostException e) {
			test.log(Status.INFO, "Unable to get the local host");
		}

		report.setSystemInfo("IP Address", systemAddress.getHostAddress());
		report.setSystemInfo("Host Name", systemAddress.getHostName());
		report.setSystemInfo("UserName", System.getProperty("user.name"));
		report.setSystemInfo("Operating System", System.getProperty("os.name"));

		report.flush();
	}

	public void createTest(String name) {
		mainTest = report.createTest(name);
	}

	public void createNode(String stepName, String stepDefinitionName) {
		test = mainTest.createNode(stepName + " : " + stepDefinitionName);
		System.out.println("Executing the Step Definition   -   " + stepName + " : " + stepDefinitionName);
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
	public String getTimeStamp() {
		Date d = new Date();
		return d.toString().replace(":", "_").replace(" ", "_");
	}

	public String getFeature(String featureFile) {
		int count = 0;
		for (int i = 0; i < featureFile.length() - 1; i++) {

			char ch = featureFile.charAt(featureFile.length() - (i + 1));

			String str = String.valueOf(ch);

			if (str.equals("/")) {
				break;
			}
			count++;
		}
		featureFile = featureFile.substring(featureFile.length() - count);
		return featureFile;
	}

	public String getScenario(Scenario scenario) {
		System.out.println("Fetching the Scenario Name");
		String name = getFeature(scenario.getUri().toString()) + " : " + scenario.getName();
		System.out.println(name);

		return name;
	}
	
	public void createFolder(String foldPath) {
		File f = new File(foldPath);
		if (!f.exists()) {
			f.mkdirs();
		}
	}

}
