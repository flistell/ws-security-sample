package fl.poc;

import fl.poc.ws.Ping;
import fl.poc.ws.PingService;
import javax.xml.ws.WebServiceRef;

public class App {

    /*
    @WebServiceRef(wsdlLocation = "http://127.0.0.1:7001/ws-security-sample-0.0.1-SNAPSHOT/PingService?WSDL")
    private PingService service;
    */
    

    public static void main(String[] args){
        PingService service = new PingService();
        System.out.print(service + ": ");
        Ping port = service.getPingPort();
        System.out.println(port.ping());
    }
}
