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
import com.tyyd.extension.TxtHandle;

public class tyyd_wap_login_2003 {
//	private static String datafile = "testdata.txt";
	private static String datafile = "testdata.xls";
	  private static WebDriver driver;
	  private static String baseUrl;
	  private static String userName;
	  private static String passWd;
	  private boolean acceptNextAlert = true;
	  private StringBuffer verificationErrors = new StringBuffer();
	  
	  @BeforeClass
	  public static void start() throws Exception {
//		  baseUrl = TxtHandle.readData(datafile, 0);
		  baseUrl = ExcelHandle.readExcel(datafile, 0, 0, 1);
//		  userName = TxtHandle.readData(datafile, 1);
		  userName = ExcelHandle.readExcel(datafile, 0, 1, 1);
//		  passWd = TxtHandle.readData(datafile, 2);
		  passWd = ExcelHandle.readExcel(datafile, 0, 2, 1);

		  driver =  new FirefoxDriver();
	  }
	  
	  @Rule
	  public TestRule myScreenshot = new TakeScreenshotOnFailureRule(driver, "tyyd_wap_login_2003");

	  @Before
	  public void setUp() throws Exception {
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  }

	  @Test
	  public void TyydWapLogin2003() throws Exception {
		  driver.navigate().to(baseUrl);
		  assertEquals("注册", driver.findElement(By.xpath("//div[2]/span[2]/a[1]")).getText());
		  try {
			  assertTrue(isElementPresent(By.linkText("登录")));
		  } catch (Error e){
			  verificationErrors.append(e.toString()+"login link isn't present!\n");
		  }
		  driver.findElement(By.linkText("登录")).click();
		  driver.findElement(By.name("phoneNum")).clear();
		  driver.findElement(By.name("phoneNum")).sendKeys(userName);
		  driver.findElement(By.name("randomCode")).clear();
		  driver.findElement(By.name("randomCode")).sendKeys(passWd);
		  driver.findElement(By.name("autoLogin")).click();
		  driver.findElement(By.cssSelector("input.btn-yellow.fl")).click();
		  try {
			  assertTrue(isElementPresent(By.linkText(userName)));
		  } catch (Error e) {
			  //TODO:
		  }

		  driver.findElement(By.linkText("中心")).click();
		  try {
			  assertTrue(isElementPresent(By.linkText("资料")));
		  } catch (Error e) {
			  verificationErrors.append(e.toString()+"User login failure!\n");
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

