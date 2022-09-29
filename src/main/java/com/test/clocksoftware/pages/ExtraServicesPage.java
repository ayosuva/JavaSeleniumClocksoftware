package com.test.clocksoftware.pages;
import com.test.clocksoftware.Util.DriverManager;
import org.openqa.selenium.By;

public class ExtraServicesPage extends PageBase {
    public ExtraServicesPage(DriverManager manager){
        super(manager);}

    By input_Airport_Transfer_AddOn     = By.xpath("//*[contains(text(),'Airport')]/../following-sibling::div/input");
    By input_Business_Services_AddOn    = By.xpath("//*[contains(text(),'Business')]/../following-sibling::div/input");
    By btn_Add_Selected_Service         = By.xpath("//input[@value='Add the selected services >>']");

    public void select_two_addons() {
        getWebElementVisible(input_Airport_Transfer_AddOn).sendKeys("1");
        getWebElementVisible(input_Business_Services_AddOn).sendKeys("1");
        getWebElementVisible(btn_Add_Selected_Service).click();
    }

}