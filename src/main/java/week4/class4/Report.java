package week4.class4;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Report {
public ExtentReports extent;
public ExtentTest test, testData;
//@BeforeSuite
public void startResult() {
	ExtentHtmlReporter html = new ExtentHtmlReporter("./reports/result.html");
	html.setAppendExisting(true);
	 extent = new ExtentReports();
	extent.attachReporter(html);
}
public void reportStep(String stepDesc, String status) {
	if(status.equalsIgnoreCase("Pass")) {
		testData.pass(stepDesc);
	}
	else if(status.equalsIgnoreCase("Fail")) {
		testData.pass(stepDesc); 			
		}
		}
//@BeforeClass
public void startTestCase(String testName,String desc) {
	test = extent.createTest(testName,desc);
}
//@BeforeMethod
public void beforeMethod(String author, String category) {
	testData = test.createNode("Leads");
	test.assignAuthor(author);
	test.assignCategory(category);
}
//@AfterSuite
public void endResult() {
	extent.flush();
}
}


