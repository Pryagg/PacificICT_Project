package stepDefinitions;

import context.TestContext;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import helpers.HelperMethods;
import org.junit.Assert;
import pages.Categories;
import pages.Products;

public class ProductSteps {
	TestContext testContext;
	 Categories categories;
	 Products products;
	 HelperMethods helperMethods;
	 
	
	public ProductSteps(TestContext context) {
		testContext = context;
		 categories = context.getPageObjectManager().getCategories();
		 products = context.getPageObjectManager().getProducts();
		 helperMethods = context.getPageObjectManager().getHelperMethods();
}
	
	 @When("^I  click on (.+) product")
	 public void click_category(String product) {
		 products.Product(product).click();
	 }
	 
	 @When("^I click on Add to cart button$")
	 public void click_add_to_cart() {
		 products.AddToCartButton().click();
	 }
	 
	 @When("^I add (.+) from (.+) category to cart$")
	 public void add_product_to_cart(String product, String category) {
		// helperMethods.waitForXSeconds(05);
		 categories.Category(category).click();
	 helperMethods.waitForXSeconds(03);
		 helperMethods.waitOnElementToBeVisible(products.Product(product), 20 );
		 products.Product(product).click();
		 helperMethods.waitForXSeconds(10);
		 products.AddToCartButtons().get(0).click();
		 helperMethods.waitForXSeconds(3);
	 }

	@And("^I add order notes (.+)$")
	public void add_order_notes(String ordernotes){
		products.OrderNotes().clear();
		products.OrderNotes().sendKeys(ordernotes);
	}

	@Then("^I see that I am landed on product (.+) page$")
	public void verify_page_heading(String page){
		switch(page) {
			case "list":
				Assert.assertTrue(products.productPageHeading().isDisplayed());
				break;
			case "details":
				Assert.assertTrue(products.productPageHeading().isDisplayed());
				break;
		}
	}

	@Then("^I verify that (.+) is displayed on product list page$")
	public void verify_product_page_elements(String ele){
	 	switch(ele){
			case "bread crumbs":
				Assert.assertTrue(products.breadCrumbText().isDisplayed());
				break;
			case "category content":
				Assert.assertTrue(products.catContent().isDisplayed());
				break;
			case "navigation Title":
				helperMethods.waitOnElementToBeVisible(products.sideNavigationTitle(), 20);
				Assert.assertTrue(products.sideNavigationTitle().isDisplayed());
				break;
			case "side product menu":
				Assert.assertTrue(products.sideproductMenu().isDisplayed());
				break;
			case "description":
				Assert.assertTrue(products.productDescription().isDisplayed());
				break;
		}
	}

	@When("^I click on (.+) product from (.+) category list$")
	public void select_product(String product, String category){
		categories.Category(category).click();
		products.Product(product).click();
	}

	@Then("^I see (.+) product is displayed on product details page$")
	public void verify_product_display(String product){
	 	Assert.assertTrue(products.productTitle(product).getText().contains(product));
	}

	@When("^I click on (.+) product from the side navigation menu$")
	public void click_product_from_side_menu(String product){
		products.productInSideNavigation(product).click();
	}

	@Then("^I see the product has (.+) displayed on the page$")
	public void verify_product_details_elements(String ele){
		switch(ele) {
			case "product name":
				Assert.assertTrue(products.productName().isDisplayed());
				break;
			case "active ingredient":
				Assert.assertTrue(products.activeIngredient().isDisplayed());
				break;
			case "manufacturer":
				Assert.assertTrue(products.manufacturer().isDisplayed());
				break;
			case "product type":
				Assert.assertTrue(products.productType().isDisplayed());
				break;
			case "product expiry date":
				Assert.assertTrue(products.productExpiryDate().isDisplayed());
				break;
		}

	}

}
