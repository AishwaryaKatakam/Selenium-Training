package com.mercury.tours;

import org.testng.annotations.DataProvider;

public class application_testData {
	
	@DataProvider(name="Sign_On")	
	public Object[][] getDataFromDataprovider(){
		
		return new Object[][] {
			//{"mngr238457","YbehEmY"},		
			{"dixit","dixit"},
			{"testing","testing"}
			//{"mngr238457","YbehEmY"}
		};
	}
	
	//-------------------------------------------- This is to read Excel Data------------

	@DataProvider(name = "LoginData")
	public Object[][] Authentication() throws Exception{
		Read_Excel excel = new Read_Excel();
		Object[][] testObjArray = excel.getExcelData("D:\\Selenium training\\com.mercury.tours_Maven\\Mercury_Tours_SignOn.xls","SignOn");
		System.out.println(testObjArray);
		return testObjArray;

	}
}
