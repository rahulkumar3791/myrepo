package backup;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TESTING {

	static List<String> listofFiles = null;

	public static void main(String[] args) throws IOException {

		//String str = "/home/rahul/access_data_files/flipkart/databases/flikart_app.db";
		 String str="/home/rahul/access_data_files";
		//String str="";

		File file = new File(str);
		if (file.exists() && !file.isDirectory()) {
			System.out.println("file here");
			listf(str);
		} else if (file.isDirectory() && !file.isFile()) {
			System.out.println("folder here");
			listf(str);
		} else {
			throw new FileNotFoundException("file is missing...!!!");
		}
	}

	public static List<File> listf(String filename) {
		File filee = new File(filename);

		List<File> resultList = new ArrayList<File>();
			File[] fList = filee.listFiles();
			resultList.addAll(Arrays.asList(fList));
			for (File file : fList) {
				if (file.isFile()) {
					// System.out.println(file.getAbsolutePath());
					//System.out.println("file names " + file.getName());

					if (file.getName().endsWith(".txt")) {
						System.out.println("found text files : " + file.getName());
					}

					if (file.getName().endsWith(".xml")) {
						System.out.println("found xml files :" + file.getName());
					}

				    if (file.getName().endsWith(".log")) {
						System.out.println("found log files : " + file.getName());
					}

					if (file.getName().endsWith(".json")) {
						System.out.println("found json files : " + file.getName());
					}

					if (file.getName().endsWith(".db")
							|| file.getName().endsWith(".sqlite")
							|| file.getName().endsWith(".sql")) {
						System.out.println("found Sqlite db files : " + file.getName());
					}

					else {
				//	System.out.println("other format files " + file.getName());
					}

				} else if (file.isDirectory()) {
					resultList.addAll(listf(file.getAbsolutePath()));
				}
			}
		
		return resultList;
	}

}
