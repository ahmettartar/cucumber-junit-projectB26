package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WikipediaSearchPage {

    public WikipediaSearchPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//input[@id='searchInput']")
    public WebElement searchBox;

    @FindBy(xpath = "//i[@class='sprite svg-search-icon']")
    public WebElement searchBtn;

    @FindBy (xpath = "//h1[@id='firstHeading']")
    public WebElement header;

    @FindBy(xpath = "//div[@class='fn']")
    public WebElement imageHeader;






}
