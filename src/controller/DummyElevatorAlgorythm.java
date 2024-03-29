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
	
	private Order lastOrderCache ;
	
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
				nextFloorStop = findNextFloorStop(floor + 1);
				computeNextStopIntoOrders(nextFloorStop);
				break;
			}
		}
		
		updateCache();
		
		return orders;
	}

	
	/**
	 * Déduit les ordres a envoyer en fonctions :
	 * - du prochain étage où s'arréter, 
	 * - du dernier ordre envoyé,
	 * - de l'étage où se trouve l'ascenseur.
	 * @param nextFloorStop
	 */
	private void computeNextStopIntoOrders(int nextFloorStop){
		if(0<= nextFloorStop && nextFloorStop < floor) {
			if(model.getSens() != Sens.BAS) {
				orders.add(Order.DESCENDRE);				
			}
			if(nextFloorStop == floor - 1) {
				if(lastOrderCache != Order.ARRET_PROCHAIN)
					orders.add(Order.ARRET_PROCHAIN);
			}else if(lastOrderCache == Order.ARRET_PROCHAIN){
				orders.add(Order.DESCENDRE);
			}
		}else if(nextFloorStop > floor) {
			if(model.getSens() != Sens.HAUT) {
				orders.add(Order.MONTER);
			}			
			if(nextFloorStop == floor + 1) {
				if(lastOrderCache != Order.ARRET_PROCHAIN)
					orders.add(Order.ARRET_PROCHAIN);
			}else if(lastOrderCache == Order.ARRET_PROCHAIN) {
				orders.add(Order.MONTER);
			}
		}
	}
	
	/**
	 * 
	 * @param floor
	 * @return le prochain étage ou s'arréter
	 */
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

	private int upCompute(int start) {System.out.println("UpCompute");
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
	

	private void updateCache() {
		int size = orders.size();
		if(size > 0)
			lastOrderCache = orders.get(size - 1);
	}
	
}
