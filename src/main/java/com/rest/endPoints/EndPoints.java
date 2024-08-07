package com.rest.endPoints;
import static io.restassured.RestAssured.*;

import com.rest.payload.UserPayload;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class EndPoints {

    //for POST user
    public static Response postUser(UserPayload payload){
        Response response;
        response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(payload)
                .when()
                .post(Routes.post_url);
        return response;
    }
    //for GET User
    public static Response getUser(String username){
        Response response;
        response = given()
                .pathParam("username",username)
                .when()
                .get(Routes.get_url);
        return response;
    }
    //for UPDATE User
    
}
