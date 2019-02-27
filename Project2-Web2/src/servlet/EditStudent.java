package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ejbs.CRUDBean;

/**
 * Servlet implementation class NewStudent
 */
@WebServlet("/EditStudent")
public class EditStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 @EJB
	 CRUDBean ejbremote;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditStudent() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    private void printOG(PrintWriter out){
    	out.println("<h1>EDIT STUDENT</h1>"
				+ "<form method=\"post\" action=\"EditStudent\">Name<p>"
				+ "<input type=\"text\" name=\"name\" value=\"\" placeholder=\"Username\">"
				+ "</p>Password<p><input type=\"password\" name=\"password\" value=\"\" placeholder=\"Password\">"
				+ "</p>Number<p><input type=\"text\" name=\"number\" value=\"\" placeholder=\"Number\">"
				+ "</p>First Year<p><input type=\"text\" name=\"firstYear\" value=\"\" placeholder=\"2000\">"
				+ "</p>Birth Date<p><input type=\"text\" name=\"birth\" value=\"\" placeholder=\"04-11-1970\">"
				+ "</p>Email<p><input type=\"text\" name=\"email\" value=\"\" placeholder=\"Email\">"
				+ "</p>Alternate Email<p><input type=\"text\" name=\"alternateEmail\" value=\"\" placeholder=\"Email\">"
				+ "</p>Address<p><input type=\"text\" name=\"address\" value=\"\" placeholder=\"Address\">"
				+ "</p>Phone<p><input type=\"text\" name=\"phone\" value=\"\" placeholder=\"Phone Number\">"
				+ "</p>Student ID<p><input type=\"text\" name=\"student\" value=\"\" placeholder=\"Student ID\">"
				+ "</p><p class=\"submit\"><input type=\"submit\" name=\"commit\" value=\"CHANGE\"></p></form>");
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		int numberi,phonei,fyi,studenti;
		Date b = null;
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		String number=request.getParameter("number");
		try{
			numberi = Integer.parseInt(number);
		}catch(Exception e){
			printOG(out);
			return;
		}
		String firstYear=request.getParameter("firstYear");
		try{
			fyi = Integer.parseInt(firstYear);
		}catch(Exception e){
			printOG(out);
			return;
		}
		String birth=request.getParameter("birth");
		String pattern = "dd-MM-yyyy";
	    SimpleDateFormat format = new SimpleDateFormat(pattern);
	    if (birth!=null){
			try {
				b = format.parse(birth);
			} catch (ParseException e) {
				printOG(out);
				return;
			}
		}
		String email=request.getParameter("email");
		String alternateEmail=request.getParameter("alternateEmail");
		String address=request.getParameter("address");
		String phone=request.getParameter("phone");
		try{
			phonei = Integer.parseInt(phone);
		}catch(Exception e){
			printOG(out);
			return;
		}
		String student=request.getParameter("student");
		try{
			studenti = Integer.parseInt(student);
		}catch(Exception e){
			printOG(out);
			return;
		}
	    
	    
		if (name==null || password==null || number==null || firstYear==null || birth==null || email==null || alternateEmail==null || address==null || phone==null ){
			printOG(out);
		}else{
				ejbremote.EditarStudent(studenti,name, password, numberi, fyi, b, email,alternateEmail, address, phonei);
				out.println(name+" changed!!"+"<form method=\"post\" action=\"EditStudent\"><p class=\"submit\"><input type=\"submit\" name=\"commit\" value=\"ADD MORE\"></p></form>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
