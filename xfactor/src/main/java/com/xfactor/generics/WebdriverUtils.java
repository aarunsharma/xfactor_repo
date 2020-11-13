package com.xfactor.generics;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;


public class WebdriverUtils {
	private WebDriverWait wait;
	private Select sel;
	private Actions act;

	// Common Explicit Wait
	/**
	 * Wait for element to be clickable
	 * 
	 * @param element
	 * @param driver
	 * @return
	 */
	public WebElement waitForElementToBeClickable(WebElement element, WebDriver driver) {
		wait = new WebDriverWait(driver, 20);
		return wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	/**
	 * Returns WebElement when it becomes visible
	 * 
	 * @param element
	 * @param driver
	 * @return
	 */
	public WebElement waitForElementVisibility(WebElement element, WebDriver driver) {
		wait = new WebDriverWait(driver, 20);
		return wait.until(ExpectedConditions.visibilityOf(element));
	}

	/**
	 * Wait for title to be visible
	 * 
	 * @param title
	 * @param driver
	 */
	public void waitForPageTitleContains(String title, WebDriver driver) {
		wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.titleContains(title));
		
	}

	/**
	 * Implicit Wait
	 * 
	 * @param driver
	 */
	public void waitForAllElements(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	public void waitForInivisibilityOfElement(WebElement element, WebDriver driver)
	{
		wait = new WebDriverWait(driver, 20);
		//wait.until(ExpectedConditions.)
		wait.until(ExpectedConditions.invisibilityOf(element));
		
	}
	
	public void waitForTitleToContain(String str, WebDriver driver)
	{
		wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.titleContains(str));
	}

	// Handling Drop-downs
	/**
	 * Select by Value Attributr
	 * 
	 * @param drpDwn
	 * @param value
	 */
	public void selectByValue(WebElement drpDwn, String value) {
		sel = new Select(drpDwn);
		//drpDwn.click();
		sel.selectByValue(value);
	}

	/**
	 * Select by Visible text
	 * 
	 * @param drpDwn
	 * @param text
	 */
	public void selectByVisibleText(WebElement drpDwn, String text) {
		sel = new Select(drpDwn);
		sel.selectByVisibleText(text);
	}

	/**
	 * Select by index
	 * 
	 * @param drpDwn
	 * @param index
	 */
	public void selectByIndex(WebElement drpDwn, int index) {
		sel = new Select(drpDwn);
		sel.selectByIndex(index);
	}

	// Handling Common Actions
	/**
	 * Move to respective element
	 * 
	 * @param element
	 * @param driver
	 */
	public void moveToElement(WebElement element, WebDriver driver) {
		act = new Actions(driver);
		act.moveToElement(element).perform();
	}

	/**
	 * Perform Double Click
	 * 
	 * @param element
	 * @param driver
	 */
	public void doubleClick(WebElement element, WebDriver driver) {
		act = new Actions(driver);
		act.doubleClick(element).perform();
	}

	/**
	 * Drag and Drop
	 * 
	 * @param source
	 * @param driver
	 * @param target
	 */
	public void dragAndDrop(WebElement source, WebDriver driver, WebElement target) {
		act = new Actions(driver);
		act.clickAndHold(source).perform();
		;
		act.dragAndDrop(source, target).perform();
		;
		act.release().perform();
	}

	/**
	 * Switching to respective tab on basis of Title
	 * 
	 * @param driver
	 * @param title
	 */
	public void switchToTab(WebDriver driver, String title) {
		Set<String> tabs = driver.getWindowHandles();
		Iterator<String> itr = tabs.iterator();
		while (itr.hasNext()) {
			String tabTitle = driver.switchTo().window(itr.next()).getTitle();
			if (tabTitle.equalsIgnoreCase(title)) {
				break;
			}
		}
	}

	/**
	 * Accept Alert
	 * 
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver) {
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

	/**
	 * Dismiss Alert
	 * 
	 * @param driver
	 */
	public void dismissAlert(WebDriver driver) {
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
	}
	
	public Object javascriptExecutor(String script,WebDriver driver, WebElement element)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		return js.executeScript(script, element);
		
	}
	
	public void captureScreenshot(WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File srcFile = ts.getScreenshotAs(OutputType.FILE);
		File destFile = new File("./screenshots/failure.png");
		Files.copy(srcFile, destFile);
	}
	
}
