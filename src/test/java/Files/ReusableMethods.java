package Files;

import io.restassured.path.json.JsonPath;

public class ReusableMethods {

		/*
		 * Objective: All Generic reusable Utils to be used in test
		 * Author : Vishesh Bakshi
		 */
		
		public static JsonPath rawToJson(String response) {
			JsonPath js = new JsonPath(response);
			return js;
		}
		

	

}
