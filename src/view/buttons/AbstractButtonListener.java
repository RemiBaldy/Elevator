package view.buttons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controller.ControllerAcessor;

/**
 * 
 * Cette classe sert a différencier le traitement graphique et la communication avec le controlleur
 * 
 */
public abstract class AbstractButtonListener implements ActionListener{
	
	@Override 
	public void actionPerformed(ActionEvent e) {
		ElevatorButton button = ((ElevatorButton)e.getSource());
		notifyController(button.translate());
		onClick(button);
	}
	
	/**
	 * Prévient le controller de la requête
	 * @param message
	 */
	private void notifyController(String request) {
		ControllerAcessor.getCurrentInstance().handleUserRequest(request);
	}

	/**
	 * Effecture des modifications propre à la vue lors du click
	 * @param button
	 */
	protected abstract void onClick(ElevatorButton button);
}
