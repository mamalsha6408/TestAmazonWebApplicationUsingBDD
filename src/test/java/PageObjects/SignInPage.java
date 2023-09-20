package PageObjects;

import Utilities.BaseClass;
import org.openqa.selenium.By;

public class SignInPage extends BaseClass {

    private By tf_email=By.id("ap_email");
    private By tf_password=By.id("ap_password");
    private By btn_continue=By.id("continue");
    private By btn_signin=By.id("signInSubmit");

    public void enterEmail(String email){
        driver.findElement(tf_email).sendKeys(email);
    }

    public void clickContinueButton(){
        driver.findElement(btn_continue).click();
    }

    public void enterPassword(String password){
        driver.findElement(tf_password).sendKeys(password);
    }

    public void clickSigninButton(){
        driver.findElement(btn_signin).click();
    }

    public void oneStepSignIn(String email,String password){
        driver.findElement(tf_email).sendKeys(email);
        driver.findElement(btn_continue).click();
        driver.findElement(tf_password).sendKeys(password);
        driver.findElement(btn_signin).click();
    }

}
