package wdMethods;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import week4.class2.ReadExcel;

public class ProjectMethods extends SeMethods {
	public String sheetname;
	public String testName;
	public String desc;
	public String author;
	public String category;
	@BeforeSuite
	public void beforeSuite(){
		startResult();	
	}
	@BeforeClass
	public void startTestcase(){
		startTestCase(testName, desc);
	}

	@BeforeMethod
	public void login() {
		beforeMethod(author,category);
		startApp("chrome", "http://leaftaps.com/opentaps");
		WebElement eleUserName = locateElement("id", "username");
		type(eleUserName, "DemoSalesManager");
		WebElement elePassword = locateElement("id","password");
		type(elePassword, "crmsfa");
		WebElement eleLogin = locateElement("class","decorativeSubmit");
		click(eleLogin);
	}
	@AfterMethod
	public void logout() {
		closeBrowser();	
	}

	@AfterSuite
	public void afterSuite() {
		endResult();
	}

	@DataProvider(name="pulldata")
	public String[][] getData() throws IOException {
		ReadExcel obj = new ReadExcel();
		return obj.excelData(sheetname);




	}
}
