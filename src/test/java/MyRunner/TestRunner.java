package MyRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
                features = "C://Users//TB5EC//IdeaProjects//SeleniumCucumber//Features//Customers.feature",
                //Bütün feature'ları çalıştırmak için;
                // "C://Users//TB5EC//IdeaProjects//SeleniumCucumber//Features/";
        //Belirli feature'ları çalıştırmak için;
        //{"C://Users//TB5EC//IdeaProjects//SeleniumCucumber//Features//Customers.feature",
        // "C://Users//TB5EC//IdeaProjects//SeleniumCucumber//Features//Login.feature"},

                glue = "stepDefinitions",
                dryRun = false,
                monochrome = true,
                plugin = {"pretty","html:test-output"}
)
public class TestRunner {
}
