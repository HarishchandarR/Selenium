package week2.class3;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

public class PracWinHandles {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/ChromeDriver.exe ");
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElementById("username").sendKeys("DemoSalesManager");
		driver.findElementById("password").sendKeys("crmsfa");
		driver.findElementByClassName("decorativeSubmit").click();
		//click crm/sfa link
		driver.findElementByLinkText("CRM/SFA").click();
		//click leads link
		driver.findElementByLinkText("Leads").click();
		driver.findElementByPartialLinkText("Merge Lea").click();
		Thread.sleep(5000);
		driver.findElementByXPath("//img[@src='/images/fieldlookup.gif'][1]").click();		
		System.out.println(driver.getTitle());
		Set<String> abc = driver.getWindowHandles();
		List<String> def = new ArrayList<String>();
		def.addAll(abc);
		driver.switchTo().window(def.get(1));
		System.out.println(driver.getTitle());
		driver.findElementByXPath("//input[@name='firstName']").sendKeys("Ramya");
		driver.findElementByXPath("//button[text()='Find Leads']").click();
		Thread.sleep(3000);
		String fnam = driver.findElementByXPath("//a[@class='linktext'][1]").getText();
		System.out.println(fnam);
		driver.findElementByXPath("//a[@class='linktext'][1]").click();
		abc = driver.getWindowHandles();
		def = new ArrayList<String>();
		def.addAll(abc);
		driver.switchTo().window(def.get(0));
		Thread.sleep(3000);
		System.out.println(driver.getTitle());
		driver.findElementByXPath("(//img[@src='/images/fieldlookup.gif'])[2]").click();
		//driver.findElementByXPath("//img[@id='ext-gen603']").click();	
		abc = driver.getWindowHandles();
		def = new ArrayList<String>();
		def.addAll(abc);
		driver.switchTo().window(def.get(1));
		driver.findElementByXPath("//input[@name='firstName']").sendKeys("gopi");
		driver.findElementByXPath("//button[text()='Find Leads']").click();
		Thread.sleep(3000);
		driver.findElementByXPath("//a[@class='linktext'][1]").click();
		abc = driver.getWindowHandles();
		def = new ArrayList<String>();
		def.addAll(abc);
		driver.switchTo().window(def.get(0));
		Thread.sleep(3000);
		driver.findElementByXPath("//a[@class='buttonDangerous']").click();
		//driver.findElementByName("Merge").click();
		driver.switchTo().alert().accept();
		String nam = driver.findElementById("viewLead_firstName_sp").getText();
		System.out.println(nam);
		driver.findElementByLinkText("Find Leads").click();
		Thread.sleep(3000);
		driver.findElementByXPath("(//input[@name='firstName'])[3]").sendKeys(fnam);
		//driver.findElementByName("firstName").sendKeys(fnam);
		driver.findElementByXPath("//button[text()='Find Leads']").click();
		Thread.sleep(5000);
		String res = driver.findElementByXPath("//div[@class='x-paging-info']").getText();
		System.out.println(res);
		driver.close();

	}

}
