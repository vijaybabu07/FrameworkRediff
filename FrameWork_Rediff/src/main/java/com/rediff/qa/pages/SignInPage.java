package com.rediff.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.rediff.qa.base.Base;

public class SignInPage extends Base{
	@FindBy(xpath="//input[@id='login1']") WebElement username;
	@FindBy(xpath="//input[@id='password']") WebElement pwd;
	@FindBy(xpath="//input[@value='Sign in']") WebElement SignInbutton;
	@FindBy(id="remember") WebElement KeepMeSigned;
	
	
	public SignInPage() throws Exception
	{
		//PageFactory.initElements(driver, SignInPage.class);
		PageFactory.initElements(driver, this);
	}
	
	public String Sigin_GetTitle()
	{
		return driver.getTitle();
	}
	public boolean KeepMeSigned_selected()
	{
		return KeepMeSigned.isSelected();
	}
	public RediffHomePage login(String uname, String passwd) throws Exception
	{
		//username.sendKeys(prop.getProperty("username"));
		username.sendKeys(uname);
		pwd.sendKeys(passwd); 
		SignInbutton.click();
		return new RediffHomePage();
	}
	/*public void enterPassword()
	{
		pwd.sendKeys(prop.getProperty("password"));
	}*/
}
