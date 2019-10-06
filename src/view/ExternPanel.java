package view;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import utility.Sens;
import view.buttons.ElevatorButton;
import view.buttons.ExternButton;
import view.buttons.ExternButtonListener;


public class ExternPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5790624585891670378L;
	
	private int nbFloor ;
	
	private ElevatorButton [] upButtons ;
	private ElevatorButton [] downButtons ;
	private ImageIcon upArrow ;
	private ImageIcon downArrow ;
	
	public ExternPanel(int nbFloor) {
		initExternModel(nbFloor);
		initLayout();
		loadIcons();
		buildButtons();
	}
	
	private void initExternModel(int nbfloor) {
		this.nbFloor = nbfloor ;
		this.downButtons = new ElevatorButton[nbfloor];
		this.upButtons = new ElevatorButton[nbfloor];
	}

	private void initLayout() {
		GridLayout layout = new GridLayout(nbFloor,2);
		layout.setHgap(5);
		layout.setVgap(10);
		this.setLayout(layout);
	}
	
	private void loadIcons() {
		upArrow = new ImageIcon("images/UpArrow.png");
		downArrow = new ImageIcon("images/DownArrow.png");
		upArrow = new ImageIcon(upArrow.getImage().getScaledInstance(90, 90, Image.SCALE_DEFAULT));
		downArrow = new ImageIcon(downArrow.getImage().getScaledInstance(90, 90, Image.SCALE_DEFAULT));
	}

	private void buildButtons() {

		ElevatorButton tmpButton ;
		for(int i = nbFloor - 1 ; i >= 0 ; i --) {
			
			tmpButton = buildUpButton(i);
			this.add(tmpButton);
			upButtons[i] = tmpButton ;
			
			tmpButton = buildDownButton(i);
			this.add(tmpButton);
			downButtons[i] = tmpButton ;
		}
	}
	
	private ElevatorButton buildUpButton(int floor) {
		ExternButton button = new ExternButton(new ExternButtonListener(), Sens.HAUT, floor);
		button.setIcon(upArrow);
		button.setBackground(getOffColor());
		button.setOpaque(true);
		return button;
	}
	
	private ElevatorButton buildDownButton(int floor) {
		ExternButton button = new ExternButton(new ExternButtonListener(), Sens.BAS, floor);
		button.setIcon(downArrow);
		button.setBackground(getOffColor());
		button.setOpaque(true);
		return button;
	}

	public void actionOn(int floor, int sens) {
		
	}

	public void actionOff(int floor, int sens) {
		if(isValidFloor(floor)) {
			Color offColor = getOffColor();
			if(sens == 1) {
				upButtons[floor].setBackground(offColor);
			}else {
				downButtons[floor].setBackground(offColor);
			}
		}
	}
	
	private boolean isValidFloor(int floor) {
		return 0 <= floor && floor < (nbFloor );
	}
	
	@SuppressWarnings("unused")
	private Color getOnColor() {
		return Color.RED;
	}
	
	private Color getOffColor() {
		return Color.GRAY;
	}
	
	
}
