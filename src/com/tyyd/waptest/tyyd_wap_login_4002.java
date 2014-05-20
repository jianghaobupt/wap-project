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

public class tyyd_wap_login_4002 {
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
		othuserName = TxtHandle.readData(datafile, 5);
		othpassWd = TxtHandle.readData(datafile, 6);
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
		assertEquals("×¢²á", driver.findElement(By.xpath("//div[2]/span[2]/a[1]")).getText());
		try {
			assertTrue(isElementPresent(By.linkText("µÇÂ¼")));
		} catch (Error e){
			verificationErrors.append(e.toString()+"login link isn't present!\n");
		}
		driver.findElement(By.linkText("µÇÂ¼")).click();
	    driver.findElement(By.linkText("ÌÚÑ¶Î¢²©")).click();
//	    if(isElementPresent(By.id("switch_login"))){
//	    	driver.findElement(By.id("switch_login")).click();
//	    }

	    	driver.findElement(By.xpath("//a[@id='switch_login']")).click();

	    
	    driver.findElement(By.id("u")).click();
	    driver.findElement(By.id("u")).clear();
	    driver.findElement(By.id("u")).sendKeys(othuserName);
	    driver.findElement(By.id("p")).clear();
	    driver.findElement(By.id("p")).sendKeys(othpassWd);
	    driver.findElement(By.id("login_button")).click();
	    try {
	        assertTrue(isElementPresent(By.id("reg_submit")));
	      } catch (Error e) {
	        verificationErrors.append(e.toString()+"qq login failure!\n");
	      }
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
