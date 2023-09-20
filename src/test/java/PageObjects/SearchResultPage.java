package PageObjects;

import Utilities.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchResultPage extends BaseClass {

    private By search_field= By.id("twotabsearchtextbox");
    private By list_of_items=By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div/div/div/div/div/div/div[2]/div/div/div[1]/h2/a");

    public void checkSearchResultAvailable(String item){
        driver.getPageSource().contains(item);
    }

    public void selectItemFromSearchResult(){
        List<WebElement> itemList=driver.findElements(list_of_items);

        for (WebElement item:itemList) {
            item.click();
            break;
        }
    }

    public void clearSearchField(){
        driver.findElement(search_field).clear();
    }

}
