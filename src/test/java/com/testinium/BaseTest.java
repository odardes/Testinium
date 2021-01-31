package com.testinium;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseTest {
	
	 WebDriver driver = null;

	 @Before
	 public void startUp() {	
		//Ýn order to close ... wants to do that
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
	 	System.setProperty("webdriver.chrome.driver", getPath());
		driver = new ChromeDriver(options);
	 }

	 @After
	 public void tearDown() {
	 	driver.quit();
	 }
	 
	 public String getPath() {
	 	String os = System.getProperty("os.name");
	    return switch (os) {
	    	case "Mac OS X" -> System.getProperty("user.dir") + "/src/main/resources/chromedriver";
	    	case "Windows 10" -> System.getProperty("user.dir") + "/src/main/resources/chromedriver.exe";
	    	case "Linux" -> System.getProperty("user.dir") + "/src/main/resources/chromedriver_linux";
	    	default -> throw new IllegalStateException("No valid OS!");
	    };
	}
}
