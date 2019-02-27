package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ejbs.CRUDBean;

/**
 * Servlet implementation class NewCourse
 */
@WebServlet("/NewCourse")
public class NewCourse extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	 CRUDBean ejbremote;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewCourse() {
        super();
        // TODO Auto-generated constructor stub
    }

    private void printOG(PrintWriter out){
    	out.println("<h1>NEW COURSE</h1>"
				+ "<form method=\"post\" action=\"NewCourse\">Name<p>"
				+ "<input type=\"text\" name=\"name\" value=\"\" placeholder=\"Course Name\">"
				+ "</p><p class=\"submit\"><input type=\"submit\" name=\"commit\" value=\"ADD\"></p></form>");
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		String name;
		if ((name=request.getParameter("name"))==null){
			printOG(out);
		}else{
			ejbremote.WriteDataCourse(name);
			out.println(name+" adicionado!!"+"<form method=\"post\" action=\"NewCourse\"><p class=\"submit\"><input type=\"submit\" name=\"commit\" value=\"ADD MORE\"></p></form>");

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
