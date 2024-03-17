package com.API_Automation;

import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.get;
import static org.hamcrest.Matchers.*;

import org.hamcrest.Matchers;
import org.hamcrest.core.Is;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class ReadBody_Basics 
{


@BeforeTest
public  void runfirst()
    {
	baseURI = "https://reqres.in/api";
    }
	
@Test
public static void readBody()
    {
	get("/users?page=2").then().statusCode(200).body("data[0].id",Is.is(7));
	get("/users?page=2").then().statusCode(200).body("data[0].id",Matchers.equalTo(7));
	System.out.println("from readBody");
    }

@Test
public static void readBody1()
    {
	given().get("/users?page=2").
	then().
	statusCode(200).
	body("data[0].id",equalTo(7)).
	body("data.id", hasItems(7,8,9,10,11,12));
	System.out.println("From readBody1");
    }

@Test
public void validationfails1() {
	get("/users?page=2").then().statusCode(200).body("data[0].id", equalTo(7)).log().all();
	System.out.println("From validationfails1");
	}

@Test
public void givenexample() {
	System.out.println(given().get("/users?page=2").getBody().asString());
	System.out.println("From givenexample");
	}


@Test
public void validationfails() {
	get("/users?page=2").then().body("data[0].id",Matchers.equalTo(8)).log().ifValidationFails();
	
}
}
