package managers;

import context.TestContext;
import pages.*;
import helpers.HelperMethods;
import helpers.Props;


public class PageObjectManager {
	
	private final TestContext context;
	private Login login;
	private HomePage homePage;
	private Categories categories;
	private OrderConfirmation orderConfirmation;
	private Payment payment;
	private Products products;
	private HelperMethods helperMethods;
	private Props props;
	private Account account;
	private Cart cart;
	private Shipping shipping;
	
	public PageObjectManager(TestContext context)
    {
        this.context = context;
    }
	
	 public Login getLogin()
	    {
	        return (login == null) ? login = new Login(context) : login;
	    }
	 
	 public HomePage getHomePage(){
		 
		 return (homePage == null) ? homePage = new HomePage(context) : homePage;
		 
		 }
	 
	public Categories getCategories(){
			 
			 return (categories == null) ? categories = new Categories(context) : categories;
			 
		}
	
	public OrderConfirmation getOrderConfirmation(){
		 
		 return (orderConfirmation == null) ? orderConfirmation = new OrderConfirmation(context) : orderConfirmation;
		 
	}
	
	public Payment getPaygment(){
		 
		 return (payment == null) ? payment = new Payment(context) : payment;
		 
	}
	
	public Products getProducts(){
		 
		 return (products == null) ? products = new Products(context) : products;
		 
	}
	
	public HelperMethods getHelperMethods(){
		 
		 return (helperMethods == null) ? helperMethods = new HelperMethods(context) : helperMethods;
		 
	}
	
	public Props getProps() {
		
		return (props == null) ? props = new Props(context) : props;
	}

	public Account getAccount(){
		return (account == null) ? account = new Account(context) : account;
	}

	public Cart getCart(){
		return (cart == null) ? cart = new Cart(context) : cart;
	}

	public Shipping getShipping(){
		return (shipping == null) ? shipping = new Shipping(context) : shipping;
	}
		 

}
