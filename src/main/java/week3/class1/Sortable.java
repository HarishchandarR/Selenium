package week3.class1;

import java.util.concurrent.TimeUnit;

//import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Sortable {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/ChromeDriver.exe ");
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://jqueryui.com/sortable/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.switchTo().frame(0);
		WebElement itm1 = driver.findElementByXPath("//*[contains(text(),'Item 1')]");
		WebElement itm4 = driver.findElementByXPath("//*[contains(text(),'Item 4')]");
		Actions builder = new Actions(driver);
		int y = itm4.getLocation().getY();
		//builder.dragAndDrop(itm1, itm4).build().perform();
		builder.dragAndDropBy(itm1, 0, y).release().perform();
		Thread.sleep(2000);
		driver.close();
	}

}
