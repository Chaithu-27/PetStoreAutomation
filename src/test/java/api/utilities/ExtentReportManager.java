package api.utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager implements ITestListener
{
	public ExtentSparkReporter sparkReporter;
	public ExtentReports extent;
	public ExtentTest test;
	
	String repName;
	
	public void onStart(ITestContext testContext)
	{
		/*SimpleDateFormat df=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
		  Date dt = new Date();
		  String currentdatetimestamp=df.format(dt);
		 */
		
		//putting above line in one single step
		String timeStamp= new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());// time stamp
		
		repName = "Test-Report-" +timeStamp +".html";
		sparkReporter = new ExtentSparkReporter(".\\reports\\"+repName);//specify location of the report
		
		sparkReporter.config().setDocumentTitle("RestAssuredAutomationProject");//Title of the Report
		sparkReporter.config().setReportName("PetStore Store API");//name of the report
		sparkReporter.config().setTheme(Theme.DARK);
		
		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
		extent.setSystemInfo("Application","PetStore Store API" );
		extent.setSystemInfo("Operating System", System.getProperty("os.name"));
		extent.setSystemInfo("User Name", System.getProperty("user.name"));
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("User", "Chaithanya");
		
	
	}
	
	public void onTestSuccess(ITestResult result)
	{
		test= extent.createTest(result.getName());
		test.assignCategory(result.getMethod().getGroups());
		test.createNode(result.getName());
		test.log(Status.PASS, "Test Passed");
	}
	
	public void onTestFailure(ITestResult result)
	{
		test= extent.createTest(result.getName());
		test.createNode(result.getName());
		test.assignCategory(result.getMethod().getGroups());	
		test.log(Status.FAIL,"Test failed");
		test.log(Status.INFO, result.getThrowable().getMessage());
		
		/*try
		{
			String imgPath= new BaseClass().captureScreen(result.getName());
			test.addScreenCaptureFromPath(imgPath);
		}
		catch(IOException e1)
		{
			e1.printStackTrace();
		}*/
	}
	
	public void onTestSkipped(ITestResult result)
	{
		test= extent.createTest(result.getName());
		test.createNode(result.getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.SKIP, "test skipped");
		test.log(Status.INFO, result.getThrowable().getMessage());
	}
	
	public void onFinish(ITestContext testContext)
	{
		extent.flush();
		
	}
	
}
