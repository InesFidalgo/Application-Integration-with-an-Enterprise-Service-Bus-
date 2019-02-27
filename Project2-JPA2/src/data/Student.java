package data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
public class Student extends Person implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private int number;
	private int firstYear;  
	@ManyToMany
	@JsonIgnore
	private List<Course> course=new ArrayList<Course>();
	 
	
	
	
	
	
	
	
	public Student() {
		super();
	}
	public Student(int number, int firstYear, String name,String password, Date birth, String email, String address, int telephone) {
		super(name,password, birth, email, address, telephone);
		this.number=number;
		this.firstYear=firstYear;
	}
	public Student(int number, int firstYear, String name,String password, Date birth, String email, String alternateEmail, String address,
			int telephone) {
		super(name,password, birth, email, alternateEmail, address, telephone);
		this.number=number;
		this.firstYear=firstYear;
	}
	
	public void addCourse(Course c){
		course.add(c);
		c.addStudent(this);
	}
	
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public int getFirstYear() {
		return firstYear;
	}
	public void setFirstYear(int firstYear) {
		this.firstYear = firstYear;
	}
	public List<Course> getCourse() {
		return course;
	}
	public void setCourse(List<Course> course) {
		this.course = course;
	}	

	
	
}
