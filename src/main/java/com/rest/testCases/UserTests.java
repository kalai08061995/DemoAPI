package com.rest.testCases;

import org.testng.annotations.Test;

import com.rest.endPoints.EndPoints;
import com.rest.payload.BasePage;
import com.rest.utilities.Utils;
import io.restassured.response.Response;
import static com.rest.utilities.Utils.userData;



public class UserTests implements BasePage {
    public static Response response;
    
@Test
    void PostData(){
        response= EndPoints.postUser();
  //      BasePage.logStatusCode(response);
//       BasePage.logCookies(response);
//        BasePage.logAll(response);
//        BasePage.logEverything(response);
//        BasePage.logHeaders(response);
        BasePage.assertWithStatusCode(response.getStatusCode(),200);
    }
//    @Test(dataProvider = "data",dataProviderClass = Provider.class)
//    void PostByExcel(String userId,String username,String FirstName,String LastName,String email,String pwd,String ph){
//        userData.setId(Integer.parseInt(userId));
//        userData.setUsername(username);
//        userData.setFirstName(FirstName);
//        userData.setLastName(LastName);
//        userData.setEmail(email);
//        userData.setPassword(pwd);
//        userData.setPhone(ph);
//        response= EndPoints.postUser(userData);
//        BasePage.logStatusCode(response);
//        BasePage.assertWithStatusCode(response.getStatusCode(),200);
//    }
@Test
  void GetData(){
        response=EndPoints.getUser(userData.getUsername());
        BasePage.logBody(response);
        BasePage.assertWithStatusCode(response.getStatusCode(),200);
    }
//    @Test
//    void UpdateData(){
//        //update the Data
//        userData.setFirstName("Mageshpoopathi");
//        userData.setLastName("S");
//        userData.setEmail("mageshpoopathi208@gmail.com");
//
//        response=EndPoints.updateUser(userData.getUsername(), Utils.setupByFaker());
//        BasePage.logBody(response);
//        BasePage.logStatusCode(response);
//        GetData();
//        BasePage.assertWithStatusCode(response.getStatusCode(),200);
//    }
//    @Test
//    void DeleteData(){
//        response=EndPoints.deleteUser(userData.getUsername());
//        BasePage.logStatusCode(response);
//        BasePage.assertWithStatusCode(response.getStatusCode(),200);
//    }
//    @Test(dataProvider = "user",dataProviderClass = Provider.class)
//    void DeleteByExcel(String singleData){
//        response=EndPoints.deleteUser(singleData);
//        BasePage.logStatusCode(response);
//        BasePage.assertWithStatusCode(response.getStatusCode(),200);
//    }

//    @Override
//    public void QueryParams() {
//
//    }
}
