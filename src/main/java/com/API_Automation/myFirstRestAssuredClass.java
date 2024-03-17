

package com.API_Automation;

import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

import  static io.restassured.RestAssured.*;

public class myFirstRestAssuredClass {
	
	
	//@Test	
	public void getResponseStatus(){
		get("https://reqres.in/api/users?page=2").then().log().all();
		}
	
	@Test
	public static void getComponents(){
		RestAssured.baseURI = "https://reqres.in/api";
		//System.out.println(get("/users?page=2").getStatusLine());//Returns status line of the response Eg : Http/1.1 200 ok
		//System.out.println(get("/users?page=2").getStatusCode()); // Returns just the status code 200 from above 
		//System.out.println(get("/users?page=2").getHeader("Content-Type")); // returns type of content
		//System.out.println(get("/users?page=2").getBody().asPrettyString()); // Formatted body
		//get("/users?page=2").then().log().status(); // THis is equal to sysout as it prints output in console. =getStatusLine
		//get("/users?page=2").then().statusCode(HttpStatus.SC_FORBIDDEN);
		//System.out.println(get("/users?page=2").asString());
		System.out.println("________________________________________");
		//System.out.println(get("/users?page=2").getBody().asString());
		System.out.println("________________________________________");
		//System.out.println(get("/users?page=2").body().asString());
		System.out.println("________________________________________");
		given().get("/users").then().log().all();
}
}
