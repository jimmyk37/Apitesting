package restapi;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC002_GET {
	
	@Test(priority=2)
	void getsingleuser() {
		
		RestAssured.baseURI="https://reqres.in/api";
		
		RequestSpecification httprequest=RestAssured.given();
		
		Response response=httprequest.request(Method.GET,"/users/3");
		
		String body=response.getBody().asString();
		int responsecode=response.getStatusCode();
		System.out.println("Response body is :"+body);
		System.out.println("status code is :"+responsecode);
		
		Assert.assertEquals(responsecode, 200);
		
	}

}
