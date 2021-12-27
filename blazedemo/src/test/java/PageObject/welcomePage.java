package PageObject;
import BaseTest.configuration;
import StepDefinitions.welcome;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.support.PageFactory;

public class welcomePage extends configuration {
    welcome welcome = PageFactory.initElements(driver, welcome.class);

    @Given("^Navigate to blazedemo site$")
    public void navigateToBlazedemo() throws Exception {
        navigate_To_URL("Blazedemo_url");
    }

    @When("^Verify welcome page is display$")
    public void verifyWelcomePageIsDisplay() throws Exception {
        welcome.welcomeMessage();
    }

    @And("^Select \"([^\"]*)\" city$")
    public void enterDepartureCity(String city) throws Exception {
        welcome.departureCity(city);
    }


    @And("^click find flights$")
    public void clickFindFlights() throws Exception{
        welcome.findFlights();
    }


}
