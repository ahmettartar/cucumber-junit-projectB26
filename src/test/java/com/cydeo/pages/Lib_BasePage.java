package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Lib_BasePage {
    public Lib_BasePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    public WebElement click_on_link(String link_name) {
        return Driver.getDriver().findElement(By.xpath("//span[.='" + link_name + "']"));
    }
    @FindBy(xpath = "//span[contains(text(),'Test')]")
    public WebElement account_holder;
    @FindBy(id = "navbarDropdown")
    public WebElement navigation_dropdown;
    @FindBy(linkText = "Log Out")
    public WebElement log_out;
}
