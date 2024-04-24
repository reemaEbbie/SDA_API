package day01;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class firstApiTest {

    /*
    Given Send GET request to https://reqres.in/api/users?page=2
    Then print status code
    And print status line
     */
    @Test
    void test(){
        String url ="https://reqres.in/api/users?page=2";
        Response response = given().when().get(url);
        response.prettyPrint();

        int statusCode= response.statusCode();
        System.out.println("statusCode = " + statusCode);
        String statusLine = response.statusLine();
        System.out.println("statusLine = " + statusLine);
    }
}