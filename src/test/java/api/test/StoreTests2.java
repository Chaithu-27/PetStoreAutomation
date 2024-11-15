package api.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.StoreEndPoints2;
import api.payload.Store;
import io.restassured.response.Response;

public class StoreTests2 
{
	Faker faker;
	Store storePayload;
	
	public Logger logger;
	
	
	@BeforeClass
	public void setUp()
	{
		faker= new Faker();
		storePayload=new Store();
		
		storePayload.setId(faker.number().hashCode());
		storePayload.setPetId(faker.idNumber().hashCode());
		storePayload.setQuantity(faker.number().numberBetween(2, 10));
		
		//logs
		logger=LogManager.getLogger(this.getClass());	
	}
	
	@Test(priority=1)
	public void testPostStore()
	{
		logger.info("***************Placing an order for Pet***********");
		
		Response response=StoreEndPoints2.placeAnOrderForPet(storePayload);
	    response.then().log().all();
	   
		Assert.assertEquals(response.getStatusCode(), 200);
		
		System.out.println("The generated id is" +  this.storePayload.getId());
		
		logger.info("************Order has been placed for pet******");
		
	}
	

	@Test(priority=2)
	public void testGetStore()
	{
		logger.info("*************Get the pet info by Id**********");
		
		Response response=StoreEndPoints2.getAnOrderById(this.storePayload.getId());
		response.then().log().all();
		
		//System.out.println("The generated id is"+);
		Assert.assertEquals(response.getStatusCode(), 200);
		logger.info("**********Pet info has been displayed******");
		
	}
	
	@Test(priority=3)
	public void testDeleteStore()
	{
		logger.info("***********Deleting a pet by id*********");
		Response response=StoreEndPoints2.deleteOrderById(this.storePayload.getId());
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	
	
	
	
	
	
	
}
