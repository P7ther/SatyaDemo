Feature: Search and place the order for products

@OffersPage
Scenario Outline: Search Experience for product search in both home and Offers page 

Given User is on GreenCart Landing Page
When User Searched with Shortname <Name> and extracted actual name of product 
Then User searched for <Name> shortname in offers page 
And Valiate product name in offers page matches with Landing Page 
Examples:
|Name|
|Tom |
|beet|

