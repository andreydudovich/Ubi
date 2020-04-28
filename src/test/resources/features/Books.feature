@all
Feature: Simple library test for REST API

  Background:
    Given library webservice is available

  @addBooks @post
  Scenario Outline: Add books to the library
    When user add Book: <name> <author> <year> <available> to the library
    Then response status code should be 201
    And book is added to library

    Examples:
      | name    | author   | year    | available |
      | "name"  | "author" | "year"  | 48        |
      | "book2" | "autho2" | "year3" | 55        |

  @addBook @post
  Scenario: Add one book to the library
    When user add Book: "test" "test" "test" 48 to the library
    Then response status code should be 201
    Then book is added to library

  @addBooksAndValidateFileds @post
  Scenario: Add book to the library and check that fields are correct
    When user add Book: "abrakadabra" "test3" "test4" 69 to the library
    Then book is added to library
    And book name is "abrakadabra"
    And book author is "test3"
    And book year is "test4"
    And book availability is 69

  @getBooks @get
  Scenario: Get books list from a webservice library
    When users want to get list of books from library
    Then response status code should be 200
    And list of books is returned

  @getBook @get
  Scenario: Return book by id
    When user want to get book by id: "1"
    Then response status code should be 200
    And book with id: "1" is returned

  @updateBook @put
  Scenario: Book information update
    Given user want to get book by id: "1"
    When user updates book name to "Carl Sagan"
    And user updates book author to "Cosmos"
    And user updates book year to "1980"
    And user updates book availability to 33
    Then book name is "Carl Sagan"
    And book author is "Cosmos"
    And book year is "1980"
    And book availability is 33

  Scenario: Delete book from library

