package TESTBACK;
import static org.junit.Assert.assertEquals;

import mycode.*;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.mockito.Mockito.*;
public class SearchSteps {
	private MockEmailHolder mockWebHolder;
	private Homes HG=new Homes();
	private static Homes SR=new Homes();
	private String result;
	private int resultp;
	private int resulta;
	private boolean mock=true;
	private String arry[]=new String[10];
	public SearchSteps(Homes h,MockEmailHolder mockEmailHolder1) {
		this.SR=h;
		mockWebHolder=mockEmailHolder1;
		

	}
	@Given("these homes are contained in the system")
	public void these_homes_are_contained_in_the_system(DataTable dataTable) {
		if (HG.checkEmpity()) {
			HG.addHouse(dataTable);
		}
		
	}
	@When("I search about home by {string}")
	public void i_search_about_home_by_placement(String string) {
		result = string;
		SR=HG.searchByplace(mock,string);
		
	}
	@Then("A list of homes that matches the  Placement specification should be returned and printed on the console")
	public void a_list_of_homes_that_matches_the_placement_specification_should_be_returned_and_printed_on_the_console() {
		SR.printHouse();
		assertEquals(true,SR.checkResultPlace(result));
		
	}
	
	
	@When("I search about home by Material {string}")
	public void iSearchAboutHomeBy(String string) {
		result = string;
		SR=HG.searchByMaterial(mock,string);
		
	}
	@Then("A list of homes that matches the  Material specification should be returned and printed on the console")
	public void aListOfHomesThatMatchesTheMaterialSpecificationShouldBeReturnedAndPrintedOnTheConsole() {
		SR.printHouse();
		assertEquals(true,SR.checkResultMaterial(result));
		
	}
	
	
	@When("I search about home by below specific price {string}")
	public void iSearchAboutHomeBybelowspecificprice(String int1) {
		result = int1;
		SR=HG.searchByBelowSpecificPrice(mock,int1);
		
	}
	@Then("A list of homes that matches the  price specification should be returned and printed on the console")
	public void aListOfHomesThatMatchesThePriceSpecificationShouldBeReturnedAndPrintedOnTheConsole() {
		SR.printHouse();
		assertEquals(true,SR.checkBelowSpecificPrice(result));
		
	}
	
	
	@When("I search about home by  {int} and {int}")
	public void iSearchAboutHomeByAnd(Integer int1, Integer int2) {
		resultp=int1;
		resulta=int2;
		SR=HG.searchByPriceBetweenRange(mock,int1,int2);
		
	}
	@Then("A list of homes that matches the price between range of specification should be returned and printed on the console")
	public void aListOfHomesThatMatchesThePriceBetweenRangeOfSpecificationShouldBeReturnedAndPrintedOnTheConsole() {
		SR.printHouse();
		assertEquals(true,SR.checkBetweenSpecificPrice(resultp,resulta));
		
	}
	
	@When("I search about home by area {string}")
	public void iSearchAboutHomeByArea(String int1) {
		result = int1;
		SR=HG.searchByBelowSpecificArea(mock,int1);
		
	}
	@Then("A list of homes that matches the  area specification should be returned and printed on the console")
	public void aListOfHomesThatMatchesTheAreaSpecificationShouldBeReturnedAndPrintedOnTheConsole() {
		SR.printHouse();
		assertEquals(true,SR.checkBelowSpecificArea(result));
		
	}
	
	
	
	@When("I search about home by area {int} and {int}")
	public void iSearchAboutHomeByAreaAnd(Integer int1, Integer int2) {
		resultp=int1;
		resulta=int2;
		SR=HG.searchByAreaBetweenRange(mock,int1,int2);
	}
	@Then("A list of homes that matches the area between range of specification should be returned and printed on the console")
	public void aListOfHomesThatMatchesTheAreaBetweenRangeOfSpecificationShouldBeReturnedAndPrintedOnTheConsole() {
		SR.printHouse();
		assertEquals(true,SR.checkBetweenSpecificArea(resultp,resulta));
		
	}
	
	
	@When("I search about home by Number of bedrooms {string}")
	public void iSearchAboutHomeByNumberOfBedrooms(String int1) {
		result = int1;
		SR=HG.searchByNumberOfBedrooms(mock,int1);
	}
	@Then("A list of homes that matches the Number of bedrooms specification should be returned and printed on the console")
	public void aListOfHomesThatMatchesTheNumberOfBedroomsSpecificationShouldBeReturnedAndPrintedOnTheConsole() {
		SR.printHouse();
		assertEquals(true,SR.checkNumberOfBedrooms(result));
		

	}
	
