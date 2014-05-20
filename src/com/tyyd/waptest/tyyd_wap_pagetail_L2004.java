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

public class tyyd_wap_pagetail_L2004 {
	private static String datafile = "testdata.xls";
  private static WebDriver driver;
  private static String baseUrl;
  private static String userName;
  private static String passWd;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  
  @BeforeClass
  public static void start() throws Exception {
	  baseUrl = ExcelHandle.readExcel(datafile, 0, 0, 1);
	  userName = ExcelHandle.readExcel(datafile, 0, 1, 1);
	  passWd = ExcelHandle.readExcel(datafile, 0, 2, 1);
	  driver =  new FirefoxDriver();
  }
  
  @Rule
  public TestRule myScreenshot = new TakeScreenshotOnFailureRule(driver, "tyyd_wap_pagetail_L2004");

  @Before
  public void setUp() throws Exception {
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testTyydWapPagetailL2004() throws Exception {
    driver.get(baseUrl);
    driver.findElement(By.linkText("品质")).click();
    assertEquals("首页 品质 男生 女生 奖励", driver.findElement(By.cssSelector("div.main-nav > p")).getText());
    assertTrue(isElementPresent(By.xpath("(//a[contains(text(),'奖励')])[2]")));
    driver.findElement(By.xpath("(//a[contains(text(),'奖励')])[2]")).click();
    assertEquals("首页> 用户登录", driver.findElement(By.cssSelector("p")).getText());
    driver.findElement(By.name("phoneNum")).clear();
    driver.findElement(By.name("phoneNum")).sendKeys(userName);
    driver.findElement(By.name("randomCode")).clear();
    driver.findElement(By.name("randomCode")).sendKeys(passWd);
    driver.findElement(By.name("autoLogin")).click();
    driver.findElement(By.cssSelector("input.btn-yellow.fl")).click();
    try {
        assertEquals("日常任务", driver.findElement(By.cssSelector("div.mod-title")).getText());
      } catch (Error e) {
        verificationErrors.append(e.toString());
      }
      try {
        assertEquals("完成任务，轻松积分！", driver.findElement(By.cssSelector("div.mod.bg-lightgray")).getText());
      } catch (Error e) {
        verificationErrors.append(e.toString());
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
