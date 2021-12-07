package com.about.you.stepdefinitions.AboutYouShop;

import com.about.you.pages.AboutYouLoginPage;
import io.cucumber.java.en.When;

public class LoginStepDefinitions {
    AboutYouLoginPage aboutYouLoginPage;

    @When("User login to about you shop with {} {}")
    public void aboutYouLogin(String username, String password){
        aboutYouLoginPage.login(username, password);
    }
}
