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
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import com.tyyd.extension.ExcelHandle;
import com.tyyd.extension.TakeScreenshotOnFailureRule;
import com.tyyd.extension.TxtHandle;

public class tyyd_wap_pagehead_L1005 {
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
  public TestRule myScreenshot = new TakeScreenshotOnFailureRule(driver, "tyyd_wap_pagehead_L1005");

  @Before
  public void setUp() throws Exception {
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testTyydWapPageheadL1005_1() throws Exception {
    driver.get(baseUrl + "/index.action?f=0");
    driver.findElement(By.linkText("书城")).click();
    assertTrue(isElementPresent(By.linkText("软件")));
    driver.findElement(By.linkText("软件")).click();
    assertEquals("首页> 下载", driver.findElement(By.cssSelector("p")).getText());
  }
  
  @Test
  public void testTyydWapPageheadL1005_2() throws Exception {
    driver.get(baseUrl + "/index.action?f=0");
    driver.findElement(By.linkText("书城")).click();
    assertTrue(isElementPresent(By.linkText("软件")));
    driver.findElement(By.linkText("软件")).click();
    assertEquals("安卓", driver.findElement(By.xpath("//div[5]/div[1]/a[1]")).getText());
  }
  
  @Test
  public void testTyydWapPageheadL1005_3() throws Exception {
    driver.get(baseUrl + "/index.action?f=0");
    driver.findElement(By.linkText("书城")).click();
    assertTrue(isElementPresent(By.linkText("软件")));
    driver.findElement(By.linkText("软件")).click();
    assertEquals("Win Phone", driver.findElement(By.xpath("//div[5]/div[1]/a[2]")).getText());
  }
  
  @Test
  public void testTyydWapPageheadL1005_4() throws Exception {
    driver.get(baseUrl + "/index.action?f=0");
    driver.findElement(By.linkText("书城")).click();
    assertTrue(isElementPresent(By.linkText("软件")));
    driver.findElement(By.linkText("软件")).click();
    assertEquals("非智能手机", driver.findElement(By.xpath("//div[5]/div[2]/a[1]")).getText());
  }
  
  @Test
  public void testTyydWapPageheadL1005_5() throws Exception {
    driver.get(baseUrl + "/index.action?f=0");
    driver.findElement(By.linkText("书城")).click();
    assertTrue(isElementPresent(By.linkText("软件")));
    driver.findElement(By.linkText("软件")).click();
    assertEquals("iPhone", driver.findElement(By.xpath("//div[5]/div[2]/a[2]")).getText());
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
