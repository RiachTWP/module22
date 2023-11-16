package com.riachs.stepDef;

import com.riachs.page.loginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.riachs.baseTest;

public class loginStepDef extends baseTest {


    protected loginPage LoginPage;


    @Given("user is on login page")
    public void userIsOnLoginPage() {
        LoginPage = new loginPage(driver);
        LoginPage.goToLoginPage();

    }

    @And("user input username with {string}")
    public void userInputUsernameWith(String username) throws InterruptedException { LoginPage.inputUsername(username);
    Thread.sleep(1000);
    }

    @And("user input password with {string}")
    public void userInputPasswordWith(String password) throws InterruptedException { LoginPage.inputPassword(password);
        Thread.sleep(1000);
    }

    @When("user click login button")
    public void userClickLoginButton() throws InterruptedException { LoginPage.clickLoginButton();Thread.sleep(1000);
    }

    @Then("user able to see error message {string}")
    public void userAbleToSeeErrorMessage(String errorMessage) throws InterruptedException { LoginPage.validateErrorAppear(errorMessage);
        Thread.sleep(1000);
    }


}



