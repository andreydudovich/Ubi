package steps;

import elements.models.BookModel;
import helpers.BookHelper;
import io.cucumber.guice.ScenarioScoped;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.java.Log;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@Log
@ScenarioScoped
public class BooksSteps extends BookHelper {

    @Given("library webservice is available")
    public void libraryWebserviceIsAvailable() {
        String responseMsg = getCallMethod(LOCALHOST)
                .getBody()
                .jsonPath()
                .getString("message");
        assertEquals(SERVER_UP, responseMsg, "Wrong output from server: " + responseMsg + ", expected: " + SERVER_UP);
    }

    @When("users want to get list of books from library")
    public void usersWantToGetListOfBooksFromLibrary() {
        getBooksFromLibrary(LOCALHOST + API);
    }

    @Then("book is added to library")
    public void bookIsAddedToLibrary() {
        checkStatusCode201(response.statusCode());
    }

    @When("user add Book: {string} {string} {string} {int} to the library")
    public void userAddBookAvailableCountToTheLibrary(String name, String author, String year, int available) {
        addBookToLibrary(LOCALHOST + API, name, author, year, available);
    }

    @When("user add Book: <name> <author> <year> <available> to the library")
    public void userAddBooksAuthorYearAvailableToTheLibrary(String name, String author, String year, int available) {
        addBookToLibrary(LOCALHOST + API, name, author, year, available);
    }

    @When("user want to get book by {string}")
    public void userWantToGetBookBy(String id) {
        getCallMethod(LOCALHOST + API + "/" + id)
                .getBody()
                .jsonPath()
                .prettyPrint();
    }

    @Then("book with {string} is returned")
    public void bookWithIsReturned(String id) {
        bookIdIs(id);
    }

    @Then("response status code should be {int}")
    public void responseStatusCodeShouldBe(int expectedStatusCode) {
        checkStatusCode(expectedStatusCode);
    }

    @Then("response status code should be <expectedStatusCode>")
    public void responseStatusCodeShouldBeExpectedStatusCode(int expectedStatusCode) {
        checkStatusCode(expectedStatusCode);
    }

    @And("book name is {string}")
    public void bookNameIs(String expectedName) {
        String actualName = response.getBody().jsonPath().getString("name");
        assertEquals(expectedName, actualName, "Wrong book name: " + actualName + ", expected: " + expectedName);
    }

    @And("book author is {string}")
    public void bookAuthorIs(String expectedAuthor) {
        String actualAuthor = response.getBody().jsonPath().getString("author");
        assertEquals(expectedAuthor, actualAuthor, "Wrong book author: " + actualAuthor + ", expected: " + expectedAuthor);
    }

    @And("book year is {string}")
    public void bookYearIs(String expectedYear) {
        String actualYear = response.getBody().jsonPath().getString("year");
        assertEquals(expectedYear, actualYear, "Wrong book year: " + actualYear + ", expected: " + expectedYear);
    }

    @And("book availability is {int}")
    public void bookAvailabilityIs(int expectedAvailability) {
        int availability = response.getBody().jsonPath().getInt("available");
        assertEquals(expectedAvailability, availability, "Wrong available count: " + availability + ", expected: " + expectedAvailability);
    }

    @And("book id is {string}")
    public void bookIdIs(String providedId) {
        String actualId = response.getBody().jsonPath().getString("id");
        assertEquals(providedId, actualId, "Book with id: " + providedId + " does not exist.");
    }

    @And("list of books is returned")
    public void listOfBooksIsReturned() {
        if (response != null) {
            log.info("List of books is returned below: ");
            response.getBody().prettyPrint();
        } else {
            log.info("JSON is null");
        }
        assertNotNull(response, "Response is null.");
    }
}
