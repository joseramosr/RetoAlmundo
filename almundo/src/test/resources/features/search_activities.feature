#Author: josejulian_ramos@hotmail.com
Feature: Search activities on the page of almundo.com.ar
  As a Certification Analyst for almundo.com.ar
  I want to test the activities searching functionality
  to validate its correct operation

  Background: Navigate to the almundo.com.ar page
    Given that the analyst is on the home page of almundo

  Scenario Outline: Successful search for activities by city
    When he looks for activities in the city of <city>
    Then he validates that the activities shown correspond to <city>
    And he should see the items of the activities found
    And he should also see the filter and sort buttons

    Examples:c
      | city              |
      | Barcelona, España |
      | Madrid, España    |

