package com.about.you.stepdefinitions.AboutYouShop;

import com.about.you.pages.AboutYouHomePage;
import com.about.you.pages.AboutYouLoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class HomeStepDefinitions {
    AboutYouHomePage aboutYouHomePage;
    AboutYouLoginPage aboutYouLoginPage;


    @Given("User opens about you URL")
    public void userOpensTheAboutYouURL() {
        aboutYouHomePage.open();
    }

    @When("User clicks on user icon to login")
    public void userClicksOnLoginIcon() throws InterruptedException {
        aboutYouHomePage.acceptCookies.waitUntilVisible().click();
        if(aboutYouHomePage.selectCurrentCountry.isCurrentlyVisible()) {
            aboutYouHomePage.selectCurrentCountry.waitUntilEnabled().click();
        }
        aboutYouHomePage.LoginIcon.waitUntilVisible().click();
    }

    @Then("User is on aboutYou home page")
    public void userIsOnAboutYouHomePage(){
        aboutYouHomePage.txtAbout.waitUntilVisible();
        assertThat(aboutYouHomePage.txtAbout.getTextContent(),is(equalTo("ABOUT")));
    }
}
