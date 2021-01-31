package com.testinium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ItemPage extends BasePage {
	
	public ItemPage(WebDriver driver) {
		super(driver);
	}
	
	 public BasketPage addToBasket() {
	      clickTo(By.id("add-to-basket"), 15); 
	      return new BasketPage(driver);
	 }
}
