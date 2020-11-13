package com.xfactor.features;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;

import com.xfactor.pageobjects.PrivacyPolicyPage;

public class PrivacyPolicyFeatures extends BaseFeatures 
{
	WebDriver driver;
	PrivacyPolicyPage ppp;
	public PrivacyPolicyFeatures(WebDriver driver) {
		super(driver);
		this.driver= driver;
		ppp = new PrivacyPolicyPage(driver);
	}
	public void verifyPrivacyPolicyPage()
	{
		String expected = "X FACTOR - Privacy Policy";
		String actual = driver.getTitle(); 
				//wdu.waitForElementVisibility(ppp.getTitle(), driver).getText();
		Assert.assertEquals(actual, expected);
		Reporter.log("Privacy Policy Page has been verified", true);
	}
}
