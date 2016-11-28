package com.book.manage.action;

import com.book.manage.dao.BookDao;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author lfm
 *
 */

public class DeleteBook extends ActionSupport{
	/**
	 * 
	 */
	//删除结果信息
	private String state;
	//删除的图书ISBN
	private String ISBN;
	private static final long serialVersionUID = 4410908701972116153L;
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		BookDao dao=new BookDao();
		state = dao.deleteBookByISBN(ISBN);
		return super.execute();
	}
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
}
