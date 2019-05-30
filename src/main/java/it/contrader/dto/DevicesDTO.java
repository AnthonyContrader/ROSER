package it.contrader.dto;

import it.contrader.model.User;

public class DevicesDTO {
	private int devId;
	private String model;
	private User user;
	
	public DevicesDTO (String model , User user) {
		this.model = model;
		this.user = user;
	
	}
	public DevicesDTO(){}

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
	

	public int getDevId() {
		return devId;
	}

	public void setDevId(int devId) {
		this.devId = devId;
	}

	@Override
	public String toString() {
		return this.getDevId() + "\t" + this.getModel() + "\t" + this.getUser();
		
	}
	
	
	
	
}

