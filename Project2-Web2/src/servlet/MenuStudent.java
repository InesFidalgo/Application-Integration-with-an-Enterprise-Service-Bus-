package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MenuStudent
 */
@WebServlet("/MenuStudent")
public class MenuStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MenuStudent() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.println("<h1>Student Menu:</h1>"
				+ "List Materials<p><form method=\"post\" action=\"Materials\"></p><p class=\"submit\"><input type=\"submit\" name=\"commit\" value=\"Show\"></p></form>"
				+ "Download Material<p><form method=\"post\" action=\"index2.jsp\"></p><p class=\"submit\"><input type=\"submit\" name=\"commit\" value=\"Chose File\"></p></form>"
				+ "Logout<p><form method=\"post\" action=\"Bye\"></p><p class=\"submit\"><input type=\"submit\" name=\"commit\" value=\"Logout\"></p></form>"

				);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
