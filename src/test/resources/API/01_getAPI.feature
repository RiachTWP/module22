@API
Feature:Get API Automation

  @Test
  Scenario: Get list users
    Given go to URL "USER_GOREST"
    And hit api get list users
    Then validation status code is equals 200
    Then validation response body get list users
    Then validation response json with JSONSchema "getListUser.json"
