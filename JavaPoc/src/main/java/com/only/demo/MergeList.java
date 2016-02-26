package com.only.demo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MergeList {
	
	public static void main(String[] args) {
		
		
		
		List<String> a=new ArrayList<String>();
		a.add("a");
		a.add("b");
		List<String> b=new ArrayList<String>();
		b.add("a");
		b.add("d");
		
		Set<String> s=new HashSet<String>();
		s.addAll(a);
		s.addAll(b);
		for(String r:s){
		    System.out.println(r);
		}
	}

}
