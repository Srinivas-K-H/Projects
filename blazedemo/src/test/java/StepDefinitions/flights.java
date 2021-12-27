package StepDefinitions;

import BaseTest.browserBot;
import org.openqa.selenium.WebDriver;

public class flights extends browserBot {
    public flights(WebDriver driver) throws Exception {
        super(driver);
    }

    public static final String MESSAGE1              = "//h3[text()='Flights from ",
                               MESSAGE2              = " to ",
                               CLOSE_XPATH           = ": ']",
                               CHOOSE_THE_FLIGHT1    = "//tr/td[text()='",
                               CHOOSE_FLIGHT_PART2   = "']/parent::tr/td/input[@type='submit']",
                               RESERVED_MESSAGE      = "//h2[text()='Your flight from TLV to SFO has been reserved.']",
                               FIRST_NAME            = "inputName",
                               ADDRESS               = "address",
                               CITY                  = "city",
                               STATE                 = "state",
                               ZIPCODE               = "zipCode",
                               NAME_ON_CARD          = "nameOnCard",
                               CREDIT_CARD_NUMBER    = "creditCardNumber",
                               PURCHASE_FLIGHT       = "//input[@type='submit']",
                               THANK_YOU             = "//h1[text()='Thank you for your purchase today!']",
                               ID                    = "//tbody/tr/td[contains(text(),'163983')]";


    public void verifyflightTravellMessage(String departure, String destination) throws Exception {
        System.out.println(MESSAGE1 + departure + MESSAGE2 + destination + CLOSE_XPATH);
        waitForElementAppearance(MESSAGE1 + departure + MESSAGE2 + destination + CLOSE_XPATH, "xpath");
        verifyTextIsPresent(MESSAGE1 + departure + MESSAGE2 + destination + CLOSE_XPATH, "xpath", "Departure and destination message is not display");
    }

    public void flightNumber(int number) throws Exception {
        click(CHOOSE_THE_FLIGHT1 + number + CHOOSE_FLIGHT_PART2, "xpath");
    }

    public void reservedMessage() throws Exception {
        waitForElementAppearance(RESERVED_MESSAGE, "xpath");
        verifyTextIsPresent(RESERVED_MESSAGE, "xpath", "Flight Reserved message is not display");
    }

    public void firstName(String name) throws Exception {
        sendKeys(FIRST_NAME, "id", name);
    }
    public void address(String address) throws Exception {
        sendKeys(ADDRESS, "id", address);
    }

    public void city(String city) throws Exception {
        sendKeys(CITY, "id", city);
    }

    public void state(String state) throws Exception {
        sendKeys(STATE, "id", state);
    }

    public void zipcode(String city) throws Exception {
        sendKeys(ZIPCODE, "id", city);
    }

    public void creditCardNumber(String city) throws Exception {
        sendKeys(CREDIT_CARD_NUMBER, "id", city);
    }
    public void nameOnCard(String city) throws Exception {
        sendKeys(NAME_ON_CARD, "id", city);
    }
    public void purchaseFlight() throws Exception {
        click(PURCHASE_FLIGHT, "xpath");
    }
    public void verifyThankYouMsg() throws Exception {
        waitForElementAppearance(THANK_YOU, "xpath");
        verifyTextIsPresent(THANK_YOU, "xpath", "Thank you message is not display");
    }
    public void verifyID() throws Exception {
        verifyTextIsPresent(ID, "xpath", "ID is not generated");
    }

}
