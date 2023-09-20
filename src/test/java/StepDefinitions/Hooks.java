package StepDefinitions;

import java.io.IOException;

import Utilities.BaseClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks extends BaseClass {

    public static int i=1;

    @Before
    public void setup() throws IOException {
        System.out.println("hello");
        setUpDriver();
        setUpPropertiesFile();
    }

    @After
    public void teardown() {
        driver.close();
        driver.quit();
        tearDown();
    }

    @AfterStep
    public void executeAfterTest(Scenario scenario) {
        System.out.println("Step - "+i+" "+scenario.getStatus());
        i++;
        if(scenario.isFailed()) {
            final byte[] screenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "image");
        }
    }

}
