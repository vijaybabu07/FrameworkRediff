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

public class SignInPageTest extends Base {
	LandingPage landingobject;
	SignInPage signinpg;

	public SignInPageTest() throws Exception {
		super();
	}

	@BeforeMethod
	public void setup() throws Exception {
		initialize();
		landingobject=new LandingPage();
		signinpg = new SignInPage();
		landingobject.SignIn_Click();
	}

	@Test(priority = 1)
	public void signIntitle_test() {
		String title = signinpg.Sigin_GetTitle();
		Assert.assertEquals(title,
				"Rediffmail");
	}

	@Test(priority = 2)
	public void KeepMeSigned_test() {
		boolean keepmesigned= signinpg.KeepMeSigned_selected();
		Assert.assertTrue(keepmesigned);
	}

	@Test(priority = 3)
	public void login_test() throws Exception  {
		signinpg.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	@AfterMethod
	public void teardown() {
		driver.close();
	}

}
