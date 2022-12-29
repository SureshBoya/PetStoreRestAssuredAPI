package api.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.StoreEndPoints;
import api.payload.Store;
import io.restassured.response.Response;

public class StoreTests {
	
	Faker storefaker;
	Store storePayload;
	@BeforeClass
	void payloadData()
	{
		storefaker=new Faker();
		storePayload=new Store();
		
		storePayload.setId(storefaker.idNumber().hashCode());
		storePayload.setPetId(storefaker.number().numberBetween(1, 999));
		storePayload.setQuantity(storefaker.number().randomDigit());
		storePayload.setShipDate(storefaker.date().toString());
		storePayload.setComplete(true);
		storePayload.setStatus("placed");
	}
	@Test(priority = 1)
	public void placeOrderForpet()
	{
		Response res=StoreEndPoints.placeOrder(storePayload);
		res.then().log().all();
		Assert.assertEquals(res.getStatusCode(), 200);
	}
	
	@Test(priority = 2)
	public void findPurchaseOrderByID()
	{
		Response res=StoreEndPoints.findPurchaseOrderByID(this.storePayload.getId());
		res.then().log().all();
		Assert.assertEquals(res.getStatusCode(), 200);
	}
	
	@Test(priority = 3)
	public void returnPetsByID()
	{
		Response res=StoreEndPoints.returnPetInventoriesByStatus();
		res.then().log().all();
		Assert.assertEquals(res.getStatusCode(), 200);
	}
	
	@Test(priority = 4)
	public void deleteOrderByID()
	{
		Response res=StoreEndPoints.deletePurchaseOrderByID(this.storePayload.getId());
		res.then().log().all();
		Assert.assertEquals(res.getStatusCode(), 200);
	}
}
