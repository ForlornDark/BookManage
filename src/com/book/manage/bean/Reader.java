package com.book.manage.bean;

import java.util.Date;

public class Reader {
	//读者ID
	private int readerId;
	//读者名字
	private String name;
	//读者性别
	private byte sex;
	//读者生日
	private Date born;
	//读者职业
	private String spec;
	//读者照片，文件路径
	private String photo;
	//读者邮箱，邮箱认证
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
