package ExtendReport;

import java.io.File;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager implements ITestListener{
	
	public ExtentSparkReporter sparkReporter;
	public ExtentReports extent;
	public ExtentTest test;
 	
	@Override
	public void onStart(ITestContext context) {
		
		sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "//Reports//report.html");
		
		sparkReporter.config().setDocumentTitle("Automation Report");
		sparkReporter.config().setReportName("Functional Testing");
		sparkReporter.config().setTheme(Theme.STANDARD);
		
		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
	
		extent.setSystemInfo("Computer Name", "localhost");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("Testers Name", "Prajith , Preetha , Preethi , Yogeshwaran D");
		extent.setSystemInfo("os", "Windows10");
		extent.setSystemInfo("Browsers name", "Chrome and Edge");
	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
		test = extent.createTest(result.getName());
		test.log(Status.PASS,"Test case PASSED is : "+result.getName());
		String path = System.getProperty("user.dir") + "\\Screenshots\\" + result.getName() + ".png" ;
	}
		
	@Override
	public void onTestFailure(ITestResult result) {
		test = extent.createTest(result.getName());
		test.log(Status.FAIL,"Test case PASSED is : "+result.getName());
		test.log(Status.FAIL,"Test case FAILED cause is : "+result.getThrowable());
	}
		
	@Override
	public void onTestSkipped(ITestResult result) {
		test = extent.createTest(result.getName());
		test.log(Status.SKIP,"Test case PASSED is : "+result.getName());
	}
		
	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
	}
	
	
}
