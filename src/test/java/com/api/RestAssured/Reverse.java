package com.api.RestAssured;

public class Reverse {
	
	
	public static void ReverseStringCharacter(String str) {
		String[] newStr = str.split(" ");
		
		String revStr = "";
		
		for(int i=newStr.length-1;i>=0;i--) {
			revStr = revStr + newStr[i] + " ";
			
					
			
		}
		 System.out.println(revStr);
		
		
	}
	
	public static void main(String[] args) {
		String str = "My name is khan";
		ReverseStringCharacter(str);
		
	}

}
