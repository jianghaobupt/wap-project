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

public class tyyd_wap_pagswitch_1001 {
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
	  public TestRule myScreenshot = new TakeScreenshotOnFailureRule(driver, "tyyd_wap_pagswitch_1001");

	  @Before
	  public void setUp() throws Exception {
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  }

	  @Test
	  public void testTyydWapPagswitch1001() throws Exception {
	    driver.get(baseUrl + "/index.action?");
	    driver.findElement(By.linkText("炫版")).click();
	    assertEquals("首页\n品质\n男生\n女生\n奖励\n分类\n收藏\n反馈\n帮助", driver.findElement(By.xpath("//footer/nav")).getText());
	    driver.findElement(By.linkText("简版")).click();
	    assertEquals("首页",driver.findElement(By.xpath("/html/body/div[17]/p[1]/a[1]")).getText());
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
