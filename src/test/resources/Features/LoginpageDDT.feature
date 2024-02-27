Feature: Open cart Login Feature

  #without Examples Keyword DDT
  @Smoke
  Scenario: Open cart Login Test Scenario
    Given user is already on Login Page
    When title of login page is Account Login
    Then user enters "walikindi@gmail.com" and "6362772735"
    Then user clicks on login button
    Then user is on home page

  #with Examples Keyword DDT
  @Sanity
  Scenario Outline: Open cart Login Test Scenario
    Given user is already on Login Page
    When title of login page is Account Login
    Then user enters "<username>" and "<password>"
    Then user clicks on login button
    Then user is on home page

    Examples: 
      | username             | password   |
      | walikindi@gmail.com  | 6362772735 |
      | prabhu1234@gmail.com | 9902545256 |

  #DataTable
  @Regression
  Scenario: Open cart Login Test Scenario
    Given user is already on Login Page
    When title of login page is Account Login
    Then user enters username and password
      | walikindi@gmail.com | 6362772735 |
    Then user clicks on login button
    Then user is on home page

  #DataTable With headers
  @Smoke
  Scenario: Open cart Login Test Scenario
    Given user has alredy logged in to application
      | username            | password   |
      | walikindi@gmail.com | 6362772735 |
