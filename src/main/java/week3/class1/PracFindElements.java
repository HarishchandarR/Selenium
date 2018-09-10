package week3.class1;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PracFindElements {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/ChromeDriver.exe ");
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://google.com");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElementById("lst-ib").sendKeys("cricket");
		driver.findElementById("lst-ib").sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		//List<WebElement> namelink = driver.findElementsByPartialLinkText("cricket");
		List<WebElement> namelink = driver.findElementsByXPath("//*[contains(text(),'cricket') or contains(text(),'Cricket')");
		System.out.println(namelink.size());
		//namelink.get(0).click();
		for (WebElement name : namelink) {
			String var=name.getText();
			var.toUpperCase();
			System.out.println(name.getText());
			
		}
		driver.close();

	}

}
