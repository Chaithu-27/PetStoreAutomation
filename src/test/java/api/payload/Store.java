package api.payload;

public class Store
{
	int id=0;
	int petId;
	int quantity;
	String shipDate="2024-11-11T16:13:55.793Z";
	String status="placed";
	boolean complete=true;


	
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public int getPetId() {
			return petId;
		}
		public void setPetId(int petId) {
			this.petId = petId;
		}
		public int getQuantity() {
			return quantity;
		}
		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}
		public String getShipDate() {
			return shipDate;
		}
		public void setShipDate(String shipdate) {
			this.shipDate = shipdate;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		public boolean isComplete() {
			return complete;
		}
		public void setComplete(boolean complete) {
			this.complete = complete;
		}
		
	}



