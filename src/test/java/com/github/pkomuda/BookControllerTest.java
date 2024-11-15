package com.github.pkomuda;

import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.hasSize;

@QuarkusTest
@TestHTTPEndpoint(BookController.class)
class BookControllerTest {

    @Test
    void getAllBooksTest() {
        when().get()
                .then()
                .statusCode(200)
                .body(".", hasSize(3));
    }
}
