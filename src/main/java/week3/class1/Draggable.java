package week3.class1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Draggable {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/ChromeDriver.exe ");
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://jqueryui.com/draggable/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.switchTo().frame(0);
		WebElement drag = driver.findElementByXPath("//*[contains(text(),'Drag me around')]");
		Actions builder = new Actions(driver);
		//builder.dragAndDropBy(drag, xOffset, yOffset)
		builder.clickAndHold(drag).pause(2000).moveByOffset(250, 10).build().perform();
		builder.clickAndHold(drag).pause(2000).moveByOffset(200, 150).build().perform();
		builder.clickAndHold(drag).pause(2000).moveByOffset(100, 75).build().perform();
		Thread.sleep(2000);
		driver.close();

	}

}
