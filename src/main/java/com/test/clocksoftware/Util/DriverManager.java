package com.test.clocksoftware.Util;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class DriverManager {
    public WebDriver getDriver() {
        if (driver == null) {
           /* ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");
            options.addArguments("--start-fullscreen");*/
            WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        }
        return driver;
    }

    private WebDriver driver;
}
