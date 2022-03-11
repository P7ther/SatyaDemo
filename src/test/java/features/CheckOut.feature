Feature: Place the order for products

@PlaceOrder
Scenario Outline: Search Experience for product search in both home and Offers page 

Given User is on GreenCart Landing Page
When User Searched with Shortname <Name> and extracted actual name of product 
And Added "3" items of the selected product to cart
Then User proceeds to Checkout and Validate the <Name> items in checkout page
And Varify user has ability to enter promo code and place the order
Examples:
|Name|
|Tom |


