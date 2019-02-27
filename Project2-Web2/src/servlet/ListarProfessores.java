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

import data.Professor;
import data.Student;
import ejbs.CRUDBean;


// 
// url = http://localhost:8080/Project2IS-Web/ListarProfessores?order=up
@WebServlet("/ListarProfessores")
public class ListarProfessores extends HttpServlet {
 private static final long serialVersionUID = 1L;
 @EJB
 CRUDBean ejbremote;

 /**
  * @see HttpServlet#HttpServlet()
  */
 public ListarProfessores() {
  super();
 }

 public static Comparator<Professor> comp1()
 {   
  Comparator comp = new Comparator<Professor>(){
      @Override
      public int compare(Professor s1, Professor s2)
      {
          return s1.getName().compareTo(s2.getName());
      }        
  };
  return comp;
 }  
 
 
 public static Comparator<Professor> comp2()
 {   
  Comparator comp = new Comparator<Professor>(){
      @Override
      public int compare(Professor s1, Professor s2)
      {
          return s2.getName().compareTo(s1.getName());
      }        
  };
  return comp;
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
 
 private String ts(Professor s){
	 return s.getName()+" | n:"+" | email:"+s.getEmail()+" | other email:"+s.getAlternateEmail()+" | phone:"+s.getTelephone()+" | ID:"+s.getId()+" | Data de nascimento:"+s.getBirth()+" | Address:"+s.getAddress()+" | InternalNumber:"+s.getInternalNumber()+" | Categoria:"+s.getCategory()+" | Office:"+s.getOffice()+" | Número Tel Interno:"+s.getInternalPhone()+" | Salário:"+s.getSalary();
 }
 
 /**
  * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
  */
 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  PrintWriter out = response.getWriter();
  response.setContentType("text/html");
  List<Professor> lista;

  if (request.getParameter("order").equals("up")) {
   lista=ejbremote.ListProfessors();
   lista.sort(comp1());
   for (Professor s:lista){
	   out.println(ts(s)+"<br/>");
   }
  }
  else if (request.getParameter("order").equals("down")){
	  lista=ejbremote.ListProfessors();
	   lista.sort(comp2());
	   for (Professor s:lista){
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
