package fl.poc.ws;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class Ping {

	@WebMethod
	public String sayHello(String name) {
		return String.format("Hello, %s", name);
	}
	
	@WebMethod
	public String ping() {
		return String.format("Pong");
	}
}
