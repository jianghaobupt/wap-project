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

import com.tyyd.extension.TakeScreenshotOnFailureRule;
import com.tyyd.extension.TxtHandle;

public class tyyd_wap_login_4003 {
	private static String datafile = "testdata.txt";
	private static WebDriver driver;
	private static String baseUrl;
	private static String othuserName;
	private static String othpassWd;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();
		  
	@BeforeClass
	public static void start() throws Exception {
		baseUrl = TxtHandle.readData(datafile, 0);
		othuserName = TxtHandle.readData(datafile, 3);
		othpassWd = TxtHandle.readData(datafile, 4);
		driver =  new FirefoxDriver();
	}
		  
	@Rule
	public TestRule myScreenshot = new TakeScreenshotOnFailureRule(driver, "tyyd_wap_login_4003");

	@Before
	public void setUp() throws Exception {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void TyydWapLogin4003() throws Exception {
		driver.navigate().to(baseUrl);
		assertEquals("ע��", driver.findElement(By.xpath("//div[2]/span[2]/a[1]")).getText());
		try {
			assertTrue(isElementPresent(By.linkText("��¼")));
		} catch (Error e){
			verificationErrors.append(e.toString()+"login link isn't present!\n");
		}
		driver.findElement(By.linkText("��¼")).click();
	    driver.findElement(By.linkText("����΢��")).click();
	    driver.findElement(By.id("userId")).clear();
	    driver.findElement(By.id("userId")).sendKeys(othuserName);
	    driver.findElement(By.id("passwd")).clear();
	    driver.findElement(By.id("passwd")).sendKeys(othpassWd);
		driver.findElement(By.cssSelector("input[type=\"image\"]")).click();
		assertEquals("��ӭ������ ���� ���û���", driver.findElement(By.xpath("//div[2]/ul/li[1]")).getText());
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

