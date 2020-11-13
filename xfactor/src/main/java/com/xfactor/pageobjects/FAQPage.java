package com.xfactor.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FAQPage extends BasePage {
	@FindBy(xpath = "//label[text()='Subscriptions']")
	private WebElement subscriptions;

	@FindBy(xpath = "//label[text()='Account Maintenance']")
	private WebElement accMaintenance;

	@FindBy(xpath = "//label[text()='Search Box']")
	private WebElement searchBox;

	@FindBy(xpath = "//label[text()='Help']")
	private WebElement help;

	@FindBy(xpath = "//label[text()='About XFactor']")
	private WebElement aboutXfactor;

	@FindBy(xpath = "//label[text()='Site-Specific Page']")
	private WebElement siteSpecificPage;

	@FindBy(xpath = "//label[text()='Interested Vendors']")
	private WebElement interestedVendors;

	@FindBy(xpath = "//label[text()='What’s Coming']")
	private WebElement whatsComing;

	@FindBy(xpath = "(//div[@class='row']/div/p)[1]")
	private WebElement firstQuesOfEachCategory;

	public FAQPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public WebElement getSubscriptions() {
		return subscriptions;
	}

	public WebElement getAccMaintenance() {
		return accMaintenance;
	}

	public WebElement getSearchBox() {
		return searchBox;
	}

	public WebElement getHelp() {
		return help;
	}

	public WebElement getAboutXfactor() {
		return aboutXfactor;
	}

	public WebElement getSiteSpecificPage() {
		return siteSpecificPage;
	}

	public WebElement getInterestedVendors() {
		return interestedVendors;
	}

	public WebElement getWhatsComing() {
		return whatsComing;
	}

	public WebElement getFirstQuesOfEachCategory() {
		return firstQuesOfEachCategory;
	}

}
