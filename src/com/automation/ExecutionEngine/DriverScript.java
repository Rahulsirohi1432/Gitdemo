package com.automation.ExecutionEngine;
import java.io.FileInputStream;
import java.lang.reflect.Method;
import java.util.Properties;

import com.automation.Config.ActionKeywords;
import com.automation.Config.Constants;
import com.automation.utils.ExcelUtils;

public class DriverScript {
	//private static WebDriver driver = null;
	//This is a class object, declared as 'public static'
	 //So that it can be used outside the scope of main[] method
	public static ActionKeywords actionkeywords;
	public static String sActionKeyword; 
	public static Method method[];
	public static Properties OR;
	public static String sPageObject;
	public static String sTestCaseID;
	public static String sRunMode;
	public static int iTestStep;
	public static int iTestLastStep;
	
	public DriverScript()
	
	{
		actionkeywords = new ActionKeywords();
	
		method = actionkeywords.getClass().getMethods();
		
		System.out.println(method);
	}

	public static void main(String[] args) throws Exception {
		
		
//		
//		// Declaring the path of the Excel file with the name of the Excel file
//     
//		String spath = Constants.Path_TestData;
     
		ExcelUtils.setExcelFile(Constants.Path_TestData);

		 //Declaring String variable for storing Object Repository path
		String Path_OR = Constants.Path_OR;
		
		//Creating file system object for Object Repository text/property file
		FileInputStream fs = new FileInputStream(Path_OR);
		 //Creating an Object of properties
		OR = new Properties(System.getProperties());
		//Loading all the properties from Object Repository property file in to OR object
		OR.load(fs);
		DriverScript startEngine = new DriverScript();
		startEngine.execute_testcases();
	}
		
		private void execute_testcases() throws Exception
		{
			//This will return the total number of test cases mentioned in the Test cases sheet
			
			int iTotalTestCases= ExcelUtils.getRowCount(Constants.Sheet_TestCases);
			
			
			//This loop will execute number of times equal to Total number of test cases
			
			for (int iTestCases=1;iTestCases<=iTotalTestCases;iTestCases++)
			{
				//This is to get the Test case name from the Test Cases sheet
				
				sTestCaseID=ExcelUtils.getcelldata(iTestCases, Constants.Col_TestCaseId, Constants.Sheet_TestCases);
					
				
				//This is to get the value of the Run Mode column for the current test case
				
				sRunMode=ExcelUtils.getcelldata(iTestCases, Constants.Col_RunMode, Constants.Sheet_TestCases);
				
				
				//This is the condition statement on RunMode value
				
				if(sRunMode.equalsIgnoreCase("Yes"))
				{
					//Only if the value of Run Mode is 'Yes', this part of code will execute
					
					
					iTestStep=ExcelUtils.getRowContains(sTestCaseID, Constants.Col_TestCaseId, Constants.Sheet_TestSteps);
					iTestLastStep=ExcelUtils.getTestStepsCount(Constants.Sheet_TestSteps, sTestCaseID, iTestStep);
					
					//This loop will execute number of times equal to Total number of test steps
					
					for (;iTestStep<=iTestLastStep;iTestStep++){
			    		sActionKeyword = ExcelUtils.getcelldata(iTestStep, Constants.Col_ActionKeyword,Constants.Sheet_TestSteps);
			    		sPageObject = ExcelUtils.getcelldata(iTestStep, Constants.Col_PageObject, Constants.Sheet_TestSteps);
			    		execute_Actions();
					
			}
			
				
			}
			}
				
		
		}
    
	
	
	
	private static void execute_Actions() throws Exception
	{
		for(int i =0;i<method.length;i++)//length=7
		{
			if(method[i].getName().equalsIgnoreCase(sActionKeyword))
			{
				method[i].invoke(actionkeywords,sPageObject);//============>>How?
				
				break;
			}
		}
		
	}

	}
