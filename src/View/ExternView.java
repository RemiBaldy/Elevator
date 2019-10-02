package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.net.URL;

import javax.swing.*;


public class ExternView extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5790624585891670378L;
	
	private int nbEtage ;
	
	private JButton [] externUpButton ;
	private JButton [] externDownButton ;
	
	public ExternView(int nbEtage) {
		this.nbEtage = nbEtage ;
		
		this.externUpButton = new JButton[nbEtage];
		this.externDownButton = new JButton[nbEtage];
		
		GridLayout layout = new GridLayout(nbEtage,2);
		layout.setHgap(5);
		layout.setVgap(10);
		this.setLayout(layout);
		
		ImageIcon upArrow = new ImageIcon("images/UpArrow.png");
		ImageIcon downArrow = new ImageIcon("images/DownArrow.png");
		upArrow = new ImageIcon(upArrow.getImage().getScaledInstance(90, 90, Image.SCALE_DEFAULT));
		downArrow = new ImageIcon(downArrow.getImage().getScaledInstance(90, 90, Image.SCALE_DEFAULT));
		
		JButton tmpButton ;
		for(int i = nbEtage - 1 ; i >= 0 ; i --) {
			tmpButton = buildButton(upArrow);
			this.add(tmpButton);
			externUpButton[i] = tmpButton ;
			
			tmpButton = buildButton(downArrow);
			this.add(tmpButton);
			externDownButton[i] = tmpButton ;
		}
	}
	
	private JButton buildButton(ImageIcon icon) {
		JButton button = new JButton(icon);
		button.setBackground(Color.GRAY);
		return button;
	}

	public void actionOn(int floor, int sens) {
		if(isValidFloor(floor)) {
			Color onColor = getOnColor();
			if(sens == 1) {
				externUpButton[floor].setBackground(onColor);
			}else {
				externDownButton[floor].setBackground(onColor);
			}
		}
	}

	public void actionOff(int floor, int sens) {
		if(isValidFloor(floor)) {
			Color offColor = getOffColor();
			if(sens == 1) {
				externUpButton[floor].setBackground(offColor);
			}else {
				externDownButton[floor].setBackground(offColor);
			}
		}
	}
	
	private boolean isValidFloor(int floor) {
		return 0 <= floor && floor < (nbEtage );
	}
	
	private Color getOnColor() {
		return Color.RED;
	}
	
	private Color getOffColor() {
		return Color.GRAY;
	}
	
	
	
}
