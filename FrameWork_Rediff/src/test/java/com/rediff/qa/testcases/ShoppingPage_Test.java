package com.rediff.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.rediff.qa.base.Base;
import com.rediff.qa.pages.LandingPage;
import com.rediff.qa.pages.ShoppingPage;

public class ShoppingPage_Test extends Base{
	LandingPage lpage;
	ShoppingPage spage;

	public ShoppingPage_Test() throws Exception {
		super();
		
	}
	@BeforeMethod
	public void setup() throws Exception
	{
		initialize();
		lpage=new LandingPage();
		spage=new ShoppingPage();
		lpage.clickShopping();		
		
	}
	@Test(priority=1)
	public void checkMobile()
	{
		boolean mobile_display=spage.verifyMobileDisplay();
		Assert.assertTrue(mobile_display);
	}
	@Test(priority=2)
	public void selectMobileEarphone() throws Exception
	{
		spage.selectMobileEarphones();
		//Thread.sleep(2000);
	}
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
	
	

}
