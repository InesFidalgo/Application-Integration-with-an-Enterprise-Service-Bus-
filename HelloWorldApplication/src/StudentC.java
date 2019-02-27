
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;

import org.codehaus.jackson.annotate.JsonIgnore;

import data.Student;


public class StudentC extends Person implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private int number;
	private int firstYear;  
	private int id;
	 
	@Override
	public String toString() {
		return "id: "+id+" email: "+super.getEmail();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public StudentC(Student s){
		super(s.getName(),s.getPassword(), s.getBirth(), s.getEmail(),s.getAlternateEmail(), s.getAddress(), s.getTelephone());

		this.number=s.getNumber();
		this.firstYear=s.getFirstYear();

	}
	
	public StudentC() {
		super();
	}
	public StudentC(int number, int firstYear, String name,String password, Date birth, String email, String address, int telephone) {
		super(name,password, birth, email, address, telephone);
		this.number=number;
		this.firstYear=firstYear;
	}
	public StudentC(int id,int number, int firstYear, String name,String password, Date birth, String email, String address, int telephone) {
		super(name,password, birth, email, address, telephone);
		this.number=number;
		this.id=id;
		this.firstYear=firstYear;
	}
	public StudentC(int number, int firstYear, String name,String password, Date birth, String email, String alternateEmail, String address,
			int telephone) {
		super(name,password, birth, email, alternateEmail, address, telephone);
		this.number=number;
		this.firstYear=firstYear;
	}
	public StudentC(int id,int number, int firstYear, String name,String password, Date birth, String email, String alternateEmail, String address,
			int telephone) {
		super(name,password, birth, email, alternateEmail, address, telephone);
		this.number=number;
		this.id=id;
		this.firstYear=firstYear;
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
	
	
}
