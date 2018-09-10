package week1.class3;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

public class EditLead {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/ChromeDriver.exe ");
		ChromeDriver driver=new ChromeDriver();
		//Launch the URL and login
		driver.get("http://leaftaps.com/opentaps");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElementById("username").sendKeys("DemoSalesManager");
		driver.findElementById("password").sendKeys("crmsfa");
		driver.findElementByClassName("decorativeSubmit").click();
		//click crm/sfa link
		driver.findElementByLinkText("CRM/SFA").click();
		//click leads link
		driver.findElementByLinkText("Leads").click();
		//click find leads button
		driver.findElementByLinkText("Find Leads").click();
		driver.findElementById("ext-gen248").sendKeys("kart");
		//driver.findElementByXPath("//input[@name='firstName']").sendKeys("kart");
		driver.findElementByXPath("//button[text()='Find Leads']").click();
		Thread.sleep(6000);
		//click on first resulting lead
		driver.findElementByXPath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a").click();
		//verify page title
		String titl=driver.getTitle();
		System.out.println(titl);
		//click edit
		driver.findElementByLinkText("Edit").click();
		//driver.findElementById("ext-gen635").click();
		//change company name
		driver.findElementById("updateLeadForm_companyName").clear();
		driver.findElementById("updateLeadForm_companyName").sendKeys("tata");
		//click update button
		driver.findElementByName("submitButton").click();
		//confirm the changed name appears
		String change=driver.findElementById("viewLead_companyName_sp").getText();
		System.out.println(change);
		//close the browser
		driver.close();

	}

}
