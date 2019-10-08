package os;

import java.util.Timer;

import utility.Order;
import utility.Sens;
import view.View;

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
	 * Elle doit donc travailler avec une vue
	 */
	private View view ;
	public DummyOS(View view) {
		this.view = view ;
	}
	
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
		//On suppose que l'ordre "MONTER" a été exéctuer il y a 1 sec quant l'ascenseur était au 2ème étage
		
		//Fin du timer :
		/*
		 * view.setElevatorFloor(3);
		 * notifyController(3);
		 */
		//Si une requête a été achevée ( si l'ordre recu a l'étage 2 était arrete toi au prochain ) : 
		/**
		 * On rajoute 
		 * view.setExternButtonOff(3, Sens.HAUT);
		 * view.setInternButtonOff(3);
		 */
			
		// La principale difficulté est de bien gérer les timers :
		// Par exemple :
		/*
		 * L'ascenseur est à l'étage 2 et recoit "MONTER"
		 * Il doit être capable d'intercepter l'ordre "ARRETE TOI AU PROCHAIN" entre les deux étages.
		 * Et bien évidemment l'arret d'urgence :
		 * foreach etage :
		 * 		view.setButtonsOff(i).
		 */
		
	}
	
	

}
