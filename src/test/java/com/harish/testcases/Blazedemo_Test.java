package com.harish.testcases;

import org.testng.annotations.Test;
import com.harish.pageobject.Blazedemo_PageObj;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class Blazedemo_Test {
	Blazedemo_PageObj ch=new Blazedemo_PageObj();

	@BeforeTest
	public void preCondition() throws Exception {

		ch.openBrowser("chrome");
		ch.callPageFactoryElement();

		ch.openApplicationURL();	
		ch.handleDropDown(ch.departurecity, "Boston");
		ch.handleDropDown(ch.destinationcity, "London");
		ch.waitForSec(2);
		ch.handleClickEvent(ch.FindFlights);

	}

	@Test(priority = 0, description = "Choose the flight")
	public void chooseflight() throws Throwable {	

		ch.choosefirst_flight();
		ch.waitForSec(3);
		ch.handleClickEvent(ch.firstflightbutton);

	}

	@Test(priority = 1, description = "Flight purchasing confirmation")
	public void confirmflightbuy() throws Throwable {	
		
		ch.nextpagetittle();

		ch.handleInputEvent(ch.name, "Jones Pence");

		ch.handleInputEvent(ch.fullAddress, "Observatory Circle, U.S");

		ch.handleInputEvent(ch.City, "Phoenix");

		ch.handleInputEvent(ch.State, "Arizona (AZ)");

		ch.handleInputEvent(ch.zipcode, "85001");

		ch.handleDropDown(ch.cardtype, "American Express");

		ch.pageScroll();

		ch.handleInputEvent(ch.cardnumber, "12345678");

		ch.handleInputEvent(ch.month, "12");

		ch.handleInputEvent(ch.year, "2018");

		ch.handleInputEvent(ch.nameoncard, "Jones Pence");

		ch.handleClickEvent(ch.remember);

		ch.handleClickEvent(ch.purchase);

		ch.waitForSec(3);

	}

	@Test(priority = 2, description = "Validate the confirmation")
	public void confirmbuyflight() throws Throwable {	

		ch.confirmingpurchase();
		ch.waitForSec(3);

	}

	@AfterTest
	public void postCondition() {

			ch.closeBrowser();	
	}


}
