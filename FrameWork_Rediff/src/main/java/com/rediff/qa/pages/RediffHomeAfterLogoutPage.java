package com.rediff.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.rediff.qa.base.Base;

public class RediffHomeAfterLogoutPage extends Base{
	@FindBy(xpath="//a[@href='http://www.rediff.com']/b") WebElement rediffhome;

	public RediffHomeAfterLogoutPage() throws Exception {
		PageFactory.initElements(driver,this);
		
	}
	
	public boolean verifyRediffHomelink()
	{
		return rediffhome.isDisplayed();
	}
	public LandingPage clickRediffHomelink() throws Exception
	{
		rediffhome.click();
		return new LandingPage();
	}
}
