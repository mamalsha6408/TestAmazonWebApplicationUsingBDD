package StepDefinitions;

import PageObjects.CheckOutPage;
import Utilities.BaseClass;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class checkOutSteps extends BaseClass {

    @When("user click proceed to buy button")
    public void user_click_proceed_to_buy_button() {
        cartPage.clickProccedToBuy();
    }

    @When("user navigate to Checkout Page")
    public void user_navigate_to_checkout_page() {
        driver.getPageSource().contains("Checkout");
        checkOutPage=new CheckOutPage();
    }

    //--add new address popup

    @When("user click Add new address link")
    public void user_click_add_new_address_link() {
        checkOutPage.clickAddNewAddressLink();
    }

    @When("user select country in delivery address popup form")
    public void user_select_country_in_delivery_address_popup_form() {
        checkOutPage.selectCountry(prop.getProperty("co_country"));
    }

    @When("user enter name in delivery address popup form")
    public void user_enter_name_in_delivery_address_popup_form() {
        checkOutPage.enterUserName(prop.getProperty("co_name"));
    }

    @When("user enter mobile in delivery address popup form")
    public void user_enter_mobile_in_delivery_address_popup_form() {
        checkOutPage.enterMobileNo(prop.getProperty("co_mobile"));
    }

    @When("user enter pincode in delivery address popup form")
    public void user_enter_pincode_in_delivery_address_popup_form() {
        checkOutPage.enterPinCode(prop.getProperty("co_pin"));
    }

    @When("user enter address line one in delivery address popup form")
    public void user_enter_address_line_one_in_delivery_address_popup_form() {
        checkOutPage.enterAddressLine1(prop.getProperty("co_address1"));
    }

    @When("user enter address line two in delivery address popup form")
    public void user_enter_address_line_two_in_delivery_address_popup_form() {
        checkOutPage.enterAddressLine2(prop.getProperty("co_address2"));
    }

    @When("user enter landmark in delivery address popup form")
    public void user_enter_landmark_in_delivery_address_popup_form() {
        checkOutPage.enterLandMark(prop.getProperty("co_landmark"));
    }

    @When("user enter city in delivery address popup form")
    public void user_enter_city_in_delivery_address_popup_form() {
        checkOutPage.enterCity(prop.getProperty("co_city"));
    }

    @When("user select state in delivery address popup form")
    public void user_select_state_in_delivery_address_popup_form() {
        checkOutPage.selectState(prop.getProperty("co_state"));
    }

    @Then("user click use this address button in delivery address popup form")
    public void user_click_use_this_address_button_in_delivery_address_popup_form() {
        checkOutPage.clickUseThisAddressButtonInPopup();
    }

    //--add new address popup

    //and user click use this address button -feature command
//    @Then("user click use this address button")
//    public void user_click_use_this_address_button(){
//        checkOutPage.clickUseThisAddressButton();
//    }

    //--credit card

    @When("user clcik credit card radio button")
    public void user_clcik_credit_card_radio_button() {
        checkOutPage.clickCreditCardRadioButton();
    }

    @When("user click enter credit card details link")
    public void user_click_enter_credit_card_details_link() {
        checkOutPage.clickEnterCardDetailsLink();
    }

    @When("user enter invalid card number in credit card popup form")
    public void user_enter_invalid_card_number_in_credit_card_popup_form() throws InterruptedException {
        checkOutPage.enterCardNumber(prop.getProperty("co_cc_number"));
    }

    @When("user enter card holder name in credit card popup form")
    public void user_enter_card_holder_name_in_credit_card_popup_form() {
        checkOutPage.enterCardName(prop.getProperty("co_cc_name"));
    }

    @When("user select month in credit card popup form")
    public void user_select_month_in_credit_card_popup_form() {
        checkOutPage.selectMonth(prop.getProperty("co_cc_month"));
    }

    @When("user select year in credit card popup form")
    public void user_select_year_in_credit_card_popup_form() {
        checkOutPage.selectYear(prop.getProperty("co_cc_year"));
    }

    @Then("user click enter card details button")
    public void user_click_enter_card_details_button() {
        checkOutPage.clickEnterCardDetails();
    }

    @Then("user got error message")
    public void user_got_error_message() {
        checkOutPage.checkErrorMessageDisplayed();
    }

    //--credit card

}
