package week3.class1;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.chrome.ChromeDriver;

public class LearnFindElements {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/ChromeDriver.exe ");
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://google.com");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElementById("lst-ib").sendKeys("Harish");
		driver.findElementById("lst-ib").sendKeys(Keys.ENTER);
		//driver.findElementByXPath("//input[@type='submit']").click();
		//driver.findElementByName("btnK").click();
		List<WebElement> namelink = driver.findElementsByPartialLinkText("Harish");
		System.out.println(namelink.size());
		//namelink.get(0).click();
		for (WebElement name : namelink) {
			System.out.println(name.getText());
			
		}
		Thread.sleep(3000);
		driver.close();

	}

}
