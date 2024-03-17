
package com.API_Automation;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;


import  static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class Time_Assertion_Examples {
	@Test
	public static void getComponents(){
		baseURI = "https://reqres.in/api";
		System.out.println(get("/users?page=2").then().time(Matchers.both(Matchers.lessThanOrEqualTo(4000L)).and(Matchers.greaterThanOrEqualTo(1000L))));
		System.out.println(get("/users?page=2").then().time(Matchers.lessThan(4000L)));	
		System.out.println(get("/users?page=2").then().time(Matchers.lessThan(4L),TimeUnit.SECONDS));	
		System.out.println(get("/users?page=2").then().time(Matchers.greaterThan(1L),TimeUnit.SECONDS));
}
}

