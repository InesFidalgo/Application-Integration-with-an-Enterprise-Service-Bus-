package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import data.Admin;
import data.Professor;
import data.Student;
import ejbs.CRUDBean;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	 CRUDBean ejbremote;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    private void printOG(PrintWriter out){
    	out.println("<h1>LOGIN</h1>"
				+ "<form method=\"post\" action=\"Login\"><input type=\"hidden\" name=\"req\" value=\"1\" />Email<p>"
				+ "<input type=\"text\" name=\"email\" value=\"\" placeholder=\"email\">"
				+ "</p>Password<p><input type=\"password\" name=\"password\" value=\"\" placeholder=\"password\">"
				+ "</p><p class=\"submit\"><input type=\"submit\" name=\"commit\" value=\"Login\"></p></form>");
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		response.setContentType("text/html");
		if (request.getParameter("req")!=null){
			String email=request.getParameter("email");
			HttpSession session = request.getSession();
			
			for (Professor p:ejbremote.ListProfessors()){
				if(p.getEmail().equals(email)){
					out.println("Professor logged in as :"+email+"!!"+"<form method=\"post\" action=\"MenuProfessor\"><p class=\"submit\"><input type=\"submit\" name=\"commit\" value=\"Menu\"></p></form>");
					session.setAttribute("user", "pro");
					return;
				}
			}
			for (Student p:ejbremote.ListStudents(1)){
				if(p.getEmail().equals(email)){
					out.println("Student logged in as :"+email+"!!"+"<form method=\"post\" action=\"MenuStudent\"><p class=\"submit\"><input type=\"submit\" name=\"commit\" value=\"Menu\"></p></form>");
					session.setAttribute("user", "stu");
					return;
				}
			}
			for (Admin a:ejbremote.ListAdmins()){
				if (a.getName().equals(email)){
					out.println("Admin logged in as :"+email+"!!"+"<form method=\"post\" action=\"MenuAdmin\"><p class=\"submit\"><input type=\"submit\" name=\"commit\" value=\"Menu\"></p></form>");
					session.setAttribute("user", "adm");
					return;
				}
			}
			printOG(out);
		}else{
			printOG(out);
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
