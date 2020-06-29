package com.rediff.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.rediff.qa.base.Base;
import com.rediff.qa.pages.LandingPage;
import com.rediff.qa.pages.RediffHomeAfterLogoutPage;
import com.rediff.qa.pages.RediffHomePage;
import com.rediff.qa.pages.SignInPage;

public class LogoutTest extends Base {
	public RediffHomePage rpage;
	public SignInPage spage;
	public LandingPage lpage;
	public LogoutTest() throws Exception {
		super();
		
	}
	@BeforeMethod
	public void setup() throws Exception
	{
		initialize();
		spage=new SignInPage();
		rpage=new RediffHomePage();
		lpage=new LandingPage();
		lpage.SignIn_Click();
		spage.login(prop.getProperty("username"), prop.getProperty("password"));
	
		
	}
	
	@Test(priority=1)
	public void logoutDispplayed()
	{
		boolean logout_displayed=rpage.verifyLogoutDisplayed();
		Assert.assertTrue(logout_displayed);
		
	}
	@Test(priority=2)
	public void logoutEnabled()
	{
		boolean logout_enabled=rpage.verifyLogoutEnabled();
		Assert.assertTrue(logout_enabled);
		
	}
	@Test(priority=3)
	public void logout() throws Exception
	{
		rpage.clickLogout();
		
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.close();
	}
	

}
