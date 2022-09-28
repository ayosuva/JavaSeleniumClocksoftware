package com.test.clocksoftware.pages;

import com.test.clocksoftware.Util.DriverManager;
import org.openqa.selenium.By;

import java.text.SimpleDateFormat;
import java.util.Date;

public class HomePage extends PageBase {

    public HomePage(DriverManager manager) {
        super(manager);
    }

    By input_Arrival_Date=By.xpath("//input[@id='date-start']");
    By input_Number_Of_Nights=By.xpath("//input[@id='to-place']");
    By btn_Book_Now=By.xpath("//input[@value='Book now !']");

    public void enter_Arrival_Date(){
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("dd-MM-yyyy");
        String date= simpleDateFormat.format(new Date());
         getWebElementVisible(input_Arrival_Date).sendKeys(date);
    }

    public void enter_Number_Of_Nights(String numberOfNights){
        getWebElementVisible(input_Number_Of_Nights).clear();
        getWebElementVisible(input_Number_Of_Nights).sendKeys(numberOfNights);
    }

    public void click_Book_Now(){
        getWebElementVisible(btn_Book_Now).click();
    }


}
