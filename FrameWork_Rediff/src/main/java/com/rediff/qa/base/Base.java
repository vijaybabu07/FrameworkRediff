package com.rediff.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import jxl.Sheet;
import jxl.Workbook;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.rediff.qa.util.TestUtil;

public class Base {
	public static WebDriver driver;
	public static Properties prop;
	public Workbook wb;
	public Sheet s;
	public WritableWorkbook wb_out;
	public WritableSheet s_out;
	public Base() throws Exception {
		prop = new Properties();
		FileInputStream fin = new FileInputStream(
				"D:\\selenium\\WD\\Work\\FrameWork_Rediff\\src\\main\\java\\com\\rediff\\qa\\config\\config.properties");
		prop.load(fin);
		/*FileInputStream faccount=new FileInputStream("‪‪D:\\selenium\\WD\\Work\\FrameWork_Rediff\\rediffaccount.xls");
		wb=Workbook.getWorkbook(faccount);
		s=wb.getSheet("Sheet1");
		FileOutputStream faccount_output=new FileOutputStream("‪D:\\selenium\\WD\\DDT\\rediffaccount_op.xls");
		wb_out=Workbook.createWorkbook(faccount_output);
		s_out=wb_out.createSheet("Sheet1", 1);*/
	}

	public void initialize() {
		String browsername = prop.getProperty("browser");
		if (browsername.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"E:\\Sel\\Jars\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browsername.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					"E:\\Sel\\Jars\\geckodriver.exe");
			driver = new FirefoxDriver();

		} else if (browsername.equals("edge")) {
			/*
			 * System.setProperty("webdriver.gecko.driver",
			 * "E:\\Sel\\Jars\\geckodriver.exe"); WebDriver driver=new
			 * FirefoxDriver();
			 */
			// edge browser
			System.out.println("edge browser");

		}
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts()
				.pageLoadTimeout(TestUtil.pageload_timeout, TimeUnit.SECONDS);
		driver.manage().timeouts()
				.implicitlyWait(TestUtil.implicit_wait, TimeUnit.SECONDS);
	}

}
