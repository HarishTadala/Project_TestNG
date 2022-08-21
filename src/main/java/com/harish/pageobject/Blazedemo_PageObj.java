package com.harish.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Blazedemo_PageObj extends TestBaseA1{

	@FindBy(name="fromPort")
	public WebElement departurecity;	

	@FindBy(name="toPort")
	public WebElement destinationcity;

	@FindBy(xpath="/html/body/div[3]/form/div/input")
	public WebElement FindFlights;

	@FindBy(xpath="/html/body/div[2]/h3")
	public WebElement pagelabel;

	@FindBy(xpath="/html/body/div[2]/table/tbody/tr[1]/td[1]/input")
	public WebElement firstflightbutton;

	@FindBy(xpath="/html/body/div[2]/h2")
	public WebElement nextpagelabeltext;

	@FindBy(xpath="/html/body/div[2]/p[1]")
	public WebElement airlinename;

	@FindBy(xpath="/html/body/div[2]/p[2]")
	public WebElement flightnumber;

	@FindBy(id="inputName")
	public WebElement name;

	@FindBy(id="address")
	public WebElement fullAddress;

	@FindBy(id="city")
	public WebElement City;

	@FindBy(id="state")
	public WebElement State;

	@FindBy(id="zipCode")
	public WebElement zipcode;

	@FindBy(id="cardType")
	public WebElement cardtype;

	@FindBy(id="creditCardNumber")
	public WebElement cardnumber;

	@FindBy(id="creditCardMonth")
	public WebElement month;

	@FindBy(id="creditCardYear")
	public WebElement year;

	@FindBy(id="nameOnCard")
	public WebElement nameoncard;

	@FindBy(id="rememberMe")
	public WebElement remember;

	@FindBy(xpath="/html/body/div[2]/form/div[11]/div/input")
	public WebElement purchase;

	public void callPageFactoryElement() {		
		PageFactory.initElements(w, this); 
	}


}
