package controller.model;

import controller.Request;
import utility.Sens;

public class RequestConvertingTool {
    String request;

    public RequestConvertingTool(String request) {
        this.request = request;
    }


    public Request decryptRequestFromElevator(){
            return new Request(extractSensFromRequest(request),extractFloorFromRequest(request));
    }
    private int extractFloorFromRequest(String request) {
        return Integer.parseInt(request.substring(2));
    }

    public Sens extractSensFromRequest(String request){
        return convertSens(request.substring(0,1));
    }
    private Sens convertSens(String substring) {
        if(substring.equals("m"))
            return Sens.HAUT;
        return Sens.BAS;
    }

}
