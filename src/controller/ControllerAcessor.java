package controller;

/**
 * 
 * Permet a n'importe quel classe java qui connait le package controller de communiquer avec
 * 
 */
public class ControllerAcessor {
	private static BaseController controller;
	
	public static BaseController getCurrentInstance() {
		return controller;
	}
	
	static void setInstance(BaseController controller) {
		ControllerAcessor.controller = controller ;
	}
}
