Feature: login into an account
  Scenario Outline: login into an amazon account

    Given i am on the amazon home page

    When i click on the sign in button from the home page
    And i enter the "<email_address>" in the email address input field
    And i click on the continue button
    And i enter the "<password>" in the password input field
    And i click on the sign in button

    Then i can able to login to my account successfully

    Examples:
      | email_address  |  password    |
      | abc@gmail.com  |  23fweuydfh  |
      | rte@gmail.com  |  23fghdeuydfh |