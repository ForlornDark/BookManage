package com.book.manage.bean;

import java.sql.Blob;

/**
 * @author lfm
 *
 */
public class Book{
	//图书ISBN
	private String ISBN;
	//图书名
	private String bookName;
	//图书id
	//private String bookId;
	//图书作者
	private String author;
	//图书出版社
	private String publisher;
	//图书价格
	private float price;
	//复本量,复本量=库存量+已借阅
	private int cnum;
	//库存量
	private int snum;
	//图书描述
	private String summary;
	//图书封面图片路径，以图片格式存储在web/inf/resources下
	private String path;
	
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String ISBN) {
		this.ISBN = ISBN;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getCnum() {
		return cnum;
	}
	public void setCnum(int cnum) {
		this.cnum = cnum;
	}
	public int getSnum() {
		return snum;
	}
	public void setSnum(int snum) {
		this.snum = snum;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	
 }