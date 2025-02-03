Feature: Search functionality

Scenario: User Searches for valid product

Given user opens the application
When user enters valid product "MacBook" into Search box field
And user clicks on Search button
Then user should get valid product displayed in search results

Scenario: user Searches for an invalid product

Given user opens the application
When user enters invalid product "Honda" into Search box field
And user clicks on Search button
Then user should get a message about no product matching

Scenario: User Searches without any product

Given user opens the application
When user dont enter any product name into Search box field
And user clicks on Search button
Then user should get a message about no product matching