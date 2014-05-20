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

public class tyyd_wap_chgirl_4001 {
	private static String dataFile = "testdata.txt";
	private static WebDriver driver;
	private static String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();
	
	@BeforeClass
	public static void start() throws Exception {
	  baseUrl = TxtHandle.readData(dataFile, 0);
	  driver = new FirefoxDriver();
	  }
	
	@Rule
	public TestRule myScreenshot = new TakeScreenshotOnFailureRule(driver, "tyyd_wap_chgirl_4001"); 
	
	@Before
	public void setUp() throws Exception {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}
	
	@Test
	public void testTyydWapChgirl4001_1() throws Exception {
		driver.get(baseUrl + "/index.action?f=3");
		driver.findElement(By.linkText("女生")).click();
//		assertEquals("言情 | 穿越 | 青春 | 新书 | 免费", driver.findElement(By.cssSelector("div.sub-nav > p")).getText());
		try {
			assertTrue(isElementPresent(By.linkText("[专题]")));
			} catch (Error e) {
				verificationErrors.append(e.toString()+"专题不存在！\n");
				}
		driver.findElement(By.linkText("[专题]")).click();
		assertEquals("【精品专题】", driver.findElement(By.cssSelector("div.mod-title")).getText());
		}
	
	@Test
	public void testTyydWapChgirl4001_2() throws Exception {
		driver.get(baseUrl + "/index.action?f=3");
		driver.findElement(By.linkText("女生")).click();
		try {
			assertTrue(isElementPresent(By.linkText("[专题]")));
			} catch (Error e) {
				verificationErrors.append(e.toString()+"[专题]不存在！\n");
				}
		driver.findElement(By.linkText("[专题]")).click();
		assertEquals("【出版专题】", driver.findElement(By.xpath("//div[8]")).getText());
		}
  
  @Test
  public void testTyydWapChgirl4001_3() throws Exception {
	driver.get(baseUrl + "/index.action?f=3");
    driver.findElement(By.linkText("女生")).click();
    try {
      assertTrue(isElementPresent(By.linkText("[专题]")));
    } catch (Error e) {
      verificationErrors.append(e.toString()+"[专题]不存在！\n");
    }
    driver.findElement(By.linkText("[专题]")).click();
    assertEquals("【女生专题】", driver.findElement(By.xpath("//div[12]")).getText());
  }
  
  @Test
  public void testTyydWapChgirl4001_4() throws Exception {
	driver.get(baseUrl + "/index.action?f=3");
    driver.findElement(By.linkText("女生")).click();
    try {
      assertTrue(isElementPresent(By.linkText("[专题]")));
    } catch (Error e) {
      verificationErrors.append(e.toString()+"[专题]不存在！\n");
    }
    driver.findElement(By.linkText("[专题]")).click();
    try {
        assertTrue(isElementPresent(By.linkText("返回上一页")));
    } catch (Error e) {
    	verificationErrors.append(e.toString()+"[返回上一页]不存在！\n");
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
