package HWday01;

import io.restassured.response.Response;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class homework04 {

    /*
    Given
        https://reqres.in/api/users/23
    When
        User sends a GET Request to the url
    Then
        HTTP Status Code should be 404
    And
        Status Line should be HTTP/1.1 404 Not Found
    And
        Server is "cloudflare"
    And
        Response body should be empty
    */

    @Test
    public void assertBodyMethod() {

        // Set the URL
        String url = "https://reqres.in/api/users/23";

        // Send the GET request and get the response
        Response response = given().when().get(url);
        response.prettyPrint();

        // Assertion
        response
                .then()
                .statusCode(404)
                .statusLine("HTTP/1.1 404 Not Found")
                .header("Server", "cloudflare")
                .body(equalTo("{}"));

    }
}