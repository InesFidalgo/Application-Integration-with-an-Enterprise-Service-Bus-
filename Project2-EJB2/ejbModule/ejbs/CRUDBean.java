package ejbs;

import javax.ejb.LocalBean;

import javax.ejb.Stateless;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import data.Admin;
import data.Course;
import data.Professor;
import data.Student;
import data.Material;
import data.Person;
import data.Course;

/**
 * Session Bean implementation class CRUDBean
 */
@Stateless
@LocalBean
public class CRUDBean /*implements CRUDBeanRemote, CRUDBeanLocal */{

    /**
     * Default constructor. 
     */
	@PersistenceContext(name="Admins")
	 EntityManager em;
	
	public ArrayList<Person> online = new ArrayList<>();
	/*public ArrayList<Admin> admins = new ArrayList<>(); 
	public ArrayList<Professor> professores = new ArrayList<>();
	public ArrayList<Student> alunos = new ArrayList<>();
	public ArrayList<Material> materiais = new ArrayList<>();
	public ArrayList<Course> courses = new ArrayList<>();*/
	
	public CRUDBean() {
		
    }
	
	private void getData(){
		int ID=0;
		Query query = em.createQuery("SELECT p from Student p");
		for (Object o:query.getResultList()){
			Student p = (Student) o;
			System.out.println(p);
		}
		Course c = em.find(Course.class, ID);

	}
	
    public Date getDate(int day, int month, int year) {
	     Calendar cal = Calendar.getInstance();
	     cal.set(Calendar.YEAR, year);
	     cal.set(Calendar.MONTH, month - 1);
	     cal.set(Calendar.DAY_OF_MONTH, day);
	
	     Date d = cal.getTime();
	     return d;
	    }
	
    //@Override
	public void WriteDataAdmin(String nome, String password) {
		byte[] bytesOfMessage;
		byte[] thedigest = null;
		MessageDigest md;
		try {
			bytesOfMessage = password.getBytes("UTF-8");
			md = MessageDigest.getInstance("MD5");
			thedigest = md.digest(bytesOfMessage);
		} catch (Exception e) {
		}
		String pts="";
		if (thedigest!=null)
			pts = new String(thedigest);
		Admin a = new Admin(nome, pts);
		//admins.add(a);
		 em.persist(a);

	}
	//@Override
	public void WriteDataProfessor(String nome, String password, Date data, String email, String alternate, String address, int tel, int internalnumber, String categoria, String office, int numerotinterno, double salario) {
		byte[] bytesOfMessage;
		byte[] thedigest = null;
		MessageDigest md;
		try {
			bytesOfMessage = password.getBytes("UTF-8");
			md = MessageDigest.getInstance("MD5");
			thedigest = md.digest(bytesOfMessage);
		} catch (Exception e) {
		}
		String pts="";
		if (thedigest!=null)
			pts = new String(thedigest);
		Professor p = new Professor(nome,pts,data,email,alternate,address, tel, internalnumber,categoria, office, numerotinterno, salario);
		//professores.add(p);
		em.persist(p);
		
	}
	//@Override
	public void WriteDataStudent(String nome, String password, int number, int firstYear, Date birth, String email, String alternateEmail, String address,
		int telephone) {
		byte[] bytesOfMessage;
		byte[] thedigest = null;
		MessageDigest md;
		try {
			bytesOfMessage = password.getBytes("UTF-8");
			md = MessageDigest.getInstance("MD5");
			thedigest = md.digest(bytesOfMessage);
		} catch (Exception e) {
		}
		String pts="";
		if (thedigest!=null)
			pts = new String(thedigest);
		Student s  = new Student( number, firstYear,nome,pts,birth, email, alternateEmail, address,  telephone);
		//alunos.add(s);
		em.persist(s);
		 
	}
	//@Override
	public void WriteDataMaterial(int idc, String url, String name) {
		Course c = em.find(Course.class, idc);
		Material m = new Material(c, url,  name);
		em.persist(m);		 
	}
	
