package commonUtils;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListnerImplementation implements ITestListener
{
	ExtentReports report;
	

	@Override
	public void onTestStart(ITestResult result)
	{
		//Reporter.log("Test Script Execution is started...",true);
		String methodName = result.getMethod().getMethodName();
		Reporter.log(methodName+"Test Script execution is started",true);
		
	}

	@Override
	public void onTestSuccess(ITestResult result)
	{
		//Reporter.log("Test Script Execution is passed...",true);
		String methodName = result.getMethod().getMethodName();
		
		//Reporter.log(methodName+"Test Script execution is passed",true);
		
		
		
		
	}

	@Override
	public void onTestFailure(ITestResult result)
	{
		//Reporter.log("Test Script Execution is Failed...",true);
		String message = result.getThrowable().toString();
		String methodName = result.getMethod().getMethodName();
		Reporter.log(methodName+"Test Script execution is failed"+message,true);
		WebDriverUtil wutil = new WebDriverUtil();
		try
		{
			wutil.screenShot(null, "Contact");
		} 
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

	@Override
	public void onTestSkipped(ITestResult result)
	{
		//Reporter.log("Test Script Execution is Skipped...",true);
		String methodName = result.getMethod().getMethodName();
		Reporter.log(methodName+"Test Script execution is skipped",true);
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context)
	{
		//Reporter.log("Test Script Execution is started...",true);
		
		JavaUtil jutil = new JavaUtil();
		
		//Create the object of ExtentSparkReporter.
		ExtentSparkReporter reporter = new ExtentSparkReporter("./ExtentReport/Report"+jutil. getRandomNumber()+".html");
		
		//Use ExtentSparkReporter class just to configure extent report.
		//call setDocumentTitle() method to give title for the report.
		reporter.config().setDocumentTitle("VTiger CRM");
		
		//call setTheme() method to set theme for extent report.
		reporter.config().setTheme(Theme.DARK);
		
		//call setReporterName() method to set the name to extent report.
		reporter.config().setReportName("Organization");
		
		//Create the object of ExtentReports class to generate extent report.
		ExtentReports report = new ExtentReports();
		
		//Call a method attachReporter(null) & pass the referance--> reporter.
		report.attachReporter(reporter);
		
		//Call a method setSystemInfo(null, null) to give extra information about report. 
		report.setSystemInfo("OS", "Window");
		
		//Call a method setSystemInfo to set browser name.
		report.setSystemInfo("Browser", "Chrome");
		
		report.setSystemInfo("Chrome Version", "121");
		
		report.setSystemInfo("Author", "Divya");
	}

	@Override
	public void onFinish(ITestContext context)
	{
		//Reporter.log("Test Script Execution is Finished...",true);
		
		//Call flush() method to add status to the extent report.
		report.flush();
	
	}
}
