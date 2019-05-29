package it.contrader.model;

public class Devices {
	private int devId;
	private String model;
	private String owner;




public Devices (int devId , String model , String owner) {
	this.model = model;
	this.owner = owner;
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




public String getOwner() {
	return owner;
}




public void setOwner(String owner) {
	this.owner = owner;
}

@Override
public String toString() {
	return this.getDevId() + "\t" + this.getModel() + "\t" + this.getOwner();
}
}
