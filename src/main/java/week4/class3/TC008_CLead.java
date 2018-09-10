package week4.class3;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import wdMethods.ProjectMethods;
//import week4.class2.ReadExcel;

public class TC008_CLead extends ProjectMethods {
	@BeforeTest
	public void SetData() {
	sheetname = "CreateLead";
	author = "Hari";
	testName = "TC008_CLead";
	category = "Smoke";
	}
	@Test(dataProvider="pulldata")
	public void CreateLead(String cname, String fname, String lname) {
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
	}
	/*@DataProvider(name="fetchdata")
	public String [][] ExcelData(){
		String [] [] data = new String [2][3];
		data [0][0] = "Testleaf";
		data [0][1] = "Hari";
		data [0][2] = "R";
		data [1][0] = "Testleaf";
		data [1][1] = "Gopi";
		data [1][2] = "K";		
		//return data;
		
	}*/

}
