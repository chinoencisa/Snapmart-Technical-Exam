package Utilities;

//////Listener class used to generate Extent Reports
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;

public class Reporting extends TestListenerAdapter 
{
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest logger;
	
	public void onStart(ITestContext testContext)
	{
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());//timestamp
		String repName="Test-Report-"+timeStamp+".html";
		htmlReporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/"+repName);//specifylocation
		htmlReporter.loadXMLConfig(System.getProperty("user.dir")+ "/extent-config.xml");
		
		extent=new ExtentReports();
		
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host name","localhost");
		extent.setSystemInfo("Environment", "QA _Exam");
		extent.setSystemInfo("Applicant", "Chino Encisa");
		
		htmlReporter.config().setDocumentTitle("Project One Report"); //title of report
		htmlReporter.config().setReportName("Functional Test Report");//name of report
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);

	}
	
	public void onTestSuccess(ITestResult tr)
	{
		logger=extent.createTest(tr.getName()); //create new entry in the report
		logger.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN)); //send the passed information
		
		String screenshotPath=System.getProperty("user.dir")+"//Screenshots//"+tr.getName()+"_PASS"+".png";
		
		File f = new File(screenshotPath);
		
		if(f.exists())
		{
			try {
				logger.pass("Screenshot is below:" + logger.addScreenCaptureFromPath(screenshotPath));
				}	
			catch (IOException e)
				{
					e.printStackTrace();
				}
		}
		
		
	}
	
	public void onTestFailure(ITestResult tr)
	{
		logger=extent.createTest(tr.getName()); //create new entry in the report
		logger.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED)); //send the passed information
		
		String screenshotPath=System.getProperty("user.dir")+"//Screenshots//"+tr.getName()+"_PASS"+".png";
		
		File f = new File(screenshotPath);
		
		if(f.exists())
		{
			try {
				logger.fail("Screenshot is below:" + logger.addScreenCaptureFromPath(screenshotPath));
				}	
			catch (IOException e)
				{
					e.printStackTrace();
				}
		}
	
	}
	
	public void onTestSkipped(ITestResult tr)
	{
		logger=extent.createTest(tr.getName()); //create new entry in the report
		logger.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(),ExtentColor.ORANGE));

	}
	
	public void onFinish(ITestContext testContext)
	{
		extent.flush();
	}
	
	
}
