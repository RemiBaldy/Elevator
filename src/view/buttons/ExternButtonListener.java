package view.buttons;

import java.awt.Color;

/**
 *
 * Action Graphique porpre a cette classe de boutons
 *
 */
public class ExternButtonListener extends AbstractButtonListener{

	@Override
	protected void onClick(ElevatorButton button) {
		button.setBackground(Color.RED);
	}

}
