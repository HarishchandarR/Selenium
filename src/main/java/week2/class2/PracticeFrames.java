package week2.class2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

public class PracticeFrames {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/ChromeDriver.exe ");
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://layout.jquery-dev.com/demos/iframe_local.html");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.switchTo().frame("chileIframe");
        driver.findElementByXPath("//*[text()='Close Me']").click();
        Thread.sleep(2000);
        driver.findElementByXPath("/html/body/div[3]/p/button").click();
        driver.switchTo().defaultContent();
        Thread.sleep(2000);
        driver.findElementByXPath("/html/body/div[1]/p[1]/button").click();
        Thread.sleep(2000);
        driver.findElementByXPath("/html/body/div[2]/p/button").click();
        Thread.sleep(2000);
        driver.findElementByXPath("/html/body/div[3]/p/button").click();
        Thread.sleep(2000);
        driver.close();
	}

}
