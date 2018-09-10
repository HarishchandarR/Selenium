package week1.class2;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class LearnDropDown {

	public static void main(String[] args) throws IOException {
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
		//Dropdown handling- selecting Source dropdown using visible text
WebElement src = driver.findElementById("createLeadForm_dataSourceId");
Select sel=new Select(src);
sel.selectByVisibleText("Direct Mail");
//selecting Marketing dropdown using value
WebElement src1 = driver.findElementById("createLeadForm_marketingCampaignId");
Select sel1=new Select(src1);
sel1.selectByValue("CATRQ_CARNDRIVER");
//seleting industry dropdown using index
WebElement src2 = driver.findElementById("createLeadForm_industryEnumId");
Select sel2=new Select(src2);
sel2.selectByIndex(2);
//list all options from Ownership dropdown
WebElement src3 = driver.findElementById("createLeadForm_ownershipEnumId");
Select sel3=new Select(src3);
List<WebElement> options = sel3.getOptions();
int count = options.size();
System.out.println(count);
for (WebElement eachoption : options) {
	System.out.println(eachoption.getText());	
	
}
//print the last option from Preferred currency dropdown
WebElement src4 = driver.findElementById("createLeadForm_currencyUomId");
Select sel4=new Select(src4);
List<WebElement> options1=sel4.getOptions();
int count1 = options1.size();
//System.out.println(count1-1);
System.out.println(options1.get(count1-1).getText());
sel4.selectByIndex(count1-1);

//take screenshot
File src5 = driver.getScreenshotAs(OutputType.FILE);
File des = new File("./snaps/img1.png");
FileUtils.copyFile(src5, des);

	}

}
