package com.cydeo.step_definitions;

import com.cydeo.pages.BasePage;
import com.cydeo.pages.Lib_BasePage;
import com.cydeo.pages.Lib_UsersPage;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Lib_SearchResultsStepDefinitions {

    WebDriverWait wait=new WebDriverWait(Driver.getDriver(),2);
    Lib_BasePage basePage=new Lib_BasePage();
    Lib_UsersPage usersPage=new Lib_UsersPage();

    @And("user click on {string} link")
    public void userClickOnLink(String link_name) {
        basePage.click_on_link(link_name).click();
    }

    @Then("table should have following column names:")
    public void tableShouldHaveFollowingColumnNames(List<String> names){
        for (int i = 0; i <usersPage.table_headers.size() ; i++) {
            Assert.assertEquals(names.get(i),usersPage.table_headers.get(i).getText());
        }

        basePage.navigation_dropdown.click();
        basePage.log_out.click();
    }
}
