package com.automation.Config;

public class Constants {
	

	 //This is the list of System Variables
	    //Declared as 'public', so that it can be used in other classes of this project
	    //Declared as 'static', so that we do not need to instantiate a class object
	    //Declared as 'final', so that the value of this variable can be changed
	    // 'String' & 'int' are the data type for storing a type of value 
	public static final String URL="http://web.smartchiponline.com:2279/CBIS/";
	public static final String Path_TestData="C:\\Users\\g515778\\eclipse-workspace\\HybridKeywordDriven\\src\\com\\automation\\dataengine\\DataEngine.xlsx";
	public static final String Path_OR="C:\\Users\\g515778\\eclipse-workspace\\HybridKeywordDriven\\src\\com\\automation\\Config\\OR.properties";
    public static final String File_TestData="DataEngine.xlsx";
	
    //List of Data Sheet Column Numbers
    public static final int Col_TestCaseId=0;
	public static final int Col_TestScenarioId=1;
	public static final int Col_PageObject=3;
	public static final int Col_ActionKeyword=4;
	//New Entry for Run Mode
	public static final int Col_RunMode=2;
	
	//List of Data Engine Excel sheets
	public static final String Sheet_TestSteps= "TestSteps";
	
	//New Entry in constant variable
	public static final String Sheet_TestCases= "Test Cases";
	
	
	// List of Test Data
	 public static final String UserName = "Admin123";
	 public static final String Password = "Admin@123";
	//public static final String Col_TestCaseID = null;
	
}
