@API
Feature: Post API Automation

  @Test
Scenario: Test create new user normal
  Given go to the URL "USER_GOREST"
  And hit api post create new users
  Then validation for status code is equals 201
  Then validation response body post create new user
  Then validation responses json with JSONSchema "postCreteNewUser.json"
