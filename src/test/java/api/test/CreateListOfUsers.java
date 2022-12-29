package api.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndPoints;
import api.payload.User;
import io.restassured.response.Response;

public class CreateListOfUsers {
	Faker faker;
	User payload;
	
	@Test
	void setUpData()
	{
		for(int i=1; i<=5; i++)
		{
			faker=new Faker();
			payload=new User();
			
			payload.setId(faker.idNumber().hashCode());
			payload.setUsername(faker.name().username());
			payload.setFirstName(faker.name().firstName());
			payload.setLastName(faker.name().lastName());
			payload.setEmail(faker.internet().emailAddress());
			payload.setPassword(faker.internet().password());
			payload.setPhone(faker.phoneNumber().cellPhone());
			
			Response res=UserEndPoints.createListOfUserWithGivenArray(payload);
			res.then().log().all();
			Assert.assertEquals(res.getStatusCode(), 200);
			
			//get the user details
			Response resfromGetReq=UserEndPoints.getUser(this.payload.getUsername());
			resfromGetReq.then().log().all();
			Assert.assertEquals(resfromGetReq.getStatusCode(), 200);
		}
	}
	
	//@Test(priority = 1)
	void test_CreateListOfUserWithGivenArray()
	{
			Response res=UserEndPoints.createListOfUserWithGivenArray(payload);
			res.then().log().all();
			Assert.assertEquals(res.getStatusCode(), 200);
			
			//get the user details
			Response resfromGetReq=UserEndPoints.getUser(this.payload.getUsername());
			resfromGetReq.then().log().all();
			Assert.assertEquals(resfromGetReq.getStatusCode(), 200);	
	}
}
