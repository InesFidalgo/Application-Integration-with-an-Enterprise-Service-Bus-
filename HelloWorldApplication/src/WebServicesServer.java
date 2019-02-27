


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import data.Course;
import data.Material;
import data.Student;
import ejbs.CRUDBean;

@Path("/project3webservices")
@RequestScoped
public class WebServicesServer {
	
	@Inject
	CRUDBean db;
	
	public WebServicesServer() {
		
		System.out.println("WebServicesServer created");
	}
	
	// http://localhost:8080/Project3-REST-Server/rest/project3webservices/gettext
	@GET
	@Path("gettext")
	@Produces({MediaType.TEXT_PLAIN})
	public String getText() {
		return "Hello World!";
	}
		
	// http://localhost:8080/Project3-REST-Server/rest/project3webservices/getmaterials
	@GET
	@Path("getmaterials")
	@Produces({MediaType.APPLICATION_XML})
	public ListCourses getAllMaterials() {
		System.out.println("getAllMaterials started");
		Course courses[] = {new Course("IS"), new Course("ES"), new Course("PPP")};
		Material materials[] = {new Material("book", "/usr"), new Material("slides", "/usr/slides"), new Material("exercises", "/usr/exercises")};
		
		courses[0].addMaterial(materials[0]);
		courses[0].addMaterial(materials[1]);
		courses[1].addMaterial(materials[0]);
		courses[1].addMaterial(materials[2]);
		courses[2].addMaterial(materials[1]);
		courses[2].addMaterial(materials[2]);
		
		ListCourses lc = new ListCourses();
		for (Course c : courses) {
			for (Material m : materials)
				if (Math.random() > 0.5)
					c.addMaterial(m);
			lc.addCourse(c);
		}
		return lc;
	}
	
	public static List<CourseC> listCourses(){
		ArrayList<CourseC> lista = new ArrayList<CourseC>();
		ArrayList<StudentC> list = new ArrayList<StudentC>();
		int[][] cp= new int[2][200];
		int qtdd=0;

		Connection connection;
		Context ctx ;
		DataSource ds = null;
		try{
			ctx = new InitialContext();
			ds = (DataSource)ctx.lookup("java:/Project2EAR");
		}catch(Exception e){
			System.out.println("erro lookup");
		}
		String url="java:/Project2EAR";
		String username = "root";
		String password2 = "root";
		try {
			
			connection= ds.getConnection();
			
			
			String query = "select * from mysqldb.course";
			PreparedStatement preparedStmt = (PreparedStatement) connection.prepareStatement(query);  
		    preparedStmt.execute();
		    ResultSet rs = preparedStmt.getResultSet();
		    while (rs.next()) {
		        lista.add(new CourseC(rs.getString("name"),rs.getInt("id")));
		    }
		    //int id,int number, int firstYear, String name,String password, Date birth, String email, String alternateEmail, String address,
			//int telephone
		    query = "select * from mysqldb.person";
			preparedStmt = (PreparedStatement) connection.prepareStatement(query);  
		    preparedStmt.execute();
		    rs = preparedStmt.getResultSet();
		    while (rs.next()) {
		        if (rs.getString("DTYPE").equals("Student")){
		        	list.add(new StudentC(rs.getInt("id"),rs.getInt("number"),rs.getInt("firstYear"),rs.getString("name"),rs.getString("password"),rs.getDate("birth"),rs.getString("email"),rs.getString("alternateEmail"),rs.getString("address"),rs.getInt("telephone")));
		        }
		    }
		    
		    query = "select * from mysqldb.course_person";
			preparedStmt = (PreparedStatement) connection.prepareStatement(query);  
		    preparedStmt.execute();
		    rs = preparedStmt.getResultSet();
		    int i=0;
		    while (rs.next()) {
		    	qtdd++;
		    	cp[0][i]=rs.getInt("Course_id");
		    	cp[1][i]=rs.getInt("student_id");
		    	i++;
		    }
		    
		    
	    }catch(Exception e){
	    	System.out.println("erro 123\n");
	    }
		
		for (int k=0;k<qtdd;k++){
			for (CourseC c:lista){
				if (c.getId()==cp[0][k]){
					for (StudentC s:list){
						if (s.getId()==cp[1][k]){
							c.addStudent(s);
						}
					}
				}
			}
		}
		return lista;
	    
	}

	
	
	@GET
	@Path("getmaterials2")
	@Produces({MediaType.APPLICATION_XML})
	public List<CourseD> getAllMaterials2() {
		System.out.println("getAllMaterials2 started");
		
		List<CourseD> l = new ArrayList<>();
		List<Course> l1 =db.ListCourses();
		List<Material> l2 =	db.ListMaterials();
		for (Course c:l1){
			l.add(new CourseD(c));
		}
		return l;
	}
	
	
	
	// http://localhost:8080/Project3-REST-Server/rest/project3webservices/getcourses
		@GET
		@Path("getcourses")
		@Produces({MediaType.APPLICATION_JSON})
		public List<CourseC> getAllCourses() {
			System.out.println("getAllCourses started");
			
			
			return listCourses();
		}
	
	// int number, int firstYear, String name,String password, Date birth, String email, String alternateEmail, String address,int telephone
	// http://localhost:8080/Project3-REST-Server/rest/project3webservices/getstudents
	@GET
	@Path("getstudents")
	@Produces({MediaType.APPLICATION_JSON})
	public List<Student> getAllStudents(@QueryParam("courseid") int id) {
		System.out.println("getAllStudents started");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		List<Student> ls = new ArrayList<>();
		try {
			Student sts [] = {
					new Student(20162844,2016,"Josaphat","123", sdf.parse("1973-01-18"), "a@uc.pt", "nand", "nand",966674819),
					new Student(20162846,2016,"Giovanni","123", sdf.parse("1983-11-12"), "x@uc.pt", "nand", "nand",962634818),
					new Student(20162845,2016,"Galli","123", sdf.parse("1993-10-2"), "c@uc.pt", "nand", "nand",962134817) };
			Course c = new Course("NOME");
			sts[0].addCourse(c);
			sts[1].addCourse(c);
			sts[2].addCourse(c);
			for (Student s : sts)
				ls.add(s);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ls;
	}
	
	// http://localhost:8080/Project3-REST-Server/rest/project3webservices/getstudents
		@GET
		@Path("getstudentsbycourse")
		@Produces({MediaType.APPLICATION_JSON})
		public List<Student> getStudentsByCourse(@QueryParam("courseid") int id) {
			System.out.println("getStudentsByCourse started");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			List<Student> ls = new ArrayList<>();
			try {
				Course courses[] = {new Course("IS"), new Course("ES"), new Course("PPP")};
				Student sts [] = {
						new Student(20162844,2016,"Josaphat","123", sdf.parse("1973-01-18"), "a@uc.pt", "nand", "nand",966674819),
						new Student(20162846,2016,"Giovanni","123", sdf.parse("1983-11-12"), "x@uc.pt", "nand", "nand",962634818),
						new Student(20162845,2016,"Galli","123", sdf.parse("1993-10-2"), "c@uc.pt", "nand", "nand",962134817) };
				sts[0].addCourse(courses[0]);
				sts[1].addCourse(courses[0]);
				sts[0].addCourse(courses[1]);
				sts[0].addCourse(courses[2]);
				sts[2].addCourse(courses[0]);
				sts[2].addCourse(courses[1]);
				sts[0].addCourse(courses[2]);
				for (Student s : sts)
					ls.add(s);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return ls;
		}
}
