package view.buttons;

import utility.Sens;
import view.ProtocolTranslator;

public class ExternButton extends ElevatorButton{
	private static final long serialVersionUID = 684343258612539607L;
	
	private String name ;

	public ExternButton(AbstractButtonListener buttonListener, Sens sens, int etage) {
		super(buttonListener);
		name = ProtocolTranslator.buildExternRequest(sens, etage);
	}
	
	@Override
	protected String translate() {
		return name;
	}

}
