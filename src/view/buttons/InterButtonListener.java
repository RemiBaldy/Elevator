package view.buttons;

import java.awt.Color;

public class InterButtonListener extends AbstractButtonListener {

	@Override
	protected void onClick(ElevatorButton button) {
		button.setBackground(Color.ORANGE);
	}

}
