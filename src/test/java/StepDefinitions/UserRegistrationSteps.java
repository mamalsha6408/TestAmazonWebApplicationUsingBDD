package StepDefinitions;

import PageObjects.UserRegistrationPage;
import Utilities.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UserRegistrationSteps extends BaseClass {

    @Given("user in amazon user registration page")
    public void user_in_amazon_user_registration_page() {
        userRegistrationPage=new UserRegistrationPage();
        driver.get(prop.getProperty("user_resgistration_url"));
    }

    @Given("user enter name")
    public void user_enter_name() {
        userRegistrationPage.enterName(prop.getProperty("ur_name"));
    }

    @Given("user select country code")
    public void user_select_country_code() {
        userRegistrationPage.selectCountryCode(prop.getProperty("ur_countryCode"));
    }

    @Given("user enter mobile no")
    public void user_enter_mobile_no() {
        userRegistrationPage.enterPhoneNo(prop.getProperty("ur_phone"));
    }

    @Given("user enter valid email")
    public void user_enter_valid_email() {
        userRegistrationPage.enterEmail(prop.getProperty("ur_email"));
    }

    @Given("user enter password")
    public void user_enter_password() {
        userRegistrationPage.enterPassword(prop.getProperty("ur_password"));
    }

    @When("user clcik continue button")
    public void user_clcik_continue_button() {
        userRegistrationPage.clcikContinueButton();
    }

    @Then("user should navigate to next window")
    public void user_should_navigate_to_next_windoe() {
        System.out.println("user in next page");
    }

    @Then("error message should displayed under the username")
    public void error_message_should_displayed_under_the_username() {

    }

    @Then("error message should displayed under the mobile number")
    public void error_message_should_displayed_under_then_mobile_number() {

    }

    @Then("error message should displayed under the password")
    public void error_message_should_displayed_under_the_password() {

    }

}
