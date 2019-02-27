package servlet;

import java.io.File;
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
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.Professor;
import ejbs.CRUDBean;

/**
 * Servlet implementation class PlayersTallerThan
 */
// http://localhost:8080/Project2IS-Web/Materiais
// url = http://localhost:8080/Project2IS-Web/Materiais?order=up
@WebServlet("/Materiais")


@SuppressWarnings("serial")


@MultipartConfig(location = "/upload", maxFileSize = 10485760L) // 10MB.

public class Materiais extends HttpServlet {
 private static final long serialVersionUID = 1L;
 @EJB
 CRUDBean ejbremote;

 /**
  * @see HttpServlet#HttpServlet()
  */
 public Materiais() {
  super();
 }


 /**
  * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
  */
 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  PrintWriter out = response.getWriter();
  
  if (request.getParameter("order").equals("1")) {
	  String action = request.getParameter("action");
	  
	  int idcourse = Integer.parseInt(request.getParameter("idcourse"));
	  String nome = request.getParameter("name");
	 
	  
	  MultipartMap map = new MultipartMap(request, this); // Processes form files
      String text = map.getParameter("name");
      File file = map.getFile("file"); // Returns the filename after successful upload.

      // Now do your thing with the obtained input.
      System.out.println("Text: " + text);
      System.out.println("File: " + file);
      String url = "/upload"+file;
	  ejbremote.WriteDataMaterial(idcourse, url,nome);
      request.getRequestDispatcher("/upload/upload_ok.jsp").forward(request, response);
      
  }
  
	  
  }
 

 /**
  * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
  */
 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  
  doPost(request, response);
  request.getRequestDispatcher("/index.jsp").forward(request, response);
  
  
 }
}
