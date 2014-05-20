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

import com.tyyd.extension.TakeScreenshotOnFailureRule;
import com.tyyd.extension.TxtHandle;

public class tyyd_wap_display_1002 {
	private static String datafile = "testdata.txt";
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
  public TestRule myScreenshot = new TakeScreenshotOnFailureRule(driver, "tyyd_wap_display_1002");

  @Before
  public void setUp() throws Exception {
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testTyydWapDisplay1002_1() throws Exception {
    driver.get(baseUrl+"/index.action?f=0");
    driver.findElement(By.xpath("//div[3]/p/a[2]")).click();
    try {
    	assertTrue(isElementPresent(By.linkText("官场")));
    } catch (Error e) {
    	verificationErrors.append(e.toString()+"link isn't present!\n");
    }
    
  }
  
  @Test
  public void testTyydWapDisplay1002_2() throws Exception {
    driver.get(baseUrl+"/index.action?f=0");
    driver.findElement(By.linkText("品质")).click();  
    try {
    	assertTrue(isElementPresent(By.linkText("影视")));
    } catch (Error e) {
    	verificationErrors.append(e.toString()+"link isn't present!\n");
    }
  }
  
  @Test
  public void testTyydWapDisplay1002_3() throws Exception {
    driver.get(baseUrl+"/index.action?f=0");
    driver.findElement(By.linkText("品质")).click();
    try {
    	assertTrue(isElementPresent(By.linkText("经管")));
    } catch (Error e) {
    	verificationErrors.append(e.toString()+"link isn't present!\n");
    }
  }
  
  @Test
  public void testTyydWapDisplay1002_4() throws Exception {
    driver.get(baseUrl+"/index.action?f=0");
    driver.findElement(By.linkText("品质")).click();
    assertEquals("经典畅销", driver.findElement(By.xpath("//div[12]")).getText());
  }
  
  @Test
  public void testTyydWapDisplay1002_5() throws Exception {
    driver.get(baseUrl+"/index.action?f=0");
    driver.findElement(By.linkText("品质")).click();
    assertEquals("包月专区\n更多", driver.findElement(By.xpath("//div[17]")).getText());
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
