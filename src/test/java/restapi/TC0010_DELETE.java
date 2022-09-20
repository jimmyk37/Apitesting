package restapi;

import org.junit.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC0010_DELETE {
	
	@Test(groups="DELETE")
	
	void delete_user() {
		
		RestAssured.baseURI="https://reqres.in/api/users";
		
		RequestSpecification httprequest=RestAssured.given();
		
		Response response=httprequest.request(Method.DELETE,"/2");
		
		int statuscode=response.getStatusCode();
		
		Assert.assertEquals(statuscode, 204);
	}

}
