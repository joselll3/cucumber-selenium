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