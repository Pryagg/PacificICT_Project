package stepDefinitions;

import org.junit.Assert;

import context.TestContext;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import managers.BaseDriver;

import helpers.HelperMethods;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import pages.HomePage;
import pages.Login;
import pages.Products;


public class HomePageSteps extends BaseDriver {

	TestContext testContext;
	HomePage homePage;
	Products products;

	Login login;
	HelperMethods helperMethods;


	public HomePageSteps(TestContext context) {
		testContext = context;
		homePage = context.getPageObjectManager().getHomePage();
		login = context.getPageObjectManager().getLogin();
		helperMethods = context.getPageObjectManager().getHelperMethods();
		products = context.getPageObjectManager().getProducts();
	}

	@Given("I am on (.+) page")
	public void verify_landing_page(String page) {

		switch (page) {
			case "home":
				Assert.assertTrue(homePage.homePageTitle().isDisplayed());
				break;
			case "products":
				Assert.assertTrue(products.productPageHeading().isDisplayed());
				break;

		}

	}


	@When("^I go to home page$")
	public void go_homepage() {
		helperMethods.implicitWait(500);
		homePage.homePageLogo().click();

	}


	@Then("^I verify area for (.+) is displayed$") // added 'area' to avoid ambiguity error

	public void verify_homepage(String content) {

		switch (content) {
			case "header":
				Assert.assertTrue(homePage.headerSection().isDisplayed());
				break;
			case "main content":
				Assert.assertTrue(homePage.mainContent().isDisplayed());
				break;
			case "footer":
				Assert.assertTrue(homePage.footerSection().isDisplayed());
				break;

		}

	}


	@Then("^I verify that (.+) is displayed$")
	public void verify_header_elements(String element) {

		switch (element) {

			case "navigation menu for Country & Currency":
				if (getBrowserName().equals("MOBILE-Chrome")) {
					login.mobileMenuIcon().click();
					Assert.assertTrue(homePage.mobileCountryAndCurrencyText().isDisplayed());
				} else if (getBrowserName().equals("TABLET-Chrome")) {
					homePage.tabletCCMenu().click();
					Assert.assertTrue(homePage.selectedCountry().isDisplayed());
					Assert.assertTrue(homePage.selectedCurrency().isDisplayed());
				} else {
					Assert.assertTrue(homePage.countryAndCurrencyText().isDisplayed());
				}
				break;
			case "navigation menu for Account":
				if (getBrowserName().equals("MOBILE-Chrome")) {
					if (!homePage.mobileAccount().isDisplayed()) {
						login.mobileMenuIcon().click();
					}
					Assert.assertTrue(homePage.mobileAccount().isDisplayed());
				} else if (getBrowserName().equals("TABLET-Chrome")) {
					login.tabletSignIn().click();
					Assert.assertTrue(homePage.tabletMyAccount().isDisplayed());

				} else {
					Assert.assertTrue(homePage.accountDropdown().isDisplayed());
				}
				break;
			case "list of categories":
				if (getBrowserName().equals("MOBILE-Chrome")) {
					homePage.mobileExploreCategories().click();
					Assert.assertTrue(homePage.mobileCategories().isDisplayed());
				} else if (getBrowserName().equals("TABLET-Chrome")) {
					homePage.tabletExploreCategories().click();
					Assert.assertTrue(homePage.tabletCategories().isDisplayed());
				} else {
					Assert.assertTrue(homePage.categoriesList().isDisplayed());
				}
				break;
			case "search box":
				Assert.assertTrue(homePage.searchBox().isDisplayed());
				break;
			case "navigation links":
				Assert.assertTrue(homePage.navigationLinks().size() > 0);
				break;
			case "shipping banner":
				Assert.assertTrue(homePage.shippingBanner().isDisplayed());
				break;
			case "image":
				Assert.assertTrue(homePage.image().isDisplayed());
				break;

		}

	}

	@Then("^I verify page (.+) in the footer links is displayed$") // added 'page' to avoid ambiguity error

	public void verify_footer_elements(String element) {

		switch (element) {
			case "Home":
				Assert.assertTrue(homePage.homeLink().isDisplayed());
				break;
			case "About Us":
				Assert.assertTrue(homePage.aboutUsLink().isDisplayed());
				break;
			case "Contact Us":
				Assert.assertTrue(homePage.contactUsLink().isDisplayed());
				break;
			case "Site Guide":
				Assert.assertTrue(homePage.siteGuideLink().isDisplayed());
				break;
			case "Reviews":
				Assert.assertTrue(homePage.reviewsLink().isDisplayed());
				break;
			case "Sitemap":
				Assert.assertTrue(homePage.sitemapLink().isDisplayed());
				break;
			case "Blog":
				Assert.assertTrue(homePage.blogLink().isDisplayed());
				break;

		}
	}


	@Then("^I verify link for (.+) in the support links is displayed$")
	// replaced 'that' with 'link for' to avoid ambiguity error

	public void verify_support_links(String element) {

		switch (element) {
			case "My Account":
				Assert.assertTrue(homePage.myAccountLink().isDisplayed());
				break;
			case "Privacy Statement":
				Assert.assertTrue(homePage.privacyStatementLink().isDisplayed());
				break;
			case "Terms & Conditions":
				Assert.assertTrue(homePage.termsAndConditionsLink().isDisplayed());
				break;
			case "Cookies Policy":
				Assert.assertTrue(homePage.cookiesPolicyLink().isDisplayed());
				break;
			case "FAQ":
				Assert.assertTrue(homePage.faqLink().isDisplayed());
				break;
			case "Shipping & Returns":
				Assert.assertTrue(homePage.shippingReturnsLink().isDisplayed());
				break;
		}

	}

