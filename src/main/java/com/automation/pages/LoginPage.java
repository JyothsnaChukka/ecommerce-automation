package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    By signInLink = By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[2]");
    By emailField = By.id("email");
    By passwordField = By.id("pass");
    By loginButton = By.xpath("//button[@class='action login primary']/span");

    public void login(String email, String password) {
    	driver.findElement(signInLink).click();
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton).click();
    }
}
