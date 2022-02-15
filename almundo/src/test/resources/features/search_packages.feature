#Author: josejulian_ramos@hotmail.com
Feature: Search packages on the page of almundo.com.ar
  As a Certification Analyst for almundo.com.ar
  I want to test the packages searching functionality
  to validate its correct operation

  Background: Navigate to the almundo.com.ar page
    Given that the analyst is on the home page of almundo

  Scenario Outline: Search packages by city a week after the current day
    When he looks for packages from <departureCity> to <arrivalCity> a week after the current day
    Then he validates that the package search is successful

    Examples:
      | departureCity     | arrivalCity   |
      | Barcelona, España | Roma, Italia  |
      | Madrid, España    | Milán, Italia |

