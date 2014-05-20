package com.tyyd.waptest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.Select;

import com.tyyd.extension.ExcelHandle;
import com.tyyd.extension.TakeScreenshotOnFailureRule;

public class tyyd_wap_search_1002 {
	private static String dataFile = "testdata.xls";
	private static String searchName;
	private static WebDriver driver;
	private static String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();
		  
	@BeforeClass
	public static void start() throws Exception {
		baseUrl = ExcelHandle.readExcel(dataFile, 0, 0, 1);
		searchName = ExcelHandle.readExcel(dataFile, 0, 6, 1);
		driver =  new FirefoxDriver();
//		driver =  new HtmlUnitDriver();
	}
		  
	@Rule
	public TestRule myScreenshot = new TakeScreenshotOnFailureRule(driver, "tyyd_wap_search_1002");
	
	@Before
	public void setUp() throws Exception {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void TyydWapSearch1002() throws Exception {
		driver.navigate().to(baseUrl+"/index.action?f=0");
	    driver.findElement(By.name("text")).clear();
	    driver.findElement(By.name("text")).sendKeys(searchName);
	    new Select(driver.findElement(By.name("type"))).selectByVisibleText("×÷Õß");
	    driver.findElement(By.cssSelector("input.btn")).click();
	    assertEquals("Ê×Ò³> ËÑË÷", driver.findElement(By.cssSelector("p")).getText());
	    assertEquals(searchName, driver.findElement(By.cssSelector("font")).getText());

	}
	
	@After
	public void tearDown() throws Exception {
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
			}
		}
	
	@AfterClass
	public static void quit() throws Exception {
		driver.quit();
		}
	
	private boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
			} catch (NoSuchElementException e) {
				return false;
				}
		}
	
	private boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
			} catch (NoAlertPresentException e) {
				return false;
				}
		}

	private String closeAlertAndGetItsText() {
		try {
			Alert alert = driver.switchTo().alert();
			String alertText = alert.getText();
			if (acceptNextAlert) {
				alert.accept();
				} else {
					alert.dismiss();
					}
			return alertText;
			} finally {
				acceptNextAlert = true;
				}
		}



}
