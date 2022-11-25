Feature: Search and place the order for Products

Scenario Outline: Search Experience for product search in both home and Offers page

Given User is on GreenCart landing page
When user searched with Shortname <Name> and extracted actual name of product
Then user searched for <Name> shortname in offers page
And validate product name in offers page matches with landing page

Examples:
| Name |
| Tom  |
| Beet |
