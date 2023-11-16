package com.riachs.stepDef;

import com.riachs.page.homePage;
import io.cucumber.java.en.Then;
import com.riachs.baseTest;

public class homeStepdef extends baseTest {


    homePage HomePage;
    @Then("user is on homepage")
    public void userIsOnHomepage() {
    HomePage = new homePage(driver);
    HomePage.validateOnHomePage();
    }
}
