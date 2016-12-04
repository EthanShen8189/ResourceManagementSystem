package concordia.soen387.project.Model;


public class Projector {

	private boolean dvi_input;
	private boolean hdmi_input;
	private int height;
	private int width;
	private boolean vga_input;
	private int id;

	public Projector(){}

	public Projector(boolean dvi_input, boolean hdmi_input, int height, int width,
					 boolean vga_input, int id){
		this.dvi_input = dvi_input;
		this.hdmi_input = hdmi_input;
		this.height = height;
		this.width = width;
		this.vga_input = vga_input;
		this.id = id;
	}

	public boolean getDvi_input() {
		return dvi_input;
	}

	public void setDvi_input(boolean dvi_input) {
		this.dvi_input = dvi_input;
	}

	public boolean getHdmi_input() {
		return hdmi_input;
	}

	public void setHdmi_input(boolean hdmi_input) {
		this.hdmi_input = hdmi_input;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public boolean getVga_input() {
		return vga_input;
	}

	public void setVga_input(boolean vga_input) {
		this.vga_input = vga_input;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}





}