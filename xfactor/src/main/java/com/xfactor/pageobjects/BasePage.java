package com.xfactor.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//dashboard Page
public class BasePage {

	@FindBy(xpath = "//a[text()='LOGOUT']")
	private WebElement logoutLink;
	
	@FindBy(tagName = "title")
	private WebElement title;
	
	@FindBy(tagName="body")
	private WebElement body;
	
	@FindBy(xpath = "//a[text()='Dashboard']")
	private WebElement dashboardLink;

	@FindBy(xpath = "//div[@id='navbarsExample05']/div/ul/li/a[contains(text(),'About')]")
	private WebElement aboutUsHoverMenu;

	@FindBy(xpath = "//div[@id='navbarsExample05']/div/ul/li/ul/li/a[text()='About us']")
	private WebElement aboutUsLink;

	@FindBy(xpath="//a[text()='FAQs']")
	private WebElement faqLink;
	
	@FindBy(id="quick-subscription-email")
	private WebElement subscriptionEmailField;
	
	@FindBy(id="quick-subscription-button")
	private WebElement subscriptionBtn;
	
	@FindBy(xpath="//div[text()='Notice!']/following-sibling::div")
	private WebElement subscriptionSuccessMsg;
	
	@FindBy(xpath="//a[text()='Privacy Policy']")
	private WebElement privacyPolicyLink;
	
	@FindBy(xpath="//div[@id='navbarsExample05']/div/ul/li/a[contains(text(),'Xfactor')]")
	private WebElement myXfactorHoverMenu;
	
	@FindBy(xpath="//div[@id='navbarsExample05']/div/ul/li/ul/li/a[text()='My Profile']")
	private WebElement myProfileLink;
	
	@FindBy(xpath="//a[text()='My Xfactor Home']")
	private WebElement myXfactorHomeLink;
	
	public BasePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getLogoutLink() {
		return logoutLink;
	}

	public WebElement getTitle() {
		return title;
	}

	public WebElement getDashboardLink() {
		return dashboardLink;
	}

	public WebElement getAboutUsHoverMenu() {
		return aboutUsHoverMenu;
	}

	public WebElement getAboutUsLink() {
		return aboutUsLink;
	}
	public WebElement getFaqLink() {
		return faqLink;
	}
	public WebElement getSubscriptionEmailField() {
		return subscriptionEmailField;
	}
	public WebElement getSubscriptionBtn() {
		return subscriptionBtn;
	}
	public WebElement getSubscriptionSuccessMsg() {
		return subscriptionSuccessMsg;
	}
	public WebElement getPrivacyPolicyLink() {
		return privacyPolicyLink;
	}
	public WebElement getMyXfactorHoverMenu() {
		return myXfactorHoverMenu;
	}
	public WebElement getMyProfileLink() {
		return myProfileLink;
	}
	public WebElement getMyXfactorHomeLink() {
		return myXfactorHomeLink;
	}
	public WebElement getBody() {
		return body;
	}
}
