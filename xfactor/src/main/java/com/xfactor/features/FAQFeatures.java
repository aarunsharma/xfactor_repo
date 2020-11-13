package com.xfactor.features;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;

import com.xfactor.pageobjects.FAQPage;

public class FAQFeatures extends BaseFeatures {
	WebDriver driver;
	FAQPage fp;

	public FAQFeatures(WebDriver driver) {
		super(driver);
		this.driver = driver;
		this.fp = new FAQPage(driver);
	}

	public void verifyFAQPage() {
		String expected = "X FACTOR - FAQs";
		String actual = driver.getTitle();
		Assert.assertEquals(actual, expected);
		Reporter.log("FAQ PAge Verified", true);
	}

	public void filterByAllCategories() throws IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, IOException, InterruptedException {
		Class<? extends FAQPage> c = fp.getClass();
		Method[] methods = c.getDeclaredMethods();
		Comparator<Method> sortByName = new Comparator<Method>() 
		{
			@Override
			public int compare(Method o1, Method o2) {
				return(o1.getName().compareTo(o2.getName()));
			}
		};
		Arrays.sort(methods, sortByName);
		
		WebElement element = null;
		List<String> expectedQues = new ArrayList<String>();
		expectedQues.add(fu.getPropertiesFileData("testdata/faq.properties", "subscription"));
		expectedQues.add(fu.getPropertiesFileData("testdata/faq.properties", "account_maintenance"));
		expectedQues.add(fu.getPropertiesFileData("testdata/faq.properties", "search_box"));
		expectedQues.add(fu.getPropertiesFileData("testdata/faq.properties", "help"));
		expectedQues.add(fu.getPropertiesFileData("testdata/faq.properties", "about_xfactor"));
		expectedQues.add(fu.getPropertiesFileData("testdata/faq.properties", "site_specific_page"));
		expectedQues.add(fu.getPropertiesFileData("testdata/faq.properties", "interested_vendors"));
		expectedQues.add(fu.getPropertiesFileData("testdata/faq.properties", "whats_coming"));
		for (Method method : methods) {

			if (method.getName().equals("getFirstQuesOfEachCategory")) {
				continue;
			} 
			else {
				//System.out.println(method.getName());
				//Thread.sleep(3000);
				element = (WebElement) method.invoke(fp);
				element.click();
				Thread.sleep(3000);
				String ques = wdu.waitForElementVisibility(fp.getFirstQuesOfEachCategory(), driver).getText();
				//System.out.println(ques);
				Assert.assertTrue(expectedQues.contains(ques));
			}

		}

	}
	
	public void subscribeToNewsLetter() throws IOException, InterruptedException
	{
		wdu.javascriptExecutor("window.scrollTo(0, document.body.scrollHeight)", driver,fp.getSubscriptionEmailField());
		fp.getSubscriptionEmailField().sendKeys(fu.getCommonInfo("subscription_email"));
		fp.getSubscriptionBtn().click();
		String expected = "Successfully subscribed!";
		String actual = wdu.waitForElementVisibility(fp.getSubscriptionSuccessMsg(), driver).getText();
		Assert.assertEquals(actual, expected);
		//wdu.waitForInivisibilityOfElement(fp.getSubscriptionSuccessMsg(), driver);
		Reporter.log("Newsletter subscription successfull", true);
		Thread.sleep(3000);
		//wdu.javascriptExecutor("window.scrollTo(0,-1713)", driver, fp.getLogoutLink());
		//wdu.waitForElementVisibility(fp.getLogoutLink(), driver);
		//Thread.sleep(3000);
		//wdu.waitForInivisibilityOfElement(fp.getSubscriptionSuccessMsg(), driver);
	}

}
