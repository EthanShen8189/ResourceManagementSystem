package concordia.soen387.project.Model;



public class UserRoles {
	
	private String user_username;
	private int roles_id;
	
	public UserRoles(String user_username, int roles_id){
		this.user_username = user_username;
		this.roles_id = roles_id;
	}

	public UserRoles() {
		// TODO Auto-generated constructor stub
	}

	public String getUser_username() {
		return user_username;
	}

	public void setUser_username(String user_username) {
		this.user_username = user_username;
	}

	public int getRoles_id() {
		return roles_id;
	}

	public void setRoles_id(int roles_id) {
		this.roles_id = roles_id;
	}
	
	

}
