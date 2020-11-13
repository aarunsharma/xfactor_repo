package com.xfactor.features;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;

import com.xfactor.pageobjects.HomePage;
import com.xfactor.pageobjects.LoginPage;

public class LoginFeatures extends HomeFeatures
{
	LoginPage lp;
	HomePage hp;
	public LoginFeatures(WebDriver driver) {
		super(driver);
		this.lp = new LoginPage(driver);
		this.hp = new HomePage(driver);
	}
	
	public void verifyLoginPage()
	{
		
		String expected = "X FACTOR - Log In";
		String actual = driver.getTitle();
		//wdu.waitForTitleToContain(expected, driver);
		wdu.waitForInivisibilityOfElement(hp.getTitle(), driver);
		Assert.assertEquals(actual, expected);
		Reporter.log("Login Page Verified", true);
	}
	
	public void login(String username, String password)
	{
		lp.getUserNameField().clear();
		lp.getPasswordField().clear();
		wdu.waitForElementToBeClickable(lp.getUserNameField(), driver).sendKeys(username);
		lp.getPasswordField().sendKeys(password);
		lp.getLoginBtn().click();
		
		
	}
	public void verifyInvalidUsernameErrorMsg()
	{
		String expected = "User doesn't exist/inactive";
		String actual = wdu.waitForElementVisibility(lp.getLoginErrorMsg(), driver).getText();
		Assert.assertEquals(actual, expected);
		Reporter.log("Invalid Username Error Message Verified", true);
	}
	public void verifyInvalidPasswordErrorMsg()
	{
		String expected = "Username Password mismatch";
		String actual = wdu.waitForElementVisibility(lp.getLoginErrorMsg(), driver).getText();
		Assert.assertEquals(actual, expected);
		Reporter.log("Invalid Password Error Message Verified", true);
	}
}
