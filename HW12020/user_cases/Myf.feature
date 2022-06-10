
Feature: Checkout
 Scenario: Checkout a banana 
	 Given the price of a "banana" is 40 
	 When I checkout 1 "banana"
	 Then the total price should be 40 
	 
	Scenario: Two banans scanned separately
		Given the price of a "banana" is 40
		When I checkout 1 "banana"
		And I checkout 1 "banana"
		Then the total price should be 80
		 
	Scenario: A banana and Apple
		Given the price of a "banana" is 40
		And the price of a "apple" is 25
		When I checkout 1 "banana"
		And I checkout 1 "apple"
		Then the total price should be 65