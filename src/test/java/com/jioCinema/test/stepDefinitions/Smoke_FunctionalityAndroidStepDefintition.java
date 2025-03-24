package com.jioCinema.test.stepDefinitions;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.idealized.Javascript;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.asserts.SoftAssert;

import com.jioCinema.pages.HomePage;
import com.jioCinema.utiliti.BaseTest;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * 
 * @author Automation Team
 *
 */

public class Smoke_FunctionalityAndroidStepDefintition extends BaseTest {

	@Before("@smoke_Android")
	public void setUp(Scenario scenario) {
		System.out.println("Launch the application");
		
		HomePage homepage = new HomePage();
	}
	
	@Given("^Login with the facebook button in sign in page androidapp$")
	public void Login_with_the_facebook_button_in_sign_in_page_androidappp() throws Throwable {
		try {
			
			launchApplication();
			System.out.println("Application launched successfully");
			System.out.println("Application launched successfully");
			//((JavascriptExecutor) driver).executeScript("", driver.findElement(elementToClick));
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	@After("@smoke_Android")
	public void tearDown(Scenario scenario) {
		try {
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}



