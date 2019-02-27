package data;

import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;

import javax.persistence.*;
import javax.transaction.Transactional;
import javax.xml.bind.annotation.XmlTransient;

@Transactional
@Entity
public class Course implements Serializable {
 private static final long serialVersionUID = 1L;
 @Id @GeneratedValue(strategy=GenerationType.AUTO)
 private int id;
 private String name;
 @ManyToOne
 private Professor professor;
 @ManyToMany ()
 private List<Student> student=new ArrayList<Student>();
 @OneToMany (fetch = FetchType.EAGER,mappedBy="course")
 private List<Material> material=new ArrayList<Material>();
 
 
 
 public Course(String name) {
	super();
	
	this.name = name;

}



public Professor getProfessor() {
	return professor;
}


public void addMaterial(Material m){
	if (!material.contains(m)){
		material.add(m);
		m.setCourse(this);
	}
}
public void addStudent(Student s){
	if (!student.contains(s)){
		student.add(s);
		s.addCourse(this);
	}
}



public void setProfessor(Professor professor) {
	this.professor = professor;
}




public void setMateriais(List<Material> materiais) {
	this.material = materiais;
}





public List<Material> getMaterial() {
	return material;
}








public List<Student> getStudent() {
	return student;
}







public void setStudent(List<Student> student) {
	this.student = student;
}







public Course() {
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
 
 
 
 public int getId() {
	return id;
}



public void setId(int id) {
	this.id = id;
}


@Override
 public String toString() {
  return this.name + " id = " + this.id ;
 }
   
}