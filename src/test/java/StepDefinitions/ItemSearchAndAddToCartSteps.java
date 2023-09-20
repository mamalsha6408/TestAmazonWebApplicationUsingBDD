package StepDefinitions;

import PageObjects.CartPage;
import PageObjects.IndexPage;
import PageObjects.ItemPage;
import PageObjects.SearchResultPage;
import Utilities.BaseClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class ItemSearchAndAddToCartSteps extends BaseClass {

    String item="";
    String homewindow;

    @Given("user in amazon index page")
    public void user_in_amazon_index_page() {
        cartPage=new CartPage();
        indexPage=new IndexPage();
        itemPage=new ItemPage();
        searchResultPage=new SearchResultPage();

        driver.get(prop.getProperty("home_url"));

        String exp_title="Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
        Assert.assertEquals(exp_title,driver.getTitle());

    }

    @Given("logged user in amazon index page")
    public void logged_user_in_amazon_page(){
        cartPage=new CartPage();
        indexPage=new IndexPage();
        itemPage=new ItemPage();
        searchResultPage=new SearchResultPage();
    }

    @And("user enter item name in search field and search")
    public void user_enter_item_name_in_search_field_and_search(io.cucumber.datatable.DataTable dataTable) {
        List<String> items=dataTable.asList();
        item= items.get(0);
        indexPage.enterItemInSearchField(item);
    }

    @And("user navigate to search result page")
    public void user_navigate_to_search_result_page() {
        searchResultPage.checkSearchResultAvailable(item);
    }

    @When("user select first item from search result")
    public void user_select_first_item_from_search_result() {
        searchResultPage.selectItemFromSearchResult();
    }

    @When("user navigate to selected item page")
    public void user_navigate_to_selected_item_page() {
        Set<String> windowValues=driver.getWindowHandles();
        Iterator<String> iter= windowValues.iterator();
        homewindow=iter.next();
        String w2=iter.next();
        driver.switchTo().window(w2);
    }

    @When("user click add to cart button")
    public void user_click_add_to_cart_button() {
        itemPage.clickAddToCartButton();
    }

    @Then("user click cart button to navigate cart")
    public void user_click_cart_button_to_navigate_cart() {
        itemPage.clickCartButtonInSideSheet();
    }

    @Then("validate added item is present in cart")
    public void validate_added_item_is_present_in_cart() {
        //check title
        String exp_title="Amazon.in Shopping Cart";
        Assert.assertEquals(exp_title,driver.getTitle());
        cartPage.checkItemIsAvailableInCart(item);
    }

    @Then("user close cartPage and navigate to searchPage")
    public void user_close_cart_page_and_navigate_to_search_page() {
        driver.close();
        driver.switchTo().window(homewindow);
        searchResultPage.clearSearchField();
    }


    @Then("print all the cart items")
    public void print_all_the_cart_items() {
        cartPage.printItemsNameAndPrice();
    }

    @Then("user delete first item from cart item list")
    public void user_delete_first_item_from_cart_item_list() {
        cartPage.deleteFirstItem();
    }

}
