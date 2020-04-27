package helpers;

import elements.models.BookModel;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.response.ValidatableResponse;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookHelper extends RequestHelper {
    //private ValidatableResponse response;
    private Response response;

    protected void addBookToLibrary(String url, String name, String author, String year, int available) {
        response = postCallMethod(url, bookModel(name, author, year, available));
        //checkStatusCode200(response.statusCode());
    }

    protected void checkStatusCode(int expectedStatusCode) {
        int actualStatusCode = response.statusCode();
        assertEquals(expectedStatusCode, actualStatusCode, "Wrong status code:" + actualStatusCode + ", expected: " + expectedStatusCode);
        response.getBody().prettyPrint();
    }

    protected void getBooksFromLibrary(String url) {
        response = postCallMethod(url);
        checkStatusCode200(response.statusCode());
    }


    //checkStatusCode200(response.statusCode());
    //response.getBody().prettyPrint();

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
