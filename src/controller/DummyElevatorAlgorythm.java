package controller;

import controller.model.Model;
import utility.Order;

public class DummyElevatorAlgorythm implements ElevatorAlgorythm{

	@Override
	public Order compute(Model model) {
		if(Math.random() > 0.5)
			return Order.MONTER;
		else
			return Order.DESCENDRE;
	}
	
}
