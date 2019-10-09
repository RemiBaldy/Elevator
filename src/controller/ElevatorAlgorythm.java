package controller;

import java.util.List;

import controller.model.Model;
import utility.Order;

public interface ElevatorAlgorythm {
	public List<Order> compute(Model model);
}
