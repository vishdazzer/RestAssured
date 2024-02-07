package com.api.RestAssured;


import java.util.Map.Entry;
import java.util.Set;

public class test {
	
	public static int SecondLargest(int arr[]) {
		
		int temp=0;
		
		for(int i=0;i<arr.length-1;i++) {
			if(arr[i]>arr[i+1]) {
				temp=arr[i];
				arr[i]=arr[i+1];
				arr[i+1]=temp;
			}
			
		}
		return arr[arr.length-2];
		
	}
	
	public static void main(String[] args) {
		
		
		int arr[] = {5,12,6,5,78};
		
		
		System.out.println("Second largest number present in an array is" +SecondLargest(arr));
		
		
	}

}
