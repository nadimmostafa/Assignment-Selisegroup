package com.selise.nadim;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @description: write a program that takes an array and find max value of an array
 * @author: nadimmostafa26@gmail.com
 * @version: v1.00
 * @since: 2026-01-01
 */
public class MaxNumberFinder {

	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		System.out.println("Enter Array Length: ");
		int arrLen = reader.nextInt();
		if (arrLen < 1) {
			System.out.println("Invalid length!");
		}
		int[] arr = new int[arrLen];
		System.out.println("Enter Array value " + arrLen + " times");
		for (int i = 0; i < arrLen; i++) {
			arr[i] = reader.nextInt();
		}
		
		//debug purpose
		//Arrays.stream(arr).forEach(System.out::print);
		
		//int []arr1 = {10,-9,11,8,7,0,-11,17,11};
		
		// call a method
		findMax(arr);
		
	}

	public static void findMax(int[] arr) {
		/*
		// find max using Java stream api
		int maxNumber = Arrays.stream(arr).max()
				.orElseThrow(()->new IllegalArgumentException("Array is empty"));
		
		System.out.println("The max number is "+maxNumber);
		*/
		
		//custom coding
		//consider the first value of an array is the max number
		int max = arr[0];
		for(int i=1;i<arr.length;i++) {
			if(arr[i]>max) {
				max=arr[i];
			}
		}
		
		System.out.println("The max number of an array is: "+ max);
	}

}
