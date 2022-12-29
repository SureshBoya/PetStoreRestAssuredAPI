package api.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.PetEndPoints;
import api.payload.Pets;
import io.restassured.response.Response;

public class PetsTest {

	Faker faker;
	Pets payload;
	
	@BeforeClass
	void petsdata()
	{
		faker=new Faker();
		payload=new Pets();
		
		payload.setId(faker.idNumber().hashCode());
		payload.setCateg_name("doggie");
		payload.setName(faker.name().username());
		payload.setStatus("available");
		payload.setPending_status("pending");
		payload.setSold_status("sold");
	}
	
	@Test(priority = 1)
	void createpet()
	{
		Response res=PetEndPoints.createPet(payload);
		res.then().log().body();
		Assert.assertEquals(res.getStatusCode(), 200);
	}
	
	@Test(priority = 2)
	void getpetByID()
	{
		Response res=PetEndPoints.getPetById(this.payload.getId());
		res.then().log().body();
		Assert.assertEquals(res.getStatusCode(), 200);
	}
	
	@Test(priority = 3)
	void updatePetDetails()
	{
		payload.setName(faker.name().username());
		
		Response res=PetEndPoints.updatePetdetails(this.payload.getId(), this.payload.getName());
		res.then().log().all();
		Assert.assertEquals(res.getStatusCode(), 200);
		
		Response res1=PetEndPoints.getPetById(this.payload.getId());
		//res1.then().log().all();
		Assert.assertEquals(res.getStatusCode(), 200);
	}
	
	@Test(priority = 4)
	void getPetsByStatus()
	{
		Response res=PetEndPoints.getPetdetailsByStatus(this.payload.getStatus());
		//res.then().log().all();
	}
}
