package restapi;

import org.json.simple.JSONObject;
import org.junit.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC008_PUT {
	
@Test(groups="PUT")

void update_put() {
	
	RestAssured.baseURI="https://reqres.in/api/users";
	
	RequestSpecification httprequest=RestAssured.given();
	
	JSONObject requestparam=new JSONObject();
	requestparam.put("name", "morpheus");
	requestparam.put("job", "zion resident");
	
	httprequest.header("Content-Type","application/json");
	httprequest.body(requestparam.toJSONString());
	
	
	Response response=httprequest.request(Method.PUT,"/2");
	
	String body=response.getBody().asString();
	int statuscode=response.getStatusCode();
	
	Assert.assertEquals(body.contains("updatedAt"), true);
	Assert.assertEquals(statuscode, 200);
	
	
	
}

}