	//@Override
	public void WriteDataCourse(String nomec) {
		Course c = new Course(nomec);
		//courses.add(c);
		em.persist(c);
		
		
	}
	//@Override
	public void EditarAdmin(int id,String nome, String password) {
		Admin c = em.find(Admin.class, id);
		c.setName(nome);
		byte[] bytesOfMessage;
		byte[] thedigest = null;
		MessageDigest md;
		try {
			bytesOfMessage = password.getBytes("UTF-8");
			md = MessageDigest.getInstance("MD5");
			thedigest = md.digest(bytesOfMessage);
		} catch (Exception e) {
		}
		String pts="";
		if (thedigest!=null)
			pts = new String(thedigest);
		c.setPasword(pts);
		em.merge(c);
	}
	//@Override
	public void EditarProfessor(int id,String nome, String password, Date data, String email, String alternate, String address,
			int tel, int internalnumber, String categoria, String office, int numerotinterno, double salario) {
		
			Professor c = em.find(Professor.class, id);
			c.setAddress(address);
			c.setAlternateEmail(alternate);
			c.setBirth(data);
			c.setCategory(categoria);
			c.setEmail(email);
			c.setInternalNumber(internalnumber);
			c.setSalary(salario);
			c.setInternalPhone(numerotinterno);
			c.setOffice(office);
			c.setName(nome);
			byte[] bytesOfMessage;
			byte[] thedigest = null;
			MessageDigest md;
			try {
				bytesOfMessage = password.getBytes("UTF-8");
				md = MessageDigest.getInstance("MD5");
				thedigest = md.digest(bytesOfMessage);
			} catch (Exception e) {
			}
			String pts="";
			if (thedigest!=null)
				pts = new String(thedigest);
			c.setPassword(pts);
			c.setTelephone(tel);
			em.merge(c);
	}
	//@Override
	public void EditarStudent(int id, String nome, String password, int number, int firstYear, Date birth, String email,
			String alternateEmail, String address, int telephone) {
		
		Student c = em.find(Student.class, id);
		c.setAddress(address);
		c.setAlternateEmail(alternateEmail);
		c.setBirth(birth);
		c.setEmail(email);			
		c.setName(nome);
		byte[] bytesOfMessage;
		byte[] thedigest = null;
		MessageDigest md;
		try {
			bytesOfMessage = password.getBytes("UTF-8");
			md = MessageDigest.getInstance("MD5");
			thedigest = md.digest(bytesOfMessage);
		} catch (Exception e) {
		}
		String pts="";
		if (thedigest!=null)
			pts = new String(thedigest);
		c.setPassword(pts);
		c.setTelephone(telephone);
		c.setFirstYear(firstYear);
		c.setNumber(number);	
		em.merge(c);
	}
	
	//@Override
	public void EditarMaterial(int id,int cid, String url, double size, String name) {
		
		Material m = em.find(Material.class, id);
		Course c = em.find(Course.class, cid);
		Course ch = m.getCourse();
		List<Material> m2 = ch.getMaterial();
		List<Material> m3 = c.getMaterial();
		m3.add(m);
		m2.remove(m);
		m.setUrl(url);
		m.setCourse(c);
		m.setName(name);
		m.setSize(size);
		em.merge(m);
		em.merge(c);
		em.merge(ch);
				
		
		
	}
	//@Override
	public void EditarCourse(int id,String nome, Professor professor, List<Student> alunos, List<Material> materiais) {
		Course c = em.find(Course.class, id);
		c.setName(nome);
		c.setProfessor(professor);
		c.setStudent(alunos);
		c.setMateriais(materiais);
		em.merge(c);
		
	}
	//@Override
	public void Logout(int id) {
		for(int i=0;i<online.size();i++){
			if(online.get(i).getId()==id){
				online.remove(i);
			}
			
		}
		
		
		
	}
	//@Override
	public boolean Login(String email, String password) {
		byte[] bytesOfMessage;
		byte[] thedigest = null;
		MessageDigest md;
		try {
			bytesOfMessage = password.getBytes("UTF-8");
			md = MessageDigest.getInstance("MD5");
			thedigest = md.digest(bytesOfMessage);
		} catch (Exception e) {
		}
		String pts="";
		if (thedigest!=null)
			pts = new String(thedigest);
		Query query = em.createQuery("SELECT p from Student p");
		for (Object o:query.getResultList()){
			Student p = (Student) o;
			if (p.getEmail().equals(email) && p.getPassword().equals(pts)){
				online.add(p);
				return true;
			}
		}
		query = em.createQuery("SELECT p from Professor p");		
		for (Object o:query.getResultList()){
			Professor p = (Professor) o;
			if (p.getEmail().equals(email) && p.getPassword().equals(pts)){
				online.add(p);
				return true;
			}
		}
		return false;
	}
	
	
	//@Override
	public void DeleteMaterial(int id) {
		Material c = em.find(Material.class, id);
		em.remove(c);
	}
	//@Override
	public List<Material> ListMaterials(int courseid) {
		List<Material> m = new ArrayList<>();
		Query query = em.createQuery("SELECT p from Material p");
		for (Object o:query.getResultList()){
			Material p = (Material) o;
			if (p.getCourse().getId()==courseid){
				m.add(p);
			}
		}
		return m;
	}
	//@Override
	public byte[] DownloadMaterials(int id) {
		/*for (Material m: materiais){
			if (m.getID()==id){
				return m.getContent();
			}
		}*/
		
		return null;
	}
	public static Comparator<Student> comp1()
	 {   
	  Comparator comp = new Comparator<Student>(){
	      @Override
	      public int compare(Student s1, Student s2)
	      {
	          return s1.getName().compareTo(s2.getName());
	      }        
	  };
	  return comp;
	 }  
	 
	 
	 public static Comparator<Student> comp2()
	 {   
	  Comparator comp = new Comparator<Student>(){
	      @Override
	      public int compare(Student s1, Student s2)
	      {
	          return s2.getName().compareTo(s1.getName());
	      }        
	  };
	  return comp;
	 } 
	
