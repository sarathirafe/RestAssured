package com.API_Automation;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import java.io.File;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.restassured.module.jsv.JsonSchemaValidator;

public class schema_validation_test {

	@BeforeTest	
	public void setBaseURI(){
		baseURI = "https://reqres.in/api";
	}
	
	@Test
	public void validateSchema(){
			 File fs = new File("C:\\Users\\ADMIN\\eclipse-workspace\\test1\\src\\test\\resources\\Schema.json");
			 given().get("/users?page=2").then().body(JsonSchemaValidator.matchesJsonSchema(fs));
	}
}
