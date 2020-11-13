package com.xfactor.test;

import java.io.IOException;

import org.testng.annotations.Test;

import com.xfactor.features.BaseFeatures;
import com.xfactor.features.HomeFeatures;
import com.xfactor.features.LoginFeatures;
import com.xfactor.generics.BaseTest;

public class LoginTest extends BaseTest{
	
	@Test(priority=1)
	public void loginWithInvalidUsername_logout() throws IOException, InterruptedException
	{
		BaseFeatures bf = new BaseFeatures(driver);
		HomeFeatures hf = new HomeFeatures(driver);
		LoginFeatures lf = new LoginFeatures(driver);
		bf.logout();
		hf.verifyHomePage();
		hf.clickOnLogin();
		lf.verifyLoginPage();
		lf.login(fu.getCommonInfo("invalid_username"), fu.getCommonInfo("password"));
		lf.verifyInvalidUsernameErrorMsg();
		Thread.sleep(5000);
	}
	@Test(priority=2)
	public void loginWithInvalidPassword() throws IOException, InterruptedException
	{
		LoginFeatures lf = new LoginFeatures(driver);
		lf.login(fu.getCommonInfo("username"), fu.getCommonInfo("invalid_password"));
		lf.verifyInvalidPasswordErrorMsg();
		Thread.sleep(5000);
	}
	@Test(priority=3)
	public void loginWithInvalidUsernameAndPassword() throws IOException
	{
		LoginFeatures lf = new LoginFeatures(driver);
		lf.login(fu.getCommonInfo("invalid_username"), fu.getCommonInfo("invalid_password"));
		lf.verifyInvalidUsernameErrorMsg();
	}
	@Test(priority=4)
	public void loginWithValidCredentials() throws IOException
	{
		LoginFeatures lf = new LoginFeatures(driver);
		BaseFeatures bf = new BaseFeatures(driver);
		lf.login(fu.getCommonInfo("username"), fu.getCommonInfo("password"));
		bf.verifyDashBoard();
	}
	
}
