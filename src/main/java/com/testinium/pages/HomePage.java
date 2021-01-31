package com.testinium.pages;

import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
	
	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	public void redirectHere() {
		driver.get("http://www.gittigidiyor.com");
		driver.manage().window().maximize();
	}	
}
