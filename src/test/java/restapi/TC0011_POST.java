package restapi;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC0011_POST {
	
 @Test(enabled=true, groups="GET")
	
	void registeruser() {
		
		RestAssured.baseURI="https://reqres.in/api";
		
		RequestSpecification httprequest=RestAssured.given();
		JSONObject requestparam=new JSONObject();
		requestparam.put("email", "eve.holt@reqres.in");
		requestparam.put("password", "pistol");
		
		httprequest.header("Content-Type","application/json");
		httprequest.body(requestparam.toJSONString());
		
		Response response=httprequest.request(Method.POST,"/register");
		
		String responsebody=response.getBody().asString();
		int statuscode=response.getStatusCode();
		String token=response.jsonPath().get("token");
		System.out.println(token);
		
		System.out.println("Response Body is: "+responsebody);
		System.out.println("Status code is: "+statuscode);
		
		Assert.assertEquals(statuscode, 200);		
				
	}

}
