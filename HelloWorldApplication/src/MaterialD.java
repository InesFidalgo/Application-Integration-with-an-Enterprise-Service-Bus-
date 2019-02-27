

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import data.Material;

@Entity
public class MaterialD {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	 private int id;
	private String content;
	private String name;
	
	public MaterialD(){
		
	}
	
	public MaterialD(String url, String name){
		this.content=url;
		
		this.name=name;
	}

	
	public MaterialD(Material m) {
		this.content=m.getContent();
		this.name=m.getName();
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
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

