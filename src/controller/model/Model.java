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
	
	public Model(int nbFloor) {
		this.nbFloor = nbFloor ;
		this.upRequest = new boolean[nbFloor];
		this.downRequest = new boolean[nbFloor];
		this.floorRequest = new boolean[nbFloor];
	}
	
	public boolean[] getUpRequest() {
		return upRequest;
	}
	public void setUpRequest(boolean[] upRequest) {
		this.upRequest = upRequest;
	}
	public boolean[] getDownRequest() {
		return downRequest;
	}
	public void setDownRequest(boolean[] downRequest) {
		this.downRequest = downRequest;
	}
	public boolean[] getFloorRequest() {
		return floorRequest;
	}
	public void setFloorRequest(boolean[] floorRequest) {
		this.floorRequest = floorRequest;
	}
	public int getEtage() {
		return floor;
	}
	public void setEtage(int etage) {
		this.floor = etage;
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
