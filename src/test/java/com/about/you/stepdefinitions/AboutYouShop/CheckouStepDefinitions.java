package com.about.you.stepdefinitions.AboutYouShop;

import com.about.you.pages.CheckoutPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class CheckouStepDefinitions {
    CheckoutPage checkoutPage;

    @Then("User verify checkout page is displayed and navigate to Your Information")
    public void checkIfDisplayedPageIsCheckoutAndNavigateToAddress() throws InterruptedException {
        String currentUrl = checkoutPage.getDriver().getCurrentUrl();
        assertThat(currentUrl, anyOf(containsString("checkout"), containsString("kasse")));
        checkoutPage.yourInfoTab.waitUntilVisible().click();
    }

    @Then("Verify all the details are displayed on the address page")
    public void checkFieldsDisplayedOnAddressPage(){
        String currentUrl = checkoutPage.getDriver().getCurrentUrl();
        assertThat(checkoutPage.txtBxFirstName.isDisplayed(),is(true));
        assertThat(checkoutPage.txtBxLastName.isDisplayed(),is(true));
        assertThat(checkoutPage.txtBxPostalCode.isDisplayed(),is(true));
        assertThat(checkoutPage.txtBxCity.isDisplayed(),is(true));
        assertThat(checkoutPage.txtAdditionalInfo.isDisplayed(),is(true));
        assertThat(checkoutPage.blckOrderAddresses.isDisplayed(),is(true));
        assertThat(checkoutPage.txtStrNumber.isDisplayed(),is(true));
    }

    @When("User enters billing address")
    public void userEntersBillingAddress(DataTable table){
        List<Map<String,String>> rows=table.asMaps(String.class, String.class);
        for (Map<String,String> columns : rows){
            String firstName = columns.get("FName");
            String lastName = columns.get("LName");
            String strHuseNo = columns.get("StrNo");
            String additionaInfo = columns.get("additionaInfo");
            String postalCode = columns.get("PostalCode");
            String city = columns.get("City");
            String dob = columns.get("DOB");
            //Clear Existing value if any
            checkoutPage.txtBxFirstName.waitUntilVisible().clear();
            checkoutPage.txtBxLastName.waitUntilVisible().clear();
            checkoutPage.txtBxPostalCode.waitUntilVisible().clear();
            checkoutPage.txtStrNumber.waitUntilVisible().clear();
            checkoutPage.txtAdditionalInfo.waitUntilVisible().clear();
            checkoutPage.txtBxCity.waitUntilVisible().clear();


            checkoutPage.txtBxFirstName.sendKeys(firstName);
            checkoutPage.txtBxLastName.sendKeys(lastName);
            checkoutPage.txtBxPostalCode.sendKeys(postalCode);
            checkoutPage.txtStrNumber.sendKeys(strHuseNo);
            checkoutPage.txtAdditionalInfo.sendKeys(additionaInfo);
            checkoutPage.txtBxCity.sendKeys(city);
            if(checkoutPage.dob.isVisible()) {
                checkoutPage.dob.clear();
                checkoutPage.dob.sendKeys(dob);
            }

        }

    }

    @Then("Verify Delivery address is the same billing address")
    public void verifyDeliveryAddressAndBillingAddress() {
        checkoutPage.deliveryBillingAddressCheck.isCurrentlyVisible();
    }

    @Then("User clicks on Continue to payment method button")
    public void continueToPayment() {
        checkoutPage.continueToPaymentButton.waitUntilClickable().click();
    }

    @Given("User is on Order confirmation Page")
    public void confirmNavigatedToOrderConfirmPage() throws InterruptedException {
        Thread.sleep(5000);
        WebElementFacade currentTab = checkoutPage.currentTab.waitUntilVisible();
        assertThat(currentTab.getTextContent().trim(), anyOf(is("Order"), is("Bestellen")));
    }

    @Then("Verify the address displayed on Billing and shipping and are equal")
    public void verifyBillingAndShippingAddressAreEqual() throws InterruptedException {
        WebElementFacade billingAddress = checkoutPage.billingAddress.waitUntilVisible();
        String billingAddressStr = billingAddress.getTextContent();
        WebElementFacade shippingAddress = checkoutPage.shippingAddress.waitUntilVisible();
        String shippingAddressStr = shippingAddress.getTextContent();
        assertThat(shippingAddressStr, is(billingAddressStr));
        Thread.sleep(5000);
        checkoutPage.quantityInput.clear();
        checkoutPage.quantityInput.sendKeys("0");
        checkoutPage.quantityInput.sendKeys(Keys.ENTER);
        Thread.sleep(5000);
    }

}
