package StepDefinitions;

import Utilities.BaseClass;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

public class testElement extends BaseClass {

    @When("user click cart button")
    public void user_click_cart_button() {
        driver.findElement(By.xpath("//*[@id=\"nav-cart-count-container\"]/span[2]")).click();
    }

    @Then("user navigate to cart page")
    public void user_navigate_to_cart_page() {
        String exp_title="Amazon.in Shopping Cart";
        Assert.assertEquals(exp_title,driver.getTitle());
    }

}
