package com.test.clocksoftware.Util;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.FileReader;
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

    public String readJsonData(String node, String field) {
        Object obj = null;
        try {
            obj = new JSONParser().parse(new FileReader("./src/test/resources/data/config.json"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        JSONObject jo = (JSONObject) obj;
        return (String) ((JSONObject) jo.get(node)).get(field);
    }
}
