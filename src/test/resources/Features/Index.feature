Feature: Search feature

  Scenario: Open cart menu features
    Given user is on login page
    When user gets the title of the page
    Then user gets the menu features name
      | Desktops            |
      | Laptops & Notebooks |
      | Components          |
      | Tablets             |
      | Software            |
      | Phones & PDAs       |
      | Cameras             |
      | MP3 Players         |
    And menu features count should be 8

  Scenario: Open cart menu features
    Given user is on index page
    When user gets the title of the page
    Then user gets the menu features Products name
      | MacBook          |
      | iPhone           |
      | Apple Cinema 30" |
      | Canon EOS 5D     |
    And menu features products count should be 4
