package com.xfactor.features;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;

import com.xfactor.generics.FileUtils;
import com.xfactor.generics.WebdriverUtils;
import com.xfactor.pageobjects.HomePage;

public class HomeFeatures {
	
	WebDriver driver;
	HomePage hp;
	FileUtils fu;
	WebdriverUtils wdu;
	public HomeFeatures(WebDriver driver) {
		
		this.driver = driver;
		hp = new HomePage(driver);
		fu = new FileUtils();
		wdu = new WebdriverUtils();
	}
	
	public void clickOnLogin()
	{
		//hp.getLoginLink().click();
		wdu.waitForElementToBeClickable(hp.getLoginLink(), driver).click();
		//Reporter.log("Clicked on Login",true);
	}
	
	public void verifyHomePage()
	{
		String expected = "X FACTOR - Home";
		String actual = driver.getTitle();
		Assert.assertEquals(actual, expected);
		Reporter.log("Homepage verified", true);
		
	}
}
