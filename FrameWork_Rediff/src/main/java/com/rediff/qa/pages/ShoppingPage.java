package com.rediff.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.rediff.qa.base.Base;

public class ShoppingPage extends Base{
	@FindBy(xpath="//span[@id='topcat3']") WebElement mobile;
	@FindBy(xpath="//a[contains(@href,'Mobiles_earphones')]") WebElement mobile_earphones;

	public ShoppingPage() throws Exception {
		PageFactory.initElements(driver,this);
	}
	
	public boolean verifyMobileDisplay()
	{
		return mobile.isDisplayed();
	}
	public EarphonesPage selectMobileEarphones() throws Exception
	{
		Actions action=new Actions(driver);
		action.moveToElement(mobile).build().perform();
		Thread.sleep(3000);
		action.moveToElement(mobile_earphones).build().perform();
		//action.moveToElement(mobile_earphones).click().build().perform();
		mobile_earphones.click();
		Thread.sleep(3000);
		return new EarphonesPage();
	}
	

}
