package api.endpoints;

import static io.restassured.RestAssured.*;
import static  io.restassured.matcher.RestAssuredMatchers.*;
import  static org.hamcrest.Matchers.*;

import java.util.ResourceBundle;

import api.payload.Store;
import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class StoreEndPoints2 
{
	//method created for getting URL's from properties file
		static ResourceBundle getURL()
		{
			ResourceBundle routes=ResourceBundle.getBundle("routes");//Load properties file//"routes" name of the properties file,no need to mention the complete file name
			return routes;
		}
		
	
	public static Response placeAnOrderForPet(Store payload)
	{
		 String post_url=getURL().getString("post_url1");
		
		Response id=given()
		  .contentType(ContentType.JSON)
		  .body(payload)
		  .accept(ContentType.JSON)
		
		.when()
		   .post(post_url);
		return id;	
	}
	
	public static Response getAnOrderById(int id)
	{
		String get_url=getURL().getString("get_url1");
		
		Response res=given()
				.pathParam("orderid", id)	
		
		.when()
		   .get(get_url);
		
		return res;
	}
	
	public static Response deleteOrderById(int id)
	{
		String delete_url=getURL().getString("delete_url1");
		
		Response res=given()
				 .pathParam("orderid", id)
			
		.when()
		   .delete(delete_url);
		
		return res;
	}

}
