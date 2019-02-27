package ws;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class Listar {
	@WebMethod
	public String setParams(String course, String nul) {
		return "Success";
	}
}
