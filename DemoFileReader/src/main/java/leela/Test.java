package leela;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.json.simple.parser.ParseException;


public class Test {
	
	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
		
		
		InputStream is=Test.class.getResourceAsStream("/jsonData/test.json");
		InputStreamReader isr=new InputStreamReader(is);

		BufferedReader br=new BufferedReader(isr);
		String l=null;
		
		while((l=br.readLine())!=null)
		{
			System.out.println(l);
		}
		
	
	}

	
	
}
