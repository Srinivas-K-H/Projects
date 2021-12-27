package StepDefinitions;

import BaseTest.browserBot;
import org.openqa.selenium.WebDriver;

import java.util.Properties;

public class welcome extends browserBot {
    public static Properties prop;
    public welcome(WebDriver driver) throws Exception {
        super(driver);

    }
    public static final String DEPARTURE               = "//select/option[text()='",
                               WELCOME                 = "//div/h1[text()='Welcome to the Simple Travel Agency!']",
                               CLOSE_XPATH             = "']",
                               DEPARTURE_SELECT1       = "//form/select[1]",
                               FIND_FLIGHTS            = "//input[@type='submit']";


    public void welcomeMessage() throws Exception {
        waitForElementAppearance(WELCOME, "xpath");
        verifyTextIsPresent(WELCOME, "xpath", "Welcome page is not display");
    }

    public void departureCity(String city) throws Exception {
        click(DEPARTURE_SELECT1, "xpath");
        click(DEPARTURE+city+CLOSE_XPATH, "xpath");

    }
    public void findFlights() throws Exception {
        click(FIND_FLIGHTS, "xpath");
    }
}
