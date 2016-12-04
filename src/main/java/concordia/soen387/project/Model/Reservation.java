package concordia.soen387.project.Model;

/**
 * Created by EthanShen on 2016-12-02.
 */
public class Reservation {

	private int id;
	private String start_date_time;
	private String end_date_time;
	private String user_username;
	
	public Reservation(int id, String start_date_time, 
			String end_date_time, String user_username){
		
		this.id = id;
		this.start_date_time = start_date_time;
		this.end_date_time = end_date_time;
		this.user_username = user_username;
	}

	public Reservation() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStart_date_time() {
		return start_date_time;
	}

	public void setStart_date_time(String start_date_time) {
		this.start_date_time = start_date_time;
	}

	public String getEnd_date_time() {
		return end_date_time;
	}

	public void setEnd_date_time(String end_date_time) {
		this.end_date_time = end_date_time;
	}

	public String getUser_username() {
		return user_username;
	}

	public void setUser_username(String user_username) {
		this.user_username = user_username;
	}
	
	
	
}