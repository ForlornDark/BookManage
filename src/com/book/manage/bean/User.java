package com.book.manage.bean;

/**
 * @author lfm
 *
 */
public class User {
	private int id;
	private String name;
	private String password;
	private byte role;
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
	public byte getRole() {
		return role;
	}
	public void setRole(byte role) {
		this.role = role;
	}
	
}
