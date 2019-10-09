package controller;

import java.util.List;

import controller.model.Model;
import controller.model.RequestConvertingTool;
import factories.AlgorythmFactory;
import os.OperationnalSystem;
import utility.Order;
import utility.Sens;

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
		processRequest(request);
		List<Order> orders = elevatorAlgorythm.compute(model);
		System.out.println(orders);
		for(Order order : orders) {
			if(order==Order.MONTER) model.setSens(Sens.HAUT);
			if(order==Order.DESCENDRE) model.setSens(Sens.BAS);
			if(order==Order.ARRET_PROCHAIN) {
				
			}
			
			operationnalSystem.execute(order);
		}
	}
	
	/**
	 * Met à jour le model en fonction de la requête reçu.
	 * Il faudrat utiliser une autre classe qui déchiffrera le protocol.
	 * 
	 */
	private void processRequest(String request) {
        Request convertedRequest = new RequestConvertingTool(request).decryptRequestFromElevator();
        updateModel(convertedRequest);
	}

	
    public void updateModel(Request convertedRequest) {
    	switch(convertedRequest.sens) {
            case HAUT:
                model.setUpRequest(convertedRequest.etage,true);
            case BAS:
                model.setDownRequest(convertedRequest.etage,true);
        }
    }

	/*
	 * Lorsque le systeme operationnel change d'etage cette fonction sera lancée.
	 */
	public void handleNewFloorNotification(int floor) {
		model.setFloor(floor);
		//Refaire un tour d'algo ?? Peut être facultatif, à voir avec l'arrêt d'urgence.
	}
	
	
}
