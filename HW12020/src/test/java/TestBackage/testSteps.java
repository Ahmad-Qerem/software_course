package TestBackage;
import static org.junit.Assert.assertTrue;
import CeckOut.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
public class testSteps {
	Check newList =new Check();
	int total;
	@Given("the price of a {string} is {int}")
	public void thePriceOfAIs(String string, Integer int1) {
		newList.addProd(string,int1);
	}
	@When("I checkout {int} {string}")
	public void iCheckout(Integer int1, String string) {
		newList.setCount(int1,string);
		total=newList.findTotal();
	}
	@Then("the total price should be {int}")
	public void theTotalPriceShouldBe(Integer int1) {
		newList.clearList();
		assertTrue(int1==total);
	}
}