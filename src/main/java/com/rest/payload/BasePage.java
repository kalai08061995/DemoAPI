package com.rest.payload;

import io.restassured.response.Response;
import org.testng.Assert;

public interface BasePage {

   // void QueryParams();
    static void assertWithStatusCode(int actualCode,int expectedCode){
        Assert.assertEquals(actualCode,expectedCode);
    }
   static void logStatusCode(Response response){
        response.then().log().status();
    }
    static void logCookies(Response response){
        response.then().log().cookies();
    }
    static void logBody(Response response){
        response.then().log().body();
    }
    static void logHeaders(Response response){
        response.then().log().headers();
    }
    static void logAll(Response response){
        response.then().log().all();
    }
    static void logEverything(Response response){
        response.then().log().everything();
    }

}
