package concordia.soen387.project.Model;

public class Computer {
	
	private int id;
	private String machine_type;
	private String hostname;
	private long operating_system_id;
	private String manufacturer;
	private String model;
	private boolean wireless_networking;
	private boolean wired_networking;
	private boolean speakers;
	private boolean keyboard;
	private boolean mouse;
	private boolean hdmi_output;
	private boolean dvi_output;
	private boolean vga_output;

	public Computer(){}

	public Computer(int id, String machine_type, String hostname,
					long operating_system_id, String manufacturer,
			String model, boolean wireless_networking, boolean wired_networking,
					boolean speakers, boolean keyboard, boolean mouse, boolean hdmi_output,
					boolean dvi_output, boolean vga_output){
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

	public long getOperating_system_id() {
		return operating_system_id;
	}

	public void setOperating_system_id(long operating_system_id) {
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

	public boolean getWireless_networking() {
		return wireless_networking;
	}

	public void setWireless_networking(boolean wireless_networking) {
		this.wireless_networking = wireless_networking;
	}

	public boolean getWired_networking() {
		return wired_networking;
	}

	public void setWired_networking(boolean wired_networking) {
		this.wired_networking = wired_networking;
	}

	public boolean getSpeakers() {
		return speakers;
	}

	public void setSpeakers(boolean speakers) {
		this.speakers = speakers;
	}

	public boolean getKeyboard() {
		return keyboard;
	}

	public void setKeyboard(boolean keyboard) {
		this.keyboard = keyboard;
	}

	public boolean getMouse() {
		return mouse;
	}

	public void setMouse(boolean mouse) {
		this.mouse = mouse;
	}

	public boolean getHdmi_output() {
		return hdmi_output;
	}

	public void setHdmi_output(boolean hdmi_output) {
		this.hdmi_output = hdmi_output;
	}

	public boolean getDvi_output() {
		return dvi_output;
	}

	public void setDvi_output(boolean dvi_output) {
		this.dvi_output = dvi_output;
	}

	public boolean getVga_output() {
		return vga_output;
	}

	public void setVga_output(boolean vga_output) {
		this.vga_output = vga_output;
	}
	
	
	
	
	
	



	
	
}
