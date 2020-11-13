package com.xfactor.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class MyXfactorHomePage extends BasePage {
	@FindBy(xpath = "(//div[@class='thumb']/select)[1]")
	private WebElement searchBySourceDropDown;

	@FindBy(xpath = "(//div[@class='thumb']/select)[3]")
	private WebElement searchByCategoryDropDown;

	@FindBy(xpath = "//input[@value='active']/following-sibling::span")
	private WebElement activeRadioBtn;

	@FindBy(xpath = "//input[@value='inactive']/following-sibling::span")
	private WebElement inactiveRadioBtn;

	@FindBy(xpath = "//input[@value='both']/following-sibling::span")
	private WebElement bothRadioBtn;

	@FindBy(xpath = "(//div[@class='thumb text-center']/input)[1]")
	private WebElement submitBtn;

	@FindBys(@FindBy(xpath = "//strong[text()='TITLE:']/following-sibling::a"))
	private List<WebElement> opportunityLinks;

	@FindBy(xpath = "//*[@id=\"home\"]/div[2]/div[2]/div/div[2]/div/p[1]")
	private WebElement opportunitySource;

	@FindBy(xpath = "//*[@id=\"home\"]/div[2]/div[2]/div/div[2]/div/p[2]")
	private WebElement opportunityCategory;

	@FindBy(xpath = "(//a[text()='Page Size'])[1]/parent::li/following-sibling::li/select")
	private WebElement pagesizeDropDown;

	@FindBy(xpath = "(//a[text()='Next'])[1]")
	private WebElement nextButton;

	@FindBy(xpath = "//div[text()='Error!']/following-sibling::div")
	private WebElement errorMsg;

	@FindBy(xpath="//span[text()='Search by RFQ ID']")
	private WebElement searchByRFQIDDropDown;
	
	public MyXfactorHomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public WebElement getSearchBySourceDropDown() {
		return searchBySourceDropDown;
	}

	public WebElement getActiveRadioBtn() {
		return activeRadioBtn;
	}

	public WebElement getInactiveRadioBtn() {
		return inactiveRadioBtn;
	}

	public WebElement getBothRadioBtn() {
		return bothRadioBtn;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}

	public WebElement getPagesizeDropDown() {
		return pagesizeDropDown;
	}

	public WebElement getNextButton() {
		return nextButton;
	}

	public WebElement getErrorMsg() {
		return errorMsg;
	}

	public List<WebElement> getOpportunityLinks() {
		return opportunityLinks;
	}

	public WebElement getOpportunitySource() {
		return opportunitySource;
	}

	public WebElement getSearchByCategoryDropDown() {
		return searchByCategoryDropDown;
	}

	public WebElement getOpportunityCategory() {
		return opportunityCategory;
	}
	public WebElement getSearchByRFQIDDropDown() {
		return searchByRFQIDDropDown;
	}
}
