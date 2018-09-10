package week1.class2;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Practiceddown {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/ChromeDriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.leafground.com");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.partialLinkText("Drop")).click();
		//select a value from 1st dropdown using index
		WebElement dd1 = driver.findElementById("dropdown1");
		Select sel1=new Select(dd1);
		sel1.selectByIndex(1);
		//select a value from 2nd dropdown using text
		WebElement dd2 = driver.findElementByName("dropdown2");
		Select sel2=new Select(dd2);
		sel2.selectByVisibleText("UFT/QTP");
		//select a value from 3rd dropdown using value
		WebElement dd3 = driver.findElementById("dropdown3");
		Select sel3=new Select(dd3);
		sel3.selectByValue("2");
		// get the no. of dropdown options from 4th dropdown
		WebElement dd4 = driver.findElementByXPath("//*[@id=\"contentblock\"]/section/div[4]/select");
		Select sel4=new Select(dd4);
		List<WebElement> options = sel4.getOptions();
		int count = options.size();
		System.out.println(count);
		WebElement dd5 = driver.findElementByXPath("//*[@id=\"contentblock\"]/section/div[5]/select");
		dd5.sendKeys("Loadrunner");
		//select 2 options Selenium and QTP from dropdown
		WebElement dd6 = driver.findElementByXPath("//*[@id=\"contentblock\"]/section/div[6]/select");
		Select sel6=new Select(dd6);
		//sel6.deselectByValue("0");
		sel6.selectByIndex(1);
		sel6.selectByIndex(3);
		List<WebElement> allSelectedOptions = sel6.getAllSelectedOptions();
		for (WebElement eachSel : allSelectedOptions) {
			System.out.println(eachSel.getText());
		}
		Thread.sleep(3000);
		driver.close();


	}

}
