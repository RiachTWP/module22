package com.riachs.API;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import com.riachs.page.getApiPage;


public class getStepDef {

    getApiPage getapiPage;

    public getStepDef(){this.getapiPage = new getApiPage();}

    @Given("go to URL {string}")
    public void goToURL(String url) {
            getapiPage.setUpURL(url);
    }

    @And("hit api get list users")
    public void hitApiGetListUsers() {
        getapiPage.hitGetListUsers();
    }

    @Then("validation status code is equals {int}")
    public void validationStatusCodeIsEquals(int status_code) {
        getapiPage.validationStatusCode(status_code);
    }

    @Then("validation response body get list users")
    public void validationResponseBodyGetListUsers() {
        getapiPage.validationBodyGetListUsers();
    }

    @Then("validation response json with JSONSchema {string}")
    public void validationResponseJsonWithJSONSchema(String FileName) {
        getapiPage.validationJsonSchemaFile(FileName);
    }


}
