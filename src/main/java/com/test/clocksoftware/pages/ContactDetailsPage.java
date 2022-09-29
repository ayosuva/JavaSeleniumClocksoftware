package com.test.clocksoftware.pages;

import com.test.clocksoftware.Util.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class ContactDetailsPage extends PageBase {
    WebDriver driver;
    PageBase pageBase;

    public ContactDetailsPage(DriverManager manager) {
        super(manager);
    }

    By input_Email              = By.xpath("//input[@title='E-mail']");
    By input_LastName           = By.xpath("//input[@id='booking_guest_attributes_last_name']");
    By input_FirstName          = By.xpath("//input[@id='booking_guest_attributes_first_name']");
    By input_Phone              = By.xpath("//input[@id='booking_guest_attributes_phone_number']");
    By radio_CreditCard         = By.xpath("//input[@id='booking_payment_service_credit_card_collect']");
    By checkbox_TermsConditions = By.xpath("//input[@title='I agree with the hotel and guarantee policy']");
    By btn_create_Booking       = By.xpath("//input[@value='Create Booking']");
    By label_arrival            = By.xpath("//*[text()='Arrival']/../following-sibling::div");
    By label_No_of_nights       = By.xpath("//*[text()='Stay']/../following-sibling::div");
    By label_Room_type          = By.xpath("//*[text()='Room Type']/../following-sibling::div");
    By label_Rate               = By.xpath("//*[text()='Rate']/../following-sibling::div");
    By label_Add_on             = By.xpath("//*[text()='Extra Services']/../following-sibling::div");
    By label_Total              = By.xpath("//div[@class='row total_charges']//*[contains(text(),'EUR')]");

    public void enter_user_details_and_create_booking() {
        getWebElementVisible(input_Email).sendKeys("test@testxx.com");
        getWebElementVisible(input_FirstName).sendKeys("Test Name");
        getWebElementVisible(input_LastName).sendKeys("Test Last Name");
        getWebElementVisible(input_Phone).sendKeys("1234567890");
        getWebElementVisible(radio_CreditCard).click();
        getWebElementVisible(checkbox_TermsConditions).click();
        getWebElementVisible(btn_create_Booking).click();

    }

    public String arrival_date() {
        return getWebElementVisible(label_arrival).getText().replace(" ", "-");
    }

    public String no_of_nights() {
        return getWebElementVisible(label_No_of_nights).getText();
    }

    public String room_type() {
        return getWebElementVisible(label_Room_type).getText();
    }

    public String rate() {
        return getWebElementVisible(label_Rate).getText();
    }

    public String addon() {
        return getWebElementVisible(label_Add_on).getText();
    }

    public Double total() {
        return Double.parseDouble(getWebElementVisible(label_Total).getText().split(" ")[0].replace(",", ""));

    }
}

