package data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Player
 *
 */
@Entity
public class Professor extends Person implements Serializable {
	
	 private static final long serialVersionUID = 1L;
	 private int internalNumber;
	 private String category;
	 private String office;
	 private int internalPhone;
	 private double salary;
	 @OneToMany (mappedBy="professor")
	 private List<Course> course=new ArrayList<Course>();
 




public Professor(String name, String password, Date birth, String email, String address, int telephone, int internalNumber, String category, String office, int internalPhone, double salary) {
	super(name,password, birth, email, address, telephone);
	this.internalNumber = internalNumber;
	this.category = category;
	this.office = office;
	this.internalPhone = internalPhone;
	this.salary = salary;
	
}


public Professor(String name,String password, Date birth, String email, String alternateEmail, String address, int telephone, int internalNumber, String category, String office, int internalPhone, double salary) {
	super(name,password, birth, email,alternateEmail , address, telephone);
	this.internalNumber = internalNumber;
	this.category = category;
	this.office = office;
	this.internalPhone = internalPhone;
	this.salary = salary;
	
	
}
public void addCourse(Course c){
	course.add(c);
}



public int getInternalNumber() {
	return internalNumber;
}






public void setInternalNumber(int internalNumber) {
	this.internalNumber = internalNumber;
}






public String getCategory() {
	return category;
}






public void setCategory(String category) {
	this.category = category;
}






public String getOffice() {
	return office;
}






public void setOffice(String office) {
	this.office = office;
}






public int getInternalPhone() {
	return internalPhone;
}






public void setInternalPhone(int internalPhone) {
	this.internalPhone = internalPhone;
}






public double getSalary() {
	return salary;
}






public void setSalary(double salary) {
	this.salary = salary;
}






public List<Course> getCourse() {
	return course;
}






public void setCourse(List<Course> course) {
	this.course = course;
}





 public Professor() {
  super();
 }






 public static long getSerialversionuid() {
  return serialVersionUID;
 }
 
 @Override
 public String toString() {
  return super.toString() + " numero interno: "+ internalNumber + " categoria: "+ category + " gabinete: "+ office + " numero de telfone interno: "+ internalPhone+ " salario: "+ salary;
 }
   
}