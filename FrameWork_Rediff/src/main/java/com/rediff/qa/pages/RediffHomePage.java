package com.rediff.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.rediff.qa.base.Base;

public class RediffHomePage extends Base{
	RediffHomePage rhomepage;
	
	@FindBy(xpath="//a[@class='rd_logout']") WebElement logout;
	
	public RediffHomePage() throws Exception
	{
		PageFactory.initElements(driver,this);
	}
	
	public boolean verifyLogoutDisplayed()
	{
		return logout.isDisplayed();
	}
	public boolean verifyLogoutEnabled()
	{
		return logout.isEnabled();
	}
	public RediffHomeAfterLogoutPage clickLogout() throws Exception
	{
		logout.click();
		return new RediffHomeAfterLogoutPage();
	}
	
	
	

}
