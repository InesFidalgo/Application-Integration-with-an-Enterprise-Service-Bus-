package data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Admin {
	 @Id @GeneratedValue(strategy=GenerationType.AUTO)
	 private int id;
	 private String name;
	 private String pasword;
	 
	 public Admin(){
		 
	 }

	public Admin(String name, String pasword) {
		super();
		this.name = name;
		this.pasword = pasword;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPasword() {
		return pasword;
	}

	public void setPasword(String pasword) {
		this.pasword = pasword;
	}
	 
	
	
}
