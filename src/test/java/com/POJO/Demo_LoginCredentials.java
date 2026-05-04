package com.POJO;

public class Demo_LoginCredentials {
	private String username;
	private String password;
	public Demo_LoginCredentials(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Demo_LoginCredentials [username=" + username + ", password=" + password + "]";
	}
	
	

}
