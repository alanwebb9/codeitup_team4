package com.jj.health.view;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class UserSignUpView {
	@NotNull
    @NotEmpty
	private String name;
	@NotNull
    @NotEmpty
	private String email;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@NotNull
    @NotEmpty
	private String password;
}
