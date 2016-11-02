package com.book.manage.bean;

import java.util.Date;

/**
 * @author lfm
 *
 */
public class Lend {

	private int lenId;
	private int readerId;
	private String ISBN;
	private Date time;
	private int num;
	private Book book;
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
	
}
