package concordia.soen387.project.Model;


public class Department {

	private int id;
	private String name;

	public Department(int id, String name){
		this.id = id;
		this.name = name;
	}

	public Department() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
