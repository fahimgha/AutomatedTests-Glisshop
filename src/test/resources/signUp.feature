@signup
Feature: As a Zenity collaborator I want to sign up so that I could access the intranet

  Scenario Outline: Perform login with valid credentials
    Given user is at the sign up page
    When user is sign-up with <username> <password> <confirmPassword>
    Then he should be at the account page Then
    Examples:
      |username | password| confirmPassword|
      |con667559@dechinamkm.com | Testtest1!| Testtest1!|