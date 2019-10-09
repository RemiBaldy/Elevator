package controller;

import utility.Sens;

public class Request {

    Sens sens;
    int etage;

    public Request(Sens sens, int etage) {
        this.sens = sens;
        this.etage = etage;
    }

    /*public Request(String request){
        this = new RequestConvertingTool(request).treatRequestFromElevator();
    }*/


}
