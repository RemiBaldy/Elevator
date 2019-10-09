package controller;

import utility.Sens;

public class Request {

    Sens sens;
    int etage;

    public Request(Sens sens, int etage) {
        this.sens = sens;
        this.etage = etage;
    }

    public Request(String request){
        new RequestConvertingTool(request).treatRequestFromElevator();
    }

    private class RequestConvertingTool {
        String request;

        public RequestConvertingTool(String request) {
            this.request = request;
        }

        public Request treatRequestFromElevator(){
            return new Request(extractSensFromExternRequest(request),extractFloorFromExternRequest(request));
        }
        private int extractFloorFromExternRequest(String request) {
            return Integer.parseInt(request.substring(2));
        }

        public Sens extractSensFromExternRequest(String request){
            return convertSens(request.substring(0,1));
        }
        private Sens convertSens(String substring) {
            if(substring.equals("m"))
                return Sens.HAUT;
            return Sens.BAS;
        }
    }

}
