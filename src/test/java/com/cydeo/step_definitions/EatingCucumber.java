package com.cydeo.step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EatingCucumber {

    @Given("John is hungry")
    public void john_is_hungry() {
//        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
        //Burayi dolduruyoruz. Yukaridakileri sileriz.
        System.out.println("It is from Given");
    }

    @When("he eats some cucumbers")
    public void he_eats_some_cucumbers() {
        System.out.println("It is from when");
    }

    @Then("he will be full")
    public void he_will_be_full() {
        System.out.println("It is from Then");
    }

    //Calisma sirasi => Given When Then seklinde olur.
    //Yukaridaki siralamayi dikkate almaz.
    //Kullanilaran tagler uzerinden siralama bu sekilde (Given-When-Then) seklinde olur.

}
