package com.testinium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	
	 WebDriver driver;
	 
	 By searchBox = By.xpath("//*[@id=\"main-header\"]/div[3]/div/div/div/div[2]/form/div/div[1]/div[2]/input");
	 By searchButton = By.xpath("//*[@id=\"main-header\"]/div[3]/div/div/div/div[2]/form/div/div[2]/button");
	 
	 public BasePage(WebDriver driver) {
		 this.driver = driver;
	 }
	 
	 public void clickTo(By byLocator, int timeoutInSeconds) {
	      WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
	      wait.until(ExpectedConditions.elementToBeClickable(byLocator))
	          .click();
	 }
	    
	 public void typeTo(By byLocator, int timeoutInSeconds, String text) {
	      WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
	      wait.until(ExpectedConditions.elementToBeClickable(byLocator))
	          .sendKeys(text);
	 }
	    
	 //For SearchBox
	 public void waitForValueToFilled(int timeoutInSeconds, String keyword) {
	      WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
	      wait.until(ExpectedConditions.attributeContains(searchBox, "Value", keyword));
	 }
	    
	 //For Control Page
	 public void waitForTitle(int timeoutInSeconds, String title) {
	      WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
	      wait.until(ExpectedConditions.titleIs(title));
	 }
	    
	 public LoginPage clickLogin() {
		 
		 //Login
	      clickTo(By.xpath("//*[@id=\"main-header\"]/div[3]/div/div/div[1]/div[3]/div/div[1]/div/div[2]"), 15); 	     
	      
		 /*          --------- It does not work, so I directly managed the url ----------
		  //Ýnvisible Login
	      clickTo(By.xpath("//*[@id=\"main-header\"]/div[3]/div/div/div/div[3]/div/div[1]/div"), 15);
	      */
		 
		 driver.get("https://www.gittigidiyor.com/uye-girisi");
	     return new LoginPage(driver);
	 }
	    
	 //Because we can search on every page
	 public SearchResultPage search(String keyword) {
	      //Type keyword
	      typeTo(searchBox, 15, keyword);
	      waitForValueToFilled(15, keyword);
	      //Click search button
	      clickTo(searchButton, 15);
	      return new SearchResultPage(driver);
	}
	    
	public String getText(By byLocator, int timeoutInSeconds) {
	      WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
	      return wait.until(ExpectedConditions.visibilityOfElementLocated(byLocator))
	                 .getText();
    }
}
