package controller.model;

import utility.Sens;

/**
 * 
 * Model/DB
 * 
 */
public class Model {
	private boolean upRequest[];
	private boolean downRequest[];
	private boolean floorRequest[];
	private int floor = 0;
	private Sens sens = Sens.ARRET;
	private int nbFloor;
	private boolean emergencyStop;
	
	public int getFloor() {
		return floor;
	}

	public void setFloor(int floor) {
		this.floor = floor;
	}

	public boolean isEmergencyStop() {
		return emergencyStop;
	}

	public void setEmergencyStop(boolean emergencyStop) {
		this.emergencyStop = emergencyStop;
	}

	public Model(int nbFloor) {
		this.nbFloor = nbFloor ;
		this.upRequest = new boolean[nbFloor];
		this.downRequest = new boolean[nbFloor];
		this.floorRequest = new boolean[nbFloor];
	}
	
	public boolean[] getUpRequest() {
		return upRequest;
	}
	public void setUpRequest(int i, boolean value) {
		this.upRequest[i] = value;
	}
	public boolean[] getDownRequest() {
		return downRequest;
	}
	public void setDownRequest(int i, boolean value) {
		this.downRequest[i] = value;
	}
	public boolean[] getFloorRequest() {
		return floorRequest;
	}
	public void setFloorRequest(int i, boolean value) {
		this.floorRequest[i] = value;
	}

	public Sens getSens() {
		return sens;
	}
	public void setSens(Sens sens) {
		this.sens = sens;
	}
	public int getNbFloor() {
		return nbFloor;
	}
	public void setNbFloor(int nbFloor) {
		this.nbFloor = nbFloor;
	}

}
