package com.xfactor.test;

import org.testng.annotations.Test;

import com.xfactor.features.MyProfileFeatures;
import com.xfactor.generics.BaseTest;

public class MyProfileTest extends BaseTest
{
	@Test
	public void displayMyProfilePage()
	{
		MyProfileFeatures mpf = new MyProfileFeatures(driver);
		mpf.clickOnMyProfile();
		mpf.verifyMyProfilePage();
	}
}
