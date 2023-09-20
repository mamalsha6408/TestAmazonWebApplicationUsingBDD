package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Utilities.BaseClass;

public class CartPage extends BaseClass{

    private By item_li=By.xpath("//div[@class=\"a-row sc-list-item sc-java-remote-feature\"]");
    private By item_name=By.xpath(".//div[4]/div/div[2]/ul/li[1]/span/a/span");
    private By item_price=By.xpath(".//div[4]/div/div[2]/ul/div/div/div/p/span");

    private By item_btn_delete=By.xpath(".//div[4]/div/div[2]/div[1]/span[2]/span/input");

    private By btn_proceedToBuy=By.xpath(".//*[@id=\"sc-buy-box-ptc-button\"]/span/input");

    public void checkItemIsAvailableInCart(String item) {
        driver.getPageSource().contains(item);
    }

    public void printItemsNameAndPrice() {
        List<WebElement> mainel=driver.findElements(item_li);
        System.out.println("--Cart Item List--");

        for(WebElement sub:mainel) {
            System.out.println("name :"+sub.findElement(item_name).getText());
            System.out.println("price :"+sub.findElement(item_price).getText());
        }

    }

    public void deleteFirstItem() {
        List<WebElement> mainel=driver.findElements(item_li);
        String txt="";

        for(WebElement sub:mainel) {
            txt=sub.findElement(item_name).getText();
            System.out.println("Item --"+txt+"-- deleted");
            sub.findElement(item_btn_delete).click();
            break;
        }

        //to reload page

        driver.get(prop.getProperty("cart_url"));


    }

    public void clickProccedToBuy() {
        driver.findElement(btn_proceedToBuy).click();
    }

}
