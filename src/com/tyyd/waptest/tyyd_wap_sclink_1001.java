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

import com.tyyd.extension.ExcelHandle;
import com.tyyd.extension.TakeScreenshotOnFailureRule;

public class tyyd_wap_sclink_1001 {
	private static String dataFile = "testdata.xls";
	private static WebDriver driver;
	private static String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();
		  
	@BeforeClass
	public static void start() throws Exception {
//		baseUrl = TxtHandle.readData(dataFile, 0);
		baseUrl = ExcelHandle.readExcel(dataFile, 0, 0, 1);
		driver =  new FirefoxDriver();
	}
		  
	@Rule
	public TestRule myScreenshot = new TakeScreenshotOnFailureRule(driver, "tyyd_wap_sclink_1001");
	
	@Before
	public void setUp() throws Exception {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void TyydWapSclink1001_1() throws Exception {
		driver.navigate().to(baseUrl+"/index.action?f=0");
	    driver.findElement(By.linkText("书城")).click();
	    driver.findElement(By.linkText("青春")).click();
	    assertEquals("首页> 分类> 甜美青春", driver.findElement(By.cssSelector("p")).getText());

	}
	
	@Test
	public void TyydWapSclink1001_2() throws Exception {
		driver.navigate().to(baseUrl+"/index.action?f=0");
	    driver.findElement(By.linkText("书城")).click();
	    driver.findElement(By.linkText("经管")).click();
	    assertEquals("首页> 分类> 经管励志", driver.findElement(By.cssSelector("p")).getText());

	}
	
	@Test
	public void TyydWapSclink1001_3() throws Exception {
		driver.navigate().to(baseUrl+"/index.action?f=0");
	    driver.findElement(By.linkText("书城")).click();
	    driver.findElement(By.linkText("生活")).click();
	    assertEquals("首页> 分类> 生活时尚", driver.findElement(By.cssSelector("p")).getText());

	}
	
	@Test
	public void TyydWapSclink1001_4() throws Exception {
		driver.navigate().to(baseUrl+"/index.action?f=0");
	    driver.findElement(By.linkText("书城")).click();
	    driver.findElement(By.linkText("短篇")).click();
	    assertEquals("首页> 分类> 短篇小品", driver.findElement(By.cssSelector("p")).getText());

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
