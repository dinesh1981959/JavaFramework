Feature: Shopping Cart Validation

 Scenario Outline: Add item to shopping cart

   Given a user with add to shopping cart link
   When the user adds an "<item>" to the cart from "<category>"
   Then the item should be added to the cart successfully

   Examples:
     | item          |category|
     | Purple Camera |Camera  |
