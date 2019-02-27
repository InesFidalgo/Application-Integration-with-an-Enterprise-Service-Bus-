package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.Material;
import data.Student;
import ejbs.CRUDBean;

/**
 * Servlet implementation class Materials
 */
@WebServlet("/Materials")
public class Materials extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 @EJB
	 CRUDBean ejbremote;

	 /**
	  * @see HttpServlet#HttpServlet()
	  */
	 public Materials() {
	  super();
	 }

	 
	 
	
	 
	 /**
	  * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	  */
	 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  PrintWriter out = response.getWriter();
	  response.setContentType("text/html");
	  for (Material m:ejbremote.ListMaterials()){
		  out.println(m.getName()+" ("+m.getSize()+")"+" pertence a "+m.getCourse().getName()+" ("+m.getCourse().getId()+")"+"<br/>");
	  }
	 }

	 /**
	  * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	  */
	 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  doGet(request, response);
	 }
	}
