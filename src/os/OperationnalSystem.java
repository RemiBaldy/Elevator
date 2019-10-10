package os;

import controller.BaseController;
import controller.ControllerAcessor;
import utility.Order;


/**
 * OperationnalSystem devra mettre la Vue à jour en fonction :
 * De son timer ( simulation de la montée de l'ascenseur )
 * De son dernier ordre reçu.
 * Du sens et de l'étage courrant de l'ascenseur.
 * 
 * Cette classe simule le boitié collé au moteur de l'ascenseur.
 * 
 * Elle n'a pas forcément besoin d'un système d'abonnement car, en théorie, elle est directement relié à l'ascenseur physique.
 * Si une classe veut le simuler avec une vue ( ce qu'on veut faire pour l'instant ), elle devrat l'étendre et proposer un système d'abonnement si besoin.
 *
 */
public abstract class OperationnalSystem {
	public abstract void execute(Order order);
	
	// Il faudrat revoir l'ordre de construction pour optimiser ( très léger ) :
	// protected BaseController controller = ControllerAcessor.getCurrentInstance();
	
	protected void notifyController() {
		// En attendant c'est ici :
		BaseController controller = ControllerAcessor.getCurrentInstance();
		controller.handleNewFloorNotification();
	}
}
