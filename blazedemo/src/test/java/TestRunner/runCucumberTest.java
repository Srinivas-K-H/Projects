package TestRunner;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:features",
        plugin = {"html:target/cucumber-html-report", // html report
        },
        glue = {"StepDefinitions"},
           tags = {"@bookTicket"})

public class runCucumberTest {
    @AfterClass()
    public static void setup() throws Exception {

    }

}