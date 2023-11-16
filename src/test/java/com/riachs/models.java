package com.riachs;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;

import static com.riachs.baseTest.generateEmail;

public class models {

    private static RequestSpecification req;

    public static void setUpHeaders(){
        req = RestAssured.given()
                .header("Content-Type","application/json")
                .header("Accept","application/Json")
                .header("Authorization","Bearer 05ba22d7cb2ab2c12ff8bc4a8f556d97afe595365553e6124b9bd53fc2821593");
    }
    public static Response getListUsers(String endpoint){
        setUpHeaders();
        return req.when().get(endpoint);
    }

    public static Response postCreateUser(String endPoint){
        String name = "Daffa Fawwaz Maulana";
        String gender = "male";
        String email = generateEmail();
        String status = "active";
        JSONObject payload = new JSONObject();
        payload.put("name", name);
        payload.put("gender", gender);
        payload.put("email", email);
        payload.put("status", status);

        setUpHeaders();
        return req.body(payload.toString()).when().post(endPoint);
    }

    public static Response deleteUser(String endPoint, String userId){
        setUpHeaders();
        String finalEndPoint = endPoint + "/" + userId;
        return req.when().delete(finalEndPoint);
    }




}
