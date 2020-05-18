Feature: Test baidu search for selenium
	Search for selenium on baidu
	

@tag
  Scenario: Test Baidu search for selenium
    Given I navigate to "baidu"
    When I send "selenium" into searchbox
    And I click search button
    Then The correct search result is returned