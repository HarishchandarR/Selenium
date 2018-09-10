package wdMethods;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

import week4.class4.Report;

public class SeMethods extends Report implements WdMethods{
        public int i=1;
	public RemoteWebDriver driver;
	public void startApp(String browser, String url) {
		try {
			if(browser.equalsIgnoreCase("chrome")){
				System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
				driver = new ChromeDriver();
			} else if (browser.equalsIgnoreCase("firefox")){
				System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
				driver = new FirefoxDriver();
			}
			driver.get(url);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			reportStep("The Browser "+browser+" Launched Successfully","PASS");
		}
	catch (WebDriverException e) {
		reportStep("Unknown exception occurred","FAIL");
	}finally {
		takeSnap();
	}
	}
	
	public WebElement locateElement(String locator, String locValue) {
		
			try {
				switch(locator) {
				case "id"	 : return driver.findElementById(locValue);
				case "class" : return driver.findElementByClassName(locValue);
				case "name"	: return driver.findElementByName(locValue);
				case "xpath" : return driver.findElementByXPath(locValue);
				case "Partiallinktext"	: return driver.findElementByPartialLinkText(locValue);
				case "linktext" : return driver.findElementByLinkText(locValue);
				}
			} 
			catch (NoSuchElementException e) {
				System.err.println("Element is not found or visible in the webpage");
			}
			catch (ElementNotVisibleException e) {
				System.err.println("Element is not found or visible in the webpage");
			}
			finally {
				takeSnap();
			}
		return null;
	}

	@Override
	public WebElement locateElement(String locValue) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public void type(WebElement ele, String data) {
	
			ele.sendKeys(data);
			System.out.println("The data "+data+" is Entered Successfully");
		
	}

	
	public void clickWithNoSnap(WebElement ele) {
		
			ele.click();
			System.out.println("The Element "+ele+" Clicked Successfully");
		
	}
	
	
	@Override
	public void click(WebElement ele) {
		
			ele.click();
			System.out.println("The Element "+ele+" Clicked Successfully");
		
	}

	@Override
	public String getText(WebElement ele) {
		ele.getText();
		System.out.println("The text "+ele+"gets displayed successfully");
		return null;
	}

	@Override
	public void selectDropDownUsingText(WebElement ele, String value) {
		Select selobj = new Select(ele);
		selobj.selectByVisibleText(value);

	}

	@Override
	public void selectDropDownUsingIndex(WebElement ele, int index) {
		Select selobj = new Select(ele);
		selobj.selectByIndex(index);

	}

	@Override
	public boolean verifyTitle(String expectedTitle) {		

		return false;
	}
	
	

	@Override
	public void verifyExactText(WebElement ele, String expectedText) {
		String text = ele.getText();
		if(text.equals(expectedText)) {
			System.out.println("The text"+text+" matched with" +expectedText+" successfully.");}
			else{
				System.out.println("The text"+text+" does not match with" +expectedText+"");				
			};
			
		}


	@Override
	public void verifyPartialText(WebElement ele, String expectedText) {
		// TODO Auto-generated method stub

	}

	@Override
	public void verifyExactAttribute(WebElement ele, String attribute, String value) {
		// TODO Auto-generated method stub

	}

	@Override
	public void verifyPartialAttribute(WebElement ele, String attribute, String value) {
		// TODO Auto-generated method stub

	}

	@Override
	public void verifySelected(WebElement ele) {
		try {
			if(ele.isSelected()) {
				System.out.println("Checkbox:" + ele + "is already selected");
									
			}
			else {
				ele.click();
			}
			
		}catch(Exception e) {
			System.out.println("Unable to select the checkbox"+ele);
		}

	}

	@Override
	public void verifyDisplayed(WebElement ele) {
		// TODO Auto-generated method stub

	}

	@Override
	public void switchToWindow(int index) {
		Set<String> abc = driver.getWindowHandles();
		List<String> def = new ArrayList<String>();
		def.addAll(abc);
		driver.switchTo().window(def.get(index));

	}

	@Override
	public void switchToFrame(WebElement ele) {
		// TODO Auto-generated method stub

	}

	@Override
	public void acceptAlert() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dismissAlert() {
		// TODO Auto-generated method stub

	}

	@Override
	public String getAlertText() {
		// TODO Auto-generated method stub
		return null;
	}

	
	public void takeSnap() {
		File src = driver.getScreenshotAs(OutputType.FILE);
		File des = new File("./snaps/img"+i+".png");
		try {
			FileUtils.copyFile(src, des);
		} catch (IOException e) {
			System.err.println("IOException");
		}
		i++;
	}

	@Override
	public void closeBrowser() {
		driver.close();
	}

	@Override
	public void closeAllBrowsers() {
		// TODO Auto-generated method stub

	}


	@Override
	public void clear(WebElement ele) {
		ele.clear();
		
	}

}
