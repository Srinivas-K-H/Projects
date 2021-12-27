@bookTicket
Feature: Verify user is able to book ticket successfully

  Scenario Outline: able to book ticket successfully and id is generated
    Given Navigate to blazedemo site
    When Verify welcome page is display
    And Select "<DEPARTURE_CITY>" city
    And Select "<DESTINATION_CITY>" city
    And click find flights
    Then Verify flights "<DEPARTURE_CITY>" and "<DESTINATION_CITY>" message
    When Choose the "<FLIGHT_NUMBER>"
    Then Verify flight reserved message
    When Enter first "<NAME>"
    And Enter address"<ADDRESS>"
    And Enter city "<CITY>"
    And enter state "<STATE>"
    And Enter zipcode"<ZIPCODE>"
    And Enter credit "<CARD_NUMBER>"
    And Enter "<NAME_ON_CARD>"
    And select purchase flight
    Then Verify thank you message
    And Verify id is generated succesfully

    Examples:
      | DEPARTURE_CITY | DESTINATION_CITY | FLIGHT_NUMBER | NAME     | ADDRESS   | CITY      | STATE     | ZIPCODE | CARD_NUMBER | NAME_ON_CARD |
      | Boston         | London           | 234           | Srinivas | Karnataka | Bangalore | KARNATAKA | 560043  | SRINIVAS    | 1234         |
