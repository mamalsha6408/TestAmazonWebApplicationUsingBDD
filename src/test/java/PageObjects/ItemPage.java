package PageObjects;

import org.openqa.selenium.By;

import Utilities.BaseClass;

public class ItemPage extends BaseClass{

    private By item_name=By.xpath("//span[@id=\"productTitle\"]");
    private By item_price=By.xpath("//*[@id=\"corePriceDisplay_desktop_feature_div\"]");
    private By btn_addToCart=By.id("add-to-cart-button");
    private By btn_cartSideSheet=By.xpath("//*[@id=\"attach-sidesheet-view-cart-button\"]/span/input");

    public void clickAddToCartButton(){
        driver.findElement(btn_addToCart).click();
    }

    public void clickCartButtonInSideSheet(){
        driver.findElement(btn_cartSideSheet).click();
    }

    public void printItemDetails(){
        String name=driver.findElement(item_name).getText();
        String price=driver.findElement(item_price).getText();
        System.out.println("Item Name : "+name);
        System.out.println("Item Price : "+price);
    }

}
