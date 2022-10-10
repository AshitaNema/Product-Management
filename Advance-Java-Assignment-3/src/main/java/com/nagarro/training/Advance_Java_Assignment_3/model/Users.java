package com.nagarro.training.Advance_Java_Assignment_3.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Users {
	
@Id
private String uname;
private String pass;

@Override
public String toString() {
	return "User [uname=" + uname + ", upass=" + pass + "]";
}
public String getUname() {
	return uname;
}
public void setUname(String uname) {
	this.uname = uname;
}
public String getPass() {
	return pass;
}
public void setPass(String pass) {
	this.pass = pass;
}


}
