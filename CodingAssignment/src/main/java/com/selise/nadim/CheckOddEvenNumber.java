package com.selise.nadim;

import java.util.Scanner;

/**
 * @description: write a program that takes a number and check odd or even
 * @author: nadimmostafa26@gmail.com
 * @version: v1.00
 * @since: 2026-01-01
**/
public class CheckOddEvenNumber {

	public static void main(String[] args) {

		Scanner reader = new Scanner(System.in);
		System.out.println("Enter Whole Number: ");
		if (reader.hasNextInt()) {
			int number = reader.nextInt();
			oddEvenChecker(number);
		} else {
			System.out.println("Invalid Number! Please Give Valid Whole Number ('.')");
		}

		reader.close();

	}

	public static void oddEvenChecker(int wholeNumber) {
		if (wholeNumber % 2 == 0) {
			System.out.println(wholeNumber + " is Even Number");
		} else {
			System.out.println(wholeNumber + " is Odd number");
		}
	}

}
