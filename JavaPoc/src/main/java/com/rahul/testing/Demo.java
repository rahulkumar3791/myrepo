package com.rahul.testing;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.commons.io.FileUtils;

public class Demo {

	public static void main(String[] args) throws IOException {

		/*
		 * Path tempDir = Files.createTempDirectory("彰化銀行行動網銀.apk");
		 * System.out.println("Directory name " + tempDir.getFileName());
		 * System.out.println(tempDir);
		 * 
		 * Path tempFile = Files.createTempFile(tempDir, "彰化銀行行動網銀.apk", null);
		 * System.out.println(tempFile);
		 * 
		 * File file = new File("/home/rahul/彰化銀行行動網銀.apk");
		 * FileUtils.copyFileToDirectory(file, tempDir.toFile());
		 * 
		 * System.out.println("Actual file name " + file.getName());
		 */

		/*
		 * String fileName="/home/rahul/彰化銀行行動網銀.apk"; List<String> lines =
		 * Arrays.asList(fileName); Files.write(tempFile, lines,
		 * Charset.defaultCharset(), StandardOpenOption.WRITE);
		 */

		readFile(args[0]);

	}
//create directory via filename and copied file into created directory..
	public static void readFile(String fileName) {
		File file = new File(fileName);

		String absolutePath = file.getAbsolutePath();
		String filePath = absolutePath.substring(0,
				absolutePath.lastIndexOf(File.separator));

		System.out.println("file Name is " + file.getName());
		System.out.println("absolute path :: "+ filePath);

		try {
			// Path tempDir = Files.createTempDirectory(file.getName());
			Path tempDir = Files.createTempDirectory(Paths.get(filePath),
					file.getName());

			System.out.println(tempDir);
			System.out.println("Directory Name is " + tempDir.getFileName());
			FileUtils.copyFileToDirectory(file, tempDir.toFile());

		} 
		
		catch (IOException e) {
			e.printStackTrace();
		}

	}

}
