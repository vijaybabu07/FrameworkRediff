package com.rediff.qa.testcases;

import jxl.JXLException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.rediff.qa.base.Base;
import com.rediff.qa.pages.AccountCreationPage;
import com.rediff.qa.pages.LandingPage;

public class AccountCreationTest extends Base{

	LandingPage lpage;
	AccountCreationPage apage;
	public AccountCreationTest() throws Exception 
	{
		super();
		
	}
	@BeforeMethod
	public void setup() throws Exception
	{
		initialize();
		lpage=new LandingPage();
		apage=new AccountCreationPage();
		
	}
	@Test
	public void addUser() throws JXLException, Exception
	{
		apage.EnterUserDetails();
	}

}
