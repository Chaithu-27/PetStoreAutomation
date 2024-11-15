package api.endpoints;

import static io.restassured.RestAssured.*;
import static  io.restassured.matcher.RestAssuredMatchers.*;
import  static org.hamcrest.Matchers.*;

import api.payload.Store;
import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class StoreEndPoints 
{
	public static Response placeAnOrderForPet(Store payload)
	{
		Response id=given()
		  .contentType(ContentType.JSON)
		  .body(payload)
		  .accept(ContentType.JSON)
		
		.when()
		   .post(Routes.post_url);
		return id;	
	}
	
	public static Response getAnOrderById(int id)
	{
		Response res=given()
				.pathParam("orderid", id)	
		
		.when()
		   .get(Routes.get_url);
		
		return res;
	}
	
	public static Response deleteOrderById(int id)
	{
		Response res=given()
				 .pathParam("orderid", id)
			
		.when()
		   .delete(Routes.delete_url);
		
		return res;
	}

}
