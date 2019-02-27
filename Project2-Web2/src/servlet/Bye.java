package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ejbs.CRUDBean;

/**
 * Servlet implementation class Bye
 */
@WebServlet("/Bye")
public class Bye extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	 CRUDBean ejbremote;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Bye() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		  response.setContentType("text/html");
			HttpSession session = request.getSession();
			String nome ="";
			if (session!= null && (session.getAttribute("user"))!= null){
				nome =(String) session.getAttribute("user");
			}
			out.println(nome+" logged out!!"+"<form method=\"post\" action=\"Login\"><p class=\"submit\"><input type=\"submit\" name=\"commit\" value=\"Login\"></p></form>");
			session.setAttribute("user", "");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
