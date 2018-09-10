package testcases;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import wdMethods.SeMethods;

public class TC003_EditLead extends SeMethods{
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
		WebElement FLfname = locateElement("id","ext-gen248");
		type(FLfname, "kart");
		WebElement FLsubmit = locateElement("xpath","//button[text()='Find Leads']");
		click(FLsubmit);
		Thread.sleep(5000);
		driver.findElementByXPath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a").click();
		//WebElement FLlead1 = locateElement("xpath","//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a']");
		//click(FLlead1);
		String titl=driver.getTitle();
		System.out.println(titl);
		WebElement edi = locateElement("linktext","Edit");
		click(edi);
		WebElement cl = locateElement("id","updateLeadForm_companyName");
		clear(cl);
		WebElement cmp = locateElement("id","updateLeadForm_companyName");
		type(cmp,"tata");
		WebElement submit = locateElement("name","submitButton");
		click(submit);
		WebElement postsubmittext = locateElement("id","viewLead_companyName_sp");
		verifyExactText(postsubmittext, "tata");
		closeBrowser();
		
}
	

}
