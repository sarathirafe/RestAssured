package com.API_Automation;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.hamcrest.Matchers;
import org.hamcrest.core.Is;
import org.json.simple.JSONObject;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class post_test {
	
	@BeforeTest
	public  void runfirst()
	    {
		baseURI = "https://reqres.in";
	    }
	
	@Test
	public void post1() {
		given().
		contentType(ContentType.JSON).accept(ContentType.JSON);
		  JSONObject js = new JSONObject(); 
		  js.put("name", "partha");
		  js.put("job", "Software engg");
		  given().body(js.toJSONString()).post("/api/users").then().statusCode(201);
	}
}
