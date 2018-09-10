package week2.class2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

public class LearnFrames {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/ChromeDriver.exe ");
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_prompt");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.switchTo().frame("iframeResult");
		driver.findElementByXPath("//button[text()='Try it']").click();
		String text2 = driver.switchTo().alert().getText();
		System.out.println(text2);
		driver.switchTo().alert().sendKeys("Harish");
		driver.switchTo().alert().accept();
		String text=driver.findElementById("demo").getText();
		System.out.println(text);
		Thread.sleep(2000);
		driver.close();

	}

}
