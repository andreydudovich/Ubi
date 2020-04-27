package helpers;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static com.google.common.util.concurrent.Uninterruptibles.sleepUninterruptibly;
import static java.util.concurrent.TimeUnit.SECONDS;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RequestHelper {

    protected static final int STATUS_CODE_200 = 200;
    protected static final int STATUS_CODE_201 = 201;

    public static Response postCallMethod(String endPoint, Object modelBuilder) {
        waitBeforeRequest();
        return RestAssured.with()
                .baseUri(endPoint)
                .contentType(ContentType.JSON)
                .body(modelBuilder)
                .log().method().log().uri()
                .given().log().body()
                .post();
    }

    public static Response postCallMethod(String endPoint) {
        waitBeforeRequest();
        return RestAssured.with()
                .baseUri(endPoint)
                .contentType(ContentType.JSON)
                .log().method().log().uri()
                .given().log().body()
                .post();
    }

    public static Response putCallMethod(String endPoint, Object modelBuilder) {
        waitBeforeRequest();
        return RestAssured.with()
                .baseUri(endPoint)
                .contentType(ContentType.JSON)
                .body(modelBuilder)
                .log().method().log().uri()
                .given().log().body()
                .put();
    }

    public static Response getCallMethod(String endPoint) {
        waitBeforeRequest();
        return RestAssured.with()
                .baseUri(endPoint)
                .log().method()
                .log().uri()
                .get();
    }

    public static void checkStatusCode200(int actualStatusCode) {
        assertEquals(STATUS_CODE_200, actualStatusCode, "Wrong status code:" + actualStatusCode + ", expected: " + STATUS_CODE_200);
    }

    public static void checkStatusCode201(int actualStatusCode) {
        assertEquals(STATUS_CODE_201, actualStatusCode, "Wrong status code:" + actualStatusCode + ", expected: " + STATUS_CODE_201);
    }

    private static void waitBeforeRequest() {
        sleepUninterruptibly(1, SECONDS);
    }

}