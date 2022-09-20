package restapi;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC004_GET {
	
	@Test
	
	void getlist() {
		
		RestAssured.baseURI="https://reqres.in/api/unknown";
		
		RequestSpecification httprequest=RestAssured.given();
		
		Response response=httprequest.request(Method.GET);
		 String outresp=response.getBody().asString();
		 int total=response.jsonPath().get("total");
		 
		 int statuscode=response.getStatusCode();
		 Assert.assertEquals(statuscode, 200);
		 Assert.assertEquals(total, 12);
		
	}

}
