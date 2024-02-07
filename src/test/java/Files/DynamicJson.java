package Files;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
public class DynamicJson {
	
	/*
	 * sc-1 (Sending parameters from payload to test)
	 * sc-2 (Parameterizing your tests with multiple data set)
	 * Author Name - Vishesh Bakshi
	 */
	
	@Test	(dataProvider="BookData")
	public void addBook(String isbn, String aisle) 
	
	{
		
		RestAssured.baseURI = "http://216.10.245.166";		
		String libraryResponse = given().header("Content-Type","application/json")
		.body(Payload.publicLibrary(isbn,aisle))
		.when().post("/Library/Addbook.php").then().statusCode(200).extract().asString();	
		System.out.println("Response of a given library api is " +libraryResponse);	
		JsonPath js = ReusableMethods.rawToJson(libraryResponse);	
		String repId = js.get("ID");		
		System.out.print(repId);
	}
	
	//Can be called as utility code
	@DataProvider(name="BookData")
    public Object[][] getData() {
		//array - collection of elements
		//multidimensional array - collection of arrays
		
		return new Object[][]  {{"3455","fvsfv"},{"54334","vedfvr"},{"343434","fdrfdf"}};
			
	}

}
