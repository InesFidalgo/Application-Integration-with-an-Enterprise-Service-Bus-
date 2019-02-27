package servlet;
 
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
 
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
/**
 * Servlet implementation class AddMaterial
 */
 
 
 
@WebServlet("/DownloadMaterial")
@MultipartConfig(location = "/upload", maxFileSize = 104857600L) // 1MB.
 
public class DownloadMaterial extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DownloadMaterial() {
        super();
        // TODO Auto-generated constructor stub
    }
 
    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
    	 if (request.getParameter("order").equals("1")) {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
 
        RequestDispatcher view;
        view = request.getRequestDispatcher("/index2.jsp");
        view.forward(request,response);
    	 }
    }
 
    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
       
             
             
            response.setContentType("text/html");  
            PrintWriter out = response.getWriter();
            String filepath = "C:/upload/";  
            String filename = request.getParameter("filename");
            response.setContentType("APPLICATION/OCTET-STREAM");  
            response.setHeader("Content-Disposition","attachment; filename=\"" + filename + "\"");  
             
            FileInputStream fileInputStream = new FileInputStream(filepath + filename);  
                       
            int i;  
            while ((i=fileInputStream.read()) != -1) {  
            out.write(i);  
            }  
            fileInputStream.close();  
            out.close();  
            }  
             
           
       
   
 
}