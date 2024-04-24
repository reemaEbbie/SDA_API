package day01;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;


public class C02_HeaderAssertions {

    /*
    Given
        https://restful-booker.herokuapp.com/booking
    When
        User sends a GET Request to the url
    Then
        HTTP Status Code should be 200
    And
        Content Type should be JSON
    And
        Status Line should be HTTP/1.1 200 OK
    And
        Connection should be keep-alive
*/
    public  void HeaderAssertions(){

        // While doing api test you can follow the following 4 steps:
        // Set Url
        String url ="https://restful-booker.herokuapp.com/booking";

        // Set expected data (if we expect data in certain format) or payload (if we use put or post)

        // Sent request and get response

        Response response = given().when().get(url);
        response.prettyPrint();

        // Do assertions
        response
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .statusLine("HTTP/1.1 200 OK")
                .header("Connection","keep-alive");



    }
}