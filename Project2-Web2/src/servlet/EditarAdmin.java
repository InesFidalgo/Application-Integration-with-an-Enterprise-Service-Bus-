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
// http://localhost:8080/Project2IS-Web/EditarAdmin?order=1
// url = http://localhost:8080/Project2IS-Web/Materiais?order=up
@WebServlet("/EditarAdmin")
public class EditarAdmin extends HttpServlet {
 private static final long serialVersionUID = 1L;
 @EJB
 CRUDBean ejbremote;

 /**
  * @see HttpServlet#HttpServlet()
  */
 public EditarAdmin() {
  super();
 }


 /**
  * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
  */
 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  PrintWriter out = response.getWriter();
  
  if (request.getParameter("order").equals("1")) {
	  String action = request.getParameter("action");
	  //int idadmin=0;
	  int idadmin = Integer.parseInt(request.getParameter("id"));
	  String nome = request.getParameter("name");
	  String password = request.getParameter("password");
	  
	  ejbremote.EditarAdmin(idadmin, nome, password);
	  
	  request.getRequestDispatcher("/editaradmin.jsp").forward(request, response);
	  
	  out.println("<h1>Edited Admin!!</h1>");
	  
  }
  
	  
  }
 

 /**
  * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
  */
 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  doPost(request, response);
 }
}
