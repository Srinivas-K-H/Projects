package StepDefinitions;
import BaseTest.configuration;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;

public class hooks extends configuration {
    @Before
    public void openBrowser() throws Exception {
        openBrowser("Chrome");
    }

    @After(order = 0)
    public void embededScreenShot(Scenario scenario) throws Exception {
        if (scenario.isFailed()) {
            try {
                final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                scenario.embed(screenshot, "image/png");
            } catch (WebDriverException wd) {
                System.err.println(wd.getMessage());
            } catch (ClassCastException cce) {
                cce.printStackTrace();
            }
        }
        driver.quit();
    }


}
