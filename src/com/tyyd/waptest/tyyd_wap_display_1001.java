package com.tyyd.waptest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.text.SimpleDateFormat;
import java.util.Date;
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


public class tyyd_wap_display_1001 {
	  private static String dataFile = "testdata.txt";
  private static WebDriver driver;
  private static String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  
  @BeforeClass
  public static void readData() throws Exception {
	  baseUrl = TxtHandle.readData(dataFile, 0);
	  driver = new FirefoxDriver();
//	  driver = new HtmlUnitDriver();
  }
  
  @Rule
  public TestRule myScreenshot = new TakeScreenshotOnFailureRule(driver, "tyyd_wap_display_1001");
  
  @Before
  public void setUp() throws Exception {
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testTyydWapDisplay1001_1() throws Exception {
    driver.get(baseUrl + "/");
    driver.findElement(By.linkText("书城")).click();
    assertEquals("排行\n|\n分类\n|\n包月\n|\n免费\n|\n软件", driver.findElement(By.xpath("//div[3]/p[2]")).getText());
  }
  
  @Test
  public void testTyydWapDisplay1001_2() throws Exception {
    driver.get(baseUrl + "/");
    driver.findElement(By.linkText("书城")).click();
    assertEquals("热门 | 重磅 | 新书", driver.findElement(By.xpath("//div[7]")).getText());
  }
  
  @Test
  public void testTyydWapDisplay1001_3() throws Exception {
    driver.get(baseUrl + "/");
    driver.findElement(By.linkText("书城")).click();
    assertEquals("男生 | 女生 | 品质", driver.findElement(By.xpath("//div[8]")).getText());
  }
  
  @Test
  public void testTyydWapDisplay1001_4() throws Exception {
    driver.get(baseUrl + "/");
    driver.findElement(By.linkText("书城")).click();
    assertEquals("连载 | 完本 | 大神", driver.findElement(By.xpath("//div[9]")).getText());
  }
  
  @Test
  public void testTyydWapDisplay1001_5() throws Exception {
    driver.get(baseUrl + "/");
    driver.findElement(By.linkText("书城")).click();
    assertTrue(isElementPresent(By.linkText("热书榜")));
  }
  
  @After
  public void tearDown() throws Exception {
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }
  
  @AfterClass
  public static void saveResult() throws Exception {
	  driver.quit();
	  
	  String rootPath = "D:\\";
	  String testName = "WaptestReport_tyyd_wap_display_1001_";
	  String testCase = "tyyd_wap_display_1001";
	  
	  SimpleDateFormat formatter = new SimpleDateFormat( "yyyyMMddhhmm"); 
	  String dateString = formatter.format(new Date());
	  String excelPath = rootPath+testName+dateString+".xls";
	  
	  /**
	   * 
	   * call ExcelHandle.writeExcel method
	   * use POI to implement the function
	   * 
	   */
	  ExcelHandle.writeExcel(excelPath, testCase);
//	  ExcelHandle.modifyExcel();
	
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
