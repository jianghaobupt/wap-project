package com.tyyd.extension;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class WebDriverWrapper {
	
	/** 
	 * Function to take the screen shot and save it to the classpath dir. 
	 * Usually, you will find the png file under the project root. 
	 *
	 * @param driver 
	 * Webdriver instance 
	 * @param desc
	 * The description of the png 
	 */ 
	
     public static void screenShot(WebDriver driver, String desc) { 
		
		Date currentTime = new Date(); 
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd-hhmmss"); 
		String dateString = formatter.format(currentTime); 
		
		String dir_name = "screenshot\\"+desc;  // ���ﶨ���˽�ͼ���Ŀ¼��
		if (!(new File(dir_name).isDirectory())) {  // �ж��Ƿ���ڸ�Ŀ¼
			new File(dir_name).mkdir();  // ������������½�һ��Ŀ¼
			}
		
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); 
		
		try { 
			desc = desc.trim().equals("") ? "" : "-" + desc.trim(); 
			File screenshot = new File(dir_name + File.separator + dateString + desc + ".png"); 
			FileUtils.copyFile(scrFile, screenshot); 
			} catch (IOException e) { 
				e.printStackTrace(); 
				} 
		} 
	}