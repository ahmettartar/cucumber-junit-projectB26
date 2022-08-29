package com.cydeo.step_definitions;

import com.cydeo.pages.*;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Lib_Login_StepDefinitions {

    Lib_LoginPage loginPage = new Lib_LoginPage();
    Lib_HomePage homePage = new Lib_HomePage();
    Lib_BasePage basePage = new Lib_BasePage();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 2);

    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("library.url"));
    }

    @When("user enters librarian username")
    public void userEntersLibrarianUsername() {
        wait.until(ExpectedConditions.visibilityOf(loginPage.login_input));
        loginPage.login_input.sendKeys(ConfigurationReader.getProperty("librarian1_login"));
    }

    @And("user enters librarian password")
    public void userEntersLibrarianPassword() {
        loginPage.password_input.sendKeys(ConfigurationReader.getProperty("librarian1_password"));
        loginPage.sign_in.click();
    }

    @Then("user should see the dashboard")
    public void user_should_see_the_dashboard() {
        wait.until(ExpectedConditions.titleIs("Library"));
        Assert.assertEquals("Library", Driver.getDriver().getTitle());
        basePage.navigation_dropdown.click();
        basePage.log_out.click();
    }

    @When("user enters student username")
    public void userEntersStudentUsername() {
        loginPage.login_input.sendKeys(ConfigurationReader.getProperty("student1_login"));
    }

    @And("user enters student password")
    public void userEntersStudentPassword() {
        loginPage.password_input.sendKeys(ConfigurationReader.getProperty("student1_password"));
        loginPage.sign_in.click();
    }

    @When("user enters {string} username")
    public void userEntersUsername(String username) {
        loginPage.login_input.sendKeys(ConfigurationReader.getProperty(username));
    }

    @And("user enters {string} password")
    public void userEntersPassword(String password) {
        loginPage.password_input.clear();
        loginPage.password_input.sendKeys(ConfigurationReader.getProperty(password));
        loginPage.sign_in.click();
    }

    @When("user login using {string} and {string}")
    public void userLoginUsingAnd(String username, String password) {
        loginPage.login_input.sendKeys(username);
        loginPage.password_input.sendKeys(password);
        loginPage.sign_in.click();
    }

    @And("there should be {int} users")
    public void thereShouldBeUsers(int users_number) {
        wait.until(ExpectedConditions.visibilityOf(homePage.user_count));

        Assert.assertEquals(users_number, Integer.parseInt(homePage.user_count.getText()));
        basePage.navigation_dropdown.click();
        basePage.log_out.click();
    }

    @And("user login as a librarian")
    public void userLoginAsALibrarian() {
        loginPage.login_input.sendKeys(ConfigurationReader.getProperty("librarian1_login"));
        loginPage.password_input.sendKeys(ConfigurationReader.getProperty("librarian1_password"));
        loginPage.sign_in.click();
    }

    @Then("account holder name should be {string}")
    public void accountHolderNameShouldBe(String account_holder_name) {
        Assert.assertEquals(account_holder_name, basePage.account_holder.getText());
        basePage.navigation_dropdown.click();
        basePage.log_out.click();
    }

    @Then("user should see the dashboard page")
    public void userShouldSeeTheDashboardPage() {
        wait.until(ExpectedConditions.titleIs("Library"));
        Assert.assertEquals("Library", Driver.getDriver().getTitle());
    }
}
