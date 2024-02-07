package com.api.RestAssured;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import Files.Payload;
import Files.ReusableMethods;
import io.restassured.path.json.JsonPath;

import io.restassured.RestAssured;

public class AddPlace {

	public static void main(String[] args) {
		/*
		 * Scenario Name (1): Validation For Adding a Place and extracting response in string format
		 * Scenario Name (2): Validation For Updating  a Place by extracting place_id
		 * Author Name : Vishesh Bakshi
		*/
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		String response = given().log().all().queryParam("key ", "qaclick123")
		.body(Payload.AddPlacePayload()).when().post("/maps/api/place/add/json").then().statusCode(200)
		.body("scope",equalTo("App")).header("Server", "Apache/2.4.52(Ubuntu)").extract().response().asString();

		System.out.println("My entire response body looks like " +response);	
		
		//Sc:2 Update place with place_id
		//Parsing json with json path class with input as an string
		
		JsonPath js =ReusableMethods.rawToJson(response); //this will return an object
		String placeId = js.get("place_id");
		
		System.out.println("My added place is "+placeId);
		
		given().log().all().queryParam("key ", "qaclick123")
		.body("{\r\n"
				+ "\"place_id\":\""+placeId+"\",\r\n"
				+ "\"address\":\"70 Summer ThanaRoad, USA\",\r\n"
				+ "\"key\":\"qaclick123\"\r\n"
				+ "}\r\n"
				+ "").when().put("/maps/api/place/add/json").then().log().all().assertThat().statusCode(200);
					
	}


}
