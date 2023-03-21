package steps;

import java.util.List;
import java.util.Map;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AmazonHome;
import utils.PicoTestContext;

public class AmazonSearchSD {

	//String sURL = "https://www.amazon.in/";
	//PicoTestContext picoTestContext;
	AmazonHome amazonHome;

	public AmazonSearchSD(PicoTestContext picoTestContext) {
		//this.picoTestContext = picoTestContext;
		amazonHome = picoTestContext.getPagesManager().getAmazonPage();
	}

	@Given("User should navigate to Amazon")
	public void user_should_navigate_to_amazon() {
		amazonHome.navigateToAmazon();
	}

	@When("User search with multiple products in Amazon called")
	public void user_search_with_multiple_products_called(DataTable dataTable) {
		List<Map<String, String>> searchs = dataTable.asMaps();
		for (Map<String, String> search : searchs) {
			amazonHome.enterProductName(search.get("ProdName"));
			amazonHome.selectProductCatagory(search.get("ProdCat"));
			amazonHome.clickSearchButton();
		}
	}

	@Then("Validate the Amazon search result")
	public void validate_the_search_result() {
		String sResult = amazonHome.getsearchResult(); // 530,000
		System.out.println("Result is : " + sResult);
	}
}
