Feature: EndToEnd

@Regression @EndToEnd 
Scenario: Verify the  successful order
	Given I login as an individual 1
	When I add Duovir 10 Tablets ( Lamivudine and Zidovudine) from Aids category to cart
	And I add order notes Test order
	And I click on Proceed to Purchase button
	And I click on continue button on shipping page
	And I click on continue button on shipping method page
	And I click on continue button on billing address page
	When I select payment method as mail us a check
	And I click on continue button on Keep in touch page
	And I select all the terms
	And I enter patient's name
	And I enter doctor's name
	And I click on continue button on terms page
	When I click on Complete Order Now
	Then I verify that the order is successfully placed


	Scenario: Verify the  successful order for US customers for SignedIn user
		Given I login as an individual 1
		Then I click dropdown country and Currency Dropdown
		When I select United States as country
		And I select US Dollars as currency
		And I click on Save
		When I add Duovir 10 Tablets ( Lamivudine and Zidovudine) from Aids category to cart
		And I add order notes Test order
		And I click on Proceed to Purchase button
		And I click on continue button on shipping page
		And I select Shipping method free standard
		And I click on continue button on shipping method page
		And I click on continue button on billing address page
		When I select payment method as mail us a check
		And I click on continue button on Keep in touch page
		And I select all the terms
		And I enter patient's name
		And I enter doctor's name
		And I click on continue button on terms page
		When I click on Complete Order Now
		Then I verify that the order is successfully placed

	Scenario: Verify the  successful order for US customers for Guest User
		And I click on accept cookies
		Given  I am on home page
		Then I click dropdown country and Currency Dropdown
		When I select United States as country
		And I select US Dollars as currency
		And I click on Save
		When I add Duovir 10 Tablets ( Lamivudine and Zidovudine) from Aids category to cart
		And I add order notes Test order
		And I click on Proceed to Purchase button
		And I enter email for guestuser 1
		And I click on continue button on guest user login page
		And I enter shipping information on checkout for individual1
		And I click on continue button on shipping page
		And I select Shipping method free registered
		And I click on continue button on shipping method page
		And I select billing address same as Shipping yes
		And I click on continue button on billing address page
		When I select payment method as mail us a check
		And I click on continue button on Keep in touch page
		And I select all the terms
		And I enter patient's name
		And I enter doctor's name
		And I click on continue button on terms page
		And I select to create account for guest user no
		When I click on Complete Order Now
		Then I verify that the order is successfully placed
