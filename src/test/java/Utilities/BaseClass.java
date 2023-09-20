package Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import PageObjects.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

    public static UserRegistrationPage userRegistrationPage;

    public static WebDriver driver;
    public static WebDriverWait wait;

    public static FileInputStream fi;
    public static Properties prop;

    public static SignInPage signInPage;
    public static CartPage cartPage;
    public static IndexPage indexPage;
    public static ItemPage itemPage;
    public static SearchResultPage searchResultPage;
    public static CheckOutPage checkOutPage;

    public static void setUpDriver() {
        if(driver==null) {
            WebDriverManager.chromedriver().setup();
            System.setProperty("webdriver.chrome.driver", "src/test/resources/Drivers/chromedriver.exe");
            driver=new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            wait=new WebDriverWait(driver, 30);
        }
    }

    public static void tearDown() {
        if(driver!=null) {
            driver=null;
        }
    }

    public static void setUpPropertiesFile()throws IOException{
        fi=new FileInputStream("src/test/resources/testData.properties");
        prop=new Properties();
        prop.load(fi);
    }

}
