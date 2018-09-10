package testcases;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import wdMethods.SeMethods;

public class TC004_DupliLead extends SeMethods {
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
	WebElement elefindleads = locateElement("linktext","Find Leads");
	click(elefindleads);
	WebElement elemail = locateElement("linktext","Email");
	click(elemail);
	WebElement elemailtype = locateElement("name","emailAddress");
	type(elemailtype, "mramyasri1996@gmail.com");
	WebElement elefind = locateElement("xpath","//button[text()='Find Leads']");
	click(elefind);
	Thread.sleep(5000);
	WebElement nameflead = locateElement("xpath","//div[@class='x-grid3-cell-inner x-grid3-col-firstName']/a");
	verifyExactText(nameflead, "Ramyasri");
	WebElement eleflead = locateElement("xpath","//div[@class='x-grid3-cell-inner x-grid3-col-firstName']/a");
	click(eleflead);
	WebElement duplead = locateElement("linktext","Duplicate Lead");
	click(duplead);
	String second=driver.getTitle();
	System.out.println(second);
	Thread.sleep(5000);
	WebElement smit = locateElement("name","submitButton");
	click(smit);
	Thread.sleep(5000);
	WebElement dup = locateElement("Id","viewLead_firstName_sp");
	System.out.println(dup);
	verifyExactText(dup, "Ramyasri");
	closeBrowser();

}
}
