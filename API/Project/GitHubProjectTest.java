package project;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;

public class GitHubProjectTest {
        String sshKey = "ssh-ed25519 AAAAC3NzaC1lZDI1NTE5AAAAIBtd/YPjsArbuGvg3uR3vYloP29xCFdi44uY2q8zsBG2";
    int sshKeyId;

   
    RequestSpecification requestSpec = new RequestSpecBuilder().
            setBaseUri("https://api.github.com/user/keys").
            addHeader("Authorization", "token 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").
            addHeader("Content-Type", "application/json").
            build();

    ResponseSpecification responseSpec = new ResponseSpecBuilder().
            expectResponseTime(lessThan(4000L)).
            expectBody("key", equalTo(sshKey)).
            expectBody("title", equalTo("TESTAPIKEYPROJECT")).
            build();

    @Test(priority = 1)
    public void postRequestTest() {
        Map<String, String> reqBody = new HashMap<>();
        reqBody.put("title", "TESTAPIKEYPROJECT");
        reqBody.put("key", sshKey);
        Response response = given().spec(requestSpec).body(reqBody).when().post();

        sshKeyId = response.then().extract().path("id");
        response.then().statusCode(201).spec(responseSpec).log().all();
    }

    @Test(priority = 2)
    public void getRequestTest() {

        given().spec(requestSpec).pathParam("keyId", sshKeyId).
        when().get("/{keyId}").
        then().statusCode(200).spec(responseSpec).log().all();
    }

    @Test(priority = 3)
    public void deleteRequestTest() {

        given().spec(requestSpec).pathParam("keyId", sshKeyId).
        when().delete("/{keyId}").
        then().statusCode(204).time(lessThan(3000L));
    }

}