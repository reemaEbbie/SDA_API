package day05;
import base_urls.JsonPlaceHolderBaseUrl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import testData.JsonPlaceHolderTestData;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class C22_ObjectMapperMap extends JsonPlaceHolderBaseUrl {

    @Test
    public void test() throws JsonProcessingException {
        //Set Url
        spec.pathParam("first", "todos");

        //Set expected data
        String expectedStr = """
                {
                  "userId": 55,
                  "title": "Tidy your room",
                  "completed": false
                  }""";
        //JsonPlaceHolderTestData.jsonPlaceHolderMapper(55, "Tidy your room",false);
        ObjectMapper objectMapper=new ObjectMapper();
        Map<String, Object> payLoad = objectMapper.readValue(expectedStr, Map.class);

        //Send request and get response
        Response response = given(spec).body(payLoad).when().post("{first}");
        response.prettyPrint();
        Map<String, Object> actualData = objectMapper.readValue(response.asString(), Map.class);

        //Do assertions
        assertEquals(201,response.statusCode());
        assertEquals(payLoad.get("userId"),actualData.get("userId"));
        assertEquals(payLoad.get("title"),actualData.get("title"));
        assertEquals(payLoad.get("completed"),actualData.get("completed"));



    }

    /*
         Given
           1) https://jsonplaceholder.typicode.com/todos
           2) {
                "userId": 55,
               "title": "Tidy your room",
               "completed": false
               }
        When
            I send POST Request to the Url
        Then
            Status code is 201
        And
            response body is like {
                                    "userId": 55,
                                    "title": "Tidy your room",
                                    "completed": false,
                                    "id": 201
                                    }

Note: Use map and POJO seperately
*/
}