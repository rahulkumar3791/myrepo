package com.test;

public class MultipleValuesReturn {

	
	public static void main(String[] args) {
		
	
	String result =  getMultipleValues();
	   int intval = Integer.parseInt(result.split(",.,")[0]);
	   double doubleval = Double.parseDouble(result.split(",.,")[1]);     
	    String strval = result.split(",.,")[2];
	    System.out.println("Intval : "+intval+ " doubleval : "+doubleval+ " strval : "+strval);
	 }

	 public static String getMultipleValues(){

	   int intval = 231;//some int value      
	   double doubleval = 3.14;//some double val
	   String strval = "hello";//some String val

	   return(intval+",.,"+doubleval+",.,"+strval);

	 }

}
