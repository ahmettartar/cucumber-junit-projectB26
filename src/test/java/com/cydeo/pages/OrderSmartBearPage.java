package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderSmartBearPage {
    public OrderSmartBearPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(id = "ctl00_MainContent_username")
    public WebElement input_username;

    @FindBy(id = "ctl00_MainContent_password")
    public WebElement input_password;

    @FindBy(id = "ctl00_MainContent_login_button")
    public WebElement login;

    public void login(String username, String password) {
        input_username.sendKeys(username);
        input_password.sendKeys(password);
        login.click();}

    @FindBy(xpath = "//a[.='Order']")
    public WebElement order_btn;

    @FindBy(id = "ctl00_MainContent_fmwOrder_ddlProduct")
    public WebElement product_dropdown;

    @FindBy(id = "ctl00_MainContent_fmwOrder_txtQuantity")
    public WebElement quantity_input;

    @FindBy(id = "ctl00_MainContent_fmwOrder_txtName")
    public WebElement fullName_box;

    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox2")
    public WebElement street_box;

    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox3")
    public WebElement city_box;

    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox4")
    public WebElement state_box;

    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox5")
    public WebElement zip_box;

    @FindBy(css = "input[value='Visa']")
    public WebElement visa;

    @FindBy(css = "input[value='MasterCard']")
    public WebElement mastercard;

    @FindBy(css = "input[value='American Express']")
    public WebElement american_express;

    public WebElement choose_card_type(String card_type) {
        if (card_type.equalsIgnoreCase("Visa")) {
            return visa;
        } else if (card_type.equalsIgnoreCase("MasterCard")) {
            return mastercard;
        } else if (card_type.equalsIgnoreCase("American Express")) {
            return american_express;
        }
        return null;
    }

    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox6")
    public WebElement card_number_box;

    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox1")
    public WebElement expiration_date_box;

    @FindBy(id = "ctl00_MainContent_fmwOrder_InsertButton")
    public WebElement process_btn;

    @FindBy(xpath = "//a[.='View all orders']")
    public WebElement view_all_orders;

    public void check_name_in_list(String customer_name) {
        WebElement name_in_list = Driver.getDriver().findElement(By.xpath("//div[@class='content']//td[.='" + customer_name + "']"));
        //Hanna solution. Burada field locator olmasi lazim, better solution.
        Assert.assertEquals(customer_name, name_in_list.getText());
    }
}
