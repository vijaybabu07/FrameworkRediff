package com.rediff.qa.testcases;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.rediff.qa.base.Base;
import com.rediff.qa.pages.LandingPage;
import com.rediff.qa.pages.SignInPage;

public class LandingPageTest extends Base {
	LandingPage landingobject;
	SignInPage signinpg;

	public LandingPageTest() throws Exception {
		super();
	}
	
	//Best Practices
	//testcases shouldd be independent of each other
	//launch browser before every test
	//close browser after every test/class

	@BeforeMethod
	public void setup() throws Exception {
		initialize();
		landingobject = new LandingPage();
	}

	@Test(priority = 1)
	public void Landingtitle_test() {
		String title = landingobject.LandingPageTitle();
		Assert.assertEquals(title,
				"Rediff.com: News | Rediffmail | Stock Quotes | Shopping");
	}

	@Test(priority = 2)
	public void SignInDisplay_test() {
		boolean signInDisplay = landingobject.SignIn_Displayed();
		Assert.assertTrue(signInDisplay);
	}

	@Test(priority = 3)
	public void SignInClick_test() throws Exception {
		signinpg = landingobject.SignIn_Click();
	}

	@AfterMethod
	public void teardown() {
		driver.close();
	}

}
