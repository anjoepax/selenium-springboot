package com.ajmspring.org.bdd;

import com.ajmspring.org.annotations.LazyAutowired;
import com.ajmspring.org.page.visa.VisaRegistrationPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import java.time.LocalDate;


public class VisaRegistrationSteps {

    @LazyAutowired
    private VisaRegistrationPage registrationPage;

    @Given("I am on VISA registration form")
    public void launchSite() {
        this.registrationPage.goTo();
        Assert.assertTrue(this.registrationPage.isAt());
    }

    @When("I select my from country {string} and to country {string}")
    public void selectCountry(String from, String to) {
        this.registrationPage.setCountryFromAndTo(from, to);
    }

    @And("U enter my date of birth as {string}")
    public void enterDob(String dob) {
        this.registrationPage.setBirthDate(LocalDate.parse(dob));
    }

    @And("I enter my name as {string} and {string}")
    public void enterName(String firstName, String lastName) {
        this.registrationPage.setNames(firstName, lastName);
    }

    @And("I enter my contact details as {string} and {string}")
    public void enterContactDetails(String email, String phone) {
        this.registrationPage.setContactDetails(email, phone);
    }

    @And("I enter the comment {string}")
    public void enterComments(String comments) {
        this.registrationPage.setComments(comments);
    }

    @And("I submit the form")
    public void submit() {
        this.registrationPage.submit();
    }

    @Then("I should see get the confirmation number")
    public void iShouldSeeGetTheConfirmationNumber() {
        String number = this.registrationPage.getConfirmationNumber();
        Assert.assertFalse(number.isEmpty());
    }
}
