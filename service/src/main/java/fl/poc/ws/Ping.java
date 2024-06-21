package fl.poc.ws;

import javax.jws.WebMethod;
import javax.jws.WebService;

import weblogic.jws.Policy;

@WebService
@Policy(uri = "policy:Wssp1.2-Https.xml")
public class Ping {

	@WebMethod
	public String sayHello(String name) {
		return String.format("Hello, %s", name);
	}
	
	@WebMethod
	public String ping() {
		return String.format("Pong");
	}

	@WebMethod
	public String pingSecure(){
		return String.format("SecurePong");
	}
}
