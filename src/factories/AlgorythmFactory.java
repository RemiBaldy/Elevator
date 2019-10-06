package factories;

import controller.DummyElevatorAlgorythm;
import controller.ElevatorAlgorythm;

/**
 * 
 * Il n'y aura que cette classe a changer pour faire d'autre essais
 * 
 */
public class AlgorythmFactory {
	public static ElevatorAlgorythm getInstance() {
		return new DummyElevatorAlgorythm();
	}
}
