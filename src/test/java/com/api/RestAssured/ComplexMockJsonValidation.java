package com.api.RestAssured;

import Files.Payload;
import io.restassured.path.json.JsonPath;

public class ComplexMockJsonValidation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Scenario 1) - Print number of courses returned by API 
		 * Scenario 2) - Print Purchase amount 
		 * Scenario 3) - Print title of first course
		 * Scenario 4) - Print all course title and their respective prices
		 * Scenario 5) - Print number of courses sold by RPA course
		 * 
		 * Author - Vishesh Bakshi
		 */
		
		JsonPath js = new JsonPath(Payload.Courses());
		
		//Sc:1
		
		int size = js.getInt("courses.size()");
		System.out.println("Total size of the dummy courses is equal to " +size);
		
		//Sc:2
		
		int purchaseAmount = js.getInt("dashboard.purchaseAmount");
		System.out.println("Purchase amount for the dummy courses is equal to " +purchaseAmount);
		
		//Sc:3
		
		String firstCourseTite = js.getString("courses[0].title");
		System.out.println("First course title  for the dummy courses is equal to " +firstCourseTite);
		
		//Sc:4 
		
		
		for(int i=0;i<size;i++) {
			
			String CourseTitles = js.getString("courses["+i+"].title"); 
			if(CourseTitles!="") {
				int  price = js.getInt("courses["+i+"].price");
				System.out.println("course title  for the dummy courses is equal to " +CourseTitles+ "with price amount "+price);
				
			}
					
		}
		
		//Sc:5 (Print number of copies sold by RPA course)
		
		for(int i=0;i<size;i++) {
			String CourseTitles = js.getString("courses["+i+"].title"); 
			if(CourseTitles.contains("RPA")) {
				int copies = js.getInt("courses["+i+"].copies");
				System.out.println("total copies created for RPA course is equal to " +copies);
			}
		}
		
		
		
		
	}

}
