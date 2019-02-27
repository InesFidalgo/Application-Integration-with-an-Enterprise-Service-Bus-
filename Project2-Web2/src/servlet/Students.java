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

import data.Student;
import ejbs.CRUDBean;


// http://localhost:8080/Project2-Web/Students?order=1
// url = http://localhost:8080/Project2-Web/Students?order=up
@WebServlet("/Students")
public class Students extends HttpServlet {
 private static final long serialVersionUID = 1L;
 @EJB
 CRUDBean ejbremote;

 /**
  * @see HttpServlet#HttpServlet()
  */
 public Students() {
  super();
 }

 
 
 public void fill(){
	 ejbremote.WriteDataStudent("joao", "dsad", 654, 5466, new Date(), "dsds", "sdsd", "sdsdvv",65465);
	 ejbremote.WriteDataStudent("joana", "ddsad", 654, 5466, new Date(), "dsds", "sdsd", "sdsdvv",65465);
	 ejbremote.WriteDataStudent("joao1", "dsdad", 654, 5466, new Date(), "dsds", "sdsd", "sdsdvv",65465);
	 ejbremote.WriteDataStudent("joao2", "dsadd", 654, 5466, new Date(), "dsds", "sdsd", "sdsdvv",65465);
	 ejbremote.WriteDataStudent("joao3", "dsxad", 654, 5466, new Date(), "dsds", "sdsd", "sdsdvv",65465);
	 ejbremote.WriteDataStudent("joao4", "dsfxad", 654, 5466, new Date(), "dsds", "sdsd", "sdsdvv",65465);
	 ejbremote.WriteDataStudent("joao5", "dsfad", 654, 5466, new Date(), "dsds", "sdsd", "sdsdvv",65465);
	 ejbremote.WriteDataStudent("joao6", "dsaad", 654, 5466, new Date(), "dsds", "sdsd", "sdsdvv",65465);
	 ejbremote.WriteDataStudent("joao7", "dsaad", 654, 5466, new Date(), "dsds", "sdsd", "sdsdvv",65465);
	 ejbremote.WriteDataStudent("joao8", "dsaaad", 654, 5466, new Date(), "dsds", "sdsd", "sdsdvv",65465);
	 
 }
 
 private String ts(Student s){
	 return s.getName()+" | n:"+s.getNumber()+" | email:"+s.getEmail()+" | other email:"+s.getAlternateEmail()+" | first year"+s.getFirstYear()+" | phone:"+s.getTelephone()+" | ID:"+s.getId();
 }
 
 /**
  * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
  */
 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  PrintWriter out = response.getWriter();
  response.setContentType("text/html");
  ArrayList<Student> lista;
  if (request.getParameter("order").equals("up")) {
   lista=ejbremote.ListStudents(1);
   for (Student s:lista){
	   out.println(ts(s)+"<br/>");
   }
  }
  else if (request.getParameter("order").equals("down")){
	  lista=ejbremote.ListStudents(0);
	   for (Student s:lista){
		   out.println(ts(s)+"<br/>");
	   }
  }else if(request.getParameter("order").equals("1")) {
	  fill();
	  out.println("<h1>Added some students!</h1>");
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
