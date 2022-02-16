@login
Feature: As a Zenity collaborator I want to login so that I could access the intranet

  Scenario Outline: Perform login with valid credentials
    Given user is at the login page
    When user is logging-in with <username> <password>
    Then he should be at the home page Then
    Examples:
    |username | password|
    |civon21335@chinamkm.com | Testtest1!|
