package restapi;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class TC005_GET {
	
	@Test(groups="GET")
	
	void singleresource() {
		
		RestAssured.baseURI="https://reqres.in/api/unknown";
		
		RequestSpecification httprequest=RestAssured.given();
		
		Response response=httprequest.request(Method.GET,"/2");
		
		String statusbody=response.getBody().asString();
		int statuscode=response.getStatusCode();
		
		Assert.assertEquals(statusbody.contains("fuchsia rose"), true);
		Assert.assertEquals(statuscode, 200);
	
		
		
				
	}

}
