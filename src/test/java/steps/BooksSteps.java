package steps;

import helpers.BookHelper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BooksSteps extends BookHelper {
    @When("users want to get list of books from library")
    public void usersWantToGetListOfBooksFromLibrary() {
        getBooksFromLibrary("http://localhost:4000/books/");
    }

    @Then("the requested data is returned")
    public void theRequestedDataIsReturned() {
    }

    @Then("response from webservice is successful")
    public void responseFromWebserviceIsSuccessful() {
    }

    @Then("book is added to library")
    public void bookIsAddedToLibrary() {
    }

    @When("user add Book: {string} {string} {string} {int} to the library")
    public void userAddBookAvailableCountToTheLibrary(String book, String author, String year, int available) {
        addBookToLibrary("http://localhost:4000/books/", book, author, year, available);
    }

    @Given("library webservice is available")
    public void libraryWebserviceIsAvailable() {


    }

    @When("user want to get book by {string}")
    public void userWantToGetBookBy(String id) {
    }

    @Then("book with {string} is returned")
    public void bookWithIsReturned(String id) {
    }

    @Then("response status code should be {int}")
    public void responseStatusCodeShouldBe(int expectedStatusCode) {
        checkStatusCode(expectedStatusCode);
    }
}
