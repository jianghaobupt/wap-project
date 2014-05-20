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

public class tyyd_wap_pagehead_L1019 {
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
  public TestRule myScreenshot = new TakeScreenshotOnFailureRule(driver, "tyyd_wap_pagehead_L1019");

  @Before
  public void setUp() throws Exception {
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testTyydWapPageheadL1019_1() throws Exception {
    driver.get(baseUrl + "/index.action?");
    driver.findElement(By.linkText("品质")).click();
    assertEquals("排行 | 分类 | 杂志 | 漫画 | 听书", driver.findElement(By.xpath("//p[2]")).getText());
    assertTrue(isElementPresent(By.linkText("漫画")));
    driver.findElement(By.linkText("漫画")).click();
    assertEquals("幽默搞笑", driver.findElement(By.cssSelector("font")).getText());
    assertEquals("绝美言情", driver.findElement(By.xpath("//div[9]/font")).getText());
  }
  
  @Test
  public void testTyydWapPageheadL1019_2() throws Exception {
    driver.get(baseUrl + "/index.action?");
    driver.findElement(By.linkText("品质")).click();
    assertTrue(isElementPresent(By.linkText("漫画")));
    driver.findElement(By.linkText("漫画")).click();
    assertEquals("奇幻科幻", driver.findElement(By.xpath("//div[11]/font")).getText());
    assertEquals("青春校园", driver.findElement(By.xpath("//div[13]/font")).getText());
  }
  
  @Test
  public void testTyydWapPageheadL1019() throws Exception {
    driver.get(baseUrl + "/index.action?");
    driver.findElement(By.linkText("品质")).click();
    assertTrue(isElementPresent(By.linkText("漫画")));
    driver.findElement(By.linkText("漫画")).click();
    assertTrue(isElementPresent(By.linkText("返回上一页")));
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
