package stepDefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import support.Master;

public class browserLaunch extends Master {
	    
	    @Given("a user in a amazon home page")
	    public void a_user_in_a_amazon_home_page() {
	    	driver.navigate().to(p.getProperty("url"));
	    }

	    @When("the user selects the sign in button")
	    public void the_user_selects_the_sign_in_button() throws InterruptedException {
	    	homePage.accountLink();
	    }

	    @And("clicks the continue after entering email address")
	    public void clicks_the_continue_after_entering_email_address() {
	    	homePage.emailAddressInputField();
	    }


	@Then("^the user should be prompted with the appropriate \"([^\"]*)\" for the \"([^\"]*)\"$")
	public void theUserShouldBePromptedWithTheAppropriateForThe(String errorMessage, String field) {
		homePage.verifyLoginError(errorMessage,field);
	}
}
