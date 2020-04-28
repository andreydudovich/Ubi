package helpers;

import elements.models.BookModel;
import io.cucumber.guice.ScenarioScoped;
import io.restassured.response.Response;
import lombok.extern.java.Log;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Log
@ScenarioScoped
public class BookHelper extends RequestHelper {

    protected Response response;

    protected static String SERVER_UP = "Server is UP";
    protected static String LOCALHOST = "http://localhost:4000/";
    protected static String API = "books";

    protected void addBookToLibrary(String url, String name, String author, String year, int available) {
        log.info("Adding book to library");
        response = postCallMethod(url, bookModel(name, author, year, available));
    }

    protected void checkStatusCode(int expectedStatusCode) {
        int actualStatusCode = response.statusCode();
        assertEquals(expectedStatusCode, actualStatusCode, "Wrong status code:" + actualStatusCode + ", expected: " + expectedStatusCode);
    }

    protected void getBooksFromLibrary(String url) {
        response = getCallMethod(url);
        checkStatusCode200(response.statusCode());
    }

    public void getBookByIdFromLibrary(String id) {
        response = getCallMethod(LOCALHOST + API + "/" + id);
        response.getBody().prettyPrint();
    }

    protected void updateBookInformation(String url, String name, String author, String year, int available) {
        log.info("Updating book information.");
        response = putCallMethod(url, bookModel(name, author, year, available));
    }

    private BookModel bookModel(String name, String author, String year, int available) {
        return BookModel.builder()
                .name(name)
                .author(author)
                .year(year)
                .available(available)
                .build();
    }

    public String getActualName() {
        return response.getBody().jsonPath().getString("name");
    }

    public String getActualAuthor() {
        return response.getBody().jsonPath().getString("author");
    }

    public String getActualYear() {
        return response.getBody().jsonPath().getString("year");
    }

    public int getActualAvailable() {
        return response.getBody().jsonPath().getInt("available");
    }

    public String getActualId() {
        return response.getBody().jsonPath().getString("id");
    }
}
