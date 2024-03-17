package com.API_Automation;

import org.json.simple.JSONObject;
import org.mozilla.javascript.annotations.JSSetter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class LocalJsonServer {
	
	@BeforeTest
	public void before_test() {
		baseURI="http://localhost:3000";
	}
	
	@Test
	public void get_test() {
		baseURI="http://localhost:3000";
		get("/user").then().statusCode(200).log().all();
	}
	
	//@Test
	public void post_test() {
		JSONObject js = new JSONObject();
		js.put("name", "Rajalakshmi");
		given().
		contentType(ContentType.JSON).
		accept(ContentType.JSON).
		body(js.toJSONString()).
		when().
		post("/user").
		then().
		statusCode(201);
	}
	
	//@Test
	public void put_test() {
		JSONObject js = new JSONObject();
		js.put("name", "partha");
		js.put("sub id", 2);
		given().
		contentType(ContentType.JSON).
		accept(ContentType.JSON).
		body(js.toJSONString()).
		when().
		put("/user/1").
		then().
		statusCode(200);
	}
	
	//@Test
	public void patch_test() {
		JSONObject js = new JSONObject();
		js.put("name", "patchTest");
		given().
		contentType(ContentType.JSON).
		accept(ContentType.JSON).
		body(js.toJSONString()).
		when().
		patch("/user/1").
		then().
		statusCode(200);
	}
	
	//@Test
	public void delete_test() {
		JSONObject js = new JSONObject();
		given().
		delete("/user/1").
		then().
		statusCode(404);
	}
	
	
}
