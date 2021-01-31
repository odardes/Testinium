package com.testinium.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchResultPage extends BasePage {

    By descriptionText = By.className("search-result-keyword");
	
    public SearchResultPage(WebDriver driver) {
        super(driver);
    }
    
    public String getDescriptionText() {
        return getText(descriptionText, 10);
    }
    
	 public ItemPage clickItem() {
	      clickTo(By.id("product_id_635619110"), 15); 
	      return new ItemPage(driver);
	 }
	 
	 public void clickPageNumber(String number) {
		 List<WebElement> options = driver.findElements(By.xpath("//*[@id=\"best-match-right\"]/div[5]/ul"));
	     for (WebElement opt : options) {
	         if (opt.getText().equals("number")) {
	             opt.click();
	         }
	    }		 
	 }

}
