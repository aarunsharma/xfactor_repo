package com.xfactor.features;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;

import com.xfactor.pageobjects.AboutUsPage;

public class AboutUsFeatures extends BaseFeatures
{
	WebDriver driver;
	AboutUsPage ap;
	public AboutUsFeatures(WebDriver driver) {
		super(driver);
		this.driver = driver;
		this.ap = new AboutUsPage(driver);
		
	}
	public void verifyAboutUsPage()
	{
		String expected = "X FACTOR - About Us";
		String actual = driver.getTitle();
		Assert.assertEquals(actual, expected);
		Reporter.log("About Us Page Verified", true);
	}
	
}
