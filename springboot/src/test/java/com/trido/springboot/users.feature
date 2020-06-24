Feature: sample karate test script for users api

  Background:
    * url 'http://localhost:8080'

  Scenario: get all users
    Given path 'users'
    When method get
    Then status 200

    * def first = response[0]
    Given path 'users', first.id
    When method get
    Then status 200
    And match response == {"id":1,"name":"John","age":23}

  Scenario: create a new user
    * def user =
    """
      {"name": "Gumiho","age": 23}
    """
    Given path 'users'
    And request user
    When method post
    Then status 200

  Scenario: get a specific user
    * def id = 5
    * def expected =
    """
      {"id":5,"name":"Susan","age":32}
    """
    Given path 'users', id
    When method get
    Then status 200
    Then match response == expected
    Then print response

  Scenario: delete a specific user
    * def id = 4
    Given path "users", id
    When method delete
    Then status 200

  Scenario: update a specific user
    * def id = 3
    * def newInfo =
      """
      {"name":"Bob","age":56}
      """
    Given path "users", id
    And request newInfo
    When method put
    Then status 200
    Then print "Update successfully"

