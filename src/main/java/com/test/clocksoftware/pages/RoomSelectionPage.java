package com.test.clocksoftware.pages;

import com.test.clocksoftware.Util.DriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;

public class RoomSelectionPage extends PageBase {

    public RoomSelectionPage(DriverManager manager) {
        super(manager);
    }

    By label_room_types=By.xpath("//div[contains(@class,'bookable-container bookable-location')]//h2");
    By btn_Check_availability_calendar=By.xpath("//a[contains(text(),'Check availability calendar')]");
    String  iframe_id="clock_pms_iframe_1";
    By label_Dates=By.xpath("//h4[contains(text(),'Deluxe Appartment')]/../../following-sibling::div[1]//a[contains(@class,'list-group-item list-group-item')]");
    By btn_Next_Page=By.xpath("//div[@class='icon-double-angle-right']");
    By btn_search_For_Available_Rooms= By.xpath("//input[@value='Search for available rooms']");
    By label_selected_Date= By.xpath("//div[@class='h2 text-center']");
    By label_price=By.xpath("//h2[contains(text(),'Deluxe Appartment')]/../../following-sibling::div[1]//tr[@class='room-type']//td[@class='text-right hidden-xs']//*[contains(text(),'EUR')]");
    By btn_Select=By.xpath("//span[@class='pull-right']//a[@class='btn btn-success ']//i");
    public Double highest_value;


    public String bookDeluxeApartment(){
         driver.switchTo().frame(iframe_id);
         List<WebElement> room_types = driver.findElements(label_room_types);
         String room_type="";
         String date="";
        for (WebElement element : room_types) {
            room_type=room_type+element.getText();
        }
         if (!room_type.contains("Deluxe Appartment")) {
             getWebElementVisible(btn_Check_availability_calendar).click();
             int numberOfNights=0;
             List<WebElement> list_dates_availability;
             while(numberOfNights<=3) {
                 list_dates_availability =getWebElementsVisible(label_Dates) ;
                 for (int i = 0; i < list_dates_availability.size(); i++) {
                     String class_attribute="";
                     try{
                         class_attribute=list_dates_availability.get(i).getAttribute("class");

                     }
                     catch (StaleElementReferenceException exception){
                         list_dates_availability =getWebElementsVisible(label_Dates) ;
                         class_attribute=list_dates_availability.get(i).getAttribute("class");
                     }
                     if(class_attribute.contains("danger"))
                     {
                         numberOfNights=0;
                     }
                     else
                     {
                         numberOfNights+=1;
                     }
                     if(numberOfNights==4)
                     {
                         list_dates_availability.get(i-3).click();
                         break;
                     }
                 }
                 if(numberOfNights!=4)
                 {
                     retryClick(btn_Next_Page);
                 }
                 else{
                     getWebElementVisible(btn_search_For_Available_Rooms).click();
                     break;
                 }


                 numberOfNights=0;
             }
             date=select_Highest_Price_Deluxe_Apartment();
         }
         else
         {
             date=select_Highest_Price_Deluxe_Apartment();

         }
        return date;
    }

    public String  select_Highest_Price_Deluxe_Apartment()
    {
        waitForElementToLoad();
        String arrival_date=getWebElementVisible(label_selected_Date).getText();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("dd-MMM-yyyy");
        String date= null;
        try {
            date = simpleDateFormat.format(new SimpleDateFormat("dd MMM yyyy").parse(arrival_date));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        List<WebElement> list_prices = driver.findElements(label_price);
        ArrayList<Double> list_prices_values = new ArrayList<>();
        for (WebElement price : list_prices) {
            list_prices_values.add(Double.parseDouble(price.getAccessibleName().split(" ")[0].replace(",", "")));
        }
        highest_value=Collections.max(list_prices_values);
        List<WebElement> list_select_button = driver.findElements(btn_Select);
        for (int i = 0; i < list_prices.size(); i++) {
            if (Double.parseDouble(list_prices.get(i).getAccessibleName().split(" ")[0].replace(",", "")) == Collections.max(list_prices_values)) {
                list_select_button.get(i).click();
            }
        }
        return date;
    }



}
