package com.automation.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class WatchPage {
    WebDriver driver;

    public WatchPage(WebDriver driver) {
        this.driver = driver;
    }

    By watchMaterial = By.xpath("//*[@id='narrow-by-list']/div[4]/div[1]");
    By metal = By.xpath("//*[@id='narrow-by-list']/div[4]/div[2]/ol/li[2]/a");
    By addToCartButton = By.xpath("//*[@id='product-addtocart-button']");
    By increaseQuantityButton = By.xpath("//*[@id='qty']");
    By cartIcon = By.xpath("//a[@class='action showcart']");

    public void filterByMaterial() {
    	Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30)).pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
    	wait.until(ExpectedConditions.elementToBeClickable(watchMaterial)).click();
    	wait.until(ExpectedConditions.elementToBeClickable(metal)).click();
    }

    public void addWatchToCart() {
    	Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(40)).pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
    	driver.findElement(By.xpath("//img[@alt='Summit Watch']")).click();
    	driver.findElement(increaseQuantityButton).click();
    	driver.findElement(increaseQuantityButton).clear();
    	driver.findElement(increaseQuantityButton).sendKeys("2");
    	wait.until(ExpectedConditions.elementToBeClickable(addToCartButton)).click();
    }

    public void goToCart() {
    	Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30)).pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
    	wait.until(ExpectedConditions.elementToBeClickable(cartIcon)).click();
    }
}
