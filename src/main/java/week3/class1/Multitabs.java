package week3.class1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Multitabs {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromeDriver.exe");
        ChromeDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.indeed.co.in/fresher-jobs");
        List<WebElement> lnks = driver.findElementsByXPath("(//td[@id='resultsCol'])//a[@data-tn-element='jobTitle']");
        //List<WebElement> lnks = driver.findElementsByClassName("turnstileLink");
        System.out.println(lnks.size());
        for (WebElement lnk : lnks) {
              Actions builder = new Actions(driver);
              builder.sendKeys(lnk,Keys.CONTROL).click(lnk).perform();       
        }
        ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
        System.out.println(tabs.size());
        int n=tabs.size();
        for (int i=0; i<n; i++) {
        driver.switchTo().window(tabs.get(i));
        System.out.println(driver.getTitle());
        }        
        driver.close();
	}
}
