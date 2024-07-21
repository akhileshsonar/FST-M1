package activity;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
 
import org.testng.annotations.Test;
 
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
 
public class Activity_2 {
   
    final static String ROOT_URI = "https://petstore.swagger.io/v2/user";
 
    @Test(priority=1)
    public void addNewUserFromFile() throws IOException {
        
        FileInputStream inputJSON = new FileInputStream("userinfo.json");
       
        String reqBody = new String(inputJSON.readAllBytes());
 
        Response response = 
            given().contentType(ContentType.JSON)
            .body(reqBody) 
            .when().post(ROOT_URI);
 
        inputJSON.close();
 
        // Assertion
        response.then().body("code", equalTo(200));
        response.then().body("message", equalTo("22222"));
        System.out.println(response.body().asPrettyString());
    }
    
    @Test(priority=2)
    public void getUserInfo() {
        
        File outputJSON = new File("userGETResponse.json");
 
        Response response = 
            given().contentType(ContentType.JSON) 
            .pathParam("username", "Testuser") 
            .when().get(ROOT_URI + "/{username}"); 
        
     
        String resBody = response.getBody().asPrettyString();
        System.out.println("Respnse is "+resBody);
 
        try {
           
            outputJSON.createNewFile();
            
            FileWriter writer = new FileWriter(outputJSON.getPath());
            writer.write(resBody);
            writer.close();
        } catch (IOException excp) {
            excp.printStackTrace();
        }
        
        // Assertion
        response.then().body("id", equalTo(22222));
        response.then().body("username", equalTo("Testuser"));
        response.then().body("firstName", equalTo("test"));
        response.then().body("lastName", equalTo("test"));
        response.then().body("email", equalTo("test@mail.com"));
        response.then().body("password", equalTo("password123"));
        response.then().body("phone", equalTo("9812763450"));
    }
    
    @Test(priority=3)
    public void deleteUser() throws IOException {
        Response response = 
            given().contentType(ContentType.JSON) 
            .pathParam("username", "Testuser") 
            .when().delete(ROOT_URI + "/{username}"); 
        System.out.println("Delete Response is "+response.body().asPrettyString());
        // Assertion
        response.then().body("code", equalTo(200));
        response.then().body("message", equalTo("Testuser"));
    }
}