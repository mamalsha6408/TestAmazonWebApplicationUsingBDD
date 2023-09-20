package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import Utilities.BaseClass;

public class UserRegistrationPage extends BaseClass{

    private By tf_name=By.id("ap_customer_name");
    private By dd_countryCode=By.id("auth-country-picker");
    private By tf_phoneNo=By.id("ap_phone_number");
    private By tf_email=By.id("ap_email");
    private By pf_password=By.id("ap_password");
    private By btn_continue=By.id("continue");

    public void enterName(String name) {
        driver.findElement(tf_name).sendKeys(name);
    }

    public void selectCountryCode(String countryCode) {
        Select dd=new Select(driver.findElement(dd_countryCode));
        dd.selectByVisibleText(countryCode);
    }

    public void enterPhoneNo(String phoneno) {
        driver.findElement(tf_phoneNo).sendKeys(phoneno);
    }

    public void enterEmail(String email) {
        driver.findElement(tf_email).sendKeys(email);
    }

    public void enterPassword(String password) {
        driver.findElement(pf_password).sendKeys(password);
    }

    public void clcikContinueButton() {
        driver.findElement(btn_continue).click();
    }

}
