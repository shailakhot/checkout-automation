package com.about.you.stepdefinitions.AboutYouShop;

import com.about.you.pages.AboutYouHomePage;
import com.about.you.pages.SrchedProductsPage;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchStepDefinitions {
    AboutYouHomePage aboutYouHomePage;
    SrchedProductsPage srchedProductsPage;

    @When("User search some product by entering {}")
    public void srchProduct(String product) throws InterruptedException {
        Thread.sleep(5000);
        aboutYouHomePage.iconSearch.waitUntilVisible().click();
        aboutYouHomePage.txtBtxSearch.waitUntilVisible().sendKeys(product);
        aboutYouHomePage.txtBtxSearch.sendKeys(Keys.ENTER);
    }

    @When("User selects the product")
    public void selProduct() throws InterruptedException {
        Thread.sleep(10000);
        List<WebElement> results = srchedProductsPage.Lnkimg;
        if (results.size() > 0) {
            results.get(0).click();
        }
    }

    @When("User selects product size {}")
    public void slctSize(String size) throws InterruptedException {
        Thread.sleep(10000);
        srchedProductsPage.drpDownSize.waitUntilVisible().click();
        List<WebElement> results = srchedProductsPage.dropdownList;
        int currentSize = 0;
        if (results.size() > 0) {
           for(WebElement element : results) {
               if(element.getText().contains(size)) {
                   element.click();
                   break;
               }
           }
        }
    }

    @When("User clicks on add button")
    public void userClicksonAdd() {
        srchedProductsPage.btnAdd.waitUntilVisible().click();
    }

    @When("User clicks on the checkout button")
    public void userClicksCheckout() throws InterruptedException {
        Thread.sleep(5000);
        srchedProductsPage.checkoutButton.waitUntilEnabled().click();
    }


}
