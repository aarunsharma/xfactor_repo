package com.xfactor.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends HomePage {
	@FindBy(xpath = "//input[@placeholder='USERNAME']")
	private WebElement userNameField;

	@FindBy(xpath = "//input[@placeholder='PASSWORD']")
	private WebElement passwordField;

	@FindBy(xpath = "//button[text()='LOGIN']")
	private WebElement loginBtn;

	@FindBy(xpath = "//a[text()='Register Now']")
	private WebElement registerNowLink;

	@FindBy(xpath = "//a[text()='Forgot Username?']")
	private WebElement forgetUsernameLink;

	@FindBy(xpath = "//a[text()='Forgot Password?']")
	private WebElement forgetPasswordLink;

	@FindBy(xpath="//div[@id='growls-default']//div[@class='growl-message']")
	private WebElement loginErrorMsg;
	
	public LoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public WebElement getUserNameField() {
		return userNameField;
	}

	public WebElement getPasswordField() {
		return passwordField;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}

	public WebElement getRegisterNowLink() {
		return registerNowLink;
	}

	public WebElement getForgetUsernameLink() {
		return forgetUsernameLink;
	}

	public WebElement getForgetPasswordLink() {
		return forgetPasswordLink;
	}
	public WebElement getLoginErrorMsg() {
		return loginErrorMsg;
	}

}
