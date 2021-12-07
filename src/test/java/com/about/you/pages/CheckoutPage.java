package com.about.you.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class CheckoutPage extends PageObject {

    @FindBy(xpath = "//a[@href='/order/data/billing-address']")
    public WebElementFacade yourInfoTab;

    @FindBy(name = "firstName")
    public WebElementFacade txtBxFirstName ;

    @FindBy(name ="lastName")
    public WebElementFacade txtBxLastName;

    @FindBy(name = "streetHouseNumber")
    public WebElementFacade txtStrNumber;

    @FindBy(name = "additional")
    public WebElementFacade txtAdditionalInfo ;

    @FindBy(name = "zipCode")
    public WebElementFacade  txtBxPostalCode ;

    @FindBy(name = "city")
    public WebElementFacade txtBxCity ;

    @FindBy(name = "birthDate")
    public WebElementFacade dob;

    @FindBy(xpath = "//div[@class ='order-addresses']")
    public WebElementFacade blckOrderAddresses;

    @FindBy(xpath = "//div[@class = 'o-icon as-checkmark']")
    public WebElementFacade deliveryBillingAddressCheck;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElementFacade continueToPaymentButton;

    @FindBy(xpath = "//li[@class='current']")
    public WebElementFacade currentTab;

    @FindBy(xpath = "//li[@class='shipping-address']/div/div[@class='address-wrapper']")
    public WebElementFacade shippingAddress;

    @FindBy(xpath = "//li[@class='billing-address fade-in-out-transition']/div/div[@class='address-wrapper']")
    public WebElementFacade billingAddress;

    @FindBy(xpath = "//div[@class='quantity']/input")
    public WebElementFacade quantityInput;

}
