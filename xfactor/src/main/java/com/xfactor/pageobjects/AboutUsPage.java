package com.xfactor.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class AboutUsPage extends BasePage{
	
	
	public AboutUsPage(WebDriver driver) 
	{
		super(driver);
		PageFactory.initElements(driver, this);
	}
}
