package week1.class1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class LoginCreateLead {

	public static void main(String[] args) throws InterruptedException {
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
		//Fill all fields in Create Lead form
		driver.findElementById("createLeadForm_companyName").sendKeys("TestLeaf");
		driver.findElementById("createLeadForm_firstName").sendKeys("Harish");
		driver.findElementById("createLeadForm_lastName").sendKeys("R");
		WebElement src = driver.findElementById("createLeadForm_dataSourceId");
		Select sel=new Select(src);
		sel.selectByVisibleText("Employee");
		WebElement src1 = driver.findElementById("createLeadForm_marketingCampaignId");
		Select sel1=new Select(src1);
		sel1.selectByValue("CATRQ_CARNDRIVER");
		driver.findElementById("createLeadForm_firstNameLocal").sendKeys("Harish");
		driver.findElementById("createLeadForm_lastNameLocal").sendKeys("R");
		driver.findElementById("createLeadForm_personalTitle").sendKeys("TLeaf");
		driver.findElementById("createLeadForm_birthDate").sendKeys("11/02/1986");
		driver.findElementById("createLeadForm_generalProfTitle").sendKeys("My title");
		driver.findElementById("createLeadForm_departmentName").sendKeys("Mechanical");
		driver.findElementById("createLeadForm_annualRevenue").sendKeys("50000");
		WebElement src4 = driver.findElementById("createLeadForm_currencyUomId");
		Select sel4=new Select(src4);
		sel4.selectByVisibleText("INR - Indian Rupee");
		WebElement src2 = driver.findElementById("createLeadForm_industryEnumId");
		Select sel2=new Select(src2);
		sel2.selectByIndex(2);
		driver.findElementById("createLeadForm_numberEmployees").sendKeys("2000");
		WebElement src3 = driver.findElementById("createLeadForm_ownershipEnumId");
		Select sel3=new Select(src3);
		sel3.selectByVisibleText("OWN_PUBLIC_CORP");
		driver.findElementById("createLeadForm_sicCode").sendKeys("abc123");
		driver.findElementById("createLeadForm_tickerSymbol").sendKeys("alpha");
		driver.findElementById("createLeadForm_description").sendKeys("My first description");
		driver.findElementById("createLeadForm_importantNote").sendKeys("This is very important");
		driver.findElementById("createLeadForm_primaryPhoneCountryCode").sendKeys("91");
		driver.findElementById("createLeadForm_primaryPhoneAreaCode").sendKeys("044");
		driver.findElementById("createLeadForm_primaryPhoneNumber").sendKeys("22245468");
		driver.findElementById("createLeadForm_primaryPhoneExtension").sendKeys("1715");
		driver.findElementById("createLeadForm_primaryPhoneAskForName").sendKeys("Expert");
		driver.findElementById("createLeadForm_primaryEmail").sendKeys("kish_haris@gmail.com");
		driver.findElementById("createLeadForm_primaryWebUrl").sendKeys("www.hari.com");
		driver.findElementById("createLeadForm_generalToName").sendKeys("Haris");
		driver.findElementById("createLeadForm_generalAttnName").sendKeys("Attention");
		driver.findElementById("createLeadForm_generalAddress1").sendKeys("Srinivas flats");
		driver.findElementById("createLeadForm_generalAddress2").sendKeys("Barathiyar street");
		driver.findElementById("createLeadForm_generalCity").sendKeys("chennai");
		WebElement src6 = driver.findElementByName("generalCountryGeoId");
		Select sel6=new Select(src6);
		sel6.selectByVisibleText("India");
		WebElement src5 = driver.findElementByName("generalStateProvinceGeoId");
		Select sel5=new Select(src5);
		sel5.selectByVisibleText("TAMILNADU");
		driver.findElementById("createLeadForm_generalPostalCode").sendKeys("600114");
		driver.findElementById("createLeadForm_generalPostalCodeExt").sendKeys("114");		
		driver.findElementByClassName("smallSubmit").click();
		Thread.sleep(5000);
		driver.close();
	}

}
