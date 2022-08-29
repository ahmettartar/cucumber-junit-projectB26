package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Lib_LandingPage extends Lib_BasePage {
    public Lib_LandingPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "user_count")
    public WebElement userCount;


    public void log_out() {
        navigation_dropdown.click();
        log_out.click();
    }
}