	@When("I search about home by Number of bathrooms {string}")
	public void iSearchAboutHomeByNumberOfBathrooms(String int1) {
		result = int1;
		SR=HG.searchByNumberOfBathrooms(mock,int1);
	}
	@Then("A list of homes that matches the Number of bathrooms specification should be returned and printed on the console")
	public void aListOfHomesThatMatchesTheNumberOfBathroomsSpecificationShouldBeReturnedAndPrintedOnTheConsole() {
		SR.printHouse();
		assertEquals(true,SR.checkNumberOfBathrooms(result));
		

	}
	
	@When("I search about home by Allow Pets {string}")
	public void iSearchAboutHomeByAllowPets(String string) {
		result = string;
		SR=HG.searchByAllowPets(mock,string);
	}
	@Then("A list of homes that matches Allow Pets specification should be returned and printed on the console")
	public void aListOfHomesThatMatchesAllowPetsSpecificationShouldBeReturnedAndPrintedOnTheConsole() {
		SR.printHouse();
		assertEquals(true,SR.checkAllowPets(result));
		

	}
	
	@When("I search about home by type {string}")
	public void iSearchAboutHomeByType(String string) {
		result = string;
		SR=HG.searchBytype(mock,string);
	}
	@Then("A list of homes that matches the  Type specification should be returned and printed on the console")
	public void aListOfHomesThatMatchesTheTypeSpecificationShouldBeReturnedAndPrintedOnTheConsole() {
		SR.printHouse();
		assertEquals(true,SR.checkResultType(result));
		
	}
	
	@When("I search about home by Lease Length {string} monthes")
	public void iSearchAboutHomeByLeaseLengthMonthes(String int1) {
		result = int1;
		SR=HG.searchByLeaseLength(mock,int1);
	}
	@Then("A list of homes that matches the Lease Length specification should be returned and printed on the console")
	public void aListOfHomesThatMatchesTheLeaseLengthSpecificationShouldBeReturnedAndPrintedOnTheConsole() {
		SR.printHouse();
		assertEquals(true,SR.checkLeaseLength(result));
		

	}
	
	@When("I search about home by Amenties {string}")
	public void iSearchAboutHomeByAmenties(String string) {
		result = string;
		SR=HG.searchByAmenties(mock,string);
	}
	@Then("A list of homes that matches the  Amenties specification should be returned and printed on the console")
	public void aListOfHomesThatMatchesTheAmentiesSpecificationShouldBeReturnedAndPrintedOnTheConsole() {
		SR.printHouse();
		assertEquals(true,SR.checkAmenties(result));
	}
	@When("I search about home by Combination {string},{string},{string},{string},{string},{string},{string},{string},{string},{string}")
	public void iSearchAboutHomeByCombination(String S1,String S2,String S3,String S4,String S5,String S6,String S7,String S8,String S9,String S10) {
		mock=false;
		arry[0]=S1;
		arry[1]=S2;
		arry[2]=S3;
		arry[3]=S4;
		arry[4]=S5;
		arry[5]=S6;
		arry[6]=S7;
		arry[7]=S8;
		arry[8]=S9;
		arry[9]=S10;
		
	SR=HG.searchByComp(mock,HG,S1, S2, S3, S4, S5, S6, S7, S8, S9, S10);
	
}
	@Then("A list of homes that matches the  Combination specification should be returned and printed on the console")
	public void aListOfHomesThatMatchesTheCombinationSpecificationShouldBeReturnedAndPrintedOnTheConsole() {
	SR.printHouse();	
	assertEquals(true,SR.checkPyComp(arry));
	
}
	
	
	@Then("email with the result should be sent to user {string}")
	public void email_with_the_result_should_be_sent_to_user(String email){
		verify(mockWebHolder.getEmailSender(),times(1)).send(SR.getOut(), email);
	}
	
}
