package week1.class3;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

public class DuplicatedLead {

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
		//click Email tab
		driver.findElementByLinkText("Email").click();
		Thread.sleep(5000);
		driver.findElementByName("emailAddress").sendKeys("mramyasri1996@gmail.com");
		//driver.findElementById("ext-gen289").sendKeys("mramyasri1996@gmail.com");
		driver.findElementByXPath("//button[text()='Find Leads']").click();
		Thread.sleep(5000);
		//capture name of first resulting lead
		String first=driver.findElementByXPath("//div[@class='x-grid3-cell-inner x-grid3-col-firstName']/a").getText();
		System.out.println(first);
		//click on first resulting lead
		driver.findElementByXPath("//div[@class='x-grid3-cell-inner x-grid3-col-firstName']/a").click();
		//click duplicate lead
		driver.findElementByLinkText("Duplicate Lead").click();
		//verify title
		String second=driver.getTitle();
		System.out.println(second);
		Thread.sleep(5000);
		driver.findElementByName("submitButton").click();
		//confirm the duplicated name is same as captured name
		
		//confirm the changed name appears
		Thread.sleep(5000);
		String dup=driver.findElementById("viewLead_firstName_sp").getText();
		System.out.println(dup);
		if (dup.equals("Ramyasri")){
				System.out.println("Duplicated");}
				else {
				System.out.println("Not duplicated");
				}
		driver.close();
		}

	}

