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

public class tyyd_wap_pagetail_L2007 {
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
  public TestRule myScreenshot = new TakeScreenshotOnFailureRule(driver, "tyyd_wap_pagetail_L2007");

  @Before
  public void setUp() throws Exception {
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testTyydWapPagetailL2007_1() throws Exception {
    driver.get(baseUrl + "/index.action?");
    driver.findElement(By.linkText("品质")).click();
    assertEquals("首页 品质 男生 女生 奖励\n分类 收藏 反馈 帮助", driver.findElement(By.cssSelector("div.main-nav")).getText());  
    assertTrue(isElementPresent(By.linkText("反馈")));
    driver.findElement(By.linkText("反馈")).click();
    assertEquals("首页> 反馈", driver.findElement(By.cssSelector("p")).getText());
    assertEquals("填写您的反馈意见：", driver.findElement(By.cssSelector("div.mod-ctltitle")).getText());
  }
  
  @Test
  public void testTyydWapPagetailL2007_2() throws Exception {
    driver.get(baseUrl + "/index.action?");
    assertTrue(isElementPresent(By.linkText("反馈")));
    driver.findElement(By.linkText("反馈")).click();
    assertTrue(isElementPresent(By.cssSelector("input.btn")));
    assertTrue(isElementPresent(By.name("comment")));
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
