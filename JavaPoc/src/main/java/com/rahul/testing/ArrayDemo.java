package com.rahul.testing;

import java.util.Scanner;

public class ArrayDemo {

	public static void main(String[] args) {

		String ar[] = new String[5];
		for (int i = 0; i < ar.length; i++) {
			Scanner in = new Scanner(System.in);

			System.out.println("Enter a string");
			String s = in.nextLine();
			System.out.println("You entered string " + s);
		}

	}

}
