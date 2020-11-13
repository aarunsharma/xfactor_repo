package com.xfactor.features;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.xfactor.pageobjects.MyXfactorHomePage;

public class MyXfactorHomeFeatures extends BaseFeatures {
	WebDriver driver;
	MyXfactorHomePage mxhp;

	public MyXfactorHomeFeatures(WebDriver driver) {
		super(driver);
		this.driver = driver;
		this.mxhp = new MyXfactorHomePage(driver);
	}

	public void verifyMyXfactorHomePage() {
		String expected = "X FACTOR - My XFactor";
		String actual = driver.getTitle();
		Assert.assertEquals(actual, expected);
		Reporter.log("MyXfactorHomePage verfied", true);
	}

	public void searchBySource(String searchOption, String searchTxt) throws InterruptedException {
		switch (searchOption) {
		case "All":
			Thread.sleep(5000);
			mxhp.getSearchBySourceDropDown().click();
			wdu.selectByValue(mxhp.getSearchBySourceDropDown(), searchTxt);
			//mxhp.getBothRadioBtn().click();
			mxhp.getSubmitBtn().click();
			//Thread.sleep(15000);
			try
			{
				wdu.waitForElementVisibility(mxhp.getOpportunityLinks().get(0), driver);
				while(true)
				{
					 List<WebElement> titles = mxhp.getOpportunityLinks();
					 WebElement source = mxhp.getOpportunitySource();
					 for (int i = 0; i < titles.size(); i++) 
					 {
						 Reporter.log(titles.get(i).getText(),true);
						 String sourceTxt = source.getText();
						 //Reporter.log(sourceTxt,true);
						 Assert.assertEquals(sourceTxt, searchTxt);
					 }
					 mxhp.getNextButton().click();
					 WebDriverWait wait = new WebDriverWait(driver, 2);
					 Boolean status = wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[text()='Error!']")));
					 if(!status)
					 {
						 break;
					 }
				}
			}
			catch(TimeoutException e)
			{
				driver.navigate().refresh();
				wdu.javascriptExecutor("arguments[0].scrollIntoView();", driver,mxhp.getBody());
			}
			
			break;
		case "Active":
			Thread.sleep(5000);
			mxhp.getSearchBySourceDropDown().click();
			wdu.selectByValue(mxhp.getSearchBySourceDropDown(), searchTxt);
			mxhp.getActiveRadioBtn().click();
			mxhp.getSubmitBtn().click();
			//Thread.sleep(15000);
			try
			{
				wdu.waitForElementVisibility(mxhp.getOpportunityLinks().get(0), driver);
				while(true)
				{
					 List<WebElement> titles = mxhp.getOpportunityLinks();
					 WebElement source = mxhp.getOpportunitySource();
					 for (int i = 0; i < titles.size(); i++) 
					 {
						 Reporter.log(titles.get(i).getText(),true);
						 String sourceTxt = source.getText();
						 //Reporter.log(sourceTxt,true);
						 Assert.assertEquals(sourceTxt, searchTxt);
					 }
					 mxhp.getNextButton().click();
					 WebDriverWait wait = new WebDriverWait(driver, 2);
					 Boolean status = wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[text()='Error!']")));
					 if(!status)
					 {
						 break;
					 }
				}
			}
			catch(TimeoutException e)
			{
				driver.navigate().refresh();
				wdu.javascriptExecutor("arguments[0].scrollIntoView();", driver,mxhp.getBody());
			}
			break;
		case "Historic":
			Thread.sleep(5000);
			mxhp.getSearchBySourceDropDown().click();
			wdu.selectByValue(mxhp.getSearchBySourceDropDown(), searchTxt);
			mxhp.getInactiveRadioBtn().click();
			mxhp.getSubmitBtn().click();
			//Thread.sleep(15000);
			try
			{
				wdu.waitForElementVisibility(mxhp.getOpportunityLinks().get(0), driver);
				while(true)
				{
					 List<WebElement> titles = mxhp.getOpportunityLinks();
					 WebElement source = mxhp.getOpportunitySource();
					 for (int i = 0; i < titles.size(); i++) 
					 {
						 Reporter.log(titles.get(i).getText(),true);
						 String sourceTxt = source.getText();
						 //Reporter.log(sourceTxt,true);
						 Assert.assertEquals(sourceTxt, searchTxt);
					 }
					 mxhp.getNextButton().click();
					 WebDriverWait wait = new WebDriverWait(driver, 2);
					 Boolean status = wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[text()='Error!']")));
					 if(!status)
					 {
						 break;
					 }
				}
			}
			catch(TimeoutException e)
			{
				driver.navigate().refresh();
				wdu.javascriptExecutor("arguments[0].scrollIntoView();", driver,mxhp.getBody());
			}
			break;

		}
	}
	public void searchByCategory(String searchOption, String searchTxt)
	{
		FluentWait fluentWait = new FluentWait(driver)
				.withTimeout(Duration.ofSeconds(5))
				.pollingEvery(Duration.ofMillis(500))
				.ignoring(NoSuchElementException.class);
		switch (searchOption) {
		case "All":
			fluentWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='thumb']/select)[3]")));
			mxhp.getSearchByCategoryDropDown().click();
			wdu.selectByValue(mxhp.getSearchByCategoryDropDown(), searchTxt);
			mxhp.getSubmitBtn().click();
			try
			{
				wdu.waitForElementVisibility(mxhp.getOpportunityLinks().get(0), driver);
				while(true)
				{
					 List<WebElement> titles = mxhp.getOpportunityLinks();
					 WebElement category = mxhp.getOpportunityCategory();
					 for (int i = 0; i < titles.size(); i++) 
					 {
						 Reporter.log(titles.get(i).getText(),true);
						 String categoryTxt = category.getText();
						 //Reporter.log(sourceTxt,true);
						 Assert.assertEquals(categoryTxt, searchTxt);
					 }
					 mxhp.getNextButton().click();
					 WebDriverWait wait = new WebDriverWait(driver, 2);
					 Boolean status = wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[text()='Error!']")));
					 if(!status)
					 {
						 break;
					 }
				}
			}
			catch(TimeoutException e)
			{
				driver.navigate().refresh();
				wdu.javascriptExecutor("arguments[0].scrollIntoView();", driver,mxhp.getBody());
			}
			break;
			case "Active":
				fluentWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='thumb']/select)[3]")));
				mxhp.getSearchByCategoryDropDown().click();
				wdu.selectByValue(mxhp.getSearchByCategoryDropDown(), searchTxt);
				mxhp.getActiveRadioBtn().click();
				mxhp.getSubmitBtn().click();
				try
				{
					wdu.waitForElementVisibility(mxhp.getOpportunityLinks().get(0), driver);
					while(true)
					{
						 List<WebElement> titles = mxhp.getOpportunityLinks();
						 WebElement category = mxhp.getOpportunityCategory();
						 for (int i = 0; i < titles.size(); i++) 
						 {
							 Reporter.log(titles.get(i).getText(),true);
							 String categoryTxt = category.getText();
							 //Reporter.log(sourceTxt,true);
							 Assert.assertEquals(categoryTxt, searchTxt);
						 }
						 mxhp.getNextButton().click();
						 WebDriverWait wait = new WebDriverWait(driver, 2);
						 Boolean status = wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[text()='Error!']")));
						 if(!status)
						 {
							 break;
						 }
					}
				}
				catch(TimeoutException e)
				{
					driver.navigate().refresh();
					wdu.javascriptExecutor("arguments[0].scrollIntoView();", driver,mxhp.getBody());
				}
				break;
			case "Historic":
				fluentWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='thumb']/select)[3]")));
				mxhp.getSearchByCategoryDropDown().click();
				wdu.selectByValue(mxhp.getSearchByCategoryDropDown(), searchTxt);
				mxhp.getInactiveRadioBtn().click();
				mxhp.getSubmitBtn().click();
				try
				{
					wdu.waitForElementVisibility(mxhp.getOpportunityLinks().get(0), driver);
					while(true)
					{
						 List<WebElement> titles = mxhp.getOpportunityLinks();
						 WebElement category = mxhp.getOpportunityCategory();
						 for (int i = 0; i < titles.size(); i++) 
						 {
							 Reporter.log(titles.get(i).getText(),true);
							 String categoryTxt = category.getText();
							 //Reporter.log(sourceTxt,true);
							 Assert.assertEquals(categoryTxt, searchTxt);
						 }
						 mxhp.getNextButton().click();
						 WebDriverWait wait = new WebDriverWait(driver, 2);
						 Boolean status = wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[text()='Error!']")));
						 if(!status)
						 {
							 break;
						 }
					}
				}
				catch(TimeoutException e)
				{
					driver.navigate().refresh();
					wdu.javascriptExecutor("arguments[0].scrollIntoView();", driver,mxhp.getBody());
				}
				break;
		}
	}
}
