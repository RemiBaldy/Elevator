package View;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.*;

public class ExternView extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5790624585891670378L;
	
	private int nbEtage ;
	
	private JButton [] externUpButton ;
	private JButton [] externDownButton ;
	
	public ExternView( int nbEtage) {
		this.nbEtage = nbEtage ;
		
		this.externUpButton = new JButton[nbEtage];
		this.externDownButton = new JButton[nbEtage];
		
		this.setLayout(new GridLayout(5,5));
		this.setSize(new Dimension(800, 500));
		
		for(int i = 0 ; i < 5 ; i ++) {
			JButton button = new JButton("Etage" + i + " Haut");
			this.add(button);
			externUpButton[i] = button ;
			
			JButton button2 = new JButton("Etage" + i + " Bas");
			this.add(button2);
			externDownButton[i] = button2 ;
		}
	}

	public void actionOn(int floor, int sens) {
		
	}

	public void actionOff(int floor, int sens) {
		
	}
	
	
	
}
