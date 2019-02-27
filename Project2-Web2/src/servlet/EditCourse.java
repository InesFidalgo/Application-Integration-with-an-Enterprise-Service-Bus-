package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.Course;
import data.Material;
import data.Professor;
import data.Student;
import ejbs.CRUDBean;

/**
 * Servlet implementation class NewCourse
 */
@WebServlet("/EditCourse")
public class EditCourse extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	 CRUDBean ejbremote;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditCourse() {
        super();
        // TODO Auto-generated constructor stub
    }

    private void printOG(PrintWriter out){
    	out.println("<h1>Edit COURSE</h1>"
				+ "<form method=\"post\" action=\"EditCourse\">Name<p>"
				+ "<input type=\"text\" name=\"name\" value=\"\" placeholder=\"Course Name\">"
				+ "</p>Course ID<p><input type=\"text\" name=\"id\" value=\"\" placeholder=\"ID\">"
				+ "</p>Professor<p><input type=\"text\" name=\"professor\" value=\"\" placeholder=\"ID do professor\">"
				+ "</p>Alunos<p><input type=\"text\" name=\"students\" value=\"\" placeholder=\"ID1,ID2,ID3,...\">"
				+ "</p>Materiais<p><input type=\"text\" name=\"materials\" value=\"\" placeholder=\"ID1,ID2,ID3,...\">"
				+ "</p><p class=\"submit\"><input type=\"submit\" name=\"commit\" value=\"CHANGE\"></p></form>");
    }
    
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		int k,PID;
		String name;
		List<Material> mog=null;
		List<Student> sog=null;
		Professor pog=null;
		String id = request.getParameter("id");
		String professor = request.getParameter("professor");
		if (professor!=null){
			try {
				PID = Integer.parseInt(professor);
			} catch (Exception e) {
				printOG(out);
				return;
			}
		}
		String students = request.getParameter("students");
		List<Integer> studentIds = new ArrayList<Integer>();
		if (students!=null)
			for (String s:students.split(",")){
				try{
					k=Integer.parseInt(s);
					studentIds.add(k);
				}catch(Exception e){
					printOG(out);
					return;
				}
			}
		String materials = request.getParameter("materials");
		List<Integer> materialIds = new ArrayList<Integer>();
		if (materials!=null)
			for (String s:materials.split(",")){
				try{
					k=Integer.parseInt(s);
					materialIds.add(k);
				}catch(Exception e){
					printOG(out);
					return;
				}
			}
		int i = 0;
		try{
			i=Integer.parseInt(id);
		}catch(Exception e){
			printOG(out);
			return;
		}
		if ((name=request.getParameter("name"))==null || id ==null){
			printOG(out);
			return;
		}else{
			for (Course c:ejbremote.ListCourses()){
				if(c.getId()==i){
					pog=c.getProfessor();
					sog=c.getStudent();
					mog=c.getMaterial();
				}
			}
			Professor p = null;
			for (Professor pf:ejbremote.ListProfessors()){
				if (pf.getId()==i)
					p=pf;
			}
			List<Student> s  = new ArrayList<Student>();
			for (Student st:ejbremote.ListStudents(1)){
				if (studentIds.contains(st.getId()))
					s.add(st);
			}
			List<Material> m  = new ArrayList<Material>();
			for (Material mt:ejbremote.ListMaterials()){
				if (materialIds.contains(mt.getID()))
					m.add(mt);
			}			
			if(professor!=null){
				ejbremote.EditarCourse(i, name, p, sog, mog);
			}
			if(students!=null){
				ejbremote.EditarCourse(i, name, pog, s, mog);
			}
			if(materials!=null){
				ejbremote.EditarCourse(i, name, pog, sog, m);
			}
			ejbremote.EditarCourse(i, name, pog,sog,mog);
			out.println(name+" changed!!"+"<form method=\"post\" action=\"EditCourse\"><p class=\"submit\"><input type=\"submit\" name=\"commit\" value=\"EDIT MORE\"></p></form>");

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
