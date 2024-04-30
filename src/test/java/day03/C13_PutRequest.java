package day03;
import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import testData.JsonPlaceHolderTestData;

import java.util.Map;
import java.util.Objects;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;
import static testData.JsonPlaceHolderTestData.jsonPlaceHolderMapper;

public class C13_PutRequest extends JsonPlaceHolderBaseUrl {

/*
    Given
        1) https://jsonplaceholder.typicode.com/todos/198
        2) {
             "userId": 21,
             "title": "Read Books",
             "completed": false
           }
    When
        I send a PUT request to the URL
    Then
       the status code should be 200
       And the response body should be like:
       {
          "completed": false,
          "title": "Read Books",
          "userId": 21,
          "id": 198
       }

 */

    @Test
    public void putRequestTest(){
        spec.pathParams("first","todos"
                ,"second",198);
        Map<String, Object> payLoad =  jsonPlaceHolderMapper(21,"Read Books",false);

        Response response =given(spec)
                .body(payLoad)
                .when()
                .put("{first}/{second}");
        response.prettyPrint();

        Map<String, Object> actualData = response.as(Map.class);
        assertEquals(200,response.statusCode());
        assertEquals(payLoad.get("userId"),actualData.get("userId"));
        assertEquals(payLoad.get("title"),actualData.get("title"));
        assertEquals(payLoad.get("completed"),actualData.get("completed"));

    }
}
    /*
        Given
            1) https://jsonplaceholder.typicode.com/todos/198
            2) {
                 "title": "Read Books"
               }
        When
            I send PATCH Request to the Url
        Then
           Status code is 200
           And response body is like  {
                                            "userId": 10,
                                            "id": 198,
                                            "title": "Read Books",
                                            "completed": true
                                        }
    */