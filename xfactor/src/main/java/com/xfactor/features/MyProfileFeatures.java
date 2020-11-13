package com.xfactor.features;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;

import com.xfactor.pageobjects.MyProfilePage;

public class MyProfileFeatures extends BaseFeatures
{
	WebDriver driver;
	MyProfilePage mpf;
	
	public MyProfileFeatures(WebDriver driver) 
	{
		super(driver);
		this.driver = driver;
		this.mpf = new MyProfilePage(driver);
	}
	
	public void verifyMyProfilePage()
	{
		String expected ="X FACTOR - My Profile";
		String actual = driver.getTitle();
		Assert.assertEquals(actual, expected);
		Reporter.log("Profile Page has been verified",true);
	}
}
