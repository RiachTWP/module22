@API
Feature: Delete API Automation

  @Test
  Scenario: Test delete user normal
    Given go to url for "USER_GOREST"
    And hit the api post create new users
    Then validation status for code is equals 201
    Then validation for response body post create new user
    And hit api delete new
    Then validation status for code is equals 204