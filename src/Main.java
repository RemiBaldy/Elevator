

import controller.BaseController;
import controller.model.Model;
import os.DummyOS;
import view.DummyView;

public class Main {
    public static void main(String[] args) {

    	BaseController controller = new BaseController(new Model(5), new DummyOS());
        DummyView view = new DummyView(5);
    }

}
