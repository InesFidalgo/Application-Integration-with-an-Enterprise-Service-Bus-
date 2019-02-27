package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MenuProfessor
 */
@WebServlet("/MenuProfessor")
public class MenuProfessor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MenuProfessor() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.println("<h1>Professor Menu:</h1>"
				+ "List Materials<p><form method=\"post\" action=\"Materials\"></p><p class=\"submit\"><input type=\"submit\" name=\"commit\" value=\"Show\"></p></form>"
				+ "Download Material<p><form method=\"post\" action=\"index2.jsp\"></p><p class=\"submit\"><input type=\"submit\" name=\"commit\" value=\"Chose File\"></p></form>"
				+ "Upload Material<p><form method=\"post\" action=\"index.jsp\"></p><p class=\"submit\"><input type=\"submit\" name=\"commit\" value=\"Chose File\"></p></form>"
				+ "Delete Material<p><form method=\"post\" action=\"deletematerials.jsp\"></p><p class=\"submit\"><input type=\"submit\" name=\"commit\" value=\"Chose File\"></p></form>"
				+ "Create Course<p><form method=\"post\" action=\"NewCourse\"></p><p class=\"submit\"><input type=\"submit\" name=\"commit\" value=\"New Course\"></p></form>"
				+ "Add professor to course<p><form method=\"post\" action=\"addproftocourse.jsp\"></p><p class=\"submit\"><input type=\"submit\" name=\"commit\" value=\"Add\"></p></form>"
				+ "Add Student to course<p><form method=\"post\" action=\"AddStudentToCourse\"></p><p class=\"submit\"><input type=\"submit\" name=\"commit\" value=\"Add\"></p></form>"
				+ "Edit course<p><form method=\"post\" action=\"EditCourse\"></p><p class=\"submit\"><input type=\"submit\" name=\"commit\" value=\"Add\"></p></form>"
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
