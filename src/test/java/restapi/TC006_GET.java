package restapi;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC006_GET {
	
@Test(groups="GET")
void singlenotfound() {
	
	RestAssured.baseURI="https://reqres.in/api/unknown";
	
	RequestSpecification httprequest=RestAssured.given();
	
	Response response=httprequest.request(Method.GET,"/23");
	
	int statuscode=response.getStatusCode();
	Assert.assertEquals(statuscode, 404);
}

}
