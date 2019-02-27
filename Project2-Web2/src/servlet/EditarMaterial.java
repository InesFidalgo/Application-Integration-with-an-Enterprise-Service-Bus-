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
// http://localhost:8080/Project2IS-Web/EditarMaterial?order=1
// url = http://localhost:8080/Project2IS-Web/Materiais?order=up
@WebServlet("/EditarMaterial")
public class EditarMaterial extends HttpServlet {
 private static final long serialVersionUID = 1L;
 @EJB
 CRUDBean ejbremote;

 /**
  * @see HttpServlet#HttpServlet()
  */
 public EditarMaterial() {
  super();
 }


 /**
  * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
  */
 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  PrintWriter out = response.getWriter();
  
  if (request.getParameter("order").equals("1")) {
	  String action = request.getParameter("action");
	  
	  int id = Integer.parseInt(request.getParameter("id"));
	 
	  int idc = Integer.parseInt(request.getParameter("idc"));
	  String nome = request.getParameter("name");
	  
	  double size = Double.parseDouble(request.getParameter("size"));
	  //content???? array de bytes
	  byte[] content = null;
	  ejbremote.EditarMaterial(id, idc, "",size, nome);
	  
	  request.getRequestDispatcher("/editarmaterial.jsp").forward(request, response);
	  out.println("<h1>editado!</h1>");
	  
  }
  
	  
  }
 

 /**
  * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
  */
 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  doPost(request, response);
 }
}
