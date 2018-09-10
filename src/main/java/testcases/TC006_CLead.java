package testcases;

import org.openqa.selenium.WebElement;
//import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import wdMethods.SeMethods;
//Parametrization using @parameter for create lead testcase
public class TC006_CLead extends SeMethods {
	@Parameters({"url","user","pwd"})
	@Test
	//@Test(dataProvider="fetchdata")
	public void login(String URL, String uname, String PWD) {
		startApp("chrome", URL);
		WebElement eleUserName = locateElement("id", "username");
		type(eleUserName, uname);
		WebElement elePassword = locateElement("id","password");
		type(elePassword, PWD);
		WebElement eleLogin = locateElement("class","decorativeSubmit");
		click(eleLogin);
	//@Test(dataProvider="fetchdata")
	//public void CreateLead(String cname, String fname, String lname) {
		WebElement eletext = locateElement("id","form");
		verifyExactText(eletext,"Welcome");
		WebElement elecrm = locateElement("linktext","CRM/SFA");
		click(elecrm);
		WebElement eleleads = locateElement("linktext","Leads");
		click(eleleads);
		WebElement elecrlead = locateElement("linktext","Create Lead");
		click(elecrlead);
		WebElement clform_compname = locateElement("id","createLeadForm_companyName");
		type(clform_compname, "Testleaf");
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
	/*@DataProvider(name="fetchdata")
	public String [][] getData(){
		String [] [] data = new String [2][3];
		data [0][0] = "Testleaf";
		data [0][1] = "Hari";
		data [0][2] = "R";
		data [1][0] = "Testleaf";
		data [1][1] = "Gopi";
		data [1][2] = "K";		
		return data;*/
		
	}

