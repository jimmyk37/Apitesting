package restapi;


import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;

import io.restassured.specification.RequestSpecification;

public class TC001_GET {
	
	@Test(enabled=true, groups="GET")
	void getlistuser() {
		
		RestAssured.baseURI="https://reqres.in/api";
		
		RequestSpecification httprequest=RestAssured.given();
		
		Response response=httprequest.request(Method.GET, "/users?page=2");
		
	
		
		String body=response.getBody().asString();
		int statuscode=response.getStatusCode();
		System.out.println("Response Body is: "+body);
		System.out.println("Status code is: "+statuscode);
		
		Assert.assertEquals(statuscode, 200);		
		
	}
	
	
	
	
	
	
	}



