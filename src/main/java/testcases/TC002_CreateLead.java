package testcases;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import wdMethods.SeMethods;
//create lead testcase using SeMethods
public class TC002_CreateLead extends SeMethods {
	@Test(groups="Smoke")
	public void login() {
		startApp("chrome", "http://leaftaps.com/opentaps");
		WebElement eleUserName = locateElement("id", "username");
		type(eleUserName, "DemoSalesManager");
		WebElement elePassword = locateElement("id","password");
		type(elePassword, "crmsfa");
		WebElement eleLogin = locateElement("class","decorativeSubmit");
		click(eleLogin);
		WebElement eletext = locateElement("id","form");
		verifyExactText(eletext,"Welcome");
		WebElement elecrm = locateElement("linktext","CRM/SFA");
		click(elecrm);
		WebElement eleleads = locateElement("linktext","Leads");
		click(eleleads);
		WebElement elecrlead = locateElement("linktext","Create Lead");
		click(elecrlead);
		WebElement clform_compname = locateElement("id","createLeadForm_companyName");
		type(clform_compname, "Test Leaf");
		WebElement clform_firstname = locateElement("id","createLeadForm_firstName");
		type(clform_firstname, "Hari");
		WebElement clform_lastname = locateElement("id","createLeadForm_lastName");
		type(clform_lastname, "R");
		WebElement clform_submit = locateElement("class","smallSubmit");
		click(clform_submit);
		WebElement postsubmittext = locateElement("id","viewLead_firstName_sp");
		verifyExactText(postsubmittext, "Hari");
		closeBrowser();		
		
	}
	

}
