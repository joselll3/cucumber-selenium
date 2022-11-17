Feature: Application Login

Scenario: Home Page Default Login
Given User is on NetBanking landing page
When User login into application with username "jin" and password "1234"
Then Home page is populated
And Cards displayed are "true"

Scenario: Home Page Default Login
Given User is on NetBanking landing page
When User login into application with username "john" and password "9876"
Then Home page is populated
And Cards displayed are "false"


Scenario: Home Page Default Login
Given User is on NetBanking landing page
When User sign up with following credentials
| jenny | abc | john@abcd.com | Australia | 234343|

Then Home page is populated
And Cards displayed are "false"