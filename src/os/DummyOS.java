package os;

import java.util.Timer;

import utility.Order;
import utility.Sens;

/**
 * 
 * Etend OS pour simuler le comportement sur une vue Java.
 * 
 * Rajouter un système d'abonnement avec la classe abstraite View pourrait être utile pour tester plusieurs vues.
 * 
 */
@SuppressWarnings("unused")
public class DummyOS extends OperationnalSystem {

	
	private int currentFlow ;
	private Sens currentSens ;
	private Timer timer ;
	private Order lastOrder ;
	
	/**
	 * Met à jour le dernier ordre qui lui a été envoyé.
	 * 
	 * On pourra faire des maths pour savoir ou est précisemment l'acsenseur entre deux étages
	 * A part pour une simulation de la vue plus précise, ce n'est pas très iomportant car normalement les capteurs seront indépendants.
	 * 
	 * Il faudrait prévenir le controller lorsque l'ascenseur atteind un nouvel étage ( super.notifyController(newFloor) ).
	 * 
	 * Et bien sur la vue qu'on souhaite simuler ( en plus des reqûetes accomplie pour éteindre les boutons ).
	 * 
	 * 
	 * Cette classe n'est pas si triviale à coder par rapport aux autres.
	 * 
	 */
	@Override
	public void execute(Order order) {
		
	}

}
