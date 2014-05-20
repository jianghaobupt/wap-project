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

public class tyyd_wap_pagehead_L1003 {
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
  public TestRule myScreenshot = new TakeScreenshotOnFailureRule(driver, "tyyd_wap_pagehead_L1003");

  @Before
  public void setUp() throws Exception {
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testTyydWapPageheadL1003_1() throws Exception {
    driver.get(baseUrl + "/index.action?");
    driver.findElement(By.linkText("书城")).click();
    assertEquals("排行\n|\n分类\n|\n包月\n|\n免费\n|\n软件", driver.findElement(By.xpath("//p[2]")).getText());
    assertTrue(isElementPresent(By.linkText("包月")));
    driver.findElement(By.linkText("包月")).click();
    assertEquals("首页> 包月", driver.findElement(By.xpath("//div[2]/p")).getText());
    try {
    	assertTrue(isElementPresent(By.linkText("成功必读包月区")));
    } catch (Error e) {
    	verificationErrors.append(e.toString()+"link isn't present!\n");
    }
  }
  
  @Test
  public void testTyydWapPageheadL1003_2() throws Exception {
    driver.get(baseUrl + "/index.action?");
    driver.findElement(By.linkText("书城")).click();
    assertTrue(isElementPresent(By.linkText("包月")));
    driver.findElement(By.linkText("包月")).click();
    assertEquals("热门排行", driver.findElement(By.xpath("//div[5]")).getText());
    try {
    	assertTrue(isElementPresent(By.linkText("完美生活包月区")));
    } catch (Error e) {
    	verificationErrors.append(e.toString()+"link isn't present!\n");
    }
  }
  
  @Test
  public void testTyydWapPageheadL1003_3() throws Exception {
    driver.get(baseUrl + "/index.action?");
    driver.findElement(By.linkText("书城")).click();
    assertTrue(isElementPresent(By.linkText("包月")));
    driver.findElement(By.linkText("包月")).click();
    assertEquals("新品抢鲜", driver.findElement(By.xpath("//div[16]")).getText());
    try {
    	assertTrue(isElementPresent(By.linkText("都市夜色包月区")));
    } catch (Error e) {
    	verificationErrors.append(e.toString()+"link isn't present!\n");
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
