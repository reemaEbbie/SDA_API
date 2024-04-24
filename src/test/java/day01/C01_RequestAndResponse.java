package day01;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class C01_RequestAndResponse {

    public static void main(String[] args) {
 /*
    Given
        https://restful-booker.herokuapp.com/booking
    When
        User sends a GET Request to the url
    Then
        Print Status Code (should be 200)
    And
        Print Content Type (should be JSON)
    And
        Print Status Line (should be HTTP/1.1 200 OK)
    And
        Print Connection and Date headers on console
    And
        Print all headers on console

*/
        String url="https://restful-booker.herokuapp.com/booking";
        Response response= given().get(url);

        //how to print response
        System.out.println(response.prettyPrint());

        //how to print status code
        int statusCode = response.statusCode();
        System.out.println("statusCode = " + statusCode);

        //how to print status code
        String statusLine = response.statusLine();
        System.out.println("statusLine = " + statusLine);

        //how to print content type
        String contentType = response.contentType();
        System.out.println("contentType = " + contentType);



    }
}