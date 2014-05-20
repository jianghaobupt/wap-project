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

public class tyyd_wap_chpublish_2004 {
  private static final String datafile = "testdata.txt";
  private static WebDriver driver;
  private static String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  
  @BeforeClass
  public static void start() throws Exception {
	  baseUrl = TxtHandle.readData(datafile, 0);
	  driver =  new FirefoxDriver();
  }
  
  @Rule
  public TestRule myScreenshot = new TakeScreenshotOnFailureRule(driver, "tyyd_wap_chpublish_2004");

  @Before
  public void setUp() throws Exception {
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testTyydWapChpublish2004_1() throws Exception {
	driver.get(baseUrl + "/index.action?f=1");
    driver.findElement(By.linkText("品质")).click();
    assertTrue(isElementPresent(By.linkText("[专区]")));
    driver.findElement(By.linkText("[专区]")).click();
    assertEquals("【成功必读排行】   周榜  月榜", driver.findElement(By.cssSelector("div.mod-title")).getText());
  }
  
  @Test
  public void testTyydWapChpublish2004_2() throws Exception {
	driver.get(baseUrl + "/index.action?f=1");
    driver.findElement(By.linkText("品质")).click();
    assertTrue(isElementPresent(By.linkText("[专区]")));
    driver.findElement(By.linkText("[专区]")).click();
    assertEquals("【名家推荐】", driver.findElement(By.xpath("//div[10]")).getText());
  }
  
  @Test
  public void testTyydWapChpublish2004_3() throws Exception {
	driver.get(baseUrl + "/index.action?f=1");
    driver.findElement(By.linkText("品质")).click();
    assertTrue(isElementPresent(By.linkText("[专区]")));
    driver.findElement(By.linkText("[专区]")).click();
    assertEquals("【包月专区】", driver.findElement(By.xpath("//div[13]")).getText());
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
