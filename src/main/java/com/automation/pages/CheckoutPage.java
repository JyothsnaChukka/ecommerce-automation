package com.automation.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

public class CheckoutPage {
    WebDriver driver;
    
    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }
    
    By successMessage = By.xpath("//div[@class='message-success success message']");
    By checkoutButton = By.xpath("//*[@id='maincontent']/div[1]/div[2]/div/div/div/a");
    By proceedToCheckout = By.xpath("//*[@id='maincontent']/div[3]/div/div[2]/div[1]/ul/li[1]/button");
    /*By firstName = By.xpath("//input[@name='firstname']");
    By lastName = By.xpath("//input[@name='lastname']");
    By streetAddress = By.xpath("//input[@name='street[0]']");
    By city = By.xpath("//input[@name='city']");
    By zipcode = By.xpath("//input[@name='postcode']");
    By phoneNumber = By.xpath("//input[@name='telephone']");*/
    By shippingMethod = By.xpath("//input[@name='ko_unique_1']");
    By nextButton = By.xpath("//button[@class='button action continue primary']");
    
    By placeOrder = By.xpath("//button[@title='Place Order']");
    
    By orderSuccessMessage = By.xpath("//span[@data-ui-id='page-title-wrapper']");
    By orderId = By.xpath("//a[@class='order-number']/strong");


    public void completePurchase() {
    	Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(60)).pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);
    	wait.until(ExpectedConditions.textToBePresentInElementLocated(successMessage, "You added"));
    	wait.until(ExpectedConditions.elementToBeClickable(checkoutButton)).click();
    	wait.until(ExpectedConditions.elementToBeClickable(proceedToCheckout)).click();
    }
    
    public void enterAddressDetails() {
    	Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(60)).pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
    	/*wait.until(ExpectedConditions.elementToBeClickable(firstName)).click();
    	driver.findElement(firstName).clear();
    	driver.findElement(firstName).sendKeys("Test");
    	driver.findElement(lastName).clear();
    	driver.findElement(lastName).sendKeys("User");
    	driver.findElement(streetAddress).sendKeys("test street");
    	driver.findElement(city).sendKeys("test city");
    	WebElement state = driver.findElement(By.xpath("//select[@name='region_id']"));  
    	Select stateDropdown = new Select(state);  
    	stateDropdown.selectByVisibleText("California");  
    	driver.findElement(zipcode).sendKeys("96162");
    	WebElement country = driver.findElement(By.xpath("//select[@name='country_id']"));  
    	Select countryDropdown = new Select(country);  
    	countryDropdown.selectByVisibleText("United States");
    	driver.findElement(phoneNumber).sendKeys("798796976788");*/
    	wait.until(ExpectedConditions.elementToBeClickable(shippingMethod)).click();
    	driver.findElement(nextButton).click();
    }
    
    public void placeOrder() {
    	Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(60)).pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
    	wait.until(ExpectedConditions.elementToBeClickable(placeOrder)).click();
    }

    public String getSuccessMessage() {
    	Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(60)).pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
    	wait.until(ExpectedConditions.textToBePresentInElementLocated(orderSuccessMessage, "Thank you for your purchase!"));
        return driver.findElement(orderSuccessMessage).getText();
    }

    public String getOrderId() {
        return driver.findElement(orderId).getText();
    }
}
