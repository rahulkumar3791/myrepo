package com.rahul.testing;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class HiddenFile {

	public static void main(String[] args) throws Exception {
		BufferedImage bImage = null;
		try {
			String str="/home/rahul/Desktop/screens/.cadastrocanal.activity.QuizStartActivity1454507402548.png";
			File initialImage = new File(str
					);

			bImage = ImageIO.read(initialImage);
			
			System.out.println(initialImage);
			System.out.println(bImage);

			ImageIO.write(bImage, "png", new File(
					"/home/rahul/Desktop/rahul.png"));

			
			
		
			
			
		} catch (IOException e) {
			System.out.println("Exception occured :" + e.getMessage());
		}
		System.out.println("Images were written succesfully.");
	}

}
