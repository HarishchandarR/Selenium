package week3.class1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class Selectable {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/ChromeDriver.exe ");
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://jqueryui.com/selectable/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.switchTo().frame(0);
		//driver.findElementByXPath("//*[contains(text(),'Item 1')]").click();
		//driver.findElementByXPath("//*[contains(text(),'Item 1')]").sendKeys(Keys.CONTROL);
		//driver.findElementByXPath("//*[contains(text(),'Item 3')]").click();
		WebElement itm1 = driver.findElementByXPath("//*[contains(text(),'Item 1')]");
		WebElement itm3 = driver.findElementByXPath("//*[contains(text(),'Item 3')]");
		WebElement itm5 = driver.findElementByXPath("//*[contains(text(),'Item 5')]");
		WebElement itm7 = driver.findElementByXPath("//*[contains(text(),'Item 3')]");
		Actions builder = new Actions(driver);
		builder.keyDown(Keys.CONTROL).click(itm1).click(itm3).click(itm5).click(itm7).perform();
		//builder.clickAndHold(itm1).build().perform();
		//builder.clickAndHold(itm3).build().perform();
		Thread.sleep(3000);
		driver.close();

	}

}
