package com.about.you.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;

import java.util.List;

public class SrchedProductsPage extends PageObject {

    @FindBy(xpath = "//div[@data-testid ='productImage']")
    public List<WebElement> Lnkimg ;

    @FindBy(xpath = "//div[@data-test-id = 'SingleSizeDropdown']")
    public WebElementFacade drpDownSize;

    @FindBy(xpath = "//ul[@data-test-id ='DropdownList']/li")
    public List<WebElement> dropdownList;

    @FindBy(xpath = "//button[@data-test-id = 'A2BButton']")
    public WebElementFacade btnAdd;

    @FindBy(xpath = "//button[@data-test-id='CheckoutButton']")
    public WebElementFacade checkoutButton;


}
