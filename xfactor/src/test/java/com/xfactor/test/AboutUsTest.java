package com.xfactor.test;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import org.testng.annotations.Test;

import com.xfactor.features.AboutUsFeatures;
import com.xfactor.features.FAQFeatures;
import com.xfactor.features.PrivacyPolicyFeatures;
import com.xfactor.generics.BaseTest;
import com.xfactor.generics.WebdriverUtils;
import com.xfactor.pageobjects.PrivacyPolicyPage;

public class AboutUsTest extends BaseTest 
{
	@Test(priority=1)
	public void displayAboutUsPage()
	{
		AboutUsFeatures af = new AboutUsFeatures(driver);
		af.clickOnAboutUs();
		af.verifyAboutUsPage();
		driver.navigate().refresh();
	}
	
	@Test(priority=2)
	public void displayFAQPage() throws InterruptedException
	{
		FAQFeatures ff = new FAQFeatures(driver);
		ff.clickOnFAQs();
		ff.verifyFAQPage();
	}
	@Test(dependsOnMethods="displayFAQPage")
	public void filterFAQsAccordingToCategories() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, IOException, InterruptedException
	{
		FAQFeatures ff = new FAQFeatures(driver);
		ff.filterByAllCategories();
		driver.navigate().refresh();
	}
	@Test(priority=3)
	public void contactUs() throws IOException, InterruptedException
	{
		FAQFeatures ff = new FAQFeatures(driver);
		ff.subscribeToNewsLetter();
		
	}
	@Test(priority=4)
	public void displayEnduserTerms()
	{
		PrivacyPolicyFeatures ppf = new PrivacyPolicyFeatures(driver);
		ppf.clickOnPrivacyPolicy();
		ppf.verifyPrivacyPolicyPage();
	}
}
