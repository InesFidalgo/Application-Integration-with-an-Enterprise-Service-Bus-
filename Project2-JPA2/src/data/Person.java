package data;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Player
 *
 */
@Entity
public class Person implements Serializable {
 private static final long serialVersionUID = 1L;
 @Id @GeneratedValue(strategy=GenerationType.AUTO)
 private int id;
 private String name;
 @Temporal(TemporalType.DATE)
 private Date birth;
 private String email;
 private String alternateEmail;
 private String address;
 private int telephone;
 private String password;
 
 public Person() {
  super();
 }


 public Person(String name, String password, Date birth, String email, String address, int telephone) {
	super();
	this.name = name;
	this.birth = birth;
	this.password=password;
	this.email = email;
	this.address = address;
	this.telephone = telephone;
	this.alternateEmail = "";

}



public Person(String name, String password, Date birth, String email, String alternateEmail, String address, int telephone) {
	super();
	this.name = name;
	this.birth = birth;
	this.password=password;
	this.email = email;
	this.alternateEmail = alternateEmail;
	this.address = address;
	this.telephone = telephone;
}

public void setPassword(String password){
	this.password=password;
}

public String getPassword() {
	  return password;
	 }

public String getName() {
  return name;
 }

 public void setName(String name) {
  this.name = name;
 }

 public Date getBirth() {
  return birth;
 }

 public void setBirth(Date birth) {
  this.birth = birth;
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



public String getEmail() {
	return email;
}



public void setEmail(String email) {
	this.email = email;
}



public String getAlternateEmail() {
	return alternateEmail;
}



public void setAlternateEmail(String alternateEmail) {
	this.alternateEmail = alternateEmail;
}



public String getAddress() {
	return address;
}



public void setAddress(String address) {
	this.address = address;
}



public int getTelephone() {
	return telephone;
}



public void setTelephone(int telephone) {
	this.telephone = telephone;
}



@Override
 public String toString() {
  return this.name + " id = " + this.id + ", " + this.email + " or " + this.alternateEmail +  " lives in : " + this.address + " phone : " + this.telephone + ". Born on " + this.birth;
 }
   
}