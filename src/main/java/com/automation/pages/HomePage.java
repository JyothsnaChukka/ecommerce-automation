package com.automation.pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class HomePage {
    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    By gearLink = By.id("ui-id-6");
    By watchesLink = By.linkText("Watches");

    public void goToWatches() {
    	Actions action=new Actions(driver);
    	Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30)).pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
    	wait.until(ExpectedConditions.elementToBeClickable(gearLink));
    	action.moveToElement(driver.findElement(By.id("ui-id-6"))).build().perform();
        driver.findElement(watchesLink).click();
    }
}
