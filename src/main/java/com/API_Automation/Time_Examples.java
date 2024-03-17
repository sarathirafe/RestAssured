
package com.API_Automation;

import org.testng.annotations.Test;


import  static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class Time_Examples {
	@Test
	public static void getComponents(){
		baseURI = "https://reqres.in/api";
		
		  System.out.println(get("/users?page=2").getTime());
		  System.out.println(get("/users?page=2").getTimeIn(TimeUnit.MILLISECONDS));
		  System.out.println(get("/users?page=2").getTimeIn(TimeUnit.MICROSECONDS));
		 System.out.println("---------");
		
		 System.out.println(get("/users?page=2").time());
		System.out.println(get("/users?page=2").timeIn(TimeUnit.MILLISECONDS));
		System.out.println(get("/users?page=2").timeIn(TimeUnit.MICROSECONDS));
}
}

