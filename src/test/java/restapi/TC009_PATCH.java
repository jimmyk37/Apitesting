package restapi;

import org.json.simple.JSONObject;
import org.junit.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC009_PATCH {
	
	@Test (groups="PATCH")
	void update_patch() {
		
		RestAssured.baseURI="https://reqres.in/api/users";
		
		RequestSpecification httprequest=RestAssured.given();
		
		JSONObject requestparam=new JSONObject();
		requestparam.put("name", "morpheus");
		requestparam.put("job", "Marksman");
		
		httprequest.header("Content-Type","application/json");
		httprequest.body(requestparam.toJSONString());
		
		
		Response response=httprequest.request(Method.PATCH,"/2");
		
		String body=response.getBody().asString();
		int statuscode=response.getStatusCode();
		
		Assert.assertEquals(body.contains("Marksman"), true);
		Assert.assertEquals(statuscode, 200);
		
		
		
	}

}
