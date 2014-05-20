package com.tyyd.waptest;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.junit.*;
import org.junit.rules.TestRule;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.Select;

import com.tyyd.extension.ExcelHandle;
import com.tyyd.extension.TakeScreenshotOnFailureRule;
import com.tyyd.extension.TxtHandle;

public class tyyd_wap_pagehead_L1022 {
	/**
	 * this testcase is disable
	 * wap页面修改，该用例失效
	 * by jianghao
	 * */
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
  public TestRule myScreenshot = new TakeScreenshotOnFailureRule(driver, "tyyd_wap_pagehead_L1022");

  @Before
  public void setUp() throws Exception {
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testTyydWapPageheadL1022() throws Exception {
    driver.get(baseUrl + "/index.action?");
    driver.findElement(By.linkText("男生")).click();
    assertEquals("排行 | 分类 | 杂志 | 漫画 | 听书", driver.findElement(By.xpath("//p[2]")).getText());
    assertTrue(isElementPresent(By.linkText("玄幻")));
    driver.findElement(By.linkText("玄幻")).click();
    assertEquals("首页> 男生 > 玄幻奇幻", driver.findElement(By.cssSelector("p")).getText());
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