	//@Override
	public ArrayList<Student> ListStudents(int order) {//1-up 0-down
		ArrayList<Student> s = new ArrayList<>();
		Query query = em.createQuery("SELECT p from Student p");
		for (Object o:query.getResultList()){
			Student p = (Student) o;
			s.add(p);
		}
		if (order == 1){
			s.sort(comp1());
		}else{
			s.sort(comp2());
		}
		return s;
	}
	//@Override
	public void DeleteAdmin(int id) {
		Admin c = em.find(Admin.class, id);
		em.remove(c);
		
	}
	//@Override
	public void DeleteProfessor(int id) {
		Professor c = em.find(Professor.class, id);
		em.remove(c);
		
	}
	//@Override
	public void DeleteAluno(int id) {
		Student c = em.find(Student.class, id);
		em.remove(c);
	}
	//@Override
	public void DeleteCourse(int id) {
		Course c = em.find(Course.class, id);
		em.remove(c);
		
	}
	//@Override
	public void AddProfCourse(int id, int idc) {
		Professor c = em.find(Professor.class, id);
		Course c2 = em.find(Course.class, idc);
		c2.setProfessor(c);
		List<Course> c3=c.getCourse();
		c3.add(c2);
		em.merge(c);
		em.merge(c2);
		
	}
	//@Override
	public void AddStudentCourse(int ids, int idc) {
		Student c = em.find(Student.class, ids);
		Course c2 = em.find(Course.class, idc);
		List<Student> c4=c2.getStudent();
		c4.add(c);
		List<Course> c3=c.getCourse();
		c3.add(c2);
		em.merge(c);
		em.merge(c2);
		
	}

	//@Override
	public void EditarCourse(int id, String name) {
		Course c2 = em.find(Course.class, id);
		c2.setName(name);
		em.merge(c2);
	}

	//@Override
	public List<Professor> ListProfessors() {
		ArrayList<Professor> s = new ArrayList<>();
		Query query = em.createQuery("SELECT p from Professor p");
		for (Object o:query.getResultList()){
			Professor p = (Professor) o;
			s.add(p);
		}
		return s;
	}

	//@Override
	public List<Course> ListCourses() {
		ArrayList<Course> s = new ArrayList<>();
		Query query = em.createQuery("SELECT p from Course p");
		for (Object o:query.getResultList()){
			Course p = (Course) o;
			s.add(p);
		}
		return s;
	}

	//@Override
	public List<Material> ListMaterials() {
		ArrayList<Material> s = new ArrayList<>();
		Query query = em.createQuery("SELECT p from Material p");
		for (Object o:query.getResultList()){
			Material p = (Material) o;
			s.add(p);
		}
		return s;
	}

	//@Override
	public List<Admin> ListAdmins() {
		ArrayList<Admin> s = new ArrayList<>();
		Query query = em.createQuery("SELECT p from Admin p");
		for (Object o:query.getResultList()){
			Admin p = (Admin) o;
			s.add(p);
		}
		return s;
	}
	
	//public Student(int number, int firstYear, String name,String password, Date birth, String email, String alternateEmail, String address, int telephone) {


	public void addStuff() {
		Course c1 = new Course("Course1");
		Course c2 = new Course("Course2");
		Course c3 = new Course("Course3");
		Material m1 = new Material("/ex1.jpg","Exercicio1");
		Material m2 = new Material("/ex2.jpg","Exercicio2");
		Material m3 = new Material("/ex3.jpg","Exercicio3");
		Material m4 = new Material("/ex4.jpg","Exercicio4");
		Student s1 = new Student(123, 2016,"joao", "123",  new Date(),"joao@mail.com", "nn", "nn", 56465);
		Student s2 = new Student(123,2016,"fernando", "123", new Date(),"fernando@mail.com", "nn", "nn", 56465);
		Student s3 = new Student(123,2016,"carlos", "123",  new Date(),"carlos@mail.com", "nn", "nn", 56465);
		Student s4 = new Student(123,2016,"diogo", "123", new Date(),"diogo@mail.com", "nn", "nn", 56465);
		Student s5 = new Student(123,2016,"joana", "123",  new Date(),"joana@mail.com", "nn", "nn", 56465);
		c1.addStudent(s1);
		c1.addStudent(s3);
		c1.addStudent(s5);
		c2.addStudent(s2);
		c2.addStudent(s3);
		c3.addStudent(s1);
		c3.addStudent(s2);
		c3.addStudent(s3);
		c3.addStudent(s4);
		c3.addStudent(s5);
		c1.addMaterial(m1);
		c1.addMaterial(m2);
		c3.addMaterial(m1);
		c2.addMaterial(m3);
		c1.addMaterial(m4);
		em.persist(c1);
		em.persist(c2);
		em.persist(c3);
		em.persist(s1);
		em.persist(s2);
		em.persist(s3);
		em.persist(s4);
		em.persist(s5);
		em.persist(m1);
		em.persist(m2);
		em.persist(m3);
		em.persist(m4);
		
		
	}

	
	
	    
	   
	    
	    
	    
    
    
    
    

}

    
    
   
