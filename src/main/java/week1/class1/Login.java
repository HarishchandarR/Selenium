package week1.class1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

public class Login {

	public static void main(String[] args) {
	
System.setProperty("webdriver.chrome.driver", "./drivers/ChromeDriver.exe ");
ChromeDriver driver=new ChromeDriver();
driver.manage().window().maximize();
//Launch the URL and login
driver.get("http://leaftaps.com/opentaps");
driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
driver.findElementById("username").sendKeys("DemoSalesManager");
driver.findElementById("password").sendKeys("crmsfa");
driver.findElementByClassName("decorativeSubmit").click();
//After login verify and print the text displayed
String text=driver.findElementById("form").getText();
System.out.println(text);
//Click on CRM/SFA after logged in
driver.findElementByLinkText("CRM/SFA").click();
driver.findElementByLinkText("Leads").click();
driver.findElementByLinkText("Create Lead").click();
//Fill mandatory fields in Create Lead form
driver.findElementById("createLeadForm_companyName").sendKeys("TestLeaf");
driver.findElementById("createLeadForm_firstName").sendKeys("Harish");
driver.findElementById("createLeadForm_lastName").sendKeys("R");
driver.findElementByClassName("smallSubmit").click();
String aaa=driver.findElementById("viewLead_firstName_sp").getText();
System.out.println(aaa);
if (aaa.contains("Harish")) {

System.out.println("Text present");
}
else {
	System.out.println("Text not present");
	}
	}
}
