

Feature: Amazon SignIn Validation

 Scenario Outline: Ou: user email address validation

Given a user in a amazon home page
When the user selects the sign in button 
And clicks the continue after entering email address
Then the user should be prompted with the appropriate "<error message>" for the "<field>"

   Examples:
     | field          |error message        |
     | password       |Enter your password  |