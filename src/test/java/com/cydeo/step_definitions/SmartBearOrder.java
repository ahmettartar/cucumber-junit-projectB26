package com.cydeo.step_definitions;

import com.cydeo.pages.OrderSmartBearPage;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.Select;

import java.util.Map;

public class SmartBearOrder {

    OrderSmartBearPage orderSmartBearPage = new OrderSmartBearPage();

    @Given("user is logged into SmartBear Tester account and on Order page")
    public void userIsLoggedIntoSmartBearTesterAccountAndOnOrderPage(Map<String, String> credentials) {
        Driver.getDriver().get(ConfigurationReader.getProperty("smartbear.order.url"));
        orderSmartBearPage.login(credentials.get("Username"), credentials.get("Password"));
    }

    @When("user fills out the form as followed:")
    public void userFillsOutTheFormAsFollowed() {
        orderSmartBearPage.order_btn.click();
    }

    @And("user selects {string} from product dropdown")
    public void userSelectsFromProductDropdown(String product) {
        Driver.getDriver().navigate().refresh();
        Select productDropDown = new Select(orderSmartBearPage.product_dropdown);
        productDropDown.selectByVisibleText(product);
    }

    @Then("user enters {int} to quantity")
    public void userEntersToQuantity(int quantity) {
        orderSmartBearPage.quantity_input.sendKeys(String.valueOf(quantity));
    }

    @And("user enters {string} to costumer name")
    public void userEntersToCostumerName(String customer_name) {
        orderSmartBearPage.fullName_box.sendKeys(customer_name);
    }

    @Then("user enters {string} to street")
    public void userEntersToStreet(String street) {
        orderSmartBearPage.street_box.sendKeys(street);
    }

    @And("user enters {string} to city")
    public void userEntersToCity(String city) {
        orderSmartBearPage.city_box.sendKeys(city);
    }

    @Then("user enters {string} to state")
    public void userEntersToState(String state) {
        orderSmartBearPage.state_box.sendKeys(state);
    }

    @And("user enters {int}")
    public void userEnters(int zip) {
        orderSmartBearPage.zip_box.sendKeys(String.valueOf(zip));
    }

    @Then("user selects {string} as card type")
    public void userSelectsAsCardType(String card_type) {
        orderSmartBearPage.choose_card_type(card_type).click();
    }

    @And("user enters {string} to card number")
    public void userEntersToCardNumber(String card_number) {
        orderSmartBearPage.card_number_box.sendKeys(card_number);
    }

    @Then("user enters {string} to expiration date")
    public void userEntersToExpirationDate(String expiration_date) {
        orderSmartBearPage.expiration_date_box.sendKeys(expiration_date);
    }

    @When("user clicks process button")
    public void userClicksProcessButton() {
        orderSmartBearPage.process_btn.click();
    }

    @Then("user verifies {string} is in the list")
    public void userVerifiesIsInTheList(String customer_name) {
        orderSmartBearPage.view_all_orders.click();
        orderSmartBearPage.check_name_in_list(customer_name);
    }
}
