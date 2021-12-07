package com.about.you.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("page:aboutYou.page")
public class AboutYouHomePage extends PageObject {

    @FindBy(id = "onetrust-accept-btn-handler")
    public WebElementFacade acceptCookies;

    @FindBy(xpath = "//header/div[1]/div[1]/div[2]/span[1]/a[1]/span[1]")
    public WebElementFacade txtAbout;

    @FindBy(xpath = "//a[@data-test-id='WishlistIconHeader']")
    public WebElementFacade LoginIcon ;

    @FindBy(xpath = "//div[@data-test-id ='SearchBar']/form/button")
    public WebElementFacade iconSearch;

    @FindBy(xpath = "//div[@data-test-id ='SearchBar']/form/input")
    public WebElementFacade txtBtxSearch ;

    @FindBy(xpath = "//button[@data-testid='countrySwitchCurrentCountry']")
    public WebElementFacade selectCurrentCountry;


}
