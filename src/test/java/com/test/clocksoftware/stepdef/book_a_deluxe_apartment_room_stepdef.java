package com.test.clocksoftware.stepdef;

import com.test.clocksoftware.Util.DriverManager;
import com.test.clocksoftware.Util.ReusableFunctions;
import com.test.clocksoftware.pages.*;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class book_a_deluxe_apartment_room_stepdef {

    DriverManager context;
    HomePage homePage;
    RoomSelectionPage roomSelectionPage;
    ExtraServicesPage   extraServicesPage;
    ContactDetailsPage contactDetailsPage;
    PaymentPage   paymentPage;
    String arrival_date;
    private Scenario scenario;
    public book_a_deluxe_apartment_room_stepdef(DriverManager context){
        this.context = context;

    }

    @Given("I am on homepage")
    public void i_am_on_homepage() {
        context.getDriver().get(context.readJsonData("defaultproperties","url"));
        homePage = new HomePage(context);
        roomSelectionPage =new RoomSelectionPage(context);
        extraServicesPage=new ExtraServicesPage(context);
        contactDetailsPage =new ContactDetailsPage(context);
        paymentPage =new PaymentPage(context);
    	addScreenshot();

    }
    @When("Select a valid date and number of nights and click book now")
    public void select_a_valid_date_and_number_of_rooms_and_click_book_now() {
        homePage.enter_Arrival_Date();
        homePage.enter_Number_Of_Nights("4");
        addScreenshot();
        homePage.click_Book_Now();
    }
    @When("Under Deluxe Apartment select the most expensive package")
    public void under_deluxe_apartment_select_the_most_expensive_package() {
        arrival_date=roomSelectionPage.bookDeluxeApartment();
        addScreenshot();
    }
    @When("Select any two add ons")
    public void select_any_add_ons() {
        extraServicesPage.select_two_addons();
        addScreenshot();
    }
    @Then("Validate all details - Date, no of nights, room type, rate, add on \\(extra services charges), total")
    public void validate_all_details_date_no_of_nights_room_type_rate_add_on_extra_services_charges_total() {
        assertEquals(contactDetailsPage.arrival_date(),arrival_date);
        assertEquals(contactDetailsPage.no_of_nights(), "4");
        assertEquals(contactDetailsPage.room_type(), "Deluxe Appartment");
        assertEquals(contactDetailsPage.rate(), "Rack Rate Standard Max +");
        assertEquals(contactDetailsPage.addon(), "75.00 EUR");
        assertEquals(Double.toString(contactDetailsPage.total()), Double.toString(roomSelectionPage.highest_value + 75.0));
    }
    @Then("Add traveler details and payment method to CC")
    public void add_traveler_details_and_payment_method_to_cc() {
        contactDetailsPage.enter_user_details_and_create_booking();
        addScreenshot();
    }
    @Then("Use a dummy Visa CC and complete payment")
    public void use_a_dummy_visa_cc_and_complete_payment() {
        paymentPage.enterPaymentDetails();
        addScreenshot();
    }
    @Then("Validate Booking complete msg")
    public void validate_booking_complete_msg() {
        assertEquals(paymentPage.bookingMsg(), "Check your e-mail for booking confirmation.");
        addScreenshot();
    }
    @After
    public void closeDriver(){
        if(this.scenario.isFailed())
        {
            addScreenshot();
        }
        context.getDriver().quit();
    }
    @Before
    public void setUpScenario(Scenario scenario){
    this.scenario = scenario; 
    }
    
    public void addScreenshot(){
        TakesScreenshot ts = (TakesScreenshot) context.getDriver();
		byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshot, "image/png", "");
    }
    
}
