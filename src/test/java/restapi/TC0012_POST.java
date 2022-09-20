package restapi;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC0012_POST {
	
@Test(enabled=true, groups="POST" )
	
	void registerunsuccess() {
		
		RestAssured.baseURI="https://reqres.in/api/register";
				
		RequestSpecification httprequest=RestAssured.given();
		
		JSONObject requestparam=new JSONObject();
		requestparam.put("email", "sydney@fife");
		
		httprequest.header("Content-Type","application/json");
		httprequest.body(requestparam.toJSONString());
		
		Response response=httprequest.request(Method.POST);
		String responsebody=response.getBody().asString();
		int statuscode=response.getStatusCode();
		System.out.println(statuscode);
		System.out.println(responsebody);
		
		
	    Assert.assertEquals(responsebody.contains("Missing password"), true);
		
		Assert.assertEquals(statuscode, 400);
		
	}

}
