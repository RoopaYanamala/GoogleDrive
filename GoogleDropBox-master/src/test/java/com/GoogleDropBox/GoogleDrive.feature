
Feature: Upload Files in to Google Drive
  

  @smoke
  Scenario: As a Registered your I will upload files in to Google Drive
    Given I Login to Google Drive account
    When I Create a folder in google drive
    And I upload multiple files in to google drive
    When I logout from google account
    Then I should close google

@regression
  Scenario Outline: As a Registered user I will upload files in to Google Drive With Data
    Given I Login to Google Drive account
    When I Create a "<Folder>" in google drive
    And I upload "<File>" in to google drive
    When I logout from google account
    Then I should close google
	Examples: 
      | Folder        | File |
      | BDDCucumber   | Selenium.txt  |