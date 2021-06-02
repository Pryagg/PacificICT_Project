package pages;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import context.TestContext;
import helpers.HelperMethods;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends BasePage{

		private TestContext context;
	    private final HelperMethods helperMethods;


	    public HomePage(TestContext context)
	    {
	        this.context = context;
	        helperMethods = context.getPageObjectManager().getHelperMethods();
	    }

//	tablet specific elements

	public WebElement tabletCCMenu(){ return findElementByXpath("//div[@class='nvtools-item nvtools-location']//div[@class='nvtools-btn']");}

	public WebElement mobileSelectedCountry(){
	    	return findElementByXpath("//div[@class='menu-loc-item']");
	}

	public WebElement mobileSelectedCurrency(String currency){ return findElementByXpath("//div[@class='menu-loc-item'][contains(text(),'"+ currency +"')]");}

	public WebElement tabletMyAccount(){ return findElementByXpath("//div[@class='nvtools-content']//a[contains(text(),'My account')]"); }

	public WebElement tabletExploreCategories(){
	    	return findElementByXpath("//div[@id='header-categories']");
	}

	public WebElement tabletCategories(){
		return findElementByXpath("//div[@class='nvtools-category-list']");
	}

	public List<WebElement> tabletCountriesList(){ return findElementsByXpath("//div[@class='loc-options']//div[contains(@class,'loc-country-item')]");	}

	public List<WebElement> tabletCurrenciesList(){	return findElementsByXpath("//div[@class='loc-options']//div[contains(@class,'loc-currency-item')]");
	}

//	mobile specific elements

	public WebElement mobileAccount() { return findElementByXpath("//div[@class='menu-account']//a[contains(text(),'My account')]");}

	public WebElement mobileExploreCategories() { return findElementByXpath("//div[contains(text(),'Explore our range')]");	}

	public WebElement mobileCategories() {
		return findElementByXpath("//div[@class='nvtools-category-list']");
	}

	public List<WebElement> mobilecountrieslist(){ return findElementsByXpath("//div[@class='menu-loc-popup']//div[contains(@class,'loc-country-item')]");	}

	public List<WebElement> mobileCurrenciesList(){		return findElementsByXpath("//div[@class='menu-loc-popup']//div[contains(@class,'loc-currency-item')]");
	}

	public WebElement mobileCountryAndCurrencyText() { return findElementByXpath("//div[@class='menu-loc-item']//strong[contains(text(),'Country & Currency')]"); }

	public WebElement mobilecountryAndCurrencyDropdown() { return findElementByXpath("//div[@class='nvtools-item nvtools-location']");	}

	public WebElement mobileSelectedCC(){
	    	return findElementByXpath("//div[@class='menu-loc']");
	}

	public WebElement mobileSave(){
	    	return findElementByXpath("//div[@class='menu-loc-submit btn btn-default']");
	}

	public WebElement mobileSignup(){ return findElementByXpath("//div[@class='menu-account']//strong[contains(text(),'Sign up.')]");}


//	web/mobile/tablet elements
	
	public WebElement homePageTitle() {
		return findElementByXpath("//div[@class='home-section']//h2[@class='home-title']"); //changed home title as image not found
	}
	
	public WebElement headerSection() {
		return findElementByXpath("//header[@class='page-header']");
	}
	
	public WebElement mainContent() {
		return findElementByXpath("//main[@class='page-main']");
	}
	
	public WebElement footerSection() {
		return findElementByXpath("//div[@class='footer-bottom']");
	}
	
	public WebElement headerNavigationBar() { return findElementByXpath("//div[@class='header-top']//div[@class='container']"); }
	
	public WebElement countryAndCurrencyText() { return findElementByXpath("//div[@class='nvtools-btn']//strong[contains(text(),'Country & Currency')]"); }

	public WebElement countryAndCurrencyDropdown() { return findElementByXpath("//div[@class='nvtools-item nvtools-location']"); }

	public WebElement selectedCountry() { return findElementByXpath("//div[@class='loc-selected loc-selected-country']");	}
	
	public WebElement selectedCurrency() { return findElementByXpath("//div[@class='loc-selected loc-selected-currency']");	}

	public WebElement selectCountry() {	return findElementByXpath("//div[@class='loc-selected loc-selected-country']");	}
	
//	public List<WebElement> countriesList(){
//		return findElementsByXpath("//div[@class='loc-options']//div[@class='loc-options-country']");
//	}
	
	public WebElement countriesList(){ return findElementByXpath("//div[@class='loc-options']//div[@class='loc-country-item']"); }
	
	public List<WebElement> currenciesList(){ return findElementsByXpath("//div[@class='loc-options']//div[@class='loc-options-currency']");}
	
	public WebElement saveButton() {
		return findElementByXpath("//div[@class='btn btn-default btn-block loc-submit']");
	}
	
	public WebElement closeButton() { return findElementByXpath("//div[@class='nvtools-popup loc-popup']//i[@class='icon icon-close']"); }
	
	public WebElement accountDropdown() { return findElementByXpath("//div[contains(text(),'Hello')]");	}
	
	public WebElement categoriesList(){ return findElementByXpath("//div[@class='header-nav']");	}
	
	public WebElement searchBox(){	return findElementByXpath("//input[@name='Search']");}
	
	public List<WebElement> navigationLinks(){ return findElementsByXpath("//div[@class='header-links']");	}
	
	public WebElement shippingBanner(){	return findElementByXpath("//div[@class='header-shipping-inner']");	}
	
	public WebElement image(){	return findElementByXpath("//div[@class='home-slider-item slick-slide slick-current slick-active']//img[@class='img-responsive']");	}
	
	public WebElement greatPricesImage() {	return findElementByXpath("//main[@class='page-main']//div[@class='row']//div[1]//a[1]");	}
	
	public WebElement categoriesLink() {
		return findElementByXpath("//span[contains(text(),'View our categories')]");
	}
	
	public WebElement excellentServiceImage() {	return findElementByXpath("//main[@class='page-main']//div[@class='row']//div[2]//a[1]"); }
	
	public WebElement customerServiceLink() { return findElementByXpath("//span[contains(text(),'Talk to one of our customer service experts')]");	}
	
	public WebElement contactImage() {	return findElementByXpath("//div[@class='hfeature hfeature-reverse']//img[@class='img-responsive']");}
	
	public WebElement contactText() { return findElementByXpath("//div[@class='hfeature hfeature-reverse']//div[@class='hfeature-content']");	}
	
	public WebElement contactLink() {
		return findElementByXpath("//a[@class='btn btn-default btn-xs']");
	}
	
	public WebElement homeLink() {
		return findElementByXpath("//ul[@class='footer-links']//a[contains(text(),'Home')]");
	}
	
	public WebElement quickLinksTitle() {
		return findElementByXpath("//div[contains(text(),'Quick links')]");
	}
	
	public WebElement aboutUsLink() {
		return findElementByXpath("//a[contains(text(),'About Us')]");
	}
	
	public WebElement contactUsLink() {	return findElementByXpath("//ul[@class='footer-links']//a[contains(text(),'Contact Us')]");	}
	
	public WebElement siteGuideLink() {	return findElementByXpath("//ul[@class='footer-links']//a[contains(text(),'Site Guide')]");	}
	
	public WebElement reviewsLink() {	return findElementByXpath("//ul[@class='footer-links']//a[contains(text(),'Reviews')]");	}
	
	public WebElement sitemapLink() {
		return findElementByXpath("//a[contains(text(),'Sitemap')]");
	}
	
	public WebElement blogLink() {
		return findElementByXpath("//ul[@class='footer-links']//a[contains(text(),'Blog')]");
	}
	
	public WebElement supportTitle() {
		return findElementByXpath("//div[contains(text(),'Support')]");
	}
	
	public WebElement myAccountLink() {	return findElementByXpath("//ul[@class='footer-links']//a[contains(text(),'My Account')]");	}
	
	public WebElement privacyStatementLink() {
		return findElementByXpath("//a[contains(text(),'Privacy Statement')]");
	}
	
	public WebElement termsAndConditionsLink() {
		return findElementByXpath("//a[contains(text(),'Terms & Conditions')]");
	}
	
	public WebElement cookiesPolicyLink() {
		return findElementByXpath("//a[contains(text(),'Cookies Policy')]");
	}
	
	public WebElement faqLink() {
		return findElementByXpath("//ul[@class='footer-links']//a[contains(text(),'FAQ')]");
	}
	
	public WebElement shippingReturnsLink() {
		return findElementByXpath("//a[contains(text(),'Shipping & Returns')]");
	}
	
	public WebElement copyRight() {
		return findElementByXpath("//div[@class='footer-copyright']");
	}
	
	public WebElement followUsTitle() {
		return findElementByXpath("//div[contains(text(),'Follow us')]");
	}
	
	public WebElement facebookIcon() {
		return findElementByXpath("//i[@class='icon-facebook-official']");
	}
	
	public WebElement facebookLink() {
		return findElementByXpath("//div[@class='footer-icon fb-like fb_iframe_widget']");
	}
	
	public WebElement feedbackLink() {
		return findElementByXpath("//div[@class='footer-feedback-btn']");
	}

	public WebElement homeImage() {	return findElementByXpath("//body/form[@name='aspnetForm']/header/div/div/div/div/a/img[1]");	}


	public WebElement homePageLogo() {
		return findElementByXpath("//div[@class='header-logo']//a[@class='logo']");
	}

	public WebElement cookiePopup() {
		return findElementById("btnAccept");
	}

	public WebElement signUpLink() { return findElementByXpath("//div[@class='nvtools-content']//strong[contains(text(),'Sign up.')]");	}

	public void selectCCOnTablet(String type) {
		switch (type) {
			case "country":
				for (WebElement option : tabletCountriesList()) {
					if (option.getText().equals(type)) {
						option.click();
						break;
					}
				}
			case "currency":
				for (WebElement option : tabletCurrenciesList()) {
					if (option.getText().equals(type)) {
						option.click();
						break;
					}
				}
		}
	}

	
	public void acceptCookies() {
			if (cookiePopup().isDisplayed()) {
				cookiePopup().click();

			}
		}


}
