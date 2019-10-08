

import controller.BaseController;
import controller.model.Model;
import os.DummyOS;
import view.DummyView;

public class Main {
    public static void main(String[] args) {
    	int nbFloors = 5 ;
    	DummyView view = new DummyView(nbFloors);
    	DummyOS os = new DummyOS(view);
    	Model model = new Model(nbFloors);
    	BaseController controller = new BaseController(model, os);
    	
    }

}
