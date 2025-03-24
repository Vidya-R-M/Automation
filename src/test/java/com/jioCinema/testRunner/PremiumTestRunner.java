package com.jioCinema.testRunner;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(glue = "com.jioCinema.test.stepDefinitions", monochrome = true, features = {
		"src/features/java/" }, plugin = { "json:target/cucumber-json-report.json",
				"html:target/cucumberHtmlReport.html" }, tags = "@smoke")
public class PremiumTestRunner {
	
}
