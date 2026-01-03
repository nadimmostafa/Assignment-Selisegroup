package com.selise.nadim;

import java.util.Scanner;

/**
 * @description: write a program that takes a number and check prime or not
 * @author: nadimmostafa26@gmail.com
 * @version: v1.00
 * @since: 2026-01-01
 */
public class CheckPrimeNumber {

	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		System.out.println("Enter Valid Number: ");
		int number = reader.nextInt();
		primeNumberChecker(number);
	}

	public static void primeNumberChecker(int number) {
		if (number <= 1) {
			System.out.println(number + " is not a prime number");
		}

		boolean isPrime = true;
		int div = 2;
		while (div * div <= number) {
			int remainder = number % div;

			if (remainder == 0) {
				isPrime = false;
				break;
			}
			div++;
		}
		if (isPrime) {
			System.out.println(number + " is a prime number.");
		} else {
			System.out.println(number + " is not a prime number.");
		}
	}

}
