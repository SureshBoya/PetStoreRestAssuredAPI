package api.endpoints;

import static io.restassured.RestAssured.given;

import api.payload.Store;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class StoreEndPoints {
	
	public static Response placeOrder(Store storePayload)
	{
		Response res=given()
			.contentType(ContentType.JSON)
			//.accept(ContentType.JSON)
			.body(storePayload)
		.when()
			.post(Routes.store_Post_url);
		
		return res;
	}
	public static Response findPurchaseOrderByID(int orderID)
	{
		Response res=given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.pathParam("id", orderID)
		.when()
			.get(Routes.store_get_url);
		return res;
	}
	public static Response returnPetInventoriesByStatus()
	{
		Response res=given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
		.when()
			.get(Routes.store_getByStaus_url);
		return res;
	}
	public static Response deletePurchaseOrderByID(int orderID)
	{
		Response res=given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.pathParam("id", orderID)
		.when()
			.get(Routes.store_delete_url);
		return res;
	}
	
	
}
