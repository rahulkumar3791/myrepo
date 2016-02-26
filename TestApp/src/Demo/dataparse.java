package Demo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class dataparse {
	
	public static void main(String args[]) throws FileNotFoundException {

        List<String> tables = new ArrayList<String>();
        List<String> columns = new ArrayList<String>();

        File text = new File("/home/rahul/rahulworkspace/TestApp/test.db");      
        Scanner scnr = new Scanner(text);      
        int lineNumber = 1;
        while(scnr.hasNextLine()){
            String line = scnr.nextLine();

            if(line.indexOf("DROP") != -1){
                tables.add(parseTable(line));
            }else{
                if(line.indexOf("CREATE") == -1)
                columns.add(parseColumn(line));
            }

            lineNumber++;
        }       

        System.out.println("Tables : "+tables);
        System.out.println("Columns : "+columns);
    }   

    public static String parseTable(String line){

        String[] arr = line.split(" ");
        return arr[2];
    }
    public static String parseColumn(String line){

        String[] arr = line.split(" ");
        return arr[0];

        }


}
