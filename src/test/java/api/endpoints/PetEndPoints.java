package api.endpoints;

import static io.restassured.RestAssured.given;
import api.payload.Pets;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PetEndPoints {

	public static Response createPet(Pets payload)
	{
		Response res=given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(payload)
		.when()
			.post(Routes.pet_post_url);
		
		return res;
	}
	
	public static Response getPetById(long petId)
	{
		Response res=given()
			.pathParam("id", petId)
		.when()
			.get(Routes.pet_get_url);
		
		return res;
	}
	
	public static Response updatePetdetails(long petId, String payload)
	{
		Response res=given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(payload)
				.pathParam("id", petId)
			.when()
				.post(Routes.pet_put_url);
			
			return res;
	}
	
	public static Response deletePetById(long petId)
	{
		Response res=given()
				.pathParam("id", petId)
			.when()
				.get(Routes.pet_delete_url);
			
			return res;
	}
	
	public static Response getPetdetailsByStatus(String petStatus)
	{
		Response res=given()
				.pathParam("status", petStatus)
			.when()
				.get(Routes.pet_get_Status_url);
			
			return res;
	}
}
