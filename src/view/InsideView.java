package view;

import javax.swing.*;
import java.awt.*;


public class InsideView extends JPanel {

    private int nbFloors;
    private JButton[] buttons;

    public InsideView(int nbFloors) {
        this.nbFloors = nbFloors;
        buttons = new JButton[nbFloors];

        this.setLayout(new GridLayout(0,2));
        addButtons();
    }

    public void addButtons(){
        for (int i = 0; i < nbFloors; i++) {
            this.buttons[i] = buildButton(i+"");
        }
        addListeners();
        for(JButton b : buttons)
            this.add(b);

    }


    private JButton buildButton(String label) {
        JButton button = new JButton(label);
        button.setFont(new Font("Arial", Font.PLAIN, 40));
        button.setBackground(Color.LIGHT_GRAY);

        return button;
    }

    private void addListeners(){
        for(JButton b : buttons){
            System.out.println(b.toString());
            b.addActionListener(e -> b.setBackground(Color.ORANGE));
            buttonPressed(b);
        }
    }

    private void buttonPressed(JButton b) {
        //TODO
        //Notify controler when button is pressed
    }

    private void buttonRealease(int floor){
        //TODO
        //Release after being notified by controller that floor is reached
    }


}
