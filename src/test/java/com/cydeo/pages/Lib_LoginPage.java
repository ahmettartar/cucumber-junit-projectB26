package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Lib_LoginPage extends Lib_BasePage{

    public Lib_LoginPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "inputEmail")
    public WebElement emailInput;

    @FindBy(id = "inputPassword")
    public WebElement passwordInput;

    @FindBy(xpath = "//button")
    public WebElement signinBtn;

    //baska yerde farkli sekilde yazilmis, ondan ekledim.
    @FindBy(id = "inputEmail")
    public WebElement login_input;
    @FindBy(id = "inputPassword")
    public WebElement password_input;
    @FindBy(css = "button[class*='block']")
    public WebElement sign_in;


    public void login(String email,String password){
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        signinBtn.click();
    }
}
