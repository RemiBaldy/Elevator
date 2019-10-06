package controller;

import controller.model.Model;
import factories.AlgorythmFactory;
import os.OperationnalSystem;
import utility.Order;

public class BaseController {

	private ElevatorAlgorythm elevatorAlgorythm = AlgorythmFactory.getInstance();
	
	
	private Model model ;
	private OperationnalSystem operationnalSystem;
	
	public BaseController(Model model, OperationnalSystem operationnalSystem) {
		this.model = model;
		this.operationnalSystem = operationnalSystem ;
		ControllerAcessor.setInstance(this);
	}
	
	public void handleUserRequest(String request) {
		updateModel(request);
		Order order = elevatorAlgorythm.compute(model);
		operationnalSystem.execute(order);
	}
	
	/**
	 * Met à jour le model en fonction de la requête reçu.
	 * Il faudrat utiliser une autre classe qui déchiffrera le protocol.
	 * 
	 */
	private void updateModel(String request) {
		
	}
	
	/*
	 * Lorsque le systeme operationnel change d'etage cette fonction sera lancée.
	 */
	public void handleNewFloorNotification(int floor) {
		model.setEtage(floor);
		//Refaire un tour d'algo ?? Peut être facultatif, à voir avec l'arrêt d'urgence.
	}
	
	
}