	@When("^I click on (.+) dropdown$")
	public void click_dropdown(String dropdown) {

		switch (dropdown) {
			case "Country & Currency":
				if (getBrowserName().equals("MOBILE-Chrome")) {
					login.mobileMenuIcon().click();
					homePage.mobileCountryAndCurrencyText().click();
				} else {
					homePage.tabletCCMenu().click();
				}
				break;
			case "Account":
				if (getBrowserName().equals("MOBILE-Chrome")) {
					login.mobileMenuIcon().click();

				} else {
					homePage.accountDropdown().click();
				}
				break;
		}

	}

	@When("^I select (.+) as country$")
	public void select_country(String country) {
		if (getBrowserName().equals("MOBILE-Chrome")) {
			for (WebElement option : homePage.mobilecountrieslist()) {
				if (option.getText().equals(country)) {
					helperMethods.scrollUntilVisible(option);
					break;
				}
			}

		} else {
			homePage.selectCountry().click();
			for (WebElement option : homePage.tabletCountriesList()) {
				if (option.getText().equals(country)) {
					option.click();
					break;
				}
			}
		}
	}

	@When("^I select (.+) as currency$")
	public void select_currency(String currency) {
		if (getBrowserName().equals("MOBILE-Chrome")) {
			for (WebElement option : homePage.mobileCurrenciesList()) {
				if (option.getText().equals(currency)) {
					helperMethods.scrollUntilVisible(option);
					break;
				}
			}

		} else {
			homePage.selectedCurrency().click();
			for (WebElement option : homePage.tabletCurrenciesList())
			{
				if (option.getText().equals(currency)) {
					option.click();
					break;
				}
			}
		}
	}

	@When("^I click on Save$")
	public void click_save() {
		if (getBrowserName().equals("MOBILE-Chrome")) {
			homePage.mobileSave().click();
		} else {
			homePage.saveButton().click();
			helperMethods.waitOnElementToBeInvisible(homePage.saveButton(), 20);
		}
	}

	@Then("^I verify that (.+) and (.+) is displayed against country & currency$")
	public void verify_country_and_currency(String country, String currency) {
		if (getBrowserName().equals("MOBILE-Chrome")) {
			try {
				login.mobileMenuIcon().click();
			} catch (StaleElementReferenceException ex) {
				login.mobileMenuIcon().click();
			}
//			Assert.assertTrue(homePage.mobileSelectedCountry().getText().contains(country));
		} else if (getBrowserName().equals("TABLET-Chrome")) {
			String countrySelected = homePage.selectedCountry().getText();
			String currencySelected = homePage.selectedCountry().getText();
			Assert.assertEquals(countrySelected, country);
			Assert.assertEquals(currencySelected, currency);
		} else {
			String countrySelected = homePage.selectedCountry().getText();
			String currencySelected = homePage.selectedCurrency().getText();
			Assert.assertEquals(countrySelected, country);
			Assert.assertEquals(currencySelected, currency);
		}
	}

	@Then("^I verify save and close buttons are displayed$")
	public void verify_save_close_buttons() {
		Assert.assertTrue(homePage.saveButton().isDisplayed());
		Assert.assertTrue(homePage.closeButton().isDisplayed());
	}

	@When("^I navigate to (.+)$")
	public void navigate_to_homepage(String page) {
		switch (page) {
			case "home page":
				homePage.homeImage().click();
				break;
		}
	}

	@Then("^I click on Sign up link$")
	public void click_signUp() {
		if (getBrowserName().equals("MOBILE-Chrome")) {
			homePage.mobileSignup().click();
		} else {
			helperMethods.waitOnElementToBeEnabled(homePage.signUpLink(), 20);
			homePage.signUpLink().click();
			helperMethods.implicitWait(20);
		}
	}

	@Then("^I verify Country & Currency popup is displayed$")
	public void verify_cc_popup() {
		if (getBrowserName().equals("MOBILE-Chrome")) {
			login.mobileMenuIcon().click();
			Assert.assertTrue(homePage.mobileCountryAndCurrencyText().isDisplayed());
		} else if (getBrowserName().equals("TABLET-Chrome")) {
			Assert.assertTrue(homePage.selectedCountry().isDisplayed());
			Assert.assertTrue(homePage.selectedCurrency().isDisplayed());
		} else {
			Assert.assertTrue(homePage.countryAndCurrencyDropdown().isDisplayed());
		}

	}

	@Then("^I verify selected country and currency with title is displayed$")
	public void verify_selected_cc() {
		if (getBrowserName().equals("MOBILE-Chrome")) {
			Assert.assertTrue(homePage.mobileSelectedCC().isDisplayed());
		} else if (getBrowserName().equals("TABLET-Chrome")) {
			Assert.assertTrue(homePage.selectedCountry().isDisplayed());
			Assert.assertTrue(homePage.selectedCurrency().isDisplayed());
		} else {
			Assert.assertTrue(homePage.selectedCountry().isDisplayed());
			Assert.assertTrue(homePage.selectedCurrency().isDisplayed());
		}
	}

	@Then("^I click dropdown country and Currency Dropdown$")
	public void click_country_currency_dropdown() {
		if (getBrowserName().equals("MOBILE-Chrome")) {
			login.mobileMenuIcon().click();
			homePage.mobilecountryAndCurrencyDropdown().click();

		} else if (getBrowserName().equals("TABLET-Chrome")){
			homePage.countryAndCurrencyDropdown().click();

		} else {

			homePage.countryAndCurrencyDropdown().click();

		}

	}


}

