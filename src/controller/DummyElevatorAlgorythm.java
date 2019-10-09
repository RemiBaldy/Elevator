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
		floor = model.getEtage();
		nbFloor = model.getNbFloor();
		this.model = model ;
		
		switch (sens) {
		case HAUT:
			return upCompute();
		case BAS:
			return downCompute();
		default:
			return freeCompute();
		}
	}

	private List<Order> freeCompute() {
		List<Order> orders = new LinkedList<Order>();
		
		//FindFirstRequest
		//orders add Sens 
		// if ( firstRequest == +-1 floor )
		//   -> orders add ArretProchain
		
		return orders;
	}

	private List<Order> downCompute() {
		List<Order> orders = new LinkedList<Order>();

		if(model.getDownRequest()[floor - 1 ] || model.getFloorRequest()[ floor - 1 ]) {
			orders.add(Order.ARRET_PROCHAIN);
		}
		
		return orders;
	}

	private List<Order> upCompute() {
		List<Order> orders = new LinkedList<Order>();
		
		if(model.getDownRequest()[floor + 1] || model.getFloorRequest()[floor+1]) {
			orders.add(Order.ARRET_PROCHAIN);
		}
		
		return orders;
	}
	
}
