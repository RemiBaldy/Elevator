package View;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DummyView implements View{

    JFrame frame ;
    
	JPanel externView ;
	JPanel internView ;

    public DummyView() {
        frame = new JFrame("Frame demo");
        //2. Optional: What happens when the frame closes?
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //3. Create components and put them in the frame.
        //...create emptyLabel...
        frame.getContentPane().add(new JLabel("Salute"), BorderLayout.CENTER);


		externView = new JPanel();//TODO
		internView = new JPanel();//TODO
		
		setPanel();
        
        //4. Size the frame.
        frame.pack();

        //5. Show it.
        frame.setVisible(true);
    }

	private void setPanel() {
		frame.getContentPane().add(externView);
		frame.getContentPane().add(internView);

	}
    
    @Override
    public void setElevatorFloor(int floor) {
        // TODO Auto-generated method stub

    }

    @Override
    public void setExternButtonOn(int floor, int sens) {
        // TODO Auto-generated method stub

    }

    @Override
    public void setInternButtonOn(int floor) {
        // TODO Auto-generated method stub

    }

    @Override
    public void setExternButtonOff(int floor, int sens) {
        // TODO Auto-generated method stub

    }

    @Override
    public void setInternButtonOff(int floor) {
        // TODO Auto-generated method stub

    }

}

