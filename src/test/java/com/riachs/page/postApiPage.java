package com.riachs.page;
import com.github.dockerjava.api.model.Endpoint;
import com.riachs.endPoint;
import static com.riachs.models.*;
import static com.riachs.baseTest.*;
import com.riachs.baseTest;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.path.json.JsonPath;

import java.io.File;

import static org.assertj.core.api.Assertions.*;
public class postApiPage {

    String SetURL, globalUserId = null;
    public String goToURL (String url){
        switch (url){
            case "USER_GOREST":
                SetURL = endPoint.USER_GOREST;
                break;
            default:
                System.out.println("input right URL");
        }
        return SetURL;
    }

    public void hitCreateNewUser(){
        res = postCreateUser(SetURL);
    }

    public void validatiStatusCode(int status_code){
        assertThat(res.statusCode()).isEqualTo(status_code);
    }

    public void validBodyCreateUser(){
        JsonPath jsonPathEvaluator = res.jsonPath();
        Integer id = jsonPathEvaluator.get("id");
        String name = jsonPathEvaluator.get("name");
        String email = jsonPathEvaluator.get("email");
        String gender = jsonPathEvaluator.get("gender");
        String status = jsonPathEvaluator.get("status");

        assertThat(id).isNotNull();
        assertThat(name).isNotNull();
        assertThat(email).isNotNull();
        assertThat(gender).isIn("female","male");
        assertThat(status).isIn("active","inactive");

        globalUserId = Integer.toString(id);
    }

    public void validationJsonSchemaPost(String fileName){
        File JSONFile = baseTest.getJsonSchemaData(fileName);
        res.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(JSONFile));
    }


}
