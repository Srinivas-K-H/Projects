package PageObject;

import BaseTest.configuration;
import StepDefinitions.flights;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.support.PageFactory;

public class flightsPage extends configuration {
flights flights = PageFactory.initElements(driver, flights.class);


    @Then("^Verify flights \"([^\"]*)\" and \"([^\"]*)\" message$")
    public void verifyMessage(String departure, String destination) throws Exception{
        flights.verifyflightTravellMessage(departure, destination);
    }

    @When("^Choose the \"([^\"]*)\"$")
    public void chooseFlightNumber(int number) throws Exception{
        flights.flightNumber(number);
    }

    @Then("^Verify flight reserved message$")
    public void verifyFlightReservedMessage() throws Exception{
        flights.reservedMessage();
    }

    @When("^Enter first \"([^\"]*)\"$")
    public void enterFirstName(String name) throws Exception{
        flights.firstName(name);
    }

    @And("^Enter address\"([^\"]*)\"$")
    public void enterAddress(String address) throws Exception {
        flights.address(address);
    }

    @And("^Enter city \"([^\"]*)\"$")
    public void enterCity(String city) throws Exception {
        flights.city(city);
    }

    @And("^enter state \"([^\"]*)\"$")
    public void enterState(String state) throws Exception {
        flights.state(state);
    }

    @And("^Enter zipcode\"([^\"]*)\"$")
    public void enterZipcode(String zipCode) throws Exception {
        flights.zipcode(zipCode);
    }

    @And("^Enter credit \"([^\"]*)\"$")
    public void enterCredit(String cardNum) throws Exception {
        flights.creditCardNumber(cardNum);
    }

    @And("^Enter \"([^\"]*)\"$")
    public void enter(String name) throws Exception {
        flights.nameOnCard(name);
    }

    @And("^select purchase flight$")
    public void selectPurchaseFlight()throws Exception{
        flights.purchaseFlight();
    }

    @Then("^Verify thank you message$")
    public void verifyThankYouMessage() throws Exception{
        flights.verifyThankYouMsg();
    }


    @And("^Verify id is generated succesfully$")
    public void verifyIdIsGeneratedSuccesfully() throws Exception{
        flights.verifyID();
    }
}
