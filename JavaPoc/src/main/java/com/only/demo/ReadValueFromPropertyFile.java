package com.only.demo;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadValueFromPropertyFile {
	
	public static void main(String[] args) {

		Properties properties = new Properties();
		InputStream input = null;

		try {
			input = new FileInputStream("src/main/resources/test.properties");
			properties.load(input);
			
			System.out.println(properties.getProperty("my_name"));
			System.out.println(properties.getProperty("my_address"));
			System.out.println(properties.getProperty("my_mob"));

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	  }

}
