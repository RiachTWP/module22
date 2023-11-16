package com.riachs.page;
import com.riachs.endPoint;
import static com.riachs.models.*;
import static com.riachs.baseTest.*;
import com.riachs.baseTest;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.module.jsv.JsonSchemaValidator;

import java.io.File;
import java.util.List;
import java.util.Objects;

import static org.assertj.core.api.Assertions.*;



public class getApiPage{


String setURL ;
    public String setUpURL (String url){
        switch (url){
            case "USER_GOREST":
                setURL = endPoint.USER_GOREST;
                break;
            default:
                System.out.println("input the right URL");
        }
        return setURL;
    }

    public void hitGetListUsers(){
        res = getListUsers(setURL);
    }

    public void validationStatusCode(int status_code){
        assertThat(res.statusCode()).isEqualTo(status_code);
    }

    public void validationBodyGetListUsers(){
        List<Object> id = res.jsonPath().getList("id");
        List<Object> name = res.jsonPath().getList("name");
        List<Object> email = res.jsonPath().getList("email");
        List<Object> gender = res.jsonPath().getList("gender");
        List<Object> status = res.jsonPath().getList("status");

        assertThat(id.get(0)).isNotNull();
        assertThat(name.get(0)).isNotNull();
        assertThat(email.get(0)).isNotNull();
        assertThat(gender.get(0)).isIn("male","female");
        assertThat(status.get(0)).isIn("active","inactive");
    }

    public void validationJsonSchemaFile(String FileName){
        File JSONFile = baseTest.getJsonSchemaData(FileName);
        res.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(JSONFile));
    }


}
