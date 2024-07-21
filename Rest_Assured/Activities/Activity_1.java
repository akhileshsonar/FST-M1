package activity;


import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Activity_1 {

    final static String ROOT_URI = "https://petstore.swagger.io/v2/pet";
 
    @Test(priority=1)
    public void addNewPet() {

    	Map<String, Object>reqBody=new HashMap<String, Object>();
    	reqBody.put("id", 77232);
    	reqBody.put("name", "Riley");
    	reqBody.put("status", "alive");
    	
 
        Response response = 
            given().contentType(ContentType.JSON)
            .body(reqBody)
            .when().post(ROOT_URI);
 
        response.then().body("id", equalTo(77232));
        response.then().body("name", equalTo("Riley"));
        response.then().body("status", equalTo("alive"));
        System.out.println("Request URI "+ROOT_URI);
    }
 
    @Test(priority=2)
    public void getPetInfo() {
        Response response = 
            given().contentType(ContentType.JSON) // Set headers
            .when().pathParam("petId", "77232") // Set path parameter
            .get(ROOT_URI + "/{petId}"); // Send GET request

        response.then().body("id", equalTo(77232));
        response.then().body("name", equalTo("Riley"));
        response.then().body("status", equalTo("alive"));
        System.out.println("Request URI "+ROOT_URI+"/{petId}");
       System.out.println("Response "+response.body().prettyPrint());
    }
    
    @Test(priority=3)
    public void deletePet() {
        Response response = 
            given().contentType(ContentType.JSON)
            .when().pathParam("petId", "77232")
            .delete(ROOT_URI + "/{petId}");

        response.then().body("code", equalTo(200));
        response.then().body("message", equalTo("77232"));
        System.out.println("Request URI "+ROOT_URI+"/{petId}");
    }
	

}
