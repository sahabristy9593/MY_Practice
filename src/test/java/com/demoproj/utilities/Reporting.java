package com.demoproj.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
//import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class Reporting extends TestListenerAdapter 
{
      public ExtentHtmlReporter htmlReporter;
      public ExtentReports extent;
      public ExtentTest logger;
      
//      ExtentSparkReporter spark = new ExtentSparkReporter("Spark.html");  //for version- 5.0.9
      
      public void onStart(ITestContext testContext) {
    	  
    	  String timeStamp =  new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
    	  String repName = "Test-Report-"+timeStamp+".html";
    	  htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/"+repName);
    	  htmlReporter.loadXMLConfig(System.getProperty("user.dir")+"/extent-config.xml");
    	  
    	  extent = new ExtentReports();
    	  
    	  extent.attachReporter(htmlReporter);
    	  extent.setSystemInfo("Host name", "localhost");
    	  extent.setSystemInfo("Environment", "QA");
    	  extent.setSystemInfo("user", "Asmita");
    	  
    	  htmlReporter.config().setDocumentTitle("Demo Test Project");
    	  htmlReporter.config().setReportName("Functional Test Report");
//     	  htmlReporter.config().setTestViewChartLocation();
    	  htmlReporter.config().setTheme(Theme.STANDARD);
    	  
      }
      
      public void onTestSuccess(ITestResult tr) {
    	  
    	  logger = extent.createTest(tr.getName());
    	  logger.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));
    	  
      }
      
      public void onTestFailure(ITestResult tr) {
    	  logger = extent.createTest(tr.getName());
    	  logger.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));
    	  
    	  String screenshotPath = System.getProperty("user.dir")+"\\Screenshots\\"+tr.getName()+".png";
    	  
    	  File f = new File(screenshotPath);
    	  
    	  if(f.exists()) {
    		  try {
    			  logger.fail("Screenshot is below:" + logger.addScreenCaptureFromPath(screenshotPath));
    		  }
    		  catch(IOException e){
    			  e.printStackTrace();
    		  }
    	  }
      }
      
      public void onTestSkipped(ITestResult tr) {
    	  logger = extent.createTest(tr.getName());
    	  logger.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.ORANGE));
      }
      
      public void onTestFinish(ITestContext testContext) {
    	  extent.flush();
      }
      
      
}
