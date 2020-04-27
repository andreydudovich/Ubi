Feature:
  Simple library test for REST API

  Background:
    Given library webservice is available

  Scenario: Add book to the library
    When user add Book: "test" "test" "test" 48 to the library
    Then response status code should be 200
    Then book is added to library

  Scenario: Get books list from a webservice library
    When users want to get list of books from library
    Then the requested data is returned

  Scenario: Return book by id
    When user want to get book by "id"
    Then book with "id" is returned

  Scenario: Book information update
    Given user want to get book by "id"
    When user want to update field "name" to "another name"

