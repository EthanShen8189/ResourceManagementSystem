package concordia.soen387.project.Model;


public class ReservationResources {
	
	private int reservation_id;
	private int resource_id;
	
	public ReservationResources(int reservation_id, int resource_id){
		
		this.reservation_id = reservation_id;
		this.resource_id = resource_id;
	}

	public ReservationResources() {
		// TODO Auto-generated constructor stub
	}

	public int getReservation_id() {
		return reservation_id;
	}

	public void setReservation_id(int reservation_id) {
		this.reservation_id = reservation_id;
	}

	public int getResource_id() {
		return resource_id;
	}

	public void setResource_id(int resource_id) {
		this.resource_id = resource_id;
	}
	
	

}
