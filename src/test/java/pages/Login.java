package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import context.TestContext;
import helpers.HelperMethods;
import managers.TestDriver;



public class Login extends BasePage {
	
	private TestContext context;
    private final HelperMethods helperMethods;


    public Login(TestContext context)
    {
        this.context = context;
        helperMethods = context.getPageObjectManager().getHelperMethods();
    }

//    mobile elements
    public WebElement mobileMenuIcon() {
    	return findElementByXpath("//div[@class='nvtools-btn menu-btn']");
    	
    }
	public WebElement MobileSignInButton() {
		return findElementByXpath("//strong[contains(text(),'Sign In')]");
	}

//    tablet elements
	public WebElement tabletSignIn() {
    	return findElementByXpath("//div[contains(text(),'Hello')]");
	}

	public WebElement tabletAccount(){
		return findElementByXpath("//strong[contains(text(),'Account')]");
	}
	public WebElement TabletSignInButton() {
		return findElementByXpath("//strong[contains(text(),'Sign in')]");
	}

	// common to Web,Tab and Mobile

	public WebElement emailTextInput() {
		return findElementByXpath("//input[contains(@name,'Login$UserName')]");
	}

	public WebElement passwordTextInput() {
		return findElementByXpath("//input[contains(@name,'Login$Password')]");
	}

	public WebElement submitButton() {
		return findElementByXpath("//input[@value='Login']");
	}


	//	Web elements
     public WebElement webSignIn() {
	 return findElementByXpath("//div[contains(text(),'Hello')]");
      }

	public WebElement MenuDropdown() {
		return findElementByXpath("//strong[contains(text(),'Account')]//i[@class='icon icon-dropdown']");
	}

	public WebElement WebSignInButton() {
		return findElementByXpath("//strong[contains(text(),'Sign in')]");
	}

	public WebElement myAccountHeading() {
		return findElementByXpath("//h1[@class='page-title']//span[contains(text(),'My Account')]");
	}
	
	public WebElement signInError() {
		return findElementByXpath("//div[@class='error_signin']");
	}
	
	public WebElement inlineUserNameError() {
		return findElementByXpath("//span[contains(text(),'Please enter your e-mail address.')]");
	}
	
	public WebElement inlinePasswordError() {
		return findElementByXpath("//span[contains(text(),'Please enter your password.')]");
	}
	
	public void clickOnLogin() {
		tabletSignIn().click();
		WebSignInButton().click();

	}

	public WebElement emailInputGuestUser() {
		//return findElementByXpath("//span[contains(@id,'Email')]");
		return findElementByXpath("//input[contains(@id,'tbEmail')]");
	}




}
