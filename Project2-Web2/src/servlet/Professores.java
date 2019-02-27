package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import ejbs.CRUDBean;

/**
 * Servlet implementation class PlayersTallerThan
 */
// http://localhost:8080/Project2IS-Web/Professores?order=1
// url = http://localhost:8080/Project2IS-Web/Professores?order=up
@WebServlet("/Professores")
public class Professores extends HttpServlet {
 private static final long serialVersionUID = 1L;
 @EJB
 CRUDBean ejbremote;

 /**
  * @see HttpServlet#HttpServlet()
  */
 public Professores() {
  super();
 }


 
 public void fill(){
	 ejbremote.WriteDataProfessor("joao", "dsad", new Date(), "email", "alternate","address", 123,123, "categoria","office", 65465, 12.0);
	 
 }
 
 /**
  * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
  */
 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  PrintWriter out = response.getWriter();
  
  if (request.getParameter("order").equals("1")) {
	  String action = request.getParameter("action");
	  
	  String name = request.getParameter("name");
	  String password = request.getParameter("password");
	  String email=request.getParameter("email");
	  String data2 = request.getParameter("data");
	  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	 
	  Date data = null;
	try {
		data = sdf.parse(data2);
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  String alternate = request.getParameter("alternate");
	  String address = request.getParameter("address");
	 
	  out.println(request.getParameter("tel"));
	  int tel = Integer.parseInt(request.getParameter("tel"));
	  
	  int internalnumber = Integer.parseInt(request.getParameter("internalnumber"));
	  String categoria = request.getParameter("categoria");
	  String office = request.getParameter("office");
	  int numerointerno = Integer.parseInt(request.getParameter("numerointerno"));
	  double salario = Double.parseDouble(request.getParameter("salario"));
	  ejbremote.WriteDataProfessor(name, password,data,email,alternate, address,tel,internalnumber,categoria,office,numerointerno,salario);
	  System.out.println("----------erro\n");
	  request.getRequestDispatcher("/register.jsp").forward(request, response);
	  
	  out.println("<h1>Added some professores!</h1>");
	  
  }
  
	  
  }
 

 /**
  * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
  */
 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  doPost(request, response);
 }
}
