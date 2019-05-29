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




public User getOwner() {
	return user;
}




public void setOwner(User user) {
	this.user = user;
}

@Override
public String toString() {
	return this.getDevId() + "\t" + this.getModel() + "\t" + this.getOwner();
}
}
