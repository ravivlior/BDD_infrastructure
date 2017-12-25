Feature: sanity scenario for entities feature
  Background: Definition of object repository for all scenarios
    Given Object repository for all GUI items is "WsCnsObjectRepository.json"

  Scenario Outline: log in to WS system
    Given navigate to "http://10.32.5.23/ui/" on browser
    When type into "<field1>" the "<inputText1>"
    And type into "<field2>" the "<inputText2>"
    And press on button "<buttonID>"
    Then wait for "<displayedItem>" is displaying on screen with timeout of "<timeout>"

    Examples:
      | field1        | inputText1   | field2         | inputText2 |  buttonID            | displayedItem |timeout |
      | userNameField | User10       | passwordField  | Pass123    | startSessionButton   | addButton     |10      |

  Scenario Outline: add entity with just mandatory fields and cancel it
    Given wait for "<buttonID0>" is displaying on screen with timeout of "<timeout>"
    When press on button "<buttonID0>"
#    And wait for "<dropdown>" is displaying on screen with timeout of "<timeout>"
    And select item "<index>" from dropdown list "<dropdown>"

#    And wait for "<buttonID1>" is displaying on screen with timeout of "<timeout>"
#    And press on button "<buttonID1>"
    And wait for "<field1>" is displaying on screen with timeout of "<timeout>"
    And type into "<field1>" the "<inputText1>"
    And type into "<field2>" the "<inputText2>"
    And press on button "<buttonID3>"
    And wait for "<buttonID4>" is displaying on screen with timeout of "<timeout>"
    And press on button "<buttonID4>"
    And wait for "<field1>" is displaying on screen with timeout of "<timeout>"
    And press on button "<buttonID3>"
    And wait for "<buttonID4>" is displaying on screen with timeout of "<timeout>"
    And press on button "<buttonID5>"
    And type into "<field3>" the "<inputText3>"
    And press on RETURN when in field "<field3>"
    Then list of results "<resultList>" not containing the item "<itemOnList>"

    Examples:
      | buttonID0| dropdown      |index| field1              |inputText1| field2             | inputText2| buttonID3         | buttonID4                        |buttonID5                        | field3          |inputText3|resultList    |itemOnList|timeout |
      | addButton| addDropdown   | 3    | personFirstNameField|Avi       | personLastNameField| Ron       | personCancelButton| PersonCancelConformationNOButton |PersonCancelConformationYESButton| mainSearchField |Avi       |mainSearchList|Avi       | 10     |