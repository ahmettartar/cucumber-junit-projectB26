package com.cydeo.step_definitions;

import com.cydeo.pages.MonthsPage;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class MonthsDropdownCydeo {
    MonthsPage monthsPage=new MonthsPage();

    @Given("user is on the dropdowns page of practice tool")
    public void user_is_on_the_dropdowns_page_of_practice_tool(){
        Driver.getDriver().get(ConfigurationReader.getProperty("cydeo.dropdown.url"));
    }

    @Then("user should see below info in month dropdown")
    public void user_should_see_below_info_in_month_dropdown(List<String> expected_months){
        Select month_dropdown = new Select(monthsPage.months_dropdown);
        for (int i = 0; i <month_dropdown.getOptions().size(); i++) {
            Assert.assertEquals(month_dropdown.getOptions().get(i).getText(),expected_months.get(i));
            month_dropdown.selectByVisibleText(expected_months.get(i));
            Assert.assertTrue(month_dropdown.getOptions().get(i).isDisplayed());
            Assert.assertTrue(month_dropdown.getOptions().get(i).isSelected());
            Assert.assertTrue(month_dropdown.getOptions().get(i).isEnabled());
        }
    }
}
