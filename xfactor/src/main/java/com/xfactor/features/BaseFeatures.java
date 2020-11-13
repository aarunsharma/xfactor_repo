package com.xfactor.features;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;

import com.xfactor.generics.FileUtils;
import com.xfactor.generics.WebdriverUtils;
import com.xfactor.pageobjects.BasePage;

//Dashboard Features
public class BaseFeatures {
	WebDriver driver;
	BasePage bp;
	WebdriverUtils wdu;
	FileUtils fu;
	public BaseFeatures(WebDriver driver) 
	{
		this.driver = driver;
		bp = new BasePage(driver);
		wdu = new WebdriverUtils();
		fu = new FileUtils();
	}
	
	public void verifyDashBoard()
	{
		String expected = "Dashboard";
		String actual = (wdu.waitForElementVisibility(bp.getDashboardLink(), driver)).getText();
		
		Assert.assertEquals(actual, expected);
		Reporter.log("Dashboard Verified", true);
	}
	
	public void logout()
	{
		bp.getLogoutLink().click();
	}
	
	public void clickOnAboutUs()
	{
		wdu.moveToElement(bp.getAboutUsHoverMenu(), driver);
		wdu.waitForElementVisibility(bp.getAboutUsLink(), driver).click();
	}
	public void clickOnFAQs()
	{
		
		wdu.moveToElement(bp.getAboutUsHoverMenu(), driver);
		wdu.waitForElementVisibility(bp.getFaqLink(), driver).click();
	}
	public void clickOnPrivacyPolicy()
	{
		wdu.javascriptExecutor("window.scrollTo(0, document.body.scrollHeight)", driver,bp.getPrivacyPolicyLink());
		bp.getPrivacyPolicyLink().click();
	}
	public void clickOnMyProfile()
	{
		wdu.moveToElement(bp.getMyXfactorHoverMenu(), driver);
		wdu.waitForElementVisibility(bp.getMyProfileLink(), driver).click();
	}
	public void clickOnMyXfactorHome()
	{
		wdu.moveToElement(bp.getMyXfactorHoverMenu(), driver);
		wdu.waitForElementVisibility(bp.getMyXfactorHomeLink(), driver).click();
	}
	
}
