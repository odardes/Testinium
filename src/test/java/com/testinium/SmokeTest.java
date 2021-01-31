package com.testinium;

import org.junit.Assert;
import org.junit.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.testinium.objects.User;
import com.testinium.objects.UserPool;
import com.testinium.pages.BasketPage;
import com.testinium.pages.HomePage;
import com.testinium.pages.ItemPage;
import com.testinium.pages.LoginPage;
import com.testinium.pages.SearchResultPage;

public class SmokeTest extends BaseTest {
	
	@Test
	public void seleniumWebAutomation() {
		
		User user = UserPool.buyer();
        String keyword = "bilgisayar";
        
		//1- Direct web site
        HomePage homePage = new HomePage(driver);
		homePage.redirectHere();

		//2-Control the home page - title is there? - and login	
        homePage.waitForTitle(10, "GittiGidiyor - Türkiye'nin Öncü Alýþveriþ Sitesi");
		LoginPage loginPage = homePage.clickLogin();
        loginPage.login(user);
        
		//3- Control login process - Account name is there? -
        String myAccountName = homePage.getText(By.xpath("//*[@id=\"main-header\"]/div[3]/div/div/div[1]/div[3]/div/div[1]/div/div[2]/span"),10);
		Assert.assertEquals(myAccountName, "senaguventurk768678");
		
		//4-Search computer on search box and control has keyword written?
		SearchResultPage searchResultPage = homePage.search(keyword);
		String descriptionText = searchResultPage.getDescriptionText();
        Assert.assertTrue(descriptionText.contains(keyword));
		
		//5-Direct second page 
        searchResultPage.clickPageNumber("2");
		
		//6-Control the page is second page
		String url = driver.getCurrentUrl();
		Assert.assertEquals(url, "https://www.gittigidiyor.com/arama/?k=bilgisayar&sf=2");
		
		//7-Select an item
		ItemPage itemPage= searchResultPage.clickItem();
		
		//8-Get the item price and add to basket
        String priceOnItemPage = itemPage.getText(By.id("sp-price-highPrice"), 10);
        BasketPage basketPage = itemPage.addToBasket();
		
		//9-Control price
        String priceOnBasketPage = basketPage.getText(By.className("total-price"), 10);
		Assert.assertEquals(priceOnItemPage, priceOnBasketPage);
		
		//10-Ýncrease number and control the number is equal to 2
        basketPage.clickTo(By.className("plus icon-plus gg-icon gg-icon-plus"), 15);
        String increasedNumber = basketPage.getText(By.className("amount"), 10);
		Assert.assertEquals(increasedNumber, "2");

		//11-Delete item and control there is no item
        basketPage.clickTo(By.className("btn-delete btn-update-item hidden-m"), 15);
        //Trying to get h2 element under div
        WebElement noItemInBasket = driver.findElement(By.cssSelector("#empty-cart-container > div.gg-d-24 > div:nth-child(1) > div > div.gg-w-22.gg-d-22.gg-t-21.gg-m-18"));
        String noItem = noItemInBasket.getText();
		Assert.assertEquals(noItem, "Sepetinizde ürün bulunmamaktadýr.");

		
	}
}