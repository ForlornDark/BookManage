package com.book.manage.bean;

import java.util.Date;

public class Reader {
	private int readerId;
	private String name;
	private byte sex;
	private Date born;
	private String spec;
	private String photo;
	private String mail;
	public int getReaderId() {
		return readerId;
	}
	public void setReaderId(int readerId) {
		this.readerId = readerId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public byte getSex() {
		return sex;
	}
	public void setSex(byte sex) {
		this.sex = sex;
	}
	public Date getBorn() {
		return born;
	}
	public void setBorn(Date born) {
		this.born = born;
	}
	public String getSpec() {
		return spec;
	}
	public void setSpec(String spec) {
		this.spec = spec;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	
}
