package ws;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class MeuServico {
	public String email;
	public String course;
	@WebMethod
	public String  subscribe(String email, String course){
		
		
		return "sucess";
		
	}
	

	@WebMethod
	public String unsubscribe(String email, String course){
		
		return "sucess";
	}
	@WebMethod
	public String listar(){
		
		return "sucess";
	}
	
	

}
