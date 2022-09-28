package com.test.clocksoftware.pages;

import com.test.clocksoftware.Util.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class PaymentPage extends PageBase{

    public PaymentPage(DriverManager manager)
    {
        super(manager);
    }
    By input_CardNumber = By.xpath("//input[@id='cardNumber']");
    By dropdown_cardTypes = By.xpath("//select[@id='credit_card_collect_purchase_brand']");
    By dropdown_expiryMonth = By.xpath("//select[@id='cardExpirationMonth']");
    By dropdown_expiryYear = By.xpath("//select[@id='cardExpirationYear']");

    By input_address = By.xpath("//input[@id='credit_card_collect_purchase_address']");
    By input_zip = By.xpath("//input[@id='credit_card_collect_purchase_zip']");
    By input_city = By.xpath("//input[@id='credit_card_collect_purchase_city']");
    By input_state = By.xpath("//input[@id='credit_card_collect_purchase_state']");
    By dropdown_country = By.xpath("//select[@id='credit_card_collect_purchase_country']");
    By btn_confirm = By.xpath("//button[@class='btn btn-success btn-lg btn-block']");

    By bookingMsg=By.xpath("//h3[text()='Check your e-mail for booking confirmation.']");

    public void enterPaymentDetails()
    {
        getWebElementVisible(input_CardNumber).sendKeys("4444333322221111");
        Select cardType = new Select(getWebElementVisible(dropdown_cardTypes));
        cardType.selectByVisibleText("VISA");
        Select expiryMonth = new Select(getWebElementVisible(dropdown_expiryMonth));
        expiryMonth.selectByVisibleText("09");
        Select expiryYear = new Select(getWebElementVisible(dropdown_expiryYear));
        expiryYear.selectByVisibleText("2024");
        getWebElementVisible(input_address).sendKeys("Flat");
        getWebElementVisible(input_zip).sendKeys("GL1 1QX");
        getWebElementVisible(input_city).sendKeys("City");
        getWebElementVisible(input_state).sendKeys("State");
        Select country = new Select(getWebElementVisible(dropdown_country));
        country.selectByVisibleText("United Kingdom");
        getWebElementVisible(btn_confirm).click();
    }
    public String bookingMsg(){
        return getWebElementVisible(bookingMsg).getText();
    }
}
