package test;

public class TEST {
	
	public static void main(String[] args) {
		
		
		String line = "ten;one,three;twenty,four";
        String[] splits = line.split("[;,]");
     
        for(String abd:splits)
        {
        	System.out.println(abd);
        }
	}

}
