package view.buttons;

import javax.swing.JButton;


public abstract class ElevatorButton extends JButton {
	private static final long serialVersionUID = 8402031641400129251L;

	/**
	 * 
	 * @return Une string qui sera envoyer au controller lors du click
	 * Chaque boutton enverra une requete différente.
	 */
	protected abstract String translate();
		
	public ElevatorButton(AbstractButtonListener buttonListener) {
		this.addActionListener(buttonListener);
	}
	
	
	
}
