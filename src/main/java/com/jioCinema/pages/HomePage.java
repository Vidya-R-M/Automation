package com.jioCinema.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;

public class HomePage {

	RemoteWebDriver driver;

	@FindBy(id="jiocinema-logo")
	public WebElement jiocinemaLogo;
	
	@FindBy(xpath="//span[text()='Home']/...")
	public WebElement homeTab;
	
	@FindBy(xpath="//span[text()='Sports']/..")
	public WebElement sportsTab;
	
	@FindBy(xpath="//span[text()='Movies']/..")
	public WebElement moviesTab;
	
	@FindBy(xpath="//span[text()='TV Shows']/..")
	public WebElement tvShowsTab;
	
	@FindBy(id="searchInputBox")
	public WebElement searchBar;
	
	@FindBy(xpath="//img[@alt='avatar']")
	public WebElement avatarIcon;
	
	@FindBy(xpath="//p[text()='Login']/..")
	public WebElement loginBtn;
	
	@FindBy(xpath="//h3[contains(@class,'MuiTypography-heading3Bold') and text()='Guest']")
	public WebElement guestUser;
	
	@FindBy(xpath="//h5[text()='Subscribe Now']")
	public WebElement subscribeNowBtn;
	
}
