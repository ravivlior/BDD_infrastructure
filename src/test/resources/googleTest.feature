Feature: search on google

  Background:
    Given navigate to "http://www.google.com" on browser

  Scenario Outline: search STD on google
    When type into "<field>" the "<inputText>"
    And press on "<buttonID>"
    Then the "<resultNumber>" from the list is "<resultValue>"
    And close the browser

  Examples:
     | field  | inputText    | buttonID | resultNumber| resultValue |
     | searchField | STD          | searchField   | 3           | Common STDs |
#     | searchField | מתכון ללביבות | searchField   | 1           | לביבות       |
#
#  Scenario Outline: Test JSON to CSV converter
#    Given navigate to "https://jsonformatter.org/" on browser
#    When type into "<inputField>" the "<inputText>"
#    And press on "<buttonID>"
#    Then "<resultValue>" on "<outputField> field equal to "<expectedResult">
#    And close the browser
#
#    Examples:
#      | inputField  | inputText    | buttonID | resultValue | outputField | expectedResult |
#      |       | STD          | lst-ib   | 3           | Common STDs |                |
##
#  Scenario: read from file
#    Given navigate to google on browser
#    When I type into search "lala"
#    Then read file named"lala.txt"
#    And close the browser