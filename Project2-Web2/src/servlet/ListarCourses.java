package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.Course;
import data.Professor;
import data.Student;
import ejbs.CRUDBean;


// 
// url = http://localhost:8080/Project2IS-Web/ListarCourses?order=up
@WebServlet("/ListarCourses")
public class ListarCourses extends HttpServlet {
 private static final long serialVersionUID = 1L;
 @EJB
 CRUDBean ejbremote;

 /**
  * @see HttpServlet#HttpServlet()
  */
 public ListarCourses() {
  super();
 }

 public static Comparator<Course> comp1()
 {   
  Comparator comp = new Comparator<Course>(){
      @Override
      public int compare(Course s1, Course s2)
      {
          return s1.getName().compareTo(s2.getName());
      }        
  };
  return comp;
 }  
 
 
 public static Comparator<Course> comp2()
 {   
  Comparator comp = new Comparator<Course>(){
      @Override
      public int compare(Course s1, Course s2)
      {
          return s2.getName().compareTo(s1.getName());
      }        
  };
  return comp;
 } 
 

 
 private String ts(Course s){
	 return s.getName()+" | n:"+" | id:"+s.getId()+" | Nome :"+s.getName()+" | Professor:"+s.getProfessor();
 }
 
 /**
  * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
  */
 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  PrintWriter out = response.getWriter();
  response.setContentType("text/html");
  List<Course> lista;

  if (request.getParameter("order").equals("up")) {
   lista=ejbremote.ListCourses();
   lista.sort(comp1());
   for (Course s:lista){
	   out.println(ts(s)+"<br/>");
   }
  }
  else if (request.getParameter("order").equals("down")){
	  lista=ejbremote.ListCourses();
	   lista.sort(comp2());
	   for (Course s:lista){
		   out.println(ts(s)+"<br/>");
	   }
  
  }else{
	  out.println("<h1>Wrong parameter!</h1>");
  }
 }

 /**
  * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
  */
 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  doGet(request, response);
 }
}
