Feature: Verify checkout functionality of about you online shopping

  Scenario Outline: successful Checkout functionality
    Given User opens about you URL
    When User clicks on user icon to login
    When User login to about you shop with <username> <password>
    Then User is on aboutYou home page
    When User search some product by entering <product>
    When User selects the product
    When User selects product size XL
    When User clicks on add button
    When User clicks on the checkout button
    Then User verify checkout page is displayed and navigate to Your Information
    Then Verify all the details are displayed on the address page
    When User enters billing address
    | FName | LName | StrNo | additionaInfo | PostalCode | City | DOB |
    | <FirstName>  |<LastName>  | <StreeNo> | <addIno> | <PostalCode>  | <City> | <DOB>|
    Then Verify Delivery address is the same billing address
    When User clicks on Continue to payment method button
    Given User is on Order confirmation Page
    Then Verify the address displayed on Billing and shipping and are equal

    @aboutYou_de
    Examples:
    | username | password | product     | size      | FirstName | LastName | StreeNo | addIno | PostalCode | City | DOB |
    | test@tests.com | test123  | Winter jackets  | 38  | Shaila  |Khot  | am europakanal 36 | abcd | 91056  | Erlangen | 15.10.88 |

    @aboutYou_at
    Examples:
      | username | password | product     | size      | FirstName | LastName | StreeNo | addIno | PostalCode | City | DOB |
      | test2@aboutyou.com | test456  | jackets  | 38  | skhot  |khot  | am europakanal 2 | abcd | 91056  | Erlangen | 15.10.88 |
