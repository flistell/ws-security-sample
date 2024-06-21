package fl.poc;

import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.Random;

import javax.xml.ws.BindingProvider;

import org.apache.commons.lang.RandomStringUtils;

import fl.poc.ws.Ping;
import fl.poc.ws.PingService;
import weblogic.xml.crypto.wss.WSSConstants;
import weblogic.xml.crypto.wss.api.Timestamp;
import weblogic.xml.crypto.wss.api.WSSecurityFactory;

/*
 * References:
 *  - https://stackoverflow.com/questions/32351354/how-to-implement-a-web-service-client-with-a-signed-body-and-timestamp-for-weblo
 */

public class App {

    /*
    @WebServiceRef(wsdlLocation = "http://127.0.0.1:7001/ws-security-sample-0.0.1-SNAPSHOT/PingService?WSDL")
    private PingService service;
    */

    public static String genNumericRandom(int length) {
        final Random rng = new Random();
        String characters = "0123456789";
        char[] text = new char[length];
        for (int i = 0; i < length; i++) {
            text[i] = characters.charAt(rng.nextInt(characters.length()));
        }
        return new String(text);
    }

    private static Timestamp genTimestamp() {
        Date date = new Date();
        Calendar created = Calendar.getInstance();
        created.setTime(date);
        Calendar expired = Calendar.getInstance();
        expired.setTime(date);
        expired.set(Calendar.HOUR_OF_DAY, created.get(Calendar.HOUR_OF_DAY) + 1);
        return WSSecurityFactory.newTimestamp("TS-" + genNumericRandom(34), created, expired);
    }

    public static void main(String[] args) {
        PingService service = new PingService();
        System.out.print(service + ": ");
        Ping port = service.getPingPort();
        Timestamp timestamp = genTimestamp();

        BindingProvider prov = (BindingProvider) port;
        Map<String, Object> requestContext = prov.getRequestContext();

        requestContext.put(BindingProvider.USERNAME_PROPERTY, "weblogic");
        requestContext.put(BindingProvider.PASSWORD_PROPERTY, "welcome1");
        requestContext.put(WSSConstants.TIMESTAMP_ELEMENT, timestamp);

        System.out.println(port.ping());
    }
}
