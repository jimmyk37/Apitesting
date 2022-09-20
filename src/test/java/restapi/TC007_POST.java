package restapi;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC007_POST {
	
	@Test(enabled=true , groups="POST")
	void createuser() {
		
		RestAssured.baseURI="https://reqres.in/api";
		
		RequestSpecification httprequest=RestAssured.given();
		
		
		
		JSONObject requestparam=new JSONObject();
		requestparam.put("name", "morpheus");
		requestparam.put("job", "leader");
		
		httprequest.header("Content-Type","application/json");
		
		httprequest.body(requestparam.toJSONString());
		
		Response response=httprequest.request(Method.POST,"/users");
		
		String body=response.getBody().asString();
		int statuscode=response.getStatusCode();
		System.out.println("Response Body is: "+body);
		System.out.println("Status code is: "+statuscode);
		
		Assert.assertEquals(statuscode, 201);
		
		String name=response.jsonPath().get("name");
		Assert.assertEquals(name, "morpheus");		
		
	}
	
}


