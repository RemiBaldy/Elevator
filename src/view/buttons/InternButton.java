package view.buttons;

import view.ProtocolTranslator;

public class InternButton extends ElevatorButton {

	private static final long serialVersionUID = 2425696627324882719L;
	
	private String clickMessage ;

	public InternButton(AbstractButtonListener buttonListener, int etage) {
		super(buttonListener);
		clickMessage = ProtocolTranslator.buildInternRequest(etage);	
	}
	
	@Override
	protected String translate() {
		return clickMessage;
	}

}
