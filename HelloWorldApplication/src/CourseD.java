

import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import data.Course;
import data.Material;
import data.Student;

@XmlRootElement(name="course")
public class CourseD implements Serializable {
 private static final long serialVersionUID = 1L;
 @XmlAttribute(name="nome")
 public String name;
 @XmlElement(name="Material")
 @XmlElementWrapper(name= "materiais")
 public List<MaterialD> materials=new ArrayList<MaterialD>();
 private int id;
 



public CourseD(Course c) {
	this.name=c.getName();
	for (Material m:c.getMaterial()){
		materials.add(new MaterialD(m));
	}
}

 
 public CourseD(String name) {
	super();
	
	this.name = name;

}















public void setMaterials(List<MaterialD> materials) {
	this.materials = materials;
}


public CourseD() {
  super();
 }

 





 public void setName(String name) {
  this.name = name;
 }



 public static long getSerialversionuid() {
  return serialVersionUID;
 }
 
 
  
}