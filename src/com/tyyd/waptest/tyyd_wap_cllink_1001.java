package com.tyyd.waptest;

import static org.junit.Assert.*;

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

import com.tyyd.extension.ExcelHandle;
import com.tyyd.extension.TakeScreenshotOnFailureRule;

public class tyyd_wap_cllink_1001 {
	private static String dataFile = "testdata.xls";
	private static WebDriver driver;
	private static String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();
		  
	@BeforeClass
	public static void start() throws Exception {
		baseUrl = ExcelHandle.readExcel(dataFile, 0, 0, 1);
		driver =  new FirefoxDriver();
	}
		  
	@Rule
	public TestRule myScreenshot = new TakeScreenshotOnFailureRule(driver, "tyyd_wap_cllink_1001");
	
	@Before
	public void setUp() throws Exception {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void TyydWapCllink1001_1() throws Exception {
		driver.navigate().to(baseUrl+"/index.action?f=0");
	    driver.findElement(By.linkText("品质")).click();
	    assertTrue(isElementPresent(By.linkText("更多分类精选")));
	    driver.findElement(By.linkText("更多分类精选")).click();
	    assertEquals("首页> 分类推荐", driver.findElement(By.xpath("//div[2]/p")).getText());

	}
	
	@Test
	public void TyydWapCllink1001_2() throws Exception {
		driver.navigate().to(baseUrl+"/index.action?f=0");
	    driver.findElement(By.linkText("男生")).click();
	    assertTrue(isElementPresent(By.linkText("更多分类精选")));
	    driver.findElement(By.linkText("更多分类精选")).click();
	    assertEquals("首页> 分类推荐", driver.findElement(By.xpath("//div[2]/p")).getText());

	}
	
	@Test
	public void TyydWapCllink1001_3() throws Exception {
		driver.navigate().to(baseUrl+"/index.action?f=0");
	    driver.findElement(By.linkText("女生")).click();
	    assertTrue(isElementPresent(By.linkText("更多分类精选")));
	    driver.findElement(By.linkText("更多分类精选")).click();
	    assertEquals("首页> 分类推荐", driver.findElement(By.xpath("//div[2]/p")).getText());

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
