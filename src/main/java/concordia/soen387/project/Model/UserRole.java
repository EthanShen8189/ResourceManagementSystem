package concordia.soen387.project.Model;


public class UserRole {
	
	private int id;
	private String user_role_human_readable;
	
	public UserRole(int id, String user_role_human_readable){
		this.id = id;
		this.user_role_human_readable = user_role_human_readable;
	}

	public UserRole() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUser_role_human_readable() {
		return user_role_human_readable;
	}

	public void setUser_role_human_readable(String user_role_human_readable) {
		this.user_role_human_readable = user_role_human_readable;
	}
	
	

}
