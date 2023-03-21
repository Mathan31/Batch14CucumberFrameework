package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.EbayHome;
import utils.PicoTestContext;

public class EbayProductSearch{
	
	public String sURL = "https://www.ebay.com/";
	//PicoTestContext picoTestContext;
	EbayHome ebayHome;
	
	public EbayProductSearch(PicoTestContext picoTestContext) {
		//this.picoTestContext = picoTestContext;
		ebayHome = picoTestContext.getPagesManager().getEbayPage();
	}
	@Given("Navigate to Ebay Home page")
	public void navigate_to_ebay_home_page() {
		ebayHome.navigateToEbay();
	}

	@When("Search the product and Select the catagory")
	public void search_the_product_and_select_the_catagory() {
		ebayHome.enterSearchText("iPhone");
		ebayHome.selectProdCatagory("Cell Phones & Accessories");	
	}
	
	@When("Search the product as {string} and Select the catagory as {string}")
	public void search_the_product_as_and_select_the_catagory_as(String prodName, String prodCatagory) {
		ebayHome.enterSearchText(prodName);
		ebayHome.selectProdCatagory(prodCatagory);	
	}
	
	
	@When("Click on submit button")
	public void click_on_submit_button() {
		ebayHome.clickOnSearchButton();
	}

	@Then("Product search result should appear")
	public void product_search_result_should_appear() {
		
		String resultText = ebayHome.getSearchResult();
		System.out.println(resultText);
		resultText = resultText.replaceAll("[^0-9]", "").trim();
		int resultValue = Integer.parseInt(resultText);
		System.out.println(resultValue);
		if(resultValue > 0) {
			System.out.println("Search Results are available");
		}else {
			System.out.println("Search Results are not available");
		}
	}
	
}
