package com.xfactor.generics;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import com.xfactor.features.BaseFeatures;
import com.xfactor.features.HomeFeatures;
import com.xfactor.features.LoginFeatures;

public abstract class BaseTest {
	public WebDriver driver;
	private WebdriverUtils wdg = new WebdriverUtils();
	public FileUtils fu = new FileUtils();
	// private

	@BeforeTest
	public void preTest() throws IOException {
		String url = fu.getCommonInfo("url");
		String browser = fu.getCommonInfo("browser");
		driver = BrowserFactory.launchBrowser(browser);
		wdg.waitForAllElements(driver);
		driver.manage().window().maximize();
		driver.get(url);
		HomeFeatures hf = new HomeFeatures(driver);
		hf.verifyHomePage();

	}

	@BeforeClass
	public void preCondition() throws IOException {
		/*
		 * ((JavascriptExecutor) driver).executeScript("window.open()"); Set<String>
		 * tabs = driver.getWindowHandles(); Iterator<String> itr = tabs.iterator();
		 * dashboardTab = itr.next(); simulatortab = itr.next();
		 * 
		 * driver.switchTo().window(simulatortab);
		 * driver.get(fu.getCommonInfo("simulator_url"));
		 */
		// driver.switchTo().window(dashboardTab);
		HomeFeatures hf = new HomeFeatures(driver);
		LoginFeatures lf = new LoginFeatures(driver);
		BaseFeatures bf = new BaseFeatures(driver);
		hf.clickOnLogin();
		lf.login(fu.getCommonInfo("username"),fu.getCommonInfo("password"));
		bf.verifyDashBoard();
	}

	@AfterClass
	public void postCondition() throws InterruptedException, IOException {

		BaseFeatures bf = new BaseFeatures(driver);
		HomeFeatures hf = new HomeFeatures(driver);
		bf.logout();
		hf.verifyHomePage();

	}

	@AfterTest
	public void teardown() throws IOException {

		driver.quit();

	}

	public WebDriver getDriverInstance() {

		return driver;
	}

}
