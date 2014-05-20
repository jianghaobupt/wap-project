package com.tyyd.extension;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;
import org.openqa.selenium.WebDriver;

public class TakeScreenshotOnFailureRule implements TestRule { 
	private static WebDriver driver; 
	private static String screendesc;
	
	public TakeScreenshotOnFailureRule(WebDriver driver, String testname) { 
		TakeScreenshotOnFailureRule.driver = driver;
		TakeScreenshotOnFailureRule.screendesc = testname;
	}
	
	@Override 
	public Statement apply(final Statement base, final Description description) { 
		
		return new Statement(){
			@Override 
			public void evaluate() throws Throwable { 
				try { 
					base.evaluate(); 
					} catch (Throwable throwable) { 
						WebDriverWrapper.screenShot(driver, screendesc+"-assert-fail");
						throw throwable; 
						} 
				} 
			};
			} 
	} 

