package com.test.clocksoftware.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.test.clocksoftware.Util.DriverManager;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.List;

import static javax.swing.text.html.CSS.getAttribute;

/**
 * Created by Yosuva
 */
public class PageBase {

    WebDriver driver;

    public PageBase(DriverManager manager){
        this.driver = manager.getDriver();
    }

    public WebElement getWebElementVisible(By by) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public List<WebElement> getWebElementsVisible(By by) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
    }

    public void waitForElementToLoad(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until((ExpectedCondition<Boolean>) wd -> ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
    }

    public boolean retryClick(By by) {
        boolean result = false;
        int attempts = 0;
        while(attempts < 2) {
            try {
                driver.findElement(by).click();
                result = true;
                break;
            } catch(StaleElementReferenceException e) {
            }
            attempts++;
        }
        return result;
    }

    public String getDateWithFormat(String format,String date,int numberOfDaysToBeAdded){
        SimpleDateFormat dateFormat = new SimpleDateFormat( format );
        Calendar cal = Calendar.getInstance();
        try {
            cal.setTime(dateFormat.parse(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        cal.add( Calendar.DATE, numberOfDaysToBeAdded);
        return dateFormat.format(cal.getTime());
    }
}
