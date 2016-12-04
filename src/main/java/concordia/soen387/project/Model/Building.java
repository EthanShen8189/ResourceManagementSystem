package concordia.soen387.project.Model;

/**
 * Created by EthanShen on 2016-12-02.
 */
public class Building {
    private String address;
    private long id;

    public Building(String address, long id) {
        this.address = address;
        this.id = id;
    }

    public Building() {
		// TODO Auto-generated constructor stub
	}

	public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
