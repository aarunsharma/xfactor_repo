package com.xfactor.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PrivacyPolicyPage extends BasePage
{
//	@FindBy(tagName="title")
//	private WebElement title;
	public PrivacyPolicyPage(WebDriver driver) 
	{
		super(driver);
		PageFactory.initElements(driver, this);
	}
//	public WebElement getTitle() {
//		return title;
//	}
}
