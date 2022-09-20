package restapi;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC003_GET {
	
	@Test(enabled=true, groups="GET")
	void usernotfound() {
		
		RestAssured.baseURI="https://reqres.in/api";
		
		RequestSpecification httprequest=RestAssured.given();
		
		Response respose=httprequest.request(Method.GET, "/users/23");
		
		String responcebody=respose.getBody().asString();
		int responsecode=respose.getStatusCode();
		System.out.println("Response body is :"+responcebody);
		System.out.println("status code is :"+responsecode);
		
		Assert.assertEquals(responsecode, 404);				
	}

}
