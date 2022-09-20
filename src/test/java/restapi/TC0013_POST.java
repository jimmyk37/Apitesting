package restapi;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC0013_POST {
	
@Test(enabled=true, groups="POST")
	
	void loginsuccess() {
		
		RestAssured.baseURI="https://reqres.in/api/login";
		
		RequestSpecification httprequest=RestAssured.given();
		JSONObject requestparam= new JSONObject();
		
		
		requestparam.put("email", "eve.holt@reqres.in");
		requestparam.put("password", "cityslicka");
		
		httprequest.header("Content-Type","application/json");
		httprequest.body(requestparam.toJSONString());
		
		Response response=httprequest.request(Method.POST);
		int responsecode=response.getStatusCode();
	
		Assert.assertEquals(responsecode, 200);
		
	}
	

}
