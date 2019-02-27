

import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;

import data.Course;
import data.Student;


public class CourseC implements Serializable {
 private static final long serialVersionUID = 1L;
 private String name;
 private List<StudentC> student=new ArrayList<StudentC>();
 private int id;
 

 public CourseC(Course c,int id) {
		this.id=id;
		this.name=c.getName();
		for (Student s:c.getStudent()){
			student.add(new StudentC(s));
		}
	}
public CourseC(String name, int id){
	this.id=id;
	this.name=name;
}
 
@Override
public String toString() {
	return "CourseC [name=" + name + ", student=" + student.toString() + ", id=" + id + "]";
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public CourseC(Course c) {
	this.name=c.getName();
	for (Student s:c.getStudent()){
		student.add(new StudentC(s));
	}
}

 
 public CourseC(String name) {
	super();
	
	this.name = name;

}




public void addStudent(StudentC s){
	if (!student.contains(s)){
		student.add(s);
	}
}







public List<StudentC> getStudent() {
	return student;
}







public void setStudent(List<StudentC> student) {
	this.student = student;
}







public CourseC() {
  super();
 }

 






public String getName() {
  return name;
 }

 public void setName(String name) {
  this.name = name;
 }



 public static long getSerialversionuid() {
  return serialVersionUID;
 }
 
 
  
}