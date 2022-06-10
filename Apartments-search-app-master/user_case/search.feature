Feature: Search about suitable home
  Background: The System has a repository of homes with their specifications (type-material-placement-pets-amenties-price-area-bedrooms-bathrooms-leaselength)
Given  these homes are contained in the system
                |HOUSE_WOOD_VILLAGE_NO_GARAGEPARKING,FIREPLACE,ELEVATOR|510_150_3_2_6|
                |APARTMENT_STONE_VILLAGE_YES_GARAGEPARKING,FIREPLACE|600_200_2_4_6|
                |HOUSE_WOOD_CITY_YES_FIREPLACE,ELEVATOR|400_120_4_1_12|
                |APARTMENT_BRICK_CITY_NO_ELEVATOR|230_120_4_2_12|
               
  @Tage1         
  Scenario: Search home by Placement
  When I search about home by "VILLAGE"
  Then A list of homes that matches the  Placement specification should be returned and printed on the console
  And email with the result should be sent to user "khaledabulibdeh@gmail.com"
  @Tage2
  Scenario: Search home by Material
  When I search about home by Material "Wood"
  Then A list of homes that matches the  Material specification should be returned and printed on the console
  And email with the result should be sent to user "khaledabulibdeh@gmail.com"
  @Tage3
  Scenario: Search home by below specific price
  When I search about home by below specific price "500"
  Then A list of homes that matches the  price specification should be returned and printed on the console
  And email with the result should be sent to user "khaledabulibdeh@gmail.com"
  @Tage4
  Scenario: Search home by between range of prices
  When I search about home by  600 and 400
  Then A list of homes that matches the price between range of specification should be returned and printed on the console
  And email with the result should be sent to user "khaledabulibdeh@gmail.com"
  @Tage5
  Scenario: Search home by below specific area
  When I search about home by area "150"
  Then A list of homes that matches the  area specification should be returned and printed on the console
  And email with the result should be sent to user "khaledabulibdeh@gmail.com"
  @Tage6
  Scenario: Search home by between range of area
  When I search about home by area 120 and 200
  Then A list of homes that matches the area between range of specification should be returned and printed on the console
  And email with the result should be sent to user "khaledabulibdeh@gmail.com"
  @Tage7
  Scenario: Search home By Number of bathrooms
  When I search about home by Number of bathrooms "4"
  Then A list of homes that matches the Number of bathrooms specification should be returned and printed on the console
  And email with the result should be sent to user "khaledabulibdeh@gmail.com"
  @Tage8
  Scenario: Search home By Number of bedrooms
  When I search about home by Number of bedrooms "4"
  Then A list of homes that matches the Number of bedrooms specification should be returned and printed on the console
  And email with the result should be sent to user "khaledabulibdeh@gmail.com"
 @Tage9
  Scenario: Search home by Allow Pets
  When I search about home by Allow Pets "YES"
  Then A list of homes that matches Allow Pets specification should be returned and printed on the console
  And email with the result should be sent to user "khaledabulibdeh@gmail.com"
  @Tage10
  Scenario: Search home by Type
  When I search about home by type "Apartment"
  Then A list of homes that matches the  Type specification should be returned and printed on the console
  And email with the result should be sent to user "khaledabulibdeh@gmail.com"
   @Tage11
  Scenario: Search home By Lease Length
  When I search about home by Lease Length "12" monthes
  Then A list of homes that matches the Lease Length specification should be returned and printed on the console
  And email with the result should be sent to user "khaledabulibdeh@gmail.com"
  @Tage12
  Scenario: Search home by Amenties
  When I search about home by Amenties "FIREPLACE,ELEVATOR"
  Then A list of homes that matches the  Amenties specification should be returned and printed on the console
  And email with the result should be sent to user "khaledabulibdeh@gmail.com"
  @Tage13
  Scenario: Search home By Combination
  #use "-" if you dont need to use a specific search (type-material-placement-pets-amenties-price-area-bedrooms-bathrooms-leaselength)
  When I search about home by Combination "-","-","CITY","-","-","-","-","-","-","12"
  Then A list of homes that matches the  Combination specification should be returned and printed on the console
  And email with the result should be sent to user "khaledabulibdeh@gmail.com"
   
