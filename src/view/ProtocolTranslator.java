package view;

import utility.Sens;

/**
 * 
 * Les bouttons ne transmettent pas la même requête 
 * Il s'agit du protocole utiliser pour envoyer des requête au controlleur
 * 
 */
public class ProtocolTranslator {
	public static String buildExternRequest(Sens sens, int etage) {
		switch(sens) {
			case HAUT:
				return "m-"+etage;
			case BAS:
				return "d-"+etage;
			default:
				return null;
		}
	}



	public static String buildInternRequest(int etage) {
		return "a-"+etage;
	}
	public static String buildAlertRequest() {
		return "AA";
	};
}
