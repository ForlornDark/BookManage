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
	private String ISBN;
	private static final long serialVersionUID = 4410908701972116153L;
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		BookDao dao=new BookDao();
		int result = dao.deleteBookByISBN(ISBN);
		if(result>0)
		ActionContext.getContext().put("msg","²Ù×÷³É¹¦");
		return super.execute();
	}
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	
}
