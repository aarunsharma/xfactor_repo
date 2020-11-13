package com.xfactor.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	@FindBy(xpath = "//div[@id='navbarsExample05']//a[text()='Home']")
	private WebElement homeLink;

	@FindBy(xpath = "//div[@id='navbarsExample05']//a[text()='Home']/parent::li/following-sibling::li/a[contains(text(),'About')]")
	private WebElement hover_AboutUs;

	@FindBy(xpath = "//div[@id='navbarsExample05']//a[text()='About us']")
	private WebElement aboutUsLink;

	@FindBy(xpath = "//div[@id='navbarsExample05']//a[text()='FAQs']")
	private WebElement faqsLink;

	@FindBy(xpath = "//div[@id='navbarsExample05']//a[text()='Contact Us']")
	private WebElement contactUsLink;

	@FindBy(xpath = "//div[@id='navbarsExample05']//a[text()='LOGIN']")
	private WebElement loginLink;
	
	@FindBy(tagName = "title")
	private WebElement title;
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getHomeLink() {
		return homeLink;
	}

	public WebElement getHover_AboutUs() {
		return hover_AboutUs;
	}

	public WebElement getAboutUsLink() {
		return aboutUsLink;
	}

	public WebElement getFaqsLink() {
		return faqsLink;
	}

	public WebElement getContactUsLink() {
		return contactUsLink;
	}

	public WebElement getLoginLink() {
		return loginLink;
	}
	public WebElement getTitle() {
		return title;
	}

}
