package day01;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class StaticImportBaseURI {

    /*
    Given Send GET request by adding static import to the class
    Then assert that status code is 200
    And assert that status line is HTTP/1.1 200 OK
     */

    @Test
    public void assertStatusCodeAndStatusLine() {
        // Send a GET request to the specified URL
        given()
                .when()
                .get("https://reqres.in/api/users?page=2")
                .then()
                .assertThat()
                .statusCode(200) // Assert status code is 200
                .statusLine("HTTP/1.1 200 OK"); // Assert status line is HTTP/1.1 200 OK
    }
}