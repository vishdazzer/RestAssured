package Files;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class HandlingStaticJsonPayloads {
	
	/*
	 * sc-1 (Handling static data)
	 * 
	 * Author Name - Vishesh Bakshi
	 */
	
	@Test
	public void addBook(String isbn, String aisle) throws IOException 
	
	{
		
		RestAssured.baseURI = "http://216.10.245.166";		
		String libraryResponse = given().header("Content-Type","application/json")
				//Converting file to string -> content of file to be converted into byte ->Byte data to string
		.body(new String (Files.readAllBytes(Paths.get("C:\\Users\\visheshbakshi\\Desktop\\Notes\\ExternalFileRead.json"))))
		.when().post("/Library/Addbook.php").then().statusCode(200).extract().asString();	
		System.out.println("Response of a given library api is " +libraryResponse);	
		JsonPath js = ReusableMethods.rawToJson(libraryResponse);	
		String repId = js.get("ID");		
		System.out.print(repId);
	}
	

}
