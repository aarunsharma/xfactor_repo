package com.xfactor.generics;

import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserFactory {
	public static WebDriver launchBrowser(String browserName) throws IOException {
		WebDriver driver = null;
		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			Map<String, Object> prefs = new LinkedHashMap<String, Object>();
			prefs.put("download.default_directory", System.getProperty("user.dir") + File.separator + "resources");
			ChromeOptions chrOption = new ChromeOptions();
			chrOption.addArguments("--disable-notifications");
			chrOption.setExperimentalOption("prefs", prefs);
			//System.out.println(chrOption.getExperimentalOption("prefs"));
			driver = new ChromeDriver(chrOption);
		} else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			FirefoxProfile fp = new FirefoxProfile();
			fp.setPreference("browser.download.folderList", 2);//Instructing FF to use diff download location
			fp.setPreference("browser.download.dir", System.getProperty("user.dir") + File.separator +"resources");
			fp.setPreference("browser.helperApps.neverAsk.saveToDisk",new FileUtils().getCommonInfo("extensions"));
			FirefoxOptions foxOption = new FirefoxOptions();
			foxOption.setProfile(fp);
			foxOption.addPreference("dom.webnotifications.enabled", false);
			driver = new FirefoxDriver(foxOption);
		}
		return driver;
	}

}
