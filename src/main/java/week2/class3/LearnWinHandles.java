package week2.class3;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

public class LearnWinHandles {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/ChromeDriver.exe ");
		ChromeDriver driver=new ChromeDriver();
		driver.navigate().to("https://legacy.crystalcruises.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//Click a link in the first window
		driver.findElementByLinkText("GUEST CHECK-IN").click();
		//get the title of the first window since the control still remains in 1st
		System.out.println(driver.getTitle());
		//create a set to navigate to 2nd window
		Set<String> abc = driver.getWindowHandles();
		//convert the set to list to interact with required window
		List<String> def = new ArrayList<String>();
		//use Addall method to add all available windows in that session
		def.addAll(abc);
		//navigate to 2nd window
		driver.switchTo().window(def.get(1));
		//print the title of 2nd window
		System.out.println(driver.getTitle());
		//click on View Offer link in the 2nd window
		driver.findElementByPartialLinkText("View").click();
		abc=driver.getWindowHandles();
		def=new ArrayList<String>();
		def.addAll(abc);
		driver.switchTo().window(def.get(2));
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		driver.close();
		
	}

}
