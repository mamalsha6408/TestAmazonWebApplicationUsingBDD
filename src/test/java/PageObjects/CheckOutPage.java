package PageObjects;

import Utilities.BaseClass;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class CheckOutPage extends BaseClass {

    private By ad_module_select_country=By.id("address-ui-widgets-countryCode-dropdown-nativeId");
    private By ad_module_tf_name=By.id("address-ui-widgets-enterAddressFullName");
    private By ad_module_tf_mobile=By.id("address-ui-widgets-enterAddressPhoneNumber");
    private By ad_module_tf_pin=By.id("address-ui-widgets-enterAddressPostalCode");
    private By ad_module_tf_addressLine1=By.id("address-ui-widgets-enterAddressLine1");
    private By ad_module_tf_addressLine2=By.id("address-ui-widgets-enterAddressLine2");
    private By ad_module_tf_addressLandMark=By.id("address-ui-widgets-landmark");
    private By ad_module_tf_city=By.id("address-ui-widgets-enterAddressCity");
    private By ad_module_select_state=By.id("address-ui-widgets-enterAddressStateOrRegion-dropdown-nativeId");
    private By ad_module_btn_useThisAddress=By.xpath("//*[@id=\"address-ui-widgets-form-submit-button\"]/span/input");

    private By link_addNewAddress=By.id("add-new-address-popover-link");
    private By btn_useThisAddress=By.id("Address_selectShipToThisAddress");
    private By checkBox_CreditCard=By.xpath("//input[@value=\"SelectableAddCreditCard\"]");
    private By link_enterCardDetails=By.xpath("//*[@class=\"a-row pmts-add-cc-default-trigger\"]");

    private By pop_head=By.id("a-popover-header-1");

    private By cc_module_tf_number=By.xpath("//input[@name=\"addCreditCardNumber\"]");
    private By cc_module_tf_name=By.xpath("//*[@class=\"a-input-text a-form-normal apx-add-credit-card-account-holder-name-input mcx-input-fields\"]");
    private By cc_module_select_month=By.xpath("//*[@name=\"ppw-expirationDate_month\"]");
    private By cc_module_select_year=By.xpath("//*[@name=\"ppw-expirationDate_year\"]");
    private By cc_module_btn_enter=By.xpath("//*[@class=\"a-button a-button-primary pmts-button-input\"]/span/input");
    private By cc_error_msg=By.xpath("//*[@class=\"a-row a-spacing-base apx-add-card-compact-grid-row\"]/div/div/div/div/h4");

    public void clickAddNewAddressLink(){
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(link_addNewAddress));
        driver.findElement(link_addNewAddress).click();
    }

    //--address module

    public void selectCountry(String country){
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(ad_module_select_country));
        Select dd=new Select(driver.findElement(ad_module_select_country));
        dd.selectByVisibleText(country);
    }

    public void enterUserName(String name){
        driver.findElement(ad_module_tf_name).sendKeys(name);
    }

    public void enterMobileNo(String mobile) {
        driver.findElement(ad_module_tf_mobile).sendKeys(mobile);
    }
    public void enterPinCode(String pin){
        driver.findElement(ad_module_tf_pin).clear();
        driver.findElement(ad_module_tf_pin).sendKeys(pin);
    }

    public void enterAddressLine1(String address1){
        driver.findElement(ad_module_tf_addressLine1).sendKeys(address1);
    }

    public void enterAddressLine2(String address2){
        driver.findElement(ad_module_tf_addressLine2).sendKeys(address2);
    }

    public void enterLandMark(String landmark){
        driver.findElement(ad_module_tf_addressLandMark).sendKeys(landmark);
    }

    public void enterCity(String city){
        driver.findElement(ad_module_tf_city).clear();
        driver.findElement(ad_module_tf_city).sendKeys(city);
    }

    public void selectState(String state){
        Select dd=new Select(driver.findElement(ad_module_select_state));
        dd.selectByVisibleText(state);
    }

    public void clickUseThisAddressButtonInPopup(){
        Actions actions=new Actions(driver);
        actions.doubleClick(driver.findElement(ad_module_btn_useThisAddress)).perform();
    }

    //--address module

    //not used
    public void clickUseThisAddressButton(){
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(btn_useThisAddress));
        driver.findElement(btn_useThisAddress).click();
    }

    public void clickCreditCardRadioButton(){
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(checkBox_CreditCard));
        driver.findElement(checkBox_CreditCard).click();
    }

    public void clickEnterCardDetailsLink(){
        List<WebElement> links=driver.findElements(link_enterCardDetails);

        for (WebElement link:links) {
            wait.until(ExpectedConditions.visibilityOf(link));
            Actions actions=new Actions(driver);
            actions.doubleClick(link).perform();
            waitUntilPopupLink(link);
            break;
        }

    }

    public void waitUntilPopupLink(WebElement element){
        System.out.println("custom wait-"+driver.findElement(pop_head).isDisplayed());
        if(!driver.findElement(pop_head).isDisplayed()){
            System.out.println("custom wait-pop"+ element.isDisplayed());
            if (!element.isDisplayed()){
                driver.findElement(checkBox_CreditCard).click();
                clickEnterCardDetailsLink();
            }
        }
    }

    public void enterCardNumber(String number)throws InterruptedException{
        Thread.sleep(10000);
        driver.switchTo().frame(driver.findElement(By.xpath("//*[@name=\"ApxSecureIframe\"]")));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(cc_module_tf_number)));
        driver.findElement(cc_module_tf_number).sendKeys(number);
    }

    public void enterCardName(String name){
        driver.findElement(cc_module_tf_name).clear();
        driver.findElement(cc_module_tf_name).sendKeys(name);
    }

    public void selectMonth(String month){
        Select select=new Select(driver.findElement(cc_module_select_month));
        select.selectByVisibleText(month);
    }

    public void selectYear(String year){
        Select select=new Select(driver.findElement(cc_module_select_year));
        select.selectByVisibleText(year);
    }

    public void clickEnterCardDetails(){
        driver.findElement(cc_module_btn_enter).click();
    }

    public void checkErrorMessageDisplayed(){
        driver.getPageSource().contains("There was a problem.");
        if(driver.findElement(cc_error_msg).isDisplayed()){
            Assert.assertTrue(false);
        }
    }


}
