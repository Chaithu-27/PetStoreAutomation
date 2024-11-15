package api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.StoreEndPoints;
import api.payload.Store;
import api.utilities.DataProvidersStore;
import io.restassured.response.Response;

public class StoreDDTests
{
	@Test(priority=1,dataProvider="Data1",dataProviderClass=DataProvidersStore.class)
	public void testPostStore(String id,String petId,String quantity)
	{
		Store storePayload=new Store();
		
		storePayload.setId(Integer.parseInt(id));
		storePayload.setPetId(Integer.parseInt(petId));
		storePayload.setQuantity(Integer.parseInt(quantity));
		
		Response response=StoreEndPoints.placeAnOrderForPet(storePayload);
		Assert.assertEquals(response.getStatusCode(), 200);
		
	}
	
	@Test(priority=2,dataProvider="OrderId",dataProviderClass=DataProvidersStore.class)
	public void testDeleteStoreByOrderId(String orderId)
	{
		Response response=StoreEndPoints.deleteOrderById(Integer.parseInt(orderId));
		Assert.assertEquals(response.getStatusCode(), 200);
	}

}
