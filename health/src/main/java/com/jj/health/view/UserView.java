package com.jj.health.view;

import com.jj.health.model.User;

public class UserView {
private int id;
private String email;
	
	public UserView(User user) {
	// TODO Auto-generated constructor stub
		 this.id = user.getId();
	        this.name = user.getName();
	        this.email = user.getEmail();
	        this.password=user.getPassword();
}
	public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
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
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
	private String name;
	private String password;
}
