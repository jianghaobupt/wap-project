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

public class tyyd_wap_pagetail_L2006 {
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
  public TestRule myScreenshot = new TakeScreenshotOnFailureRule(driver, "tyyd_wap_pagetail_L2006");

  @Before
  public void setUp() throws Exception {
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testTyydWapPagetailL2006_1() throws Exception {
    driver.get(baseUrl + "/index.action?");
    driver.findElement(By.linkText("品质")).click();
    assertEquals("首页 品质 男生 女生 奖励\n分类 收藏 反馈 帮助", driver.findElement(By.cssSelector("div.main-nav")).getText());  
    assertTrue(isElementPresent(By.linkText("[专题]")));
    driver.findElement(By.linkText("[专题]")).click();
    assertEquals("【精品专题】", driver.findElement(By.cssSelector("div.mod-title")).getText());
    assertEquals("【出版专题】", driver.findElement(By.xpath("//div[8]")).getText());
  }
  
  @Test
  public void testTyydWapPagetailL2006_2() throws Exception {
    driver.get(baseUrl + "/index.action?"); 
    assertTrue(isElementPresent(By.linkText("专题")));
    driver.findElement(By.linkText("专题")).click();
    assertEquals("【原创专题】", driver.findElement(By.xpath("//div[10]")).getText());
    assertEquals("【女生专题】", driver.findElement(By.xpath("//div[12]")).getText());
  }
  
  @Test
  public void testTyydWapPagetailL2006_3() throws Exception {
    driver.get(baseUrl + "/index.action?"); 
    assertTrue(isElementPresent(By.linkText("专题")));
    driver.findElement(By.linkText("专题")).click();
    assertEquals("【往期专题】", driver.findElement(By.xpath("//div[14]")).getText());
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
