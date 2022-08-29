package com.cydeo.step_definitions;

import com.cydeo.pages.WikipediaSearchPage;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;


public class WikipediaSearch {

    WikipediaSearchPage wikipediaSearch = new WikipediaSearchPage();

    @Given("User is on Wikipedia home page")
    public void user_is_on_wikipedia_home_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("wikipedia"));

    }

    @When("User types {string} in the wiki search box")
    public void user_types_in_the_wiki_search_box(String string) {
        wikipediaSearch.searchBox.sendKeys(string);

    }
    @When("User clicks wiki search button")
    public void user_clicks_wiki_search_button() {
        wikipediaSearch.searchBtn.click();

    }
    @Then("User sees {string} is in the wiki title")
    public void user_sees_is_in_the_wiki_title(String string) {
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertTrue(actualTitle.contains(string));

    }

    @Then("User sees {string} is in the main header")
    public void user_sees_is_in_the_main_header(String string) {
        Assert.assertEquals(string,wikipediaSearch.header.getText()); //expected-actual

    }

    @Then("User sees {string} is in the image header")
    public void user_sees_is_in_the_image_header(String string) {
        Assert.assertEquals(string, wikipediaSearch.imageHeader.getText());

    }
}
