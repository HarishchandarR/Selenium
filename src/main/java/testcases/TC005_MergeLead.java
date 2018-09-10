package testcases;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import wdMethods.SeMethods;

public class TC005_MergeLead extends SeMethods {
	@Test
	public void login() throws InterruptedException {
	startApp("chrome", "http://leaftaps.com/opentaps");
	WebElement eleUserName = locateElement("id", "username");
	type(eleUserName, "DemoSalesManager");
	WebElement elePassword = locateElement("id","password");
	type(elePassword, "crmsfa");
	WebElement eleLogin = locateElement("class","decorativeSubmit");
	click(eleLogin);
	WebElement elecrm = locateElement("linktext","CRM/SFA");
	click(elecrm);
	WebElement eleleads = locateElement("linktext","Leads");
	click(eleleads);
	WebElement merg = locateElement("Partiallinktext","Merge Lea");
	click(merg);
	Thread.sleep(5000);
	WebElement lkp1 = locateElement("xpath","//img[@src='/images/fieldlookup.gif'][1]");
	click(lkp1);
	String ttl=driver.getTitle();
	System.out.println(ttl);
	
	}
}
