package concordia.soen387.project.Model;


public class ComputerOs {

	private int id;
	private String license;
	private int os_type;
	private String version;
	
	public ComputerOs(int id, String license, int os_type, String version){
		this.id = id;
		this.license = license;
		this.os_type = os_type;
		this.version = version;
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

	public int getOs_type() {
		return os_type;
	}

	public void setOs_type(int os_type) {
		this.os_type = os_type;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}
	
	
}
