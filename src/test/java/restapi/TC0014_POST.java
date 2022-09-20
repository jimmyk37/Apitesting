package restapi;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class TC0014_POST {
	
	@Test(groups="POST")
	
	void login_unsuccess() {
		
		RestAssured.baseURI="https://reqres.in/api/login";
		
		RequestSpecification httprequest=RestAssured.given();
		
		JSONObject requestparam=new JSONObject();
		requestparam.put("email", "peter@klaven");
		
		httprequest.header("Content-Type","application/json");
		httprequest.body(requestparam.toJSONString());
		
		Response response=httprequest.request(Method.POST);
		
		int statuscode=response.getStatusCode();
		String statusbody=response.getBody().asString();
		
		
		Assert.assertEquals(statusbody.contains("Missing password"), true);
		Assert.assertEquals(statuscode, 400);
		
	}

}
