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
	
	
	@Override
	public List<Order> compute(Model model) {
		Sens sens = model.getSens();
		System.out.println("Current Sens : " + sens);
		floor = model.getFloor();
		nbFloor = model.getNbFloor();
		this.model = model ;
		
		if(model.isEmergencyStop()) {
			List<Order> orders = new LinkedList<Order>();
			orders.add(Order.ARRET_URGENT);
		}
		
		switch (sens) {
		case HAUT:
			return upCompute();
		case BAS:
			return downCompute();
		case ARRET:
			return freeCompute();
		default:
			return freeCompute();
		}
	}

	private List<Order> freeCompute() {
		List<Order> orders = new LinkedList<Order>();
		
		int firstRequest = findFirstRequest();
		
		if(firstRequest > floor) {
			orders.add(Order.MONTER);
		}else if ( 0 <= firstRequest && firstRequest < floor) {
			orders.add(Order.DESCENDRE);
		}else if ( firstRequest == floor){
			//orders.add(Order.ARRET_PROCHAIN); //Risque de bugger
		}
		return orders;
	}

	private int findFirstRequest() {
		for(int i = 0 ; i < nbFloor ; i ++) {
			if(model.getDownRequest()[i] || model.getUpRequest()[i]) {
				return i ;
			}
		}
		return -1 ;
	}

	private List<Order> downCompute() {
		List<Order> orders = new LinkedList<Order>();

		if(floor == 0) {
			orders = freeCompute();
			//Ici
		}
		if(model.getDownRequest()[floor - 1 ] || model.getFloorRequest()[ floor - 1 ]) {
			orders.add(Order.ARRET_PROCHAIN);
		}
		
		return orders;
	}

	private List<Order> upCompute() {
		List<Order> orders = new LinkedList<Order>();
		
		if(floor == nbFloor - 1) {
			orders = freeCompute();
			//Ici
		}
		if(model.getUpRequest()[floor + 1] || model.getFloorRequest()[floor+1]) {
			orders.add(Order.ARRET_PROCHAIN);
		}
		
		return orders;
	}
	
}
