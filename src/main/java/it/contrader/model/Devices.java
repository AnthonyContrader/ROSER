package it.contrader.model;

public class Devices {
	private int devId;
	private String model;
	private User user;
	
	public Devices (int devId , String model , User user) {
		this.model = model;
		this.user = user;
		this.devId = devId;
	}

	public Devices() {}
	
	
	public int getDevId() {
		return devId;
	}

	public void setDevId(int devId) {
		this.devId = devId;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	@Override
	public String toString() {
		return this.getDevId() + "\t" + this.getModel() + "\t" + this.getUser().getUsername();
	}
}
