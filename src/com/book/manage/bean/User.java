package com.book.manage.bean;

/**
 * @author lfm
 *
 */
public class User {
	//管理员ID
	private int id;
	//管理员名字
	private String name;
	//管理员密码
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
