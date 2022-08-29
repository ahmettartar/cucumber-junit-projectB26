package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Lib_HomePage {
    public Lib_HomePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(id = "user_count")
    public WebElement user_count;
}
