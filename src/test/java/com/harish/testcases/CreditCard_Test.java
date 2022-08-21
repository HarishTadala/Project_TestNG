package com.harish.testcases;

import org.testng.annotations.Test;
import com.harish.pageobject.CreditCard_PageObj;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

//@Listeners(Listener_Package.ListenerClass.class)
@Listeners(com.harish.pageobject.Listeners.class)

public class CreditCard_Test {
	CreditCard_PageObj cc = new CreditCard_PageObj();

	@BeforeTest
	public void preCondition() throws Exception {

		//cc.openBrowser("chrome");//firefox or edge
		
		cc.openBrowser(cc.readDataFromPropertiesFile("browser"));
		cc.callPageFactoryElement();

		cc.openApplicationURL(cc.readDataFromPropertiesFile("application_url"));		
		cc.handleClickEvent(cc.cancelWindow);
		cc.pageScroll();
		cc.waitForSec(2);

	}

	@Test(priority = 0, description = "Verify OutStanding Amount - > 10000 ")
	public void outStandingAmount_10000() throws Throwable {	


		cc.handleInputEvent(cc.outstandingAmt, "10000");
		cc.handleInputEvent(cc.paymentPlan, "1000");
		cc.handleInputEvent(cc.monthlyInterest, "6");
		cc.handleClickEvent(cc.SubmitLink);
		cc.waitForSec(3);

		System.out.println("Total Payment for 10000 : " + cc.getValidationValue(cc.totalPaymentCalculated));

		Assert.assertEquals(cc.getValidationValue(cc.totalPaymentCalculated), "15,730.99");//15,730.99

	}

	@Test(priority = 1, description = "Verify OutStanding Amount - > 20000 ")
	public void outStandingAmount_20000() throws Exception {



		cc.handleInputEvent(cc.outstandingAmt, "20000");
		cc.handleInputEvent(cc.paymentPlan, "2000");
		cc.handleInputEvent(cc.monthlyInterest, "4");
		cc.handleClickEvent(cc.SubmitLink);
		cc.waitForSec(3);

		System.out.println("Total Payment for 20000 : " + cc.getValidationValue(cc.totalPaymentCalculated));
	}

	@AfterTest
	public void postCondition() {

		cc.closeBrowser();
	}
}
