package Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features ="src/test/resources/Features",glue="StepDefinitions",tags="@checkout",dryRun=false,
        plugin = {"pretty",
                "html:target/cucmber-reports.html",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        monochrome = true)
public class TestRunner {

}

//,"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"