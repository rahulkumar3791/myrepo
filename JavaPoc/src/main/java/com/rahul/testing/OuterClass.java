package com.rahul.testing;


public class OuterClass {
	
	private int i = 9;
	 
	public void createInner() {
	InnerClass i1 = new InnerClass();
	i1.getValue();
	}
	 
	class InnerClass {
	public void getValue() {
	System.out.println("value of i : " + i);
	}
	}

	
	
	public static void main(String[] args) {
		
		OuterClass outerclass = new OuterClass();
		OuterClass.InnerClass innerclass = outerclass.new InnerClass();
		innerclass.getValue();
		}


}
