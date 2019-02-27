package data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Material {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	 private int id;
	@ManyToOne
	private Course course;
	private String content;
	private double size;
	private String name;
	
	public Material(){
		
	}
	
	public Material(Course c, String url, String name){
		course=c;
		this.content=url;
		
		this.name=name;
	}
	
	public Material(String url, String name){
		this.content=url;
		
		this.name=name;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public double getSize() {
		return size;
	}

	public void setSize(double size) {
		this.size = size;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public int getID(){
		return id;
	}

	public void setUrl(String url) {
		// TODO Auto-generated method stub
		
	}
	
}

