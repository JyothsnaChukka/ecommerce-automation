package com.automation.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
	WebDriver driver;
    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver","C://Users//zjyochu//eclipse-workspace//ecommerce-automation//resources//chromedriver.exe");
        ChromeOptions options=new ChromeOptions();    
        options.addArguments("--remote-allow-origins=*");    
        driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://magento.softwaretestingboard.com/");
    }

    @AfterMethod
    public void teardown() {
        if (driver != null) {
            //driver.quit();
        }
    }
}
