package com.about.you.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class AboutYouLoginPage  extends PageObject {

    @FindBy(name = "email")
    public WebElementFacade inpEmail;

    @FindBy(name = "password")
    public WebElementFacade inpPassword;

    @FindBy(xpath = "//button[@class = 'sc-rjpvdy-0 bmKor sc-1tt1kbs-16 sc-1fentof-3 khiQow cexviZ']")
    public WebElementFacade btnLogin;

    @FindBy (xpath = "//a[@class='userIcon--WJafx']")
    public WebElementFacade LoginIcon ;


    public void login(String username, String password) {
        inpEmail.waitUntilVisible().sendKeys(username);
        inpPassword.waitUntilVisible().sendKeys(password);
        btnLogin.waitUntilVisible().submit();

    }
}
