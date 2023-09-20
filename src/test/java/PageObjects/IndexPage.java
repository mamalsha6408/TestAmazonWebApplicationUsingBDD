package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import Utilities.BaseClass;

public class IndexPage extends BaseClass{

    private By search_field=By.id("twotabsearchtextbox");

    public void enterItemInSearchField(String item) {
        driver.findElement(search_field).sendKeys(item+Keys.ENTER);

    }

}
