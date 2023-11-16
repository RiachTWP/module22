package com.riachs.page;
import com.riachs.endPoint;
import static com.riachs.models.*;
import static com.riachs.baseTest.*;
import static org.assertj.core.api.Assertions.assertThat;

import com.riachs.baseTest;
import io.restassured.path.json.JsonPath;

public class deleteApiPage {

    String setURL, globalUserId = null;
    public String goToURL(String url){
        switch (url){
            case "USER_GOREST":
                setURL = endPoint.USER_GOREST;
                break;
            default:
                System.out.println("input the right URL");
        }
        return setURL;
    }

    public void createNewUser(){
        res = postCreateUser(setURL);
    }

    public void validatinStatusCode(int status_code){assertThat(res.statusCode()).isEqualTo(status_code);}

    public void validationBodyCreateUser(){
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

    public void hitDeleteUser(){
        res = deleteUser(setURL,globalUserId);
    }

}
