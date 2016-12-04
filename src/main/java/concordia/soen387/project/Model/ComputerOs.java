package concordia.soen387.project.Model;


public class ComputerOs {

	private int id;
	private String license;
	private String os_type;
	private int version;
	
	public ComputerOs(int id, String license, String os_type, int version){
		this.id = id;
		this.license = license;
		this.os_type = os_type;
		this.version = version;
	}

	public ComputerOs() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLicense() {
		return license;
	}

	public void setLicense(String license) {
		this.license = license;
	}

	public String getOs_type() {
		return os_type;
	}

	public void setOs_type(String os_type) {
		this.os_type = os_type;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}
	
	
}
