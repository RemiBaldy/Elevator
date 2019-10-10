package view;

import javax.swing.*;

import view.buttons.ElevatorButton;
import view.buttons.InterButtonListener;
import view.buttons.InternButton;

import java.awt.*;


public class InsideView extends JPanel {
	private static final long serialVersionUID = 4944849336535204583L;

	private int nbFloors;
    private ElevatorButton[] buttons;

    public InsideView(int nbFloors) {
        this.nbFloors = nbFloors;
        buttons = new ElevatorButton[nbFloors];

        this.setLayout(new GridLayout(0,2));
        addButtons();
    }

    public void addButtons(){
        for (int i = 0; i < nbFloors; i++) {
            this.buttons[i] = buildButton(i+"");
        }
        //addListeners();
        for(JButton b : buttons)
            this.add(b);

    }


    private ElevatorButton buildButton(String label) {
        InternButton button = new InternButton(new InterButtonListener(), Integer.parseInt(label));
        button.setFont(new Font("Arial", Font.PLAIN, 40));
        button.setBackground(Color.LIGHT_GRAY);
        button.setText(label);
        return button;
    }

    /*private void addListeners(){
        for(JButton b : buttons){
            System.out.println(b.toString());
            b.addActionListener(e -> b.setBackground(Color.ORANGE));
            buttonPressed(b);
        }
    }*/


    public void buttonRealease(int floor){
        buttons[floor].setBackground(Color.LIGHT_GRAY);
    }


}
