package ws;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class Unsubscription {
	@WebMethod
	public String setParams(String email, String course) {
		return "Success";
	}
}
