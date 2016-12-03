package concordia.soen387.project.Model;

public class Computer {
	
	private int id;
	private String machine_type;
	private String hostname;
	private int operating_system_id;
	private String manufacturer;
	private String model;
	private int wireless_networking;
	private int wired_networking;
	private int speakers;
	private int keyboard;
	private int mouse;
	private int hdmi_output;
	private int dvi_output;
	private int vga_output;
	
	public Computer(int id, String machine_type, String hostname,
			int operating_system_id, String manufacturer,
			String model, int wireless_networking, int wired_networking,
			int speakers, int keyboard, int mouse, int hdmi_output,
			int dvi_output, int vga_output){
		this.id = id;
		this.machine_type = machine_type;
		this.hostname = hostname;
		this.operating_system_id = operating_system_id;
		this.manufacturer = manufacturer;
		this.model = model;
		this.wireless_networking = wireless_networking;
		this.wired_networking = wired_networking;
		this.speakers = speakers;
		this.keyboard = keyboard;
		this.mouse = mouse;
		this.hdmi_output = hdmi_output;
		this.dvi_output = dvi_output;
		this.vga_output = vga_output;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMachine_type() {
		return machine_type;
	}

	public void setMachine_type(String machine_type) {
		this.machine_type = machine_type;
	}

	public String getHostname() {
		return hostname;
	}

	public void setHostname(String hostname) {
		this.hostname = hostname;
	}

	public int getOperating_system_id() {
		return operating_system_id;
	}

	public void setOperating_system_id(int operating_system_id) {
		this.operating_system_id = operating_system_id;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getWireless_networking() {
		return wireless_networking;
	}

	public void setWireless_networking(int wireless_networking) {
		this.wireless_networking = wireless_networking;
	}

	public int getWired_networking() {
		return wired_networking;
	}

	public void setWired_networking(int wired_networking) {
		this.wired_networking = wired_networking;
	}

	public int getSpeakers() {
		return speakers;
	}

	public void setSpeakers(int speakers) {
		this.speakers = speakers;
	}

	public int getKeyboard() {
		return keyboard;
	}

	public void setKeyboard(int keyboard) {
		this.keyboard = keyboard;
	}

	public int getMouse() {
		return mouse;
	}

	public void setMouse(int mouse) {
		this.mouse = mouse;
	}

	public int getHdmi_output() {
		return hdmi_output;
	}

	public void setHdmi_output(int hdmi_output) {
		this.hdmi_output = hdmi_output;
	}

	public int getDvi_output() {
		return dvi_output;
	}

	public void setDvi_output(int dvi_output) {
		this.dvi_output = dvi_output;
	}

	public int getVga_output() {
		return vga_output;
	}

	public void setVga_output(int vga_output) {
		this.vga_output = vga_output;
	}
	
	
	
	
	
	



	
	
}
