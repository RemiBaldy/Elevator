package controller;

import java.util.LinkedList;
import java.util.List;

import controller.model.Model;
import utility.Order;
import utility.Sens;

public class DummyElevatorAlgorythm implements ElevatorAlgorythm{
	
	private int floor ;
	private int nbFloor ;
	private Model model ;
	
	private List<Order> orders ;
	
	@Override
	public List<Order> compute(Model model) {
		
		orders = new LinkedList<Order>();
		
		Sens sens = model.getSens();
		System.out.println("Current Sens : " + sens);
		floor = model.getFloor();
		nbFloor = model.getNbFloor();
		this.model = model ;
		
		
		if(model.isEmergencyStop()) {
			orders.add(Order.ARRET_URGENT);
		}else {
			int nextFloorStop ;
			switch(sens) {
			case BAS:
				nextFloorStop = findNextFloorStop(floor - 1);
				computeNextStopIntoOrders(nextFloorStop);
				break;
			case HAUT:
				nextFloorStop = findNextFloorStop(floor + 1);
				computeNextStopIntoOrders(nextFloorStop);
				break;
			default:
				nextFloorStop = findNextFloorStop(floor);
				computeNextStopIntoOrders(nextFloorStop);
				break;
			}
		}
		return orders;
	}

	private void computeNextStopIntoOrders(int nextFloorStop){
		if(nextFloorStop < floor) {
			orders.add(Order.DESCENDRE);
			if(nextFloorStop == floor - 1) {
				orders.add(Order.ARRET_PROCHAIN);
			}
		}else if(nextFloorStop > floor) {
			orders.add(Order.MONTER);
			if(nextFloorStop == floor + 1) {
				orders.add(Order.ARRET_PROCHAIN);
			}
		}
	}
	
	private int findNextFloorStop(int floor) {
		switch(model.getSens()) {
		case BAS:
			return downCompute(floor);
		default:
			return upCompute(floor);
		}
	}

	private int downCompute(int start) {
		for(int i = start ; i >= 0 ; i --) {
			if(model.getDownRequest()[i] || model.getFloorRequest()[i]) 
				return i;
		}
		for(int i = 0 ; i < nbFloor ; i ++) {
			if(model.getUpRequest()[i] || model.getFloorRequest()[i])
				return i ;
		}
		for(int i = nbFloor - 1 ; i > start ; i --) {
			if(model.getDownRequest()[i] || model.getFloorRequest()[i])
				return i;
		}
		return -1 ;
	}

	private int upCompute(int start) {
		for(int i = start ; i < nbFloor ; i ++) {
			if(model.getUpRequest()[i] || model.getFloorRequest()[i]) 
				return i;
		}
		for(int i = nbFloor - 1 ; i >= 0 ; i --) {
			if(model.getDownRequest()[i] || model.getFloorRequest()[i])
				return i ;
		}
		for(int i = 0 ; i < start ; i ++) {
			if(model.getUpRequest()[i] || model.getFloorRequest()[i])
				return i;
		}
		return -1 ;
	}
	
}
