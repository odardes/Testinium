package com.testinium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.testinium.objects.User;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login(User user) {
    	//Email
        typeTo(By.id("L-UserNameField"), 15, user.getEmail());
        //Password
        typeTo(By.id("L-PasswordField"), 15, user.getPassword());
        
        /*     ---Ýf it requires---
        //I am not robot
        clickTo(By.className("recaptcha-checkbox-border"), 15);
        */
        
        //Click login
        clickTo(By.id("gg-login-enter"), 15);
    }
}
