package StepDefinitions;

import PageObjects.SignInPage;
import Utilities.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UserSignInSteps extends BaseClass {



    @Given("user in amazon signin page")
    public void user_in_amazon_signin_page() {
        signInPage=new SignInPage();
        driver.get(prop.getProperty("user_signin_url"));
    }

    @Given("user enter user email")
    public void user_enter_user_email() {
        signInPage.enterEmail(prop.getProperty("un"));
    }

    @When("user click button continue")
    public void user_click_button_continue() {
        signInPage.clickContinueButton();
    }

    @When("user enter user password")
    public void user_enter_user_password() {
        signInPage.enterPassword(prop.getProperty("pw"));
    }

    @When("user click button signin")
    public void user_click_button_signin() {
        signInPage.clickSigninButton();
    }

    @Then("user navigate to home page")
    public void user_navigate_to_home_page() {
        driver.getTitle().contains("home");
    }

    @Given("user signin")
    public void user_signin(){
        driver.get(prop.getProperty("user_signin_url"));
        signInPage.oneStepSignIn(prop.getProperty("un"), prop.getProperty("pw") );
    }

}
