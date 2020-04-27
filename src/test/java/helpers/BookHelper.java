package helpers;

import elements.models.BookModel;
import io.restassured.response.Response;
import lombok.extern.java.Log;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Log
public class BookHelper extends RequestHelper {

    protected static String SERVER_UP = "Server is UP";
    protected static String LOCALHOST = "http://localhost:4000/";
    protected static String API = "books";

    protected Response response;

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

    private BookModel bookModel(String name, String author, String year, int available) {
        return BookModel.builder()
                .name(name)
                .author(author)
                .year(year)
                .available(available)
                .build();
    }

    public String extractBody() {
        return response.getBody().jsonPath().getString("name");
    }

}
