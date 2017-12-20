Feature: search on google

  Scenario Outline: search STD on google
    Given navigate to "<page>" on browser
    When type into "<field>" the "<inputText>"
    And press on "<buttonID>"
    Then the "<resultNumber>" from the list is "<resultValue>"
    And close the browser

  Examples:
  | page                  | field  | inputText | buttonID | resultNumber| resultValue |
  | http://www.google.com | lst-ib | STD       | lst-ib   | 3           | Common STDs |
  | http://www.google.com | lst-ib | מתכון ללביבות | lst-ib | 1   | לביבות      |

#  Scenario: search STR on google
#    Given navigate to google on browser
#    When I type into search "STR"
#    And I press on search button
#    Then the first result in the search is correct
#    And close the browser
#
#
#  Scenario: read from file
#    Given navigate to google on browser
#    When I type into search "lala"
#    Then read file named"lala.txt"
#    And close the browser