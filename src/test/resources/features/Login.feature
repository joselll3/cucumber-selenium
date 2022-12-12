Feature: Application Login

  Background:
    Given validate the browser
    When Browse is triggered
    Then Check if browser is started

  @AcademicTest
  Scenario: Home Page Default Login
    Given User is on NetBanking landing page
    When User login into application with username "jin" and password "1234"
    Then Home page is populated
      And Cards displayed are "true"

  @AcademicTest
  Scenario: Home Page Default Login
    Given User is on NetBanking landing page
    When User login into application with username "john" and password "9876"
    Then Home page is populated
      And Cards displayed are "false"

  @AcademicTest
  Scenario: Home Page Default Login
    Given User is on NetBanking landing page
    When User sign up with following credentials
    | nati | jkwx | nati@domain.com | Spain | 33888 |
    Then Home page is populated
      And Cards displayed are "false"

  @AcademicTest
  Scenario Outline: Home page default login
    When User login in to application with username <username> and password <password>
    Given User is on NetBanking landing page
    Then Home page is populated
      And Cards displayed are "false"

Examples:
|username|password|
|user1|pass1|
|user2|pass2|
|user3|pass3|
