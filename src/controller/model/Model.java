package controller.model;

import controller.Request;
import utility.Sens;

import java.util.Arrays;

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

	@Override
	public String toString() {
		return "Model{" +
				"upRequest=" + Arrays.toString(upRequest) +
				", downRequest=" + Arrays.toString(downRequest) +
				", floorRequest=" + Arrays.toString(floorRequest) +
				", floor=" + floor +
				", sens=" + sens +
				'}';
	}

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
