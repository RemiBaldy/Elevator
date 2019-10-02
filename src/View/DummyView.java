package View;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class DummyView implements View{

    JFrame frame ;
    
	ExternView externView;
	InsideView insideView;
	Cabine cabine = new Cabine();
	
	int width = 900, height = 500 ;

    public DummyView(int nbFloors) {

        frame = new JFrame("Frame demo");
        externView = new ExternView(nbFloors);
        insideView = new InsideView(nbFloors);

        //2. Optional: What happens when the frame closes?
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setPanel();
        
        //4. Size the frame.
        frame.pack();

        //
        frame.setSize(this.width, this.height);
        
        //5. Show it.
        frame.setVisible(true);
    }

	private void setPanel() {
		frame.setLayout(new GridLayout(1, 3));
		
		frame.getContentPane().add(externView);

		frame.getContentPane().add(cabine);
		
		frame.getContentPane().add(insideView);
	}
    
    @Override
    public void setElevatorFloor(int floor) {
        // TODO Auto-generated method stub
    }

    @Override
    public void setExternButtonOn(int floor, int sens) {
        externView.actionOn(floor, sens);
    }

    @Override
    public void setInternButtonOn(int floor) {
        // TODO Auto-generated method stub
    }

    @Override
    public void setExternButtonOff(int floor, int sens) {
    	externView.actionOff(floor, sens);
    }

    @Override
    public void setInternButtonOff(int floor) {
        // TODO Auto-generated method stub

    }

}

