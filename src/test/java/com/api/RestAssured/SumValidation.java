package com.api.RestAssured;
import org.testng.annotations.*;
import org.testng.asserts.Assertion;

import Files.Payload;
import io.restassured.path.json.JsonPath;
import junit.framework.Assert;

public class SumValidation {
	
	/*
	 * Sc:1Verify sum of all course prices matches with purchase amount
	 * Author Name : Vishesh Bakshi 
	 */
	
	@Test
	
	public void SumOfCourses () {
		int sum = 0;
		JsonPath js = new JsonPath(Payload.Courses());
		int size = js.getInt("courses.size()");
		
		
		//Iterating throughout the courses array to get tota sum using prices and copies
		for(int i=0;i<size;i++) {
			int price = js.get("courses["+i+"].price");
			int copies = js.get("courses["+i+"].copies");
			int amount = price*copies;
			System.out.println(amount);
			sum = sum+amount;
			
		}
		System.out.println("total sum is equal to " +sum);
		int purchaseAmount = js.getInt("dashboard.purchaseAmount");
		Assert.assertEquals(sum, purchaseAmount);
	}

}
