package com.book.manage.bean;

import java.util.Date;

/**
 * @author lfm
 *
 */
public class Lend {
	//借阅id,由数据库序列产生
	private int lenId;
	//读者ID
	private int readerId;
	//所借书的ISBN
	private String ISBN;
	//借书时间
	private Date time;
	//借书数量
	private int num;
	//借书，书的详细信息
	private Book book;
	//private Boolean isBack;
	public int getLenId() {
		return lenId;
	}
	public void setLenId(int lenId) {
		this.lenId = lenId;
	}
	public int getReaderId() {
		return readerId;
	}
	public void setReaderId(int readerId) {
		this.readerId = readerId;
	}
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
//	public Boolean getIsBack() {
//		return isBack;
//	}
//	public void setIsBack(Boolean isBack) {
//		this.isBack = isBack;
//	}
	
}
