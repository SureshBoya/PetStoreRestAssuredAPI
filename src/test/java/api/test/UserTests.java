package api.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndPoints;
import api.payload.User;
import io.restassured.response.Response;

public class UserTests {
	
	Faker faker;
	User payload;
	
	@BeforeClass
	void setUpData()
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
	
	@Test(priority = 1)
	void test_CreateUser()
	{
		Response res=UserEndPoints.createUser(payload);
		res.then().log().all();
		Assert.assertEquals(res.getStatusCode(), 200);	
	}
	
	//@Test(priority = 2)
	void test_getUser()
	{
		Response res=UserEndPoints.getUser(this.payload.getUsername());
		res.then().log().all();
		Assert.assertEquals(res.getStatusCode(), 200);
	}
	
	//@Test(priority = 3)
	void test_UpdateUser()
	{
		//update user details
		payload.setFirstName(faker.name().firstName());
		payload.setLastName(faker.name().lastName());
		payload.setEmail(faker.internet().emailAddress());
		
		Response res=UserEndPoints.updateUser(this.payload.getUsername(), payload);
		res.then().log().all();
		Assert.assertEquals(res.getStatusCode(), 200);	
		
		//comparing the details
		Response resAfterUpdate=UserEndPoints.getUser(this.payload.getUsername());
		res.then().log().all();
		Assert.assertEquals(resAfterUpdate.getStatusCode(), 200);
	}
	
	//@Test(priority = 4)
	void test_DeleteUser()
	{
		Response res=UserEndPoints.deleteUser(this.payload.getUsername());
		res.then().log().all();
		Assert.assertEquals(res.getStatusCode(), 200);
	}	
}
