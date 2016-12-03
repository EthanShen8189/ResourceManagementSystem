package concordia.soen387.project.Model;


public class Resource {

	private int id;
	private int available;
	private String description;
	private int movable;
	private String name;
	
	public Resource(int id, int available, String description,
			int movable, String name){
		this.id = id;
		this.available = available;
		this.description = description;
		this.movable = movable;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAvailable() {
		return available;
	}

	public void setAvailable(int available) {
		this.available = available;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getMovable() {
		return movable;
	}

	public void setMovable(int movable) {
		this.movable = movable;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
