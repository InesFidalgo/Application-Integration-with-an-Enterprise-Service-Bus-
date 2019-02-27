package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.Professor;
import ejbs.CRUDBean;

/**
 * Servlet implementation class DeleteProfessor
 */
@WebServlet("/DeleteProfessor")
public class DeleteProfessor extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	 CRUDBean ejbremote;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteProfessor() {
        super();
        // TODO Auto-generated constructor stub
    }

    public void printOG(PrintWriter out){
    	String o = "<form method=\"post\" action=\"DeleteProfessor\"><select name=\"pid\">";
    	for (Professor p:ejbremote.ListProfessors()){
    		o = o+"<option value=\""+p.getId()+"\">"+p.getName()+"</option></select><br>";
    	}
    	o=o+"<br><input type=\"submit\" name=\"commit\" value=\"DELETE\"></form>";
    	out.println(o);
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		String cid;
		if ((cid=request.getParameter("pid"))==null){
			printOG(out);
		}else{
			int id;
			try{
				id = Integer.parseInt(cid);
			}catch(Exception e){
				printOG(out);
				return;
			}
			ejbremote.DeleteProfessor(id);
			out.println(id+" deleted !!"+"<form method=\"post\" action=\"DeleteProfessor\"><p class=\"submit\"><input type=\"submit\" name=\"commit\" value=\"Delete More\"></p></form>");

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
