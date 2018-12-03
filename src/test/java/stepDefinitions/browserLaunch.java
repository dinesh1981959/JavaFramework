package stepDefinitions;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import support.Master;

public class browserLaunch extends Master {

	@Given("^a user with add to shopping cart link$")
	public void aUserWithAddToShoppingCartLink()  {
		driver.navigate().to(p.getProperty("url"));
	}

	@When("^the user adds an \"([^\"]*)\" to the cart from \"([^\"]*)\"$")
	public void theUserAddsAnToTheCartFrom(String item, String category) throws Throwable {
		homePage.addToCart(item,category);
	}

	@Then("^the item should be added to the cart successfully$")
	public void theItemShouldBeAddedToTheCartSuccessfully() throws Throwable {
       homePage.cartValidation();
	}
}
