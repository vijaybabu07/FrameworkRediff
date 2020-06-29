package com.rediff.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.rediff.qa.base.Base;

public class LandingPage extends Base {

//	SignInPage landingobject;

	// Page Factory
	@FindBy(xpath = "//a[@title='Create Rediffmail Account']")
	WebElement createAccount;
	@FindBy(xpath = "//a[@href='https://money.rediff.com']")
	WebElement money;
	@FindBy(xpath = "//p[@id='signin_info']/a")
	WebElement SignIn;
	@FindBy(xpath="//a[@title='Online Shopping']") WebElement shop;

	// Initialising page objects
	public LandingPage() throws Exception {
		PageFactory.initElements(driver, this);
		// PageFactory.initElements(driver, LandingPage.class);
	}

	// Actions
	public String LandingPageTitle() {
		return driver.getTitle();
	}

	public boolean SignIn_Displayed() {
		return SignIn.isDisplayed();
	}

	public SignInPage SignIn_Click() throws Exception {
		SignIn.click();
		return new SignInPage();
	}
	public MoneyPage clickMoney()
	{
		money.click();
		return new MoneyPage();
	}
	public ShoppingPage clickShopping() throws Exception
	{
		shop.click();
		return new ShoppingPage();
	}
	public AccountCreationPage clickCreateAccount() throws Exception
	{
		createAccount.click();
		return new AccountCreationPage();
	}

}
