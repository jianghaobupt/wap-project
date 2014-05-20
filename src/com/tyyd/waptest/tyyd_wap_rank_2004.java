package com.tyyd.waptest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
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
import com.tyyd.extension.TxtHandle;

public class tyyd_wap_rank_2004 {
	private static String datafile = "testdata.xls";
	private static WebDriver driver;
	private static String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();
		  
	@BeforeClass
	public static void start() throws Exception {
		baseUrl = ExcelHandle.readExcel(datafile, 0, 0, 1);
		driver =  new FirefoxDriver();
	}
		  
	@Rule
	public TestRule myScreenshot = new TakeScreenshotOnFailureRule(driver, "tyyd_wap_rank_2004");

	@Before
	public void setUp() throws Exception {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void TyydWapRank2004() throws Exception {
		driver.navigate().to(baseUrl+"/index.action?f=3");
		
		driver.findElement(By.linkText("排行")).click();
		try {
			assertTrue(isElementPresent(By.linkText("热书榜")));
		} catch (Error e){
			verificationErrors.append(e.toString()+"link isn't present!\n");
		}
		driver.findElement(By.linkText("热书榜")).click();
		driver.findElement(By.linkText("女生")).click();
		assertEquals("女生", driver.findElement(By.xpath("//div[3]/div/span")).getText());
		assertEquals("首页> 榜单> 热书榜", driver.findElement(By.cssSelector("p")).getText());
		driver.findElement(By.linkText("【周】")).click();
		assertEquals("【周】", driver.findElement(By.xpath("//div[4]/div/span")).getText());
		driver.findElement(By.linkText("【月】")).click();
		assertEquals("【月】", driver.findElement(By.xpath("//div[4]/div/span")).getText());
		driver.findElement(By.linkText("【日】")).click();
		assertEquals("【日】", driver.findElement(By.xpath("//div[4]/div/span")).getText());
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
