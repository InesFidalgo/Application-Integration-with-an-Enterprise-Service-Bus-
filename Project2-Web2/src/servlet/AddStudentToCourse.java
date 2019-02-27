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
 * Servlet implementation class AddStudentToCourse
 */
@WebServlet("/AddStudentToCourse")
public class AddStudentToCourse extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	 CRUDBean ejbremote;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddStudentToCourse() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    private void printOG(PrintWriter out){
    	out.println("<h1>ADD STUDENT TO COURSE</h1>"
				+ "<form method=\"post\" action=\"AddStudentToCourse\"><input type=\"hidden\" name=\"req\" value=\"1\" />Student ID<p>"
				+ "<input type=\"text\" name=\"sid\" value=\"\" placeholder=\"54657897\">"
				+ "</p>Course ID<p><input type=\"text\" name=\"cid\" value=\"\" placeholder=\"6545654\">"
				+ "</p><p class=\"submit\"><input type=\"submit\" name=\"commit\" value=\"ADD\"></p></form>");
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		if (request.getParameter("req")==null){
			printOG(out);
		}else{
			int a,b;
			String c,d;
			c=request.getParameter("sid");
			d=request.getParameter("cid");
			try{
				a=Integer.parseInt(c);
				b=Integer.parseInt(d);
			}catch(Exception e){
				printOG(out);
				return;
			}
			ejbremote.AddStudentCourse(a, b);
			out.println(c+" added to "+d+"!!"+"<form method=\"post\" action=\"AddStudentToCourse\"><p class=\"submit\"><input type=\"submit\" name=\"commit\" value=\"Add More\"></p></form>");
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
