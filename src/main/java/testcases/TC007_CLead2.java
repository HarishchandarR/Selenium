package testcases;

import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import wdMethods.SeMethods;
//Parametrization using dataprovider for create lead testcase
public class TC007_CLead2 extends SeMethods {
		
	@Test(dataProvider="fetchdata")
	public void login(String cname, String fname, String lname) {
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
		type(clform_compname, cname);
		WebElement clform_firstname = locateElement("id","createLeadForm_firstName");
		type(clform_firstname, fname);
		WebElement clform_lastname = locateElement("id","createLeadForm_lastName");
		type(clform_lastname, lname);
		WebElement clform_submit = locateElement("class","smallSubmit");
		click(clform_submit);
		WebElement postsubmittext = locateElement("id","viewLead_firstName_sp");
		verifyExactText(postsubmittext, "Hari");
		closeBrowser();	
	}
	@DataProvider(name="fetchdata")
	public String [][] getData(){
		String [] [] data = new String [2][3];
		data [0][0] = "Testleaf";
		data [0][1] = "Hari";
		data [0][2] = "R";
		data [1][0] = "Testleaf";
		data [1][1] = "Gopi";
		data [1][2] = "K";		
		return data;
		
	}

}
