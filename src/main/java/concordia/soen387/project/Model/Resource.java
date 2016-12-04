package concordia.soen387.project.Model;

public class Resource {

	private int id;
	private boolean available;
	private String description;
	private boolean movable;
	private String name;
	private int resourceUID;

	public Resource(){}

	public Resource(int id, boolean available, String description,
					boolean movable, String name){
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

	public boolean getAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean getMovable() {
		return movable;
	}

	public void setMovable(boolean movable) {
		this.movable = movable;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getResourceUID() {
		return resourceUID;
	}

	public void setResourceUID(int resourceUID) {
		this.resourceUID = resourceUID;
	}
	
	
}
