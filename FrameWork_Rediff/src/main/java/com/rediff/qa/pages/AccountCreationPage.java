package com.rediff.qa.pages;

import jxl.JXLException;
import jxl.write.Label;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.rediff.qa.base.Base;

public class AccountCreationPage extends Base
{
	public Select sel;
	public Alert al;
	public Label l;
	@FindBy(xpath="//table[@id='tblcrtac']/tbody/tr[3]/td[3]/input") WebElement fullname;
	@FindBy(xpath="//input[starts-with(@name,'passwd')]") WebElement passwd;
	@FindBy(xpath="//input[starts-with(@name,'confirm_passwd')]") WebElement confirm_passwd;
	@FindBy(xpath="//input[contains(@name,'chk_altemail')]") WebElement alt_email;
	@FindBy(xpath="//select[contains(@name,'hint')]") WebElement select_hint;
	@FindBy(xpath="//*[@id='hid_countryCode']") WebElement mob_code;
	//*[@id='hid_countryCode' and (@value='93']
	@FindBy(xpath="//select[contains(@name,'DOB_Day')]") WebElement day;
	@FindBy(xpath="//select[contains(@name,'DOB_Month')]") WebElement month;
	@FindBy(xpath="//select[contains(@name,'DOB_Year')]") WebElement year;
	@FindBy(xpath="//input[contains(@name,'gender') and (@value='f')]") WebElement gender_f;
	@FindBy(xpath="//*[@id='Register']") WebElement createAccount_Button;
	
	public AccountCreationPage() throws Exception {
		PageFactory.initElements(driver, this);
	}
	
	public void EnterUserDetails() throws Exception, JXLException
	{
		int rowsize=s.getRows();
		int colsize=s.getColumns();
		for(int i=1;i<rowsize;i++)
		{
			for(int j=0;j<colsize;j++)
			{
				String name=s.getCell(j, i).getContents();
				fullname.sendKeys(name);
				String pwd=s.getCell(j, i).getContents();
				passwd.sendKeys(pwd);
				String confirm_pwd=s.getCell(j, i).getContents();
				confirm_passwd.sendKeys(confirm_pwd);
				sel=new Select(month);
				sel.selectByVisibleText(s.getCell(j, i).getContents());
				createAccount_Button.click();
				al=driver.switchTo().alert();
				al.dismiss();
				/*String al_msg=al.getText();
				l=new Label(0, 0, al_msg);
				s_out.addCell(l);
				wb_out.write();
				wb_out.close();*/
			}
			
		}
		
		
		
		
	}
	
	

}
