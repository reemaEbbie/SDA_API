package HWday04;

import HWpojo.HW02.UserPojo_HW2;
import HWpojo.HW05.PetStoreBaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;
import static utilities.ObjectMapperUtilities.convertJsonToJava;

public class UserPutRequest extends PetStoreBaseUrl {

    @Test
    public void putRequest(){

        //SetUrl
        spec.pathParams("first","user","second","ReemaAlebbie");
        //Set expected Data
        String expectedStr = """
                {
                  "id": 1,
                  "username": "ReemaAlebbie",
                  "firstName": "Reema",
                  "lastName": "alebbie",
                  "email": "rema@gmail",
                  "password": "1234",
                  "phone": "9876543",
                  "userStatus": 0
                }""";

        UserPojo_HW2 expectedData= convertJsonToJava(expectedStr,UserPojo_HW2.class);

        //Send Post Request and get Response
        Response response = given(spec).body(expectedData).when().put("{first}/{second}");
        response.prettyPrint();

        //Do assertions
        assertEquals(200,response.statusCode());

    }
}